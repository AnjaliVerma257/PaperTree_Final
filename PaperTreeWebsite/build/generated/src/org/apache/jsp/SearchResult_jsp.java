package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import com.mongodb.*;
import org.bson.Document;

public final class SearchResult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>PaperTree</title>\n");
      out.write("<!---------------------------- CSS ------------------------------------------>\n");
      out.write("\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/style.css\">\n");
      out.write("        \n");
      out.write("\t\n");
      out.write("<!---------------------------- CSS ------------------------------------------>\n");
      out.write("\n");
      out.write("<!---------------------------- JS ------------------------------------------->\n");
      out.write("\n");
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
      out.write("                            <div class=\"logo\"><a href=\"backend.jsp\"><img src=\"images/logo.png\" class=\"\" alt=\"\"></a></div>\n");
      out.write("\t\t\t\t<div class=\"user-sect\">\n");
      out.write("\t\t\t\t\t<span class=\"user-details\"><h1>Hi,</h1><h2>\n");
      out.write("                                                ");

                                                    
                                                String username=(String)session.getAttribute("name");
                                                String uid1=session.getAttribute("UID").toString();
                                                if(uid1==null)
                                                {
                                                 response.sendRedirect("index.html?err=Login To Access Application");
                                                }
                                                else
                                                {
                                                    out.println(username);
                                                }
                                                   
                                                
      out.write("\n");
      out.write("                                                                                   </h2></span>\n");
      out.write("                                               \n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("                                        <span class=\"user-set\"><a href=\"Settings.jsp\">Settings</a>&nbsp;|&nbsp; <a href=\"SignOut.jsp\">Logout</a></span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("                        ");

                            String search=request.getParameter("search");
                            
                                                 MongoClient mongo=new MongoClient();
                                                 DB db=mongo.getDB("TFIDF");
                                               Set<String> x=db.getCollectionNames();
                                               Object in[]=x.toArray();
                                               ArrayList op=new ArrayList();
                                               Document d=new Document("Word",search);
                                               for(int i=0;i<in.length;i++)
                                               {                                                   
                                               if(in[i].equals("IDF") || in[i].equals("system.indexes"))
                                               {}
                                               else
                                               {
                                                   DBCollection c=db.getCollection(in[i].toString());
                                                   DBObject ob=new BasicDBObject(d);
                                                   DBCursor cur=c.find(ob);
                                                   if(cur.hasNext())
                                                       op.add(in[i]);
                                                   
                                                   
                                               }
                                                                                            
                                               }   
                                               System.out.println(op.toString());
                                               System.out.println("done");
                                                  
      out.write("\n");
      out.write("\t\t</header>\n");
      out.write("\t\n");
      out.write("\t<div id=\"page-frame\">\n");
      out.write("\t\t<div id=\"page\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<div class=\"kwd-set\">\n");
      out.write("                                                                    <form action=\"SearchResult.jsp\" method=\"post\">\n");
      out.write("                                                                        <div class=\"kwd-set\"><input type=\"text\" name=\"search\" value=\"search\" onClick=\"this.value='';\">\n");
      out.write("                                                                            <button type=\"submit\" id=\"srch-max\" class=\"srch-btn\" ></button></div>\n");
      out.write("                                                                            </form>\n");
      out.write("                                                                    \n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<!--div class=\"search_bar\">\n");
      out.write("                                                                    <form action=\"SearchResult.jsp\" method=\"post\">\n");
      out.write("                                                                        <input type=\"text\" name=\"search\" value=\"search\" onClick=\"this.value='';\" >\n");
      out.write("                                                                            <button type=\"submit\">Search</button>\n");
      out.write("                                                                            </form>\n");
      out.write("                                                                    <div class=\"clearfix\"></div>\n");
      out.write("                                             </div-->\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"recent-post-dashboard\">\n");
      out.write("                                            \n");
      out.write("\t\t\t\t\t\t<h1 class=\"main-heading\">Search Results</h1>\n");
      out.write("                                    \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("                                   \n");
      out.write("                                    \n");
      out.write("                                    ");


                                                for(int i=0;i<op.size();i++)
                                                {
out.println("<div class='last-post'><ul>");                                                
out.println("<div class='post-title'>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" +op.get(i)+ "'>"  + op.get(i) +"</a></h3>");
out.println("</div>");	
out.println("<div class='last-post-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>12/12/12</a>");

out.println("</div>");									
out.println("<div class='clearfix'></div>");
out.println("</div>");	
                                                }
                                                
      out.write("\n");
      out.write("\t\t\t\t   \n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div style=\"clear:both;\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\n");
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
