
<html>

<head>
 <script>
 
    function goToIndex(){
location="index.html";
}

 
 
    function goToSignUp(){
location="Signup.html";
}
</script>
<%@page import="java.text.*" import=" java.util.*"  import="com.mongodb.*" import="org.bson.Document" language="java" %>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<link rel="stylesheet" type="text/css" media="all" href="css/style.css">
<title>Title | Backend</title>
	

</head>

<body style="background:url('images/bg.jpg') 0px 150px no-repeat">
    <header>
			<div id="pre-header">
                            <div class="logo"><a href="index.html"><img src="images/logo.png" class="" alt=""></a></div>
				<div class="user-sect">
					<span class="user-details"> <h1>Hi,</h1> <h2></h2></span>
					<div class="clearfix"></div>
					<span class="user-set"><a href="#"></a>&nbsp;&nbsp; <a href="#"></a></span>
				</div>
			</div>
		</header>
    <div id="page-frame">

<%

String success=request.getParameter("success");
System.out.println(success);
if(success.equals("yes"))
{
    
    out.println("<div id='page-frame'>");
    
			out.println("<h1 class='frame-title'>Successful</h1>");
            out.println("<form  method='post' action='mail' class='recover'>");
                out.println("<div class='recover-field'>");
            		out.println("<p>Your password has been sent to your Registered EmailID</p>");
            		
	               
	                out.println("<div style='width:200px;text-align:center;margin:20px auto 0px auto'>");
		                out.println("<input type='button' name='Submit' value='SIGN IN'  class='button' onclick='goToIndex();'>");                                                                                                                       
		                
	                out.println("</div></div></form></div>");
}
    else
{   
       out.println("<div id='page-frame'>");
    
			out.println("<h1 class='frame-title'>Unsucessfull</h1>");
            out.println("<form  method='post' action='mail' class='recover'>");
                out.println("<div class='recover-field'>");
            		out.println("<p>You are not registered with us. Please Sign Up</p>");
            		
	               
	                out.println("<div style='width:200px;text-align:center;margin:20px auto 0px auto'>");
		                out.println("<input type='button' name='Submit' value='SIGN UP'  class='button' onclick='goToSignUp();'>");                                                                                                                       
		                
	                out.println("</div></div></form></div>");

    
    
}

       
    
%>
	</div>
</body>

</html>
