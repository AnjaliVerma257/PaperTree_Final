package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import com.mongodb.*;
import org.bson.Document;

public final class SignIn_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    String email=request.getParameter("Email");
    String password=request.getParameter("Password");
    String username=null;
    MongoClient mongo=new MongoClient();
    DB db=mongo.getDB("WebDB");
    DBCollection user=db.getCollection("User");
    Document d=new Document();
    d.put("Email",email.toString());
    DBObject t=new BasicDBObject(d);    
    DBCursor cur=user.find(t);
    
    if(cur.hasNext())
    {
    cur.next();
    DBObject ob=cur.curr();
    username=(String)ob.get("Name");
    
    
    String pass=(String)ob.get("Password");
    
    if(pass.equals(password))
    {
        
    HttpSession session1=request.getSession();
                    session1.setAttribute("name", username); 
                    session1.setAttribute("email",email);
                    session1.setAttribute("UID",ob.get("UID").toString());
                    
                    
                    System.out.println(username);
                    response.sendRedirect("backend.jsp");
    }
    else
    {
        response.sendRedirect("index.html?err=Username/Password Incorrect");
        //add msg box for error to be displayed on the main page
    }
    }
    else
    {
        response.sendRedirect("index.html?err=Username/Password Incorrect");
        //add msg box for error to be displayed on the main page
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
