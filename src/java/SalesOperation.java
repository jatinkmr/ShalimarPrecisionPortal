import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet(urlPatterns = {"/SalesOperation"})
public class SalesOperation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action,slid,prid,qty,prc;
            action = request.getParameter("salsb");
            System.out.println("Your Action : "+action);
            slid = request.getParameter("sid");
            prid = request.getParameter("pid");
            qty = request.getParameter("pqty");
            prc = request.getParameter("pprc");            
            
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt=conn.createStatement();           
                if(action.equals("Insert")){
                    if((!"".equals(slid))&&(!"".equals(prid))&&(!"".equals(qty))&&(!"".equals(prc))){
                        int a = stmt.executeUpdate("insert into sales values('"+slid+"','"+prid+"','"+qty+"','"+prc+"')");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Successfully Inserted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Inserted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                        rsd.forward(request, response);
                    }                
                }else if(action.equals("Update")){
                    if((!"".equals(slid))&&(!"".equals(prid))&&(!"".equals(qty))&&(!"".equals(prc))){
                        int a = stmt.executeUpdate("update sales set p_id='"+prid+"' ,p_qty='"+qty+"' ,p_prc='"+prc+"' where s_id='"+slid+"' ");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Successfully Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                        rsd.forward(request, response);
                    }                                
                }else if(action.equals("Delete")){
                
                }else if(action.equals("Search")){
                
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
