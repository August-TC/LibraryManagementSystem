<%@ page import="RelatedObjects.LibraryManagementSystem" %>
<%@ page import="RelatedObjects.Reader" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>

<div id="header_opac">
	<h1>Online  &nbsp; Library &nbsp; Management &nbsp; System</h1>
</div>


		<div id="navsidebar">
			<ul id="nav_mylib">
				<li><a href="index.jsp" >index</a></li>
                <li><a href="accountInformation.html" >accountInformation</a></li>
                <li><a href="searchBook.jsp" >searchBook</a></li>
                <li><a href="reserveBook.html" >reserveBook</a></li>
                <li><a href="borrowingHistory.jsp" >borrowingHistory</a></li>
                <li><a href="modifyInformation.jsp" >modifyInformation</a></li>
                <li><a href="modifyPwd.jsp" >modifyPassword</a></li>
			</ul>
		</div>
		<div class="main-agileits">
	       <!--div class="right-wthree">
             
				<img src="images/woman.jpg" alt="image" /></br></br></br>
                
                
		   </div-->

			<ul class="address">
				<%
					Reader reader = LibraryManagementSystem.getInstance().getCrt_reader();
				%>
													<li>
														<ul class="address-text">
															<li><b>Name: </b></li></br>
															<li><%=reader.getReader_name()%></li>
														</ul>
													</li>
													<li>
														<ul class="address-text">
															<li><b>Email: </b></li></br>
															<li><%=reader.getReader_email()%></li>
														</ul>
													</li>
													<li>
														<ul class="address-text">
															<li><b>Tel: </b></li></br>
															<li><%=reader.getReader_TEL()%></li>
														</ul>
													</li>
													<li>
														<ul class="address-text">
															<li><b>Type: </b></li></br>
															<li><%=reader.getReader_type()%></li>
														</ul>
													</li>
			  </ul>
				
				<div class="buttonright">
					<a href="accountInformation.html" class="play-icon popup-with-zoom-anim">check the information</a>
				</div>

		</div>

        
<div class="clear"></div>
  
<div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>

</body>
</html>
