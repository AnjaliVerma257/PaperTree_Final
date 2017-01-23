package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import com.mongodb.*;
import org.bson.Document;

public final class success_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<meta content=\"text/html; charset=UTF-8\" http-equiv=\"Content-Type\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/style.css\">\n");
      out.write("<title>Title | Backend</title>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body style=\"background:url('images/bg.jpg') 0px 150px no-repeat\">\n");
      out.write("    <header>\n");
      out.write("\t\t\t<div id=\"pre-header\">\n");
      out.write("                            <div class=\"logo\"><a href=\"backend.jsp\"><img src=\"images/logo.png\" class=\"\" alt=\"\"></a></div>\n");
      out.write("\t\t\t\t<div class=\"user-sect\">\n");
      out.write("\t\t\t\t\t<span class=\"user-details\"> <h1>Hi,</h1> <h2>Username</h2></span>\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t<span class=\"user-set\"><a href=\"#\">Settings</a>&nbsp;|&nbsp; <a href=\"#\">Logout</a></span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</header>\n");
      out.write("    <div id=\"page-frame\">\n");
      out.write("\n");

String success=request.getParameter("success");
if(success=="yes")
{
    out.println("Your password has been sent to your registered Email ID<br>");
    
    out.println("<a href='index.html'>Sing In</a>");
    out.println("<div id='page-frame'>");
    
			out.println("<h1 class='frame-title'>Need Help ?</h1>");
            out.println("<form  method='post' action='mail' class='recover'>");
                out.println("<div class='recover-field'>");
            		out.println("<p>Enter your e-mail associated with your paper tree account in order to regain account access. A verification mail will be sent to your e-mail id to reset your account password.</p>");
            		
	                out.println("<label for='email'>Enter your Email Id:</label>&nbsp;&nbsp;&nbsp;&nbsp;");
	                out.println("<input type='email' name='email' onchange='checkEmail(this);' onblur='checkEmail(this);'  onsubmit='checkEmail(this);' id='email' class='recover-field-email'><br><br>");
	                
	                out.println("<div style='width:200px;text-align:center;margin:20px auto 0px auto'>");
		                out.println("<input type='submit' name='Submit' value='SUBMIT' class='button'>");                                                                                                                       
		                out.println("<input type='button' name='Clear' value='CLEAR' class='button'>");
	                out.println("</div></div></form>/div>");
}
    else
{   
    out.println("Your password has been sent to your registered Email ID<br>");
    
    out.println("<a href='index.html'>Sing In</a>");
    out.println("<div id='page-frame'>");
    
			out.println("<h1 class='frame-title'>Need Help ?</h1>");
            out.println("<form  method='post' action='mail' class='recover'>");
                out.println("<div class='recover-field'>");
            		out.println("<p>Enter your e-mail associated with your paper tree account in order to regain account access. A verification mail will be sent to your e-mail id to reset your account password.</p>");
            		
	                out.println("<label for='email'>Enter your Email Id:</label>&nbsp;&nbsp;&nbsp;&nbsp;");
	                out.println("<input type='email' name='email' onchange='checkEmail(this);' onblur='checkEmail(this);'  onsubmit='checkEmail(this);' id='email' class='recover-field-email'><br><br>");
	                
	                out.println("<div style='width:200px;text-align:center;margin:20px auto 0px auto'>");
		                out.println("<input type='submit' name='Submit' value='SUBMIT' class='button'>");                                                                                                                       
		                out.println("<input type='button' name='Clear' value='CLEAR' class='button'>");
	                out.println("</div></div></form>/div>");
}

       
    

      out.write("\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("\n");
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
