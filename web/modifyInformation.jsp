<%@ page import="RelatedObjects.LibraryManagementSystem" %>
<%@ page import="RelatedObjects.Reader" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>modifyInformation</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--<link rel="stylesheet" type="text/css" href="modifystyle.css" />-->
</head>

<body>

<div id="header_opac">
	<h1>Online  &nbsp; Library &nbsp; Management &nbsp; System</h1>
</div>

    <div class="header_right header_right_top">
      <p class="header_right_font">       </p>
      <p style="margin-top:60px;" class="header_right_font">
        <strong><a href="login.html" style="color:#666; font-size:24px;">login in</a></strong></p>
    </div>

		<div id="navsidebar">
			<ul id="nav_mylib">
				<li><a href="searchBook.jsp" >searchBook</a></li>
				<li><a href="index.jsp" >index</a></li>
                <%--<li><a href="accountInformation.html" >accountInformation</a></li>--%>
                <%--<li><a href="reserveBook.html" >reserveBook</a></li>--%>
                <%--<li><a href="borrowingHistory.jsp" >borrowingHistory</a></li>--%>
                <li><a href="modifyInformation.jsp" >modifyInformation</a></li>
                <li><a href="modifyPwd.jsp" >modifyPassword</a></li>
			</ul>
		</div>

<div id="mylib_content" >
  	<h2>modify information</h2>
  	<div style="float:left; width:300px;" >
		<FORM ACTION="modifyInfo" METHOD="POST">
				<table width="350" border="0" cellpadding="3" cellspacing="2">
                    <%
                        Reader reader = LibraryManagementSystem.getInstance().getCrt_reader();
                        String name = "";
                        String email = "";
                        String tel = "";
                        if (reader != null)
                        {
                            name = reader.getReader_name();
                            email = reader.getReader_email();
                            tel = reader.getReader_TEL();
                            out.println("<tr>\n" +
                                    "                        <td align=\"right\">Name: </td>\n" +
                                    "                        <td align=\"left\"><input class=\"input\"  name=\"name\" type=\"text\" size=\"25\" value="+name+" /></td>\n" +
                                    "                    </tr>\n" +
                                    "                    <tr>\n" +
                                    "                        <td align=\"right\">Email: </td>\n" +
                                    "                        <td align=\"left\"><input class=\"input\" name=\"email\" type=\"text\" size=\"25\" value="+email+" /></td>\n" +
                                    "                    </tr>\n" +
                                    "                    <tr>\n" +
                                    "                        <td align=\"right\">Tel: </td>\n" +
                                    "                        <td align=\"left\"><input class=\"input\" name=\"tel\" type=\"text\" size=\"25\" value="+tel+" /></td>\n" +
                                    "                    </tr><tr>\n" +
                                    "\t\t\t\t  \t<td></td>\n" +
                                    "\t\t\t\t    <td height=\"26\" colspan=\"2\"><input type=\"submit\" name=\"submit1\" class=\"btn btn-success\"  value=\"OK\"> <input type=\"button\" value=\"Return\" class=\"btn\"  onclick=\"javascript:location.href='searchBook.jsp'\" /></td>\n" +
                                    "\t\t\t\t    </tr>");
                        }
                        else
                        {
                            out.println("<tr><td>Please log in your account First</td></tr>");
                        }

                    %>

				</table>
		</FORM>				
	</div>

  </div>
  <div class="clear"></div>
<div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>
  
</body>
</html>
