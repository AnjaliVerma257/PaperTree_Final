package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import com.mongodb.*;
import org.bson.Document;

public final class Settings_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- \n");
      out.write("\n");
      out.write("Project Codename: Papertree\n");
      out.write("Codding By Anjali Verma\n");
      out.write("Version 1.0\n");
      out.write("\n");
      out.write("(In Development Phase)\n");
      out.write("-->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\">\n");
      out.write("\n");
      out.write("<title>Title | Backend</title>\n");
      out.write("<!---------------------------- CSS ------------------------------------------>\n");
      out.write("\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/style.css\">\n");
      out.write("        \n");
      out.write("\t\n");
      out.write("<!---------------------------- CSS ------------------------------------------>\n");
      out.write("\n");
      out.write("<!---------------------------- JS ------------------------------------------->\n");
      out.write("\n");
      out.write("\t<script src=\"js/jquery.js\"></script>\n");
      out.write("\t<script src=\"js/tabs.js\"></script>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\n");
      out.write("<!---------------------------- JS ------------------------------------------->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body style=\"background:url('images/bg.jpg') 0px 150px no-repeat\">\n");
      out.write("\t\t<header>\n");
      out.write("\t\t\t<div id=\"pre-header\">\n");
      out.write("\t\t\t\t<div class=\"logo\"><a href=\"#\"><img src=\"images/logo.png\" class=\"\" alt=\"\"></a></div>\n");
      out.write("\t\t\t\t<div class=\"user-sect\">\n");
      out.write("\t\t\t\t\t<span class=\"user-details\"><h1>Hi,</h1><h2>  ");

                                                String username=(String)session.getAttribute("name");
                                                if(username==null)
                                                {
                                                 response.sendRedirect("index.html?err=Login To Access Application");
                                                }
                                                else
                                                {
                                                    out.println(username);
                                                }
                                                
      out.write("</h2></span>\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t<span class=\"user-set\"><a href=\"#\">Settings</a>&nbsp;|&nbsp; <a href=\"#\">Logout</a></span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</header>\n");
      out.write("\t\n");
      out.write("\t<div id=\"page-frame\">\n");
      out.write("\t\t<div id=\"page\">\n");
      out.write("\t\t\t<div id=\"sidebar\">\n");
      out.write("\t\t\t\t<ul class=\"tabs\" id=\"tabs\">\n");
      out.write("\t\t\t\t\t<li style=\"width:190px;\"><a href=\"#change-Pass\">Change Password</a></li>\n");
      out.write("\t\t\t\t\t<li style=\"width:190px;\"><a href=\"#change-mail\">Change Email</a></li>\n");
      out.write("\t\t\t\t\t<li style=\"width:190px;\"><a href=\"#interests\">Add Interest</a></li>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"content\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div id=\"change-Pass\" class=\"tab-section dashboard\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"recent-post-dashboard\">\n");
      out.write("\t\t\t\t\t\t<h1 class=\"main-heading\">Change Password</h1>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div style=\"width:450px;margin:50px 0px 0px 30px;\">\t\n");
      out.write("                                                    <form method=\"post\" action=\"ChangePassword.jsp\">\n");
      out.write("\t\t\t                <label for=\"opassword\" class=\"log-label\">Old Password:</label>\n");
      out.write("\t\t\t                <input type=\"password\" name=\"opassword\" id=\"opassword\" class=\"logtext\">\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t\t                <div class=\"clearfix\"></div>\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t                <label for=\"password\" id=\"opasswordl\"></label>\n");
      out.write("\t\t\t\t            <label for=\"password\" class=\"log-label\">New Password:</label>\n");
      out.write("\t\t\t                <input type=\"password\" name=\"npassword\" id=\"npassword\" class=\"logtext\">\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t\t                <div class=\"clearfix\"></div>\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t                <label for=\"npassword\" id=\"npasswordl\"></label>\n");
      out.write("\t\t\t                <label for=\"rnpassword\" class=\"log-label\">Re-Enter New Password:</label>\n");
      out.write("\t\t\t                <input type=\"password\" name=\"rnpassword\" id=\"rnpassword\" class=\"logtext\">\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t\t                <div class=\"clearfix\"></div>\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t                <label for=\"password\" id=\"rnpasswordl\"></label><br>\n");
      out.write("\t\t\t                                \n");
      out.write("\t\t\t                <input type=\"submit\" name=\"ChangePass\" value=\"UPDATE\" class=\"button\" style=\"margin:30px 0px 0px 350px;\">\n");
      out.write("\t\t\t                </form>\n");
      out.write("\t\t                 </div>\n");
      out.write("\t\t\t  \t\t</div>\t\t\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t<div id=\"change-mail\" class=\"tab-section dashboard\">\n");
      out.write("                    <div class=\"recent-post-dashboard\">\n");
      out.write("\t\t\t\t\t\t<h1 class=\"main-heading\">Change Email</h1>\n");
      out.write("                                                                \n");
      out.write("\t\t\t\t\t\t<div style=\"width:450px;margin:50px 0px 0px 30px;\">\t\n");
      out.write("                                                    <form method=\"post\" action=\"ChangeEmail.jsp\">\n");
      out.write("\t\t\t                <label for=\"email\" class=\"log-label\">New Email:</label>\n");
      out.write("\t\t\t                <input type=\"email\" name=\"oemail\" id=\"oemail\" class=\"logtext\">\n");
      out.write("\t\t\t                <label for=\"email\" id=\"oemaill\"></label>\n");
      out.write("\t\t\t\t                <div class=\"clearfix\"></div>\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t                <label for=\"nemail\" class=\"log-label\">New Email:</label>\n");
      out.write("\t\t\t                <input type=\"email\" name=\"nemail\" id=\"nemail\" class=\"logtext\">\n");
      out.write("\t\t\t                <label for=\"nemail\" id=\"nemaill\"></label>\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t\t                <div class=\"clearfix\"></div>\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t                <label for=\"rnemail\" class=\"log-label\">Re-Enter New Email:</label>\n");
      out.write("\t\t\t                <input type=\"email\" name=\"rnemail\" id=\"rnemail\" class=\"logtext\">\n");
      out.write("\t\t\t                <label for=\"email\" id=\"rnemaill\"></label>\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t\t                <div class=\"clearfix\"></div>\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t                <input type=\"submit\" name=\"ChangeEmail\" value=\"UPDATE\" class=\"button\" style=\"margin:50px 0px 0px 350px;\">\n");
      out.write("\t\t\t                </form>\n");
      out.write("\t\t                 </div>\n");
      out.write("\t\t\t\t\t</div>\t\t\t\t            \n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("        \t<div id=\"interests\" class=\"tab-section dashboard\">\n");
      out.write("\t\t\t\t<div class=\"recent-post-dashboard\">\n");
      out.write("\t\t\t\t\t<h1 class=\"main-heading\">Add Interest</h1>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div style=\"width:650px;margin:50px 0px 0px 30px;\">\t\n");
      out.write("                                            <form method=\"post\" action=\"AddInterests.jsp\">\t\n");
      out.write("\t\t\t\t         <label for=\"rnemail\" class=\"log-label\">Enter Interest :</label>\n");
      out.write("\t\t\t\t         <textarea name=\"interests\" id=\"interests\" class=\"logtext\"></textarea><br>\n");
      out.write("\t\t\t\t         <label for=\"interests\" id=\"interestsl\"></label><br>\n");
      out.write("\t\t\t\t                \n");
      out.write("\t\t\t\t                <div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t                \n");
      out.write("\t\t\t\t         <input type=\"submit\" name=\"AddInterests\" value=\"Add\" class=\"button\" style=\"margin:25px 0px 0px 580px;\">    \n");
      out.write("\t\t\t\t              </form>\n");
      out.write("\t                </div>\n");
      out.write("\t\t\t\t</div>\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div style=\"clear:both;\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t<script>\n");
      out.write("\t\t$(document).ready(\n");
      out.write("\t\t$('#srch-max').click(function(){\n");
      out.write("\t\t\n");
      out.write("\t\t        $('.srch-box').css({\n");
      out.write("\t\t        'width':\"auto\", \n");
      out.write("\t\t        'height':\"auto\",\n");
      out.write("\t\t        'min-height':\"50px\", \n");
      out.write("\t\t        'background':\"transparent\",\n");
      out.write("\t\t        'margin':\"0px\",\n");
      out.write("\t\t        'box-shadow':\"0px 0px rgba(0,0,0,0)\",\n");
      out.write("\t\t        'border':\"0px\"\n");
      out.write("\t\t        });\n");
      out.write("\t\t        \n");
      out.write("\t\t        $('.kwd-set').css({\n");
      out.write("\t\t        'float':\"right\", \n");
      out.write("\t\t        'clear':\"both\",\n");
      out.write("\t\t        'margin':\"10px\",\n");
      out.write("\t\t        'width':\"auto\",\n");
      out.write("\t\t        'height':\"auto\",\n");
      out.write("\t\t        });\n");
      out.write("\t\t        \n");
      out.write("\t\t        $('.srch-box h3').css({\n");
      out.write("\t\t        'display':\"none\" \n");
      out.write("\t\t        });\n");
      out.write("\t\t        \n");
      out.write("\t\t        $('.srch-results').css({\n");
      out.write("\t\t        'display':\"block\",\n");
      out.write("\t\t        'opacity':\"1\",\n");
      out.write("\t\t        'height':\"1000px\"\n");
      out.write("\t\t        });\n");
      out.write("\t\t        \n");
      out.write("\t\t\t})\t\t\t\n");
      out.write("\t\t)\t\n");
      out.write("\t</script>\n");
      out.write("\t\n");
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
