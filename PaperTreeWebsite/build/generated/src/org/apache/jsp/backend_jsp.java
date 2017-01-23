package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import com.mongodb.*;
import org.bson.Document;

public final class backend_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                                            </h2></span>\n");
      out.write("                                             ");

                                                 
                                                MongoClient mongo=new MongoClient();
                                                DB db=mongo.getDB("WebDB");
                                                DBCollection history=db.getCollection("Readings");
                                                Document newd=new Document();
                                                newd.put("UID",uid1);
                                                DBObject hk=new BasicDBObject(newd);
                                                
                                                DBCursor ocr=history.find(hk);
                                                
                                                List<String> sets=null;
                                                
                                                int count=ocr.itcount();
                                                if(count>0)
                                                {
                                               
                                                
                                                
                                                DBObject kor=ocr.curr();
                                                
                                                String rea=(String)kor.get("History");
                                                sets = Arrays.asList(rea.split("\\s*]\\s*"));
                                                }
                                                 
                                                 
                                                
                                             
      out.write("\n");
      out.write("                                                  \n");
      out.write("                                    ");
                                                
                                                
                                                
                                                //Get interests
                                                String email=(String)session.getAttribute("email");
                                                Document d=new Document();
                                                d.put("Email",email);
                                                DBObject ob1=new BasicDBObject(d);
                                                DBCollection user=db.getCollection("User");
                                                DBCursor cur1=user.find(ob1);
                                                cur1.next();
                                                DBObject opu=cur1.curr();
                                                String intt=(String)opu.get("Interests");
                                                
                                                List<String> interests = Arrays.asList(intt.split("\\s*,\\s*"));
                                                StringBuilder sb=new StringBuilder();
                                                //Accessing keywords and get cluster
                                                
                                                DBCollection keyword=db.getCollection("ClusterKey");
                                                DBCursor cur2=keyword.find();
                                                
                                                for(int i=0;i<interests.size();i++)
                                                {
                                                 
        
        DBCollection c1=db.getCollection("ClusterKey");
        DBCursor cur=c1.find();
        //String a[]=null;
        
        while(cur.hasNext())
        {
            cur.next();
            DBObject ob=new BasicDBObject();
            ob=cur.curr();
            String cname=(String)ob.get("Cluster Name");
            String words=(String)ob.get("Keywords");
            session.setAttribute("cluster",cname);
            if(words.contains(interests.get(i)))
            sb.append(","+cname);
            
        }}
                                                List<String> clus = Arrays.asList(sb.toString().split("\\s*,\\s*"));
                                                Set<String> uniqueGas = new HashSet<String>(clus);
                                                String clusters=uniqueGas.toString();
                                                clusters=clusters.replace("[","");
                                                clusters=clusters.replace("]","");
                                                clusters=clusters.replaceAll(" ","");
                                                
                                                clusters=clusters.substring(1,clusters.length());
                                                
                                                
                                                
                                                StringBuilder pv1=new StringBuilder();
                                           List<String> c_name = Arrays.asList(clusters.split("\\s*,\\s*"));   

                                                DBCollection c2=db.getCollection("Clusters");
                                                    for(int j=0;j<c_name.size();j++)
                                                    {
                                                        
                                                        Document d1=new Document();
                                                        d1.put("Cluster Name", c_name.get(j));
                                                        
                                                        DBObject o1=new BasicDBObject(d1);
                                                        DBCursor cur3=c2.find(o1);
                                                        if(cur3.hasNext())
                                                        {
                                                        cur3.next();
                                                        DBObject o2=cur3.curr();
                                                        pv1.append(","+o2.get("PaperID"));
                                                        }
                                                        
                                                    }
                                                    
                                                String pid=pv1.toString();
                                                pid=pid.substring(1,pid.length());
                                                
                                                     List<String> pap = Arrays.asList(pid.toString().split("\\s*,\\s*"));
                                                Set<String> pids = new HashSet<String>(pap);
                                                 String test=pids.toString();
                                                    test=test.replace("[","");
                                                test=test.replace("]","");
                                                test=test.replaceAll(" ","");
                                                 List<String> fin = Arrays.asList(test.split("\\s*,\\s*"));
                                               
                                    
      out.write("      \n");
      out.write("                                                    \n");
      out.write("                                               \n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("                                        <span class=\"user-set\"><a href=\"Settings.jsp\">Settings</a>&nbsp;|&nbsp; <a href=\"SignOut.jsp\">Logout</a></span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</header>\n");
      out.write("\t\n");
      out.write("\t<div id=\"page-frame\">\n");
      out.write("\t\t<div id=\"page\">\n");
      out.write("\t\t\t<div id=\"sidebar\">\n");
      out.write("                            <ul class=\"tabs\" id=\"tabs\">\n");
      out.write("                                <li style=\"width:200px;\"><a href=\"#Dashboard\">Dashboard</a></li>\n");
      out.write("\t\t\t\t\t<li style=\"width:200px;\"><a href=\"#History\">History</a></li>\n");
      out.write("                                        <li style=\"width:200px;\"><a href=\"#Recommendations\">Recommendations</a></li>\n");
      out.write("\t\t\t\t\t<li style=\"width:200px;\"><a href=\"#Search\">Search</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    ");

                    
      out.write("\n");
      out.write("\t\t\t<div id=\"content\">\n");
      out.write("\t\t\t\t<div id=\"Dashboard\" class=\"tab-section dashboard\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"recent-post-dashboard\">\n");
      out.write("\t\t\t\t\t\t<h1 class=\"main-heading\">Recently Viewed</h1>\n");
      out.write("\t\t\t\t\t\t<div class=\"last-post\">\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("                                                       ");
        
                                                 
                                    if(sets.size()>0)
                                    {
                                                 for(int i=0;i<1;i++)
                                                {
                                                    String temp=sets.get(i);
                                                    String diff[]=temp.split(" ",2);
                                                    diff[0]=diff[0].substring(1, diff[0].length());
                                                
                                                       
out.println("<div class='post-title'>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" + diff[0]+ "'>"  + diff[0] +"</a></h3>");
out.println("</div>");	
out.println("<div class='last-post-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>"+diff[1]+"</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
			
                                                        
                                                    }
                                                    
                                                
                                    }      
                                    else
                                    {
                                        out.println("<p class='rvmsg'>Nothing here right now...</p>");
                                    }
                                           			
                                         
                                    
                                                
      out.write("\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"last-post-grid\">\n");
      out.write("\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t    ");
   

                                    
                                    
                                    System.out.println(count);
                                     if(sets.size()>0)
                                     {
                                                for(int i=1;i<sets.size();i++)
                                                {
                                                    String temp=sets.get(i);
                                                    String diff[]=temp.split(" ",2);
                                                    diff[0]=diff[0].substring(1, diff[0].length());
                                                
                                                       
out.println("<li>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" + diff[0]+ "'>"  + diff[0] +"</a></h3>");
out.println("<div class='last-post-grid-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>"+diff[1]+"</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
out.println("</li>");				
                                                        
                                                    }
                                                    
                                                
                                                
                                           			
                                     }       
                                     
                                     
                                    
                                                
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"other-post-dashboard\">\n");
      out.write("\t\t\t\t\t\t<h1 class=\"main-heading\">Explore</h1>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div class=\"last-post-grid\">\n");
      out.write("\t\t\t\t\t\t\t<ul>                 \n");
      out.write("                                                              ");


                                                for(int i=0;i<12;i++)
                                                {
                                                
out.println("<li>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" + fin.get(i).toString() +"'>"+fin.get(i).toString()+"</a></h3>");
out.println("<div class='last-post-grid-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>Edward Maya</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
out.println("</li>");								
                                                }
                                                
      out.write("\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div id=\"History\" class=\"tab-section\">\n");
      out.write("                                    <h1 class=\"main-heading\">History</h1>\n");
      out.write("\t\t\t\t     <div class=\"last-post-grid\">\n");
      out.write("\t\t\t\t\t\t\t<ul>\n");
      out.write("                                                       ");
        
                                      if(count>0)
                                      {
                                          for(int i=0;i<sets.size();i++)
                                                {
                                                    String temp=sets.get(i);
                                                    String diff[]=temp.split(" ",2);
                                                    diff[0]=diff[0].substring(1, diff[0].length());
                                                
                                                 
out.println("<li>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" + diff[0]+ "'>"  + diff[0] +"</a></h3>");
out.println("<div class='last-post-grid-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>"+diff[1]+"</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
out.println("</li>");				
                                                        
                                                    
                                                    
                                                }
                                                
                                           			
                                                
                                      }
                                      else
                                     {
                                         out.println("<p class='rvmsg'>Nothing here right now...</p>");
                                     }
                                                
      out.write("\n");
      out.write("                                                            </ul>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("\t\t\t\t<div id=\"Recommendations\" class=\"tab-section\">\n");
      out.write("                                    <h1 class=\"main-heading\">Explore<p style=\"display: inline-block; margin-left: 590px; font-size: large\"><a href=\"Keywords.jsp\">Fields</a></p></h1>\n");
      out.write("                                    <div class=\"last-post-grid\">\n");
      out.write("\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("                                   \n");
      out.write("                                    \n");
      out.write("                                    ");

/*MongoClient m2=new MongoClient();
DB db1=m2.getDB("WebDB");
DBCollection dc=db1.getCollection("User");
DBCollection read=db1.getCollection("Readings");
Set set = new HashSet();

StringBuilder sets1=null;
//intt

//interests
for(int i=0;i<interests.size();i++)
{
    String temp=interests.get(i);
    
    DBCursor dbc=dc.find();
   while(dbc.hasNext())
   {
       
       dbc.next();
       DBObject tempob=dbc.curr();
       
       String temp2=tempob.get("Interests").toString();
       String x=(tempob.get("UID").toString());
       if(x.equals(uid1))
           {                     }
       else
       {           
       if(temp2.contains(temp)==true)
       {           
           Document d2=new Document("UID",x);
           DBCursor curr=read.find(new BasicDBObject(d2));
           if(curr.hasNext())
           {
               
               curr.next();
               
           DBObject currr=curr.curr();
           
            
           }
           else
           {               
           }
             
                 
             
             
           }
       }
       
   }
    
}


*/
                                              for(int i=0;i<pids.size();i++)
                                                {
                                                
out.println("<li>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" + fin.get(i).toString() +"'>"+fin.get(i).toString()+"</a></h3>");
out.println("<div class='last-post-grid-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>Edward Maya</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
out.println("</li>");								
                                                }
                                                
      out.write("\n");
      out.write("\t\t\t\t   \n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\n");
      out.write("\t\t\t\t\t\t</div>\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                                                \n");
      out.write("                                                \n");
      out.write("                                                \n");
      out.write("                                                \n");
      out.write("                                                \n");
      out.write("\t\t\t\t<div id=\"Search\" class=\"tab-section\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<div class=\"srch-box\">\n");
      out.write("\t\t\t\t\t\t\t<h3>Looking For Something Eh?</h3>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"kwd-set\">\n");
      out.write("                                                                    <form action=\"SearchResult.jsp\" method=\"post\">\n");
      out.write("                                                                        <div class=\"kwd-set\"><input type=\"text\" name=\"search\" value=\"\">\n");
      out.write("                                                                            <button type=\"submit\" id=\"srch-max\" class=\"srch-btn\" ></button></div>\n");
      out.write("                                                                            </form>\n");
      out.write("                                                                    \n");
      out.write("\t\t\t\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div style=\"clear:both;\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t<!--script>\n");
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
      out.write("\t</script-->\n");
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
