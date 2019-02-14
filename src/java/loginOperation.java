import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class loginOperation extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String usrnm = request.getParameter("Usrnm");
            String usrpswd = request.getParameter("psswd");
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shalimaresol","shalimaresol");
                Statement stmt=con.createStatement();                     
                ResultSet rs = stmt.executeQuery("select * from userreg where  U_ID='"+usrnm+"' and U_PASS='"+usrpswd+"'");
                if(rs.next()){
                    response.sendRedirect("Welcome.jsp");                    
                }else{
                    request.setAttribute("errmsg","Invalid Username or Password");
                    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                }
            }catch(Exception ex){
                ex.printStackTrace();    
                request.setAttribute("errmsg","Link Not Established !");
                RequestDispatcher rsd = request.getRequestDispatcher("/login.jsp");
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
