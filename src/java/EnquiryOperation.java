import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet(urlPatterns = {"/EnquiryOperation"})
public class EnquiryOperation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action,id,typ,ques,ans;
            action = request.getParameter("enqrsb");
            System.out.println("Your Action : "+action);
            id = request.getParameter("eid");
            typ = request.getParameter("etyp");
            ques = request.getParameter("eques");
            ans = request.getParameter("eans");            
            
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt=conn.createStatement();           
                if(action.equals("Insert")){
                    if((!"".equals(id))&&(!"".equals(typ))&&(!"".equals(ques))&&(!"".equals(ans))){
                        int a = stmt.executeUpdate("insert into enquiry values('"+id+"','"+typ+"','"+ques+"','"+ans+"')");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Inserted Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Inserted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                        rsd.forward(request,response);
                    }                    
                }else if(action.equals("Update")){
                    if((!"".equals(id))&&(!"".equals(typ))&&(!"".equals(ques))&&(!"".equals(ans))){
                        int a = stmt.executeUpdate("update enquiry set c_type='"+typ+"' ,c_ques='"+ques+"',c_ans='"+ans+"'  where c_id='"+id+"' ");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Updated Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                        rsd.forward(request, response);                        
                    }                    
                }else if(action.equals("Delete")){
                    if(!"".equals(id)){
                        int a = stmt.executeUpdate("delete from enquiry where c_id='"+id+"'");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Deleted Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Enquiry ID First !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                        rsd.forward(request, response);
                    }                
                }else if(action.equals("Search")){
                    if(!"".equals(id)){
                        ResultSet rs = stmt.executeQuery("select * from enquiry where c_id='"+id+"'");
                        if(rs.next()){                           
                            System.out.println(rs.getString(1));
                            System.out.println(rs.getString(2));
                            System.out.println(rs.getString(3));
                            System.out.println(rs.getString(4));
                            request.setAttribute("enqid",rs.getString(1));
                            request.setAttribute("enqtyp",rs.getString(2));
                            request.setAttribute("enques",rs.getString(3));
                            request.setAttribute("enans",rs.getString(4));                            
                            request.setAttribute("errmsg","Record Found !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                            rsd.forward(request, response);                            
                        }else{
                            request.setAttribute("errmsg","Record Not Found !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                            rsd.forward(request, response);
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Enquiry ID First !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
                        rsd.forward(request, response);                
                    }                
                }
            }catch(Exception ex){
                request.setAttribute("errmsg","An Error Occurred While Establishing The Connection!!");
                RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
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
