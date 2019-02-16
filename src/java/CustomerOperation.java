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
                }else if(action.equals("Update")){
                    if((!"".equals(id))&&(!"".equals(nm))&&(!"".equals(cont))&&(!"".equals(add))&&(!"".equals(eml))&&(!"".equals(cty))&&(!"".equals(st))){
                        int a = stmt.executeUpdate("update customer set c_name='"+nm+"',c_con='"+cont+"',c_add='"+add+"',c_eml='"+eml+"',c_cty='"+cty+"',c_state='"+st+"' where c_id='"+id+"' ");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Updated Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");						
                            rsd.forward(request,response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");						
                            rsd.forward(request,response);
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Field is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                        rsd.forward(request,response);
                    }
                }else if(action.equals("Delete")){
                    if(!"".equals(id)){
                        int a = stmt.executeUpdate("delete from customer where c_id='"+id+"' ");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Deleted Successfully !");				
                            RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                            rsd.forward(request,response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Deleted !");				
                            RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                            rsd.forward(request,response);							
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Customer ID !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                        rsd.forward(request, response);
                    }
                }else if(action.equals("Search")){
                    if(!"".equals(id)){
                        ResultSet rs = stmt.executeQuery("select * from customer where c_id='"+id+"' ");
                        if(rs.next()){
							System.out.println(rs.getString(1));
							System.out.println(rs.getString(2));
							System.out.println(rs.getString(3));
							System.out.println(rs.getString(4));
							System.out.println(rs.getString(5));
							System.out.println(rs.getString(6));
							System.out.println(rs.getString(7));
                            request.setAttribute("errmsg","Record Found !");
                            request.setAttribute("csid",rs.getString(1));
							request.setAttribute("cusnm",rs.getString(2));
							request.setAttribute("cuscon",rs.getString(3));
							request.setAttribute("cusadd",rs.getString(4));
							request.setAttribute("cuseml",rs.getString(5));
							request.setAttribute("cuscty",rs.getString(6));
							request.setAttribute("cusst",rs.getString(7));
                            RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Not Found !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                            rsd.forward(request,response);
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Customer ID !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                        rsd.forward(request, response);                    
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
                request.setAttribute("errmsg","An Error Occurred !");
                RequestDispatcher rsd = request.getRequestDispatcher("/Customer.jsp");
                rsd.forward(request,response);
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
