package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import com.mongodb.*;
import org.bson.Document;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");

   try
   {
    String name=request.getParameter("name");
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    String interests=request.getParameter("interests");
    String org=request.getParameter("org");
    String job=request.getParameter("job");
    email="anjali@ufl.edu";
    
MongoClient mongo1=new MongoClient();
    DB db1=mongo1.getDB("WebDB");
    DBCollection user1=db1.getCollection("User");
    Document d1=new Document();
    d1.put("Email",email);
    DBObject t1=new BasicDBObject(d1);    
    
    DBCursor cur1=user1.find(t1);    
    System.out.println(cur1.size()+"asfdsgggggggggggggggggggggggggggggggggggggggggggggggg");
    if(cur1.size()>0)
    {        response.sendRedirect("index.html?err=Email ID already registered with the application");
    
    }
    else
    {
         Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
 MongoClient mongo = new MongoClient();	
  DB db = mongo.getDB("WebDB");

int id=100;
        DBCollection user = db.getCollection("User");
        DBCursor uid=user.find();
        id=id+uid.count()+1;
        
        Document d=new Document();
        d.put("UID",id);
        d.put("Name",name);
        d.put("Email",email);
        d.put("Password",password);
        d.put("Interests", interests);
        d.put("Org",org);
        d.put("Job",job);
        d.put("DOJ",sdf.format(date));
        DBObject ob=new BasicDBObject(d);
        user.insert(ob);
   d=new Document();
   d.put("UID",id);
   ob=new BasicDBObject(d);
   DBCursor confirm=user.find(ob);
if(confirm.hasNext())
  response.sendRedirect("index.html?err=Registration Successfull. Login to Continue");
    }
   }catch(Exception e)
   {
       e.printStackTrace();
   }
    
           
         
       
    

      out.write('\n');
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
