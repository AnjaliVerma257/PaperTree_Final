
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
                                              
                                            </h2></span>
                                          
                                                  
                                    <%                                                
                                                
                                                
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
                                               
                                    %>      
                                                    
                                               
					<div class="clearfix"></div>
                                        <span class="user-set"><a href="Settings.jsp">Settings</a>&nbsp;|&nbsp; <a href="SignOut.jsp">Logout</a></span>
				</div>
			</div>
		</header>
	
	<div id="page-frame">
		<div id="page">
			<div id="sidebar">
                            <ul class="tabs" id="tabs">
                                <li style="width:200px;"><a href="#Dashboard">Dashboard</a></li>
					<li style="width:200px;"><a href="#History">History</a></li>
                                        <li style="width:200px;"><a href="#Recommendations">Recommendations</a></li>
					<li style="width:200px;"><a href="#Search">Search</a></li>
				</ul>

                        </div>
                    <%
                    %>
			<div id="content">
				<div id="Dashboard" class="tab-section dashboard">
				
					<div class="recent-post-dashboard">
						<h1 class="main-heading">Recently Viewed</h1>
						<div class="last-post">
							
                                                       <%        
                      
                                                
                                                       
out.println("<div class='post-title'>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" + diff[0]+ "'>"  + diff[0] +"</a></h3>");
out.println("</div>");	
out.println("<div class='last-post-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>"+diff[1]+"</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
			
                                                  		
                                         
                                    
                                                %>
						</div>
						<div class="last-post-grid">
							<ul>
								    <%   

                                           
out.println("<li>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" + diff[0]+ "'>"  + diff[0] +"</a></h3>");
out.println("<div class='last-post-grid-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>"+diff[1]+"</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
out.println("</li>");				
                                                   
                                    
                                                %>
							</ul>
							<div class="clearfix"></div>
						</div>						
					</div>

					<div class="other-post-dashboard">
						<h1 class="main-heading">Explore</h1>
						
						<div class="last-post-grid">
							<ul>                 
                                                              <%

                                          
                                                
out.println("<li>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" + fin.get(i).toString() +"'>"+fin.get(i).toString()+"</a></h3>");
out.println("<div class='last-post-grid-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>Edward Maya</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
out.println("</li>");								
                                           
                                                %>
							</ul>
							<div class="clearfix"></div>
						</div>						
						
						
					</div>
				
				</div>
				<div id="History" class="tab-section">
                                    <h1 class="main-heading">History</h1>
				     <div class="last-post-grid">
							<ul>
                                                       <%        
                            
                                                
                                                 
out.println("<li>");
out.println("<h3><a href='" + "DisplayPaper.jsp?id=" + diff[0]+ "'>"  + diff[0] +"</a></h3>");
out.println("<div class='last-post-grid-meta'>");
out.println("<a href='#' class='post-desc author-details'>By Author</a>");
out.println("<a href='#' class='post-desc category'>Science</a>");
out.println("<a href='#' class='post-desc published-on'>"+diff[1]+"</a>");
out.println("<div class='clearfix'></div>");
out.println("</div>");									
out.println("</li>");				
                                                        
                                                    
                                                    
                                                   %>
                                                            </ul>
							<div class="clearfix"></div>
						</div>	
				</div>
                                    
                                    
                                    
                                    
                                    
				<div id="Recommendations" class="tab-section">
                                    <h1 class="main-heading">Explore<p style="display: inline-block; margin-left: 590px; font-size: large"><a href="Keywords.jsp">Fields</a></p></h1>
                                    <div class="last-post-grid">
							<ul>
												
                                   
                                    
                                    <%
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
                                                %>
				   
								
							</ul>
							<div class="clearfix"></div>
						</div>		
				</div>
                                                
                                                
                                                
                                                
                                                
				<div id="Search" class="tab-section">
				
						<div class="srch-box">
							<h3>Looking For Something Eh?</h3>
							
								<div class="kwd-set">
                                                                    <form action="SearchResult.jsp" method="post">
                                                                        <div class="kwd-set"><input type="text" name="search" value="">
                                                                            <button type="submit" id="srch-max" class="srch-btn" ></button></div>
                                                                            </form>
                                                                    
								</div>	
						</div>
					
									    
				</div>
			</div>
			<div style="clear:both;"></div>
		</div>
	</div>
	
	
	<!--script>
		$(document).ready(
		$('#srch-max').click(function(){
		
		        $('.srch-box').css({
		        'width':"auto", 
		        'height':"auto",
		        'min-height':"50px", 
		        'background':"transparent",
		        'margin':"0px",
		        'box-shadow':"0px 0px rgba(0,0,0,0)",
		        'border':"0px"
		        });
		        
		        $('.kwd-set').css({
		        'float':"right", 
		        'clear':"both",
		        'margin':"10px",
		        'width':"auto",
		        'height':"auto",
		        });
		        
		        $('.srch-box h3').css({
		        'display':"none" 
		        });
		        
		        $('.srch-results').css({
		        'display':"block",
		        'opacity':"1",
		        'height':"1000px"
		        });
		        
			})			
		)	
	</script-->
	
</body>

</html>
