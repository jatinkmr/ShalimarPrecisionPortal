import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet(urlPatterns = {"/CustomerOperation"})
public class CustomerOperation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id,nm,cont,add,eml,cty,st,action;
            action = request.getParameter("cstmrsb");
            System.out.println("Your Action is : "+action);
            id = request.getParameter("cid");            
            nm = request.getParameter("cn");
            cont = request.getParameter("ccn");
            add = request.getParameter("cdd");
            eml = request.getParameter("cml");
            cty = request.getParameter("cty");
            st = request.getParameter("ct");
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt=conn.createStatement();                     
                if(action.equals("Insert")){
                    if((!"".equals(id))&&(!"".equals(nm))&&(!"".equals(cont))&&(!"".equals(add))&&(!"".equals(eml))&&(!"".equals(cty))&&(!"".equals(st))){	                
                        int a = stmt.executeUpdate("insert into customer values ('"+id+"','"+nm+"','"+cont+"','"+add+"','"+eml+"','"+cty+"','"+st+"')");                    
                        if(a>0){
                            request.setAttribute("errmsg","Record Successfully Inserted!");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Inserted!");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                            rsd.forward(request, response);
                        }                    
                    }else{
                        request.setAttribute("errmsg","Some of the Field is Empty!!");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                        rsd.forward(request, response);
                    }
                }else{
                
                }
            }catch(Exception ex){
            
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
