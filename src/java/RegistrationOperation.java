import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet(urlPatterns = {"/RegistraionOperation"})
public class RegistrationOperation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action,usrid,usrtp,usrnm,upass1,upass2,sques,san,con;
            action = request.getParameter("sgn");
            usrid = request.getParameter("uid");
            usrtp = request.getParameter("usrtyp");
            upass1 = request.getParameter("upsswd1");
            upass2 = request.getParameter("upsswd2");
            sques = request.getParameter("secques");
            san = request.getParameter("sans");
            con = request.getParameter("ucon");            
            usrnm = request.getParameter("unm");
            
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt=conn.createStatement();                     
                if((!"".equals(usrid))&&(!"".equals(usrtp))&&(!"".equals(usrnm))&&(!"".equals(upass1))&&(!"".equals(upass2))&&(!"".equals(sques))&&(!"".equals(san))&&(!"".equals(con))){
                    if(upass1.equals(upass2)){
                        int a = stmt.executeUpdate("insert into userreg values('"+usrid+"','"+usrtp+"','"+upass1+"','"+sques+"','"+san+"','"+con+"','"+usrnm+"')");
                        if(a > 0){
                            request.setAttribute("errmsg","User Created Successfully !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/UserReg.jsp");
                            rsd.forward(request, response);
                        }else{
                            request.setAttribute("errmsg","User Doesn't Created !");
                            RequestDispatcher rsd = request.getRequestDispatcher("/UserReg.jsp");
                            rsd.forward(request, response);                        
                        }
                    }else{
                        request.setAttribute("errmsg","Password Didn't Match !");
                        RequestDispatcher rsd = request.getRequestDispatcher("/UserReg.jsp");
                        rsd.forward(request, response);
                    }
                }else{
                    request.setAttribute("errmsg","Some of the Given Fields is Empty !");
                    RequestDispatcher rsd = request.getRequestDispatcher("/UserReg.jsp");
                    rsd.forward(request, response);
                }
            }catch(Exception ex){
                request.setAttribute("errmsg","An Error Has Been Occurred While Creating A New User !");
                RequestDispatcher rsd = request.getRequestDispatcher("/UserReg.jsp");
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
