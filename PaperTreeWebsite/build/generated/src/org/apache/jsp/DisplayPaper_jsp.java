package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import com.mongodb.*;
import org.bson.Document;

public final class DisplayPaper_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<meta content=\"text/html; charset=UTF-8\" http-equiv=\"Content-Type\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/style.css\">\n");
      out.write("<title>PaperTree</title>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body style=\"background:url('images/bg.jpg') 0px 150px no-repeat\">\n");
      out.write("\t\t<header>\n");
      out.write("\t\t\t<div id=\"pre-header\">\n");
      out.write("\t\t\t\t<div class=\"logo\"><a href=\"backend.jsp\"><img src=\"images/logo.png\" class=\"\" alt=\"\"></a></div>\n");
      out.write("\t\t\t\t<div class=\"user-sect\">\n");
      out.write("\t\t\t\t\t<span class=\"user-details\"> <h1>Hi,</h1> <h2>");

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
      out.write("                                        <span class=\"user-set\"><a href=\"Settings.jsp\">Settings</a>&nbsp;|&nbsp; <a href=\"SignOut.jsp\">Logout</a></span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</header>\n");
      out.write("\t<div id=\"page-frame\" class=\"post-page\">\n");
      out.write("<h1 class=\"main-heading\">\t\n");
 
   try{
    MongoClient mongo=new MongoClient();
    DB db=mongo.getDB("WebDB");
 String name=request.getParameter("id");
 
 int l=name.length();
DB db1=mongo.getDB("TFIDF");
out.println("PAPER NAME:"+"              "+name+"<br>");
DBCollection table=db1.getCollection(name);
DBCursor c=table.find();

Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");


String uid=(String)session.getAttribute("UID");
//String uid="101";
DBCollection reading=db.getCollection("Readings");
Document d=new Document();
d.put("UID",uid);

DBObject ob=new BasicDBObject(d);
DBCursor c1=reading.find(ob);
String in=null;
DBCursor cur=reading.find(ob);
if(cur.hasNext())
{
    cur.next();
    DBObject k=cur.curr();
   in=k.get("History").toString();
     DBObject ob1=new BasicDBObject(new Document("UID",uid));
     String temp="["+name+" "+sdf.format(date)+"]"+in;
        DBObject ob2=new BasicDBObject(new Document("$set", new Document("History",temp)));
        reading.update(ob1,ob2);
}
else
{
    String temp="["+name+" "+sdf.format(date)+"]";
    Document tem=new Document();
    tem.put("UID", uid);
    tem.put("History",temp);
    reading.insert(new BasicDBObject(tem));
}

   out.println("<textarea style='width:500px; height:500px'>");
   
   while(c.hasNext())
{
    c.next();
    DBObject k=c.curr();
    
    String content = k.get("Word").toString();
    out.println(content);
}
   out.println("</TextArea>");    
   }catch(Exception e){e.printStackTrace();}
   

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
