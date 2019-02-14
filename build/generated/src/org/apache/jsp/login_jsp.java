package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Shalimar Precision Enterprise Online Solution</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"lgnstyls.css\">    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <center><h1>Shalimar Precision Enterprise Online Solution</h1></center>\n");
      out.write("        </div>        \n");
      out.write("        <div class=\"bck\">\n");
      out.write("            <marquee direction=\"right\"><h3>We Deliver Most Appropriate Auto-Parts To Our Clients At Reasonable Prices SINCE 2011</h3></marquee>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"box\">\n");
      out.write("            <h2>Login</h2>\n");
      out.write("            <form name=\"myfrm\" action=\"Wel\" method=\"post\">\n");
      out.write("                <div class=\"inputbox\">\n");
      out.write("                    <input type=\"text\" name=\"Usrnm\" required>\n");
      out.write("                    <label>Username</label>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"inputbox\">\n");
      out.write("                    <input type=\"password\" name=\"psswd\" required>\n");
      out.write("                    <label>Password</label>\n");
      out.write("                </div>\n");
      out.write("                <center>\n");
      out.write("                    <input id=\"sbmt\" type=\"Submit\" name=\"Submit\" value=\"LogIn\" >\n");
      out.write("                    <a href=\"UserReg.jsp\"><input id=\"sgn\" type=\"button\" name=\"signin\" value=\"SignIn\"></a>\n");
      out.write("                </center>                \n");
      out.write("            </form>\n");
      out.write("            <center><h3>");
      out.print(request.getAttribute("errmsg") );
      out.write("</h3></center>\n");
      out.write("        </div>\t\t\n");
      out.write("        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>\n");
      out.write("        <div class=\"foot\">        \n");
      out.write("            <h2>This Project Has Been Developed By Mr. Jatin Kumar \"Kamboj\" and Copyright © 2011 <a href=\"#\">Shalimar Precision EnterPrise Online Solution</a></h2>\n");
      out.write("        </div>\n");
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
