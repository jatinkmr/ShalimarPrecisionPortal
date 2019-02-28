package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserReg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User Registration</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"regis.css\">         \n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"#9df66e\">\n");
      out.write("        <div class=\"header1\">\n");
      out.write("            <center><h2>Shalimar Precision Online Enterprise Online Solution</h2></center>\n");
      out.write("        </div>         \n");
      out.write("        <div style=\"background-color:#00cc66;clear:both;text-align:center\">\n");
      out.write("            <marquee><b><font color=\"#12335b\">Announcements   >> New Products Has Been\n");
      out.write("                    Added to Our Portal Regularly.Please Be Updated........</font></b></marquee>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"subhd\">\n");
      out.write("            <center><h2>User Registration Management Portal</h2></center>\n");
      out.write("        </div>         \n");
      out.write("        <div id=\"images\">\n");
      out.write("            <img src=\"images/usrReg.jpg\" height=\"400px\" width=\"450px\" border=\"3\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"dtls\">\n");
      out.write("            <center>               \n");
      out.write("                <form action=\"ureg\" name=\"myfrm\">                    \n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">User ID</font> <input type=\"text\" name=\"uid\" placeholder=\"Enter User ID\" required/><br/><br/>                    \n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">User Type</font> \n");
      out.write("                    <select name=\"usrtyp\">\n");
      out.write("                        <option value=\"customer\" selected>Customer</option>\n");
      out.write("                        <option value=\"employee\">Employee</option>\n");
      out.write("                        <option value=\"administrator\">Administrator</option>\n");
      out.write("                        <option value=\"manager\">Manager</option>\n");
      out.write("                        <option value=\"supplier\">Supplier</option>                        \n");
      out.write("                    </select>\n");
      out.write("                    <br/><br/>                    \n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">User Name</font> <input type=\"text\" name=\"unm\" placeholder=\"Enter User Name\" required/><br/><br/>                    \n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Password</font> <input type=\"password\" name=\"upsswd1\" placeholder=\"Enter password\" required/><br/><br/>                    \n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Re-Enter Password</font> <input type=\"password\" name=\"upsswd2\" placeholder=\"Enter password\" required/><br/><br/>                    \n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Security Question</font>\n");
      out.write("                    <select name=\"secques\">                        \n");
      out.write("                        <option value=\"What was your Childhood nickname ?\">What was your Childhood nickname ?</option>\n");
      out.write("                        <option value=\"What is the middle name of your youngest child ?\">What is the middle name of your youngest child ?</option>\n");
      out.write("                        <option value=\"What is your oldest sibling's middle name ?\">What is your oldest sibling's middle name ?</option>\n");
      out.write("                        <option value=\"What was your childhood phone number including area code ?\">What was your childhood phone number including area code ?</option>\n");
      out.write("                        <option value=\"In what city or town was your first job ?\">In what city or town was your first job ?</option>\n");
      out.write("                        <option value=\"What was your favourite place to visit as a Child ?\">What was your favourite place to visit as a Child ?</option>\n");
      out.write("                    </select>\n");
      out.write("                    <br/><br/>                    \n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Security Answer</font> <input type=\"text\" name=\"sans\" placeholder=\"Enter Your Answer\" required/><br/><br/>                    \n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">User Contact</font> <input type=\"text\" name=\"ucon\" placeholder=\"Enter User Contact No\" required/><br/><br/>                                        \n");
      out.write("                    <input type=\"submit\" name=\"sgn\" value=\"Create\">\n");
      out.write("                    <input type=\"reset\" name=\"rst\" value=\"Clear\">\n");
      out.write("                    <a href=\"login.jsp\"><input type=\"button\" value=\"Already Have An Account\"></a>                    \n");
      out.write("                    <center><h3>");
      out.print(request.getAttribute("errmsg") );
      out.write("</h3></center>\n");
      out.write("                </form>\n");
      out.write("            </center>\n");
      out.write("        </div>                                                \n");
      out.write("        <div class=\"foot\">                    \n");
      out.write("            <h2>This Project Has Been Developed By Mr. Jatin Kumar \"Kamboj\" and Copyright © 2011 <a href=\"#\">Shalimar Precision EnterPrise Online Solution</a></h2>\n");
      out.write("        </div>                        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
