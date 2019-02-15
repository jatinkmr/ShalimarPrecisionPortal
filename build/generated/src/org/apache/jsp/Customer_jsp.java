package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Customer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Customer Management Portal</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"remstyls.css\">\n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"##0099ff\" text=\"#12335b\">\n");
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
      out.write("                </li>\n");
      out.write("                <li><a href=\"about.jsp\">About Us</a></li>\n");
      out.write("                <li><a href=\"login.jsp\">LogOut</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <center><h2>Shalimar Precision Online Enterprise Online Solution</h2></center>\n");
      out.write("        </div>\n");
      out.write("        <div style=\"background-color:#00cc66;clear:both;text-align:center\">\n");
      out.write("            <marquee><b><font color=\"#12335b\">Announcements   >> New Products Has Been\n");
      out.write("                    Added to Our Portal Regularly.Please Be Updated........</font></b></marquee>\n");
      out.write("        </div><br/>\n");
      out.write("        <div class=\"subhd\">\n");
      out.write("            <center><h2>Customer Management Portal</h2></center>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"images\">\n");
      out.write("            <img src=\"images/customer_servic.jpg\" height=\"400px\" width=\"500px\" border=\"3\">\n");
      out.write("        </div>\n");
      out.write("        <br/> \n");
      out.write("        <div class=\"dtls\">\n");
      out.write("            <center>               \n");
      out.write("                <form action=\"cstmr\" name=\"myfrm\">\n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Customer ID</font> <input type=\"text\" name=\"cid\" placeholder=\"Enter Customer ID\"/><br/><br/>\n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Customer Name</font> <input type=\"text\" name=\"cn\" placeholder=\"Enter Customer Name\" /><br/><br/>\n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Customer Contact</font> <input type=\"text\" name=\"ccn\" placeholder=\"Enter Customer Contact\" /><br/><br/>\n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Customer Address</font> <input type=\"text\" name=\"cdd\" placeholder=\"Enter Your Address Here\"/><br/><br/>\n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Customer Email</font> <input type=\"text\" name=\"cml\" placeholder=\"Enter Customer Email\" /><br/><br/>\n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Customer City</font> <input type=\"text\" name=\"cty\" placeholder=\"Enter Customer City\" /><br/><br/>\n");
      out.write("                    <font size=\"4px\" face=\"Lucida Calligraphy\" color=\"#894d10\">Customer State</font> <input type=\"text\" name=\"ct\" placeholder=\"Enter Customer State\" /><br/><br/>\t\t\t\t\t\t\t\t\t\t\n");
      out.write("                    <input type=\"submit\" name=\"cstmrsb\" value=\"Insert\">\n");
      out.write("                    <input type=\"submit\" name=\"cstmrsb\" value=\"Update\">\n");
      out.write("                    <input type=\"submit\" name=\"cstmrsb\" value=\"Delete\">\n");
      out.write("                    <input type=\"submit\" name=\"cstmrsb\" value=\"Search\">\n");
      out.write("                    <input type=\"reset\" value=\"Clear\">\n");
      out.write("                    <center><h3>");
      out.print(request.getAttribute("errmsg") );
      out.write("</h3></center>\n");
      out.write("                </form>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("        <br/>    \n");
      out.write("        <div class=\"foot\">                      \n");
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
