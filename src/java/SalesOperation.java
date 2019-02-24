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
                    if(!"".equals(slid)){
                        int a = stmt.executeUpdate("delete from sales where s_id='"+slid+"' ");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Successfully Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Sales ID !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                        rsd.forward(request, response);
                    }                
                }else if(action.equals("Search")){
                    if(!"".equals(slid)){
                        ResultSet rs = stmt.executeQuery("Select * from sales where s_id='"+slid+"'");
                        if(rs.next()){
                            System.out.println(rs.getString(1));
                            System.out.println(rs.getString(2));
                            System.out.println(rs.getString(3));
                            System.out.println(rs.getString(4));
                            request.setAttribute("slid",rs.getString(1));
                            request.setAttribute("prid",rs.getString(2));
                            request.setAttribute("prqty",rs.getString(3));
                            request.setAttribute("prprc",rs.getString(4));
                            request.setAttribute("errmsg","Record Found !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                            rsd.forward(request, response);                            
                        }else{
                            request.setAttribute("errmsg","Record Not Found !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Sales ID !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
                        rsd.forward(request, response);
                    }                                
                }
            }catch(Exception ex){
                System.out.println(ex);
                request.setAttribute("errmsg","An Error Has Been Occurred While Establishing The Connection !");
                RequestDispatcher rsd = request.getRequestDispatcher("/Sales.jsp");
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
