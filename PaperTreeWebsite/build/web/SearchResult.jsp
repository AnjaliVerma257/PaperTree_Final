
<!-- 

Project Codename: Papertree
Codding By Anjali Verma
Version 1.0

(In Development Phase)
-->

<!DOCTYPE html>
<html>


<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<%@page import="java.text.*" import=" java.util.*"  import="com.mongodb.*" import="org.bson.Document" language="java"%>
<title>PaperTree</title>
<!---------------------------- CSS ------------------------------------------>

	<link rel="stylesheet" type="text/css" media="all" href="css/style.css">
        
	
<!---------------------------- CSS ------------------------------------------>

<!---------------------------- JS ------------------------------------------->


	<script src="js/jquery.js"></script>
	<script src="js/tabs.js"></script>
	
	

<!---------------------------- JS ------------------------------------------->

</head>

<body style="background:url('images/bg.jpg') 0px 150px no-repeat">
		<header>
			<div id="pre-header">
                            <div class="logo"><a href="backend.jsp"><img src="images/logo.png" class="" alt=""></a></div>
				<div class="user-sect">
					<span class="user-details"><h1>Hi,</h1><h2>
                                                <%
                                                    
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
                                                   
                                                %>
                                                                                   </h2></span>
                                               
					<div class="clearfix"></div>
                                        <span class="user-set"><a href="Settings.jsp">Settings</a>&nbsp;|&nbsp; <a href="SignOut.jsp">Logout</a></span>
				</div>
			</div>
                        <%
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
                                               
                                                  %>
		</header>
	
	<div id="page-frame">
		<div id="page">
			
			
			
				
						<div class="search_bar">
                                                    <h1 class="main-heading" style="float:left; display: inline-block; margin:30px 0px 10px 20px;">Search Results</h1>
							<div class="kwd-set" style="margin:0px 20px 0px 0px; float:right; display: inline-block;">
                                                                    <form action="SearchResult.jsp" method="post">
                                                                        <div class="kwd-set"><input type="text" name="search" value="search" onClick="this.value='';">
                                                                            <button type="submit" id="srch-max" class="srch-btn" ></button></div>
                                                                            </form>
                                                                    
								</div>
                                                    
                                                    <div class="clearfix"></div>
                                                    </div>
							
								<!--div class="search_bar">
                                                                    <form action="SearchResult.jsp" method="post">
                                                                        <input type="text" name="search" value="search" onClick="this.value='';" >
                                                                            <button type="submit">Search</button>
                                                                            </form>
                                                                    
                                             </div-->
						
				
                                                                <div class="recent-post-dashboard">
                                            
						
                                    
												
                                   
                                    
                                    <%
                                               if(op.size()==0)
                                                       {
                                                          
                                                           out.println("<br><br><p class='rvmsg'  style='font-size: x-large'>Sorry... No Results Found</p><br><p class='rvmsg' style='font-size: x-large'>Our dataset does not have any research papers related to this field</p>");
                                                       }
else
                                               {
                                                for(int i=0;i<op.size();i++)
                                                {
out.println("<div class='last-post'>");                                                
out.println("<div class='post-title'>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" +op.get(i)+ "'>"  + op.get(i) +"</a></h3>");
out.println("</div>");	
out.println("<div class='last-post-meta s-result'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>12/12/12</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
out.println("<div class='clearfix'></div>");
out.println("</div>");	
                                                }
                                               }
                                                %>
				   
								
						
							<div class="clearfix"></div>
						</div>								
					</div>

				
				
				</div>
						
							    
				
			
			<div style="clear:both;"></div>
		</div>
	</div>
	
	

	
</body>

</html>
