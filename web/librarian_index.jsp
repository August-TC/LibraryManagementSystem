<%@ page import="RelatedObjects.Librarian" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="librarian/css/index.css" />
</head>

<body>

<div id="header_opac">
	<h1>Online  &nbsp; Library &nbsp; Management &nbsp; System</h1>
</div>

<div class="main-agileits">
	      <div class="right-wthree">
                
				<div class="buttonleft">
					<a href="addBook.html" class="play-icon popup-with-zoom-anim">addBook</a>
				</div>
                </br>
                <div class="buttonleft">
					<a href="deleteBook.jsp" class="play-icon popup-with-zoom-anim">deleteBook</a>
				</div>
                </br>
                <div class="buttonleft">
					<a href="addReader.html" class="play-icon popup-with-zoom-anim">addReader</a>
				</div>
                </br>
                <div class="buttonleft">
					<a href="deleteReader.jsp" class="play-icon popup-with-zoom-anim">deleteReader</a>
				</div>
                
		   </div>
			<div class="left-w3ls">
			<%--<ul class="address">--%>
													<%--<li>--%>
														<%--<ul class="address-text">--%>
															<%--<li><b>The current Librarian</b></li></br>--%>
															<%--<li><%=(String) request.getAttribute("librarian")%></li>--%>
														<%--</ul>--%>
													<%--</li>--%>
													<%--<li>--%>
														<%--<ul class="address-text">--%>
															<%--<li><b>Overdue books</b></li></br>--%>
															<%--<li>: 0</li>--%>
														<%--</ul>--%>
													<%--</li>--%>
													<%--<li>--%>
														<%--<ul class="address-text">--%>
															<%--<li><b>The earliest should return</b></li></br>--%>
															<%--<li>: 2017-09-20</li>--%>
														<%--</ul>--%>
													<%--</li>--%>
													<%--<li>--%>
														<%--<ul class="address-text">--%>
															<%--<li><b>The book owe</b></li></br>--%>
															<%--<li>: 4.4yuan</li>--%>
														<%--</ul>--%>
													<%--</li>--%>
			  <%--</ul>--%>
				<div class="buttonright">
					<a href="borrow.jsp" class="play-icon popup-with-zoom-anim">borrow Book</a>
				</div>
				</br>
				<div class="buttonright">
					<a href="return.html" class="play-icon popup-with-zoom-anim">return Book</a>
				</div>
				<%--<div class="buttonright">--%>
					<%--<a href="librarian/accountInformation.html" class="play-icon popup-with-zoom-anim">check the information</a>--%>
				<%--</div>--%>
						<!--<div id="small-dialog" class="mfp-hide w3ls_small_dialog wthree_pop">		
						<div class="agileits_modal_body">
							<iframe src="https://player.vimeo.com/video/8483438?title=0&byline=0&portrait=0"></iframe>
						</div>
					</div>-->
                <p class="header_right_font"></p>

					<%--<strong><a href="javascript:location.href='searchBook.jsp'" style="color:#666; font-size:24px;">login out</a></strong></p>--%>
				<p class="header_right_font">       </p>

			</div>

		</div>
<form action="/Login" method="post">
   <center><input type="submit" value="log out"/></center>
</form>
  <div class="clear">

  </div>
  <div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>
  
</body>
</html>
