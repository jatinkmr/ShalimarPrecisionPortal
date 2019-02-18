import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet(urlPatterns = {"/PaymentOperation"})
public class PaymentOperation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action,cid,cnm,con,id,enm,sid,econ;
            action = request.getParameter("pysb");
            cid = request.getParameter("cid");
            cnm = request.getParameter("cnm");
            con = request.getParameter("con");
            id = request.getParameter("eid");
            enm = request.getParameter("enm");
            econ = request.getParameter("econ");
            sid = request.getParameter("sid");
            
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt=conn.createStatement();           
                if(action.equals("Insert")){
                    if((!"".equals(cid))&&(!"".equals(enm))&&(!"".equals(con))&&(!"".equals(id))&&(!"".equals(enm))&&(!"".equals(econ))&&(!"".equals(sid))){
                        int a = stmt.executeUpdate("insert into payment values ('"+cid+"','"+cnm+"','"+con+"','"+id+"','"+enm+"','"+econ+"','"+sid+"')");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Inserted Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                            rsd.forward(request,response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Inserted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                            rsd.forward(request,response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                        rsd.forward(request,response);
                    }                    
                }else if(action.equals("Update")){
                    if((!"".equals(cid))&&(!"".equals(enm))&&(!"".equals(con))&&(!"".equals(id))&&(!"".equals(enm))&&(!"".equals(econ))&&(!"".equals(sid))){
                        int a = stmt.executeUpdate("update payment set c_name='"+cnm+"' ,c_con='"+con+"' ,e_id='"+id+"' ,e_name='"+enm+"' ,e_con='"+econ+"' ,s_id='"+sid+"'  where c_id='"+cid+"'");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Updated Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Updated Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                            rsd.forward(request, response);
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                        rsd.forward(request,response);                    
                    }                    
                }else if(action.equals("Delete")){
                    if(!"".equals(cid)){
                        int a = stmt.executeUpdate("delete from payment where c_id='"+cid+"'");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Successfully Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Payment ID!");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                        rsd.forward(request,response);                    
                    }                
                }else if(action.equals("Search")){
                    if(!"".equals(cid)){
                        ResultSet rs = stmt.executeQuery("select * from payment where c_id='"+cid+"'");
                        if(rs.next()){                           
                            System.out.println(rs.getString(1));
                            System.out.println(rs.getString(2));
                            System.out.println(rs.getString(3));
                            System.out.println(rs.getString(4));
                            System.out.println(rs.getString(5));
                            System.out.println(rs.getString(6));
                            System.out.println(rs.getString(7));
                            request.setAttribute("cusid", rs.getString(1));
                            request.setAttribute("cusnm",rs.getString(2));
                            request.setAttribute("cuscon",rs.getString(3));
                            request.setAttribute("empid",rs.getString(4));
                            request.setAttribute("empnm",rs.getString(5));
                            request.setAttribute("empcon",rs.getString(6));
                            request.setAttribute("supid",rs.getString(7));
                            request.setAttribute("errmsg","Record Found !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                            rsd.forward(request,response);                            
                        }else{
                            request.setAttribute("errmsg","Record Not Found !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                            rsd.forward(request,response);                            
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Payment ID!");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                        rsd.forward(request,response);                    
                    }                                
                }
            }catch(Exception ex){
                request.setAttribute("errmsg","An Error Occurred While Establishing The Connection !");
                RequestDispatcher rsd = request.getRequestDispatcher("/Payment.jsp");
                rsd.forward(request, response);
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
