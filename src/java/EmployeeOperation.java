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
            String action,id,nm,con,add,eml,ty,st,gen;
            action = request.getParameter("empsb");
            id = request.getParameter("eid");
            nm = request.getParameter("enm");
            con = request.getParameter("ecn");
            add = request.getParameter("edd");
            eml = request.getParameter("eeml");
            ty = request.getParameter("ety");
            st = request.getParameter("est");
            gen = request.getParameter("gend");
            
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt=conn.createStatement();                         
                if(action.equals("Insert")){
                    if((!"".equals(id))&&(!"".equals(nm))&&(!"".equals(con))&&(!"".equals(add))&&(!"".equals(eml))&&(!"".equals(ty))&&(!"".equals(st))&&(!"".equals(gen))){
                        int a = stmt.executeUpdate("insert into employee values('"+id+"','"+nm+"','"+eml+"','"+add+"','"+ty+"','"+st+"','"+gen+"','"+con+"')");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Inserted Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request, response);                            
                        }else{
                            request.setAttribute("errmsg", "Record Doesn't Inserted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request, response);
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                        rsd.forward(request, response);
                    }
                } else if(action.equals("Update")) {
                    if((!"".equals(id))&&(!"".equals(nm))&&(!"".equals(con))&&(!"".equals(add))&&(!"".equals(eml))&&(!"".equals(ty))&&(!"".equals(st))&&(!"".equals(gen))){                        
                        int a = stmt.executeUpdate("update employee set e_name='"+nm+"', e_email='"+eml+"', e_add='"+add+"', e_city='"+ty+"', e_state='"+st+"', e_gen='"+gen+"', e_contact='"+con+"' where e_id='"+id+"' ");
                        if(a > 0) {
                            request.setAttribute("errmsg","Record Successfully Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request, response);
                        }else {
                            request.setAttribute("errmsg","Record Doesn't Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else {
                        request.setAttribute("errmsg","Some of The Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                        rsd.forward(request, response);
                    }
                }else if(action.equals("Delete")) {
                    if(!"".equals(id)){
                        int a = stmt.executeUpdate("delete from employee where e_id='"+id+"' ");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Deleted Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request, response);                        
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Employee ID!");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                        rsd.forward(request, response);                                                
                    }
                }else if(action.equals("Search")){
                    if(!"".equals(id)){
                        ResultSet rs = stmt.executeQuery("select * from employee where e_id='"+id+"' ");
                        if(rs.next()){                  
                            System.out.println(rs.getString(1));
                            System.out.println(rs.getString(2));
                            System.out.println(rs.getString(3));
                            System.out.println(rs.getString(4));
                            System.out.println(rs.getString(5));
                            System.out.println(rs.getString(6));
                            System.out.println(rs.getString(7));                            
                            System.out.println(rs.getString(8));                            
                            request.setAttribute("empid",rs.getString(1));
                            request.setAttribute("empnm",rs.getString(2));
                            request.setAttribute("empcon",rs.getString(8));
                            request.setAttribute("empadd",rs.getString(4));
                            request.setAttribute("empeml",rs.getString(3));
                            request.setAttribute("empcty",rs.getString(5));
                            request.setAttribute("empst",rs.getString(6));
                            request.setAttribute("empgend",rs.getString(7));
                            request.setAttribute("errmsg","Record Found !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request,response);                                  
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Found !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request,response);
                        }
                    }else{
                        request.setAttribute("errmsg","Please Fill The Employee ID !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                        rsd.forward(request, response);
                    }
                }
            }catch(Exception ex){
                System.out.println(ex);
                request.setAttribute("errmsg", "An Error Occurred");
                RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
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
