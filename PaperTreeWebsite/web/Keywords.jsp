
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
                      
		</header>
	
	<div id="page-frame">
		<div id="page">
			
			
			
				
						
							
								<!--div class="search_bar">
                                                                    <form action="SearchResult.jsp" method="post">
                                                                        <input type="text" name="search" value="search" onClick="this.value='';" >
                                                                            <button type="submit">Search</button>
                                                                            </form>
                                                                    
                                             </div-->
						
				
                                                                <div class="recent-post-dashboard">
                                            
						
                                    
												
                                   
                                    
                                    <%
                                                
                                                try
                                                {
                                                    int fin=0;
        Double threshold=new Double(7.70);
  MongoClient mongo = new MongoClient();
DB pa=mongo.getDB("TFIDF");
DB cl=mongo.getDB("WebDB");
StringBuilder sb=null;
DBCollection cluster=cl.getCollection("Clusters");
Document d1=new Document("Cluster Name",session.getAttribute("cluster"));
DBCursor cur=cluster.find(new BasicDBObject(d1));
while(cur.hasNext())
{
    sb=new StringBuilder();
    cur.next();
    DBObject ob=cur.curr();
    String papers=(String) ob.get("PaperID");
    String cname=(String) ob.get("Cluster Name");
    
    List<String> pi = Arrays.asList(papers.split(","));
    System.out.println(pi.toString());
   
   for(int i=0;i<pi.size();i++)
   {
       
       DBCollection temp=pa.getCollection(pi.get(i));
       DBCursor tempcur=temp.find();
       while(tempcur.hasNext())
       {
           tempcur.next();
           DBObject tempdb=tempcur.curr();
           Double d=(Double) tempdb.get("Imp");
           if(d!=null)
           if(d>threshold)
           {
               if(fin<30)
               {
               out.println("<p style='margin-left: 30px; margin-top:5px;'>"+tempdb.get("Word")+"<br></p>");
               fin=fin+1;
               }
           }
       }
       
   }
}
                                                }
   
   catch(Exception e)
           {e.printStackTrace();}
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
