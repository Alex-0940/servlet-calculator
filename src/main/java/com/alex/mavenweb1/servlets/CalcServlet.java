package com.alex.mavenweb1.servlets;

import com.alex.mavenweb1.calc.CalcOperations;
import com.alex.mavenweb1.calc.OperationType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
public class CalcServlet extends HttpServlet {

    private ArrayList<String> listOperations = new ArrayList<String>();
        private static final String COOKIE_NAME = "count";
        private static final String SESSION_MAP = "sessionMap";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Map contains id session and list of operations sessionMap
        Map<String, List> sessionMap = (Map<String, List>)request.getServletContext().getAttribute(SESSION_MAP);
        
        if(sessionMap == null){
            sessionMap = new HashMap<String, List>();
        }       

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CalcServlet</title>");
        out.println("</head>");
        out.println("<body>");
        

        try {
            // reading the parameters
            double one = Double.valueOf(request.getParameter("one"));
            double two = Double.valueOf(request.getParameter("two"));

            String opearation = String.valueOf(request.getParameter("operation"));

            // define or create a session
            HttpSession session = request.getSession(true);

            // get operation type
            OperationType operType = OperationType.valueOf(opearation.toUpperCase());

            // calculation
            double result = calcResult(operType, one, two);
            
            ArrayList<String> listOperations = new ArrayList<String>();
            
            // create a new list for the new session
            if (session.isNew()) {
                listOperations.clear();
            } 
            else { // else get a list of session attributes
                listOperations = (ArrayList<String>) session.getAttribute("formula");
            }

            // adding a new operation to the list and the attribute of the session
            listOperations.add(one + " " + operType.getStringValue() + " " + two + " " + " = " + result);
            session.setAttribute("formula", listOperations);
            
            out.println("<table cellpatting=\"20\">");
            out.println("<tr>");
            out.println("<td style=\"vertical-align:top;\">");

            // output all operations
            out.println("<h2 style=\"color:green;\">ID your session : " + session.getId() + "</h2>");
            out.println("<h2 style=\"color:green;\">List of operations (total: " + listOperations.size() + ") </h2>");
            

            for (String oper : listOperations) {
                out.println("<h3>" + oper + "</h3>");
            }
            
            response.getWriter().write("<h2 style=\"color:green;\">Hello I am SELVLET</h2>");

            sessionMap.put(session.getId(), listOperations);
            getServletContext().setAttribute(SESSION_MAP, sessionMap);
            
            out.println("<tr>");
            out.println("<td style=\"vertical-align:top;\">");
            
            for (Map.Entry<String, List> entry : sessionMap.entrySet()){
                String sessionId = entry.getKey();
                List listOper = entry.getValue();
                
                out.println("<h2 style=\"color:red\">Last session: " + sessionId + "</h2>");

                for (Object str : listOper) {
                    out.println("<h3>" + str + "</h3>");
                }
                
            }
                       
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
                        

        } catch (Exception ex) {
            // error warning
            out.println("<h3 style=\"color:red;\">Возникла ошибка. Проверьте параметры</h3>");
            out.println("<h3>Имена параметров должны быть one, two operation</h3>");
            out.println("<h3>Operation должен принимать 1 из 4 значений: add, subtract, multiply, divide</h3>");
            out.println("<h3>Значения one и two должны быть числами</h3>");
            out.println("<h2>Скопируйте и добавьте в адресную строку: </h2>");
            out.println("<h3>?one=2&two=3&operation=add</h3>");

        } finally {
                   Cookie fromClient = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies){
                if (COOKIE_NAME.equals(cookie.getName())){
                    fromClient = cookie;
                    break;
                }
            }
        }
        
        // output number of visits
        if (fromClient == null){
            response.addCookie(new Cookie(COOKIE_NAME, "" + 1));
            response.getWriter().write("<h2 style=\"color:red;\">You visit this page: 1 time</n2");
        }else{                     
            int visitCount = Integer.valueOf(fromClient.getValue());
            response.addCookie(new Cookie(COOKIE_NAME, "" + (++visitCount)));
            response.getWriter().write("<h2 style=\"color:red;\">You visit this page: " + visitCount + " times</h2>");
        }

  
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet - calculation";
    }

    
    // calculation
    private double calcResult(OperationType operType, double one, double two) {
        double result = 0;
        switch (operType) {
            case ADD: {
                result = CalcOperations.add(one, two);
                break;
            }
            case SUBTRACT: {
                result = CalcOperations.subtract(one, two);
                break;
            }

            case DIVIDE: {
                result = CalcOperations.divide(one, two);
                break;
            }

            case MULTIPLY: {
                result = CalcOperations.multiply(one, two);
                break;
            }
        }

        return result;
    }
}
