import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet(urlPatterns = {"/PromotionOperation"})
public class PromotionOperation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action,prmid,prnnm,prprc,prpid;
            action = request.getParameter("prmsb");
            System.out.println("Your Action : "+action);
            prmid = request.getParameter("pid");
            prnnm = request.getParameter("pnm");
            prprc = request.getParameter("pprc");
            prpid = request.getParameter("prid");
            
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt=conn.createStatement(); 
                if(action.equals("Insert")){
                    if((!"".equals(prmid))&&(!"".equals(prnnm))&&(!"".equals(prprc))&&(!"".equals(prpid))){
                        int a = stmt.executeUpdate("insert into promotion values ('"+prmid+"','"+prnnm+"','"+prprc+"','"+prpid+"') ");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Inserted Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
                            rsd.forward(request, response);                                                    
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Inserted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
                        rsd.forward(request, response);                        
                    }                
                }else if(action.equals("Update")){
                    if((!"".equals(prmid))&&(!"".equals(prnnm))&&(!"".equals(prprc))&&(!"".equals(prpid))){
                        int a = stmt.executeUpdate("update promotion set pr_name='"+prnnm+"' ,pr_prc='"+prprc+"' ,pro_id='"+prpid+"'  where pr_id='"+prmid+"' ");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Successfully Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
                            rsd.forward(request, response);                        
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Updated !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg", "Some of the Given Fields is Empty !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
                        rsd.forward(request, response);                    
                    }                         
                }else if(action.equals("Delete")){
                    if(!"".equals(prmid)){
                        int a = stmt.executeUpdate("delete from promotion where pr_id='"+prmid+"' ");
                        if(a > 0){
                            request.setAttribute("errmsg","Record Successfully Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
                            rsd.forward(request, response);                    
                        }else{
                            request.setAttribute("errmsg","Record Doesn't Deleted !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
                            rsd.forward(request, response);                    
                        }
                    }else{
                        request.setAttribute("errmsg","Plesae Fill The Promotion ID !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
                        rsd.forward(request, response);                    
                    }                
                }else if(action.equals("Search")){
                
                }
                
            }catch(Exception ex){
                request.setAttribute("errmsg","An Error Occurred While Establishing The Connection !");
                RequestDispatcher rsd = request.getRequestDispatcher("/Promotion.jsp");
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
