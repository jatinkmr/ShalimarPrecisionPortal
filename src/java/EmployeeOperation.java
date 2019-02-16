import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet(urlPatterns = {"/EmployeeOperation"})
public class EmployeeOperation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action,id,nm,cn,add,eml,ty,st,gen;
            action = request.getParameter("empsb");
            id = request.getParameter("eid");
            nm = request.getParameter("enm");
            cn = request.getParameter("ecn");
            add = request.getParameter("edd");
            eml = request.getParameter("eeml");
            ty = request.getParameter("ety");
            st = request.getParameter("est");
            gen = request.getParameter("gend");
            
            try {
                Class.forName("oracle.jdbc.odbc.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt = con.createStatement();
                if(action.equals("Insert")) {
                    
                }else if(action.equals("Update")) {
                
                }else if(action.equals("Delete")) {
                
                }else if(action.equals("Search")) {
                
                }
            }catch(Exception ex) {
                request.setAttribute("errmsg","An Error Occurred While Making Connection !");
                RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                rsd.forward(request,response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
