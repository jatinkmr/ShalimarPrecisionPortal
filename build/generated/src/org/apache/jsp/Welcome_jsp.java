package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Home Page Portal</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"remstyls.css\">\n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"#0090a2\">        \n");
      out.write("        <div class=\"navbar\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"Welcome.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"Enquiry.jsp\">Enquiry</></li>\n");
      out.write("                <li><a href=\"Customer.jsp\">Customer</a></li>\n");
      out.write("                <li><a href=\"Employee.jsp\">Employee</a></li>\n");
      out.write("                <li><a href=\"#\">Transactions</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"Inventory.jsp\">Inventory</a></li>\n");
      out.write("                        <li><a href=\"Sales.jsp\">Sales</a></li>\n");
      out.write("                        <li><a href=\"Promotion.jsp\">Promotion</a></li>\n");
      out.write("                        <li><a href=\"Payment.jsp\">Payment</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>     \n");
      out.write("                <li><a href=\"about.jsp\">About Us</a></li>\n");
      out.write("                <li><a href=\"login.jsp\">LogOut</a></li>\t\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <center><h2>Shalimar Precision Online Enterprise Online Solution</h2></center>\n");
      out.write("        </div>\n");
      out.write("        <div style=\"background-color:#00cc66;clear:both;text-align:center\">\n");
      out.write("            <marquee><b><font color=\"#12335b\">Announcements   >> New Products Has Been\n");
      out.write("                    Added to Our Portal Regularly.Please Be Updated........</font></b></marquee>\n");
      out.write("        </div>\n");
      out.write("        <br/><br/><br/>\n");
      out.write("        <center>\n");
      out.write("            <div class=\"Slider\">\n");
      out.write("                <fieldset><legend><b><u>Photo Gallery</u></b></legend><br>\n");
      out.write("                    <img src=\"images/atprts.jpg\" width=\"275px\" height=\"200px\" align=\"center\" border=\"3\">\n");
      out.write("                    <img src=\"images/Logo.jpg\" width=\"275px\" height=\"200px\" align=\"center\" border=\"3\">\n");
      out.write("                    <img src=\"images/autoprts.jpg\" width=\"275px\" height=\"200px\" align=\"center\" border=\"3\">\n");
      out.write("                </fieldset>\n");
      out.write("            </div>\n");
      out.write("        </center>\n");
      out.write("        <br/><br/><br/><br/><br/>\n");
      out.write("        <div class=\"foot\">                    \n");
      out.write("            <h2>This Project Has Been Developed By Mr. Jatin Kumar \"Kamboj\" and Copyright © 2011 <a href=\"#\">Shalimar Precision EnterPrise Online Solution</a></h2>\n");
      out.write("        </div>                \n");
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
