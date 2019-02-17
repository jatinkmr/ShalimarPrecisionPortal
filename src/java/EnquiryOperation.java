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
                
                }
            }catch(Exception ex){
                request.setAttribute("errmsg","An Error Occurred While Establishing The Connection!!");
                RequestDispatcher rsd = request.getRequestDispatcher("/Enquiry.jsp");
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
	 // Another comment
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
