import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet(urlPatterns = {"/ProductOperation"})
public class ProductOperation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action,id,pid,prc,qn,grd;
            action = request.getParameter("invsb");
            System.out.println("Your Action : "+action);
            id = request.getParameter("iid");
            pid = request.getParameter("pid");
            prc = request.getParameter("upr");
            qn = request.getParameter("prqn");
            grd = request.getParameter("igr");
            
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt=conn.createStatement();   
                if(action.equals("Insert")){
                    if((!"".equals(id))&&(!"".equals(pid))&&(!"".equals(prc))&&(!"".equals(grd))){
                        int a = stmt.executeUpdate("insert into inventory values ('"+id+"','"+pid+"','"+prc+"','"+qn+"','"+grd+"')");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Inserted Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Inserted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                            rsd.forward(request, response);
                        }                    
                    }else{
                        request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                        rsd.forward(request,response);
                    }                    
                }else if(action.equals("Update")){
                    if((!"".equals(id))&&(!"".equals(pid))&&(!"".equals(prc))&&(!"".equals(grd))){
                        int a = stmt.executeUpdate("update inventory set p_id='"+pid+"' ,i_price='"+prc+"',i_qty='"+qn+"' ,i_grd='"+grd+"' where i_id='"+id+"'");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Updated Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                            rsd.forward(request, response);
                        }                    
                    }else{
                        request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                        rsd.forward(request,response);
                    }                                    
                }else if(action.equals("Delete")){
                    if(!"".equals(id)){
                        int a = stmt.executeUpdate("delete from inventory where i_id='"+id+"'");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Successfully Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                            rsd.forward(request,response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Inventory ID");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                        rsd.forward(request,response);
                    }                
                }else if(action.equals("Search")){
                
                }
            }catch(Exception ex){
                ex.printStackTrace();
                request.setAttribute("errmsg","An Error Occurred While Establishing The Connection !");
                RequestDispatcher rsd = request.getRequestDispatcher("/Inventory.jsp");
                rsd.forward(request, response);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
