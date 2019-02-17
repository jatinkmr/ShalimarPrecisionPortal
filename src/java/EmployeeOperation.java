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
                    if((!"".equals(id))&&(!"".equals(nm))&&(!"".equals(cn))&&(!"".equals(add))&&(!"".equals(eml))&&(!"".equals(ty))&&(!"".equals(st))&&(!"".equals(gen))){
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
                        request.setAttribute("errmsg","Some of The Fields is Empty.Please Fill Them Properly !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                        rsd.forward(request, response);
                    }
                }else if(action.equals("Update")) {
                    if((!"".equals(id))&&(!"".equals(nm))&&(!"".equals(con))&&(!"".equals(add))&&(!"".equals(eml))&&(!"".equals(ty))&&(!"".equals(st))&&(!"".equals(gen))){
                        int a = stmt.executeUpdate("update employee set e_email='"+eml+"' ,e_enam='"+nm+"' ,e_add='"+add+"' ,e_city='"+ty+"' ,e_state='"+st+"' ,e_gen='"+gen+"' ,e_contact='"+con+"' where e_id='"+id+"'");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Successfully Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request, response);                        
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Employee.jsp");
                            rsd.forward(request, response);                                                    
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Fields is Empty !");
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
