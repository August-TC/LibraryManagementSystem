<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="Database.*" %>
<%@ page import="RelatedObjects.*" %>
<%@ page import="java.sql.SQLException" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>borrowingHistory</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
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
                <li><a href="accountInformation.html" >accountInformation</a></li>
                <li><a href="reserveBook.html" >reserveBook</a></li>
                <li><a href="borrowingHistory.jsp" >borrowingHistory</a></li>
                <li><a href="modifyInformation.jsp" >modifyInformation</a></li>
                <li><a href="modifyPwd.jsp" >modifyPassword</a></li>

			</ul>
		</div>

 <div id="mylib_content">
  		<h2>borrowing history</h2>
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC" class="table_line">
				<tr>

					<td bgcolor="#d8d8d8" class="greytext">Reference</td>
					<td bgcolor="#d8d8d8" class="greytext">Name</td>
					<td bgcolor="#d8d8d8" class="greytext">Author</td>
					<td bgcolor="#d8d8d8" class="greytext">Press</td>
					<td bgcolor="#d8d8d8" class="greytext">BorrowDate</td>
					<td bgcolor="#d8d8d8" class="greytext">BorrowState</td>
					<td bgcolor="#d8d8d8" class="greytext">Location</td>
				</tr>

				<%
					Database database = Database.accessDatabase();
					DBData dbData = DBData.getInstance();
					Reader reader = LibraryManagementSystem.getInstance().getCrt_reader();
					if (reader != null)
					{
					    database.startConnection();
						BorrowedItemList list = null;
						try
						{
							list = dbData.getBorrowedBooks(database.getConnection(),reader.getReader_id());

							if (list!= null && !(list.getBorrowedBooks().isEmpty()))
							{
								for (BorrowedItem item :
										list.getBorrowedBooks())
								{
									Book book = dbData.getBookByID(database.getConnection(),item.getBook_id());
				%>
								<tr>
									<td bgcolor="#FFFFFF" class="whitetext"  width="10%"><%=book.getBook_copy()%></td>
									<td bgcolor="#FFFFFF" class="whitetext" width="25%"><%=book.getBook_name()%></td>
									<td bgcolor="#FFFFFF" class="whitetext" width="10%"><%=book.getBook_author()%></td>
									<td bgcolor="#FFFFFF" class="whitetext" width="10%"><%=book.getBook_publish()%></td>
									<td bgcolor="#FFFFFF" class="whitetext" width="12%"><%=item.getBorrow_date()%></td>
									<td bgcolor="#FFFFFF" class="whitetext" width="12%"><%=item.getBorrow_state()%></td>
									<td bgcolor="#FFFFFF" class="whitetext" width="15%"><%=book.getBook_location()%></td>
								</tr>
							<%}
							}
						} catch (SQLException e)
							{
								e.printStackTrace();
							}
					}
				%>
			</table>
  </div>
  <div class="clear"></div>
  
<div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>
</body>
</html>
