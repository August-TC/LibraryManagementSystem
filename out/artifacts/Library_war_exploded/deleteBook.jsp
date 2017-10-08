<%@ page import="Database.Database" %>
<%@ page import="RelatedObjects.LibraryManagementSystem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="RelatedObjects.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>deleteBook</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
</head>

<body>

<div id="header_opac">
	<h1>Online  &nbsp; Library &nbsp; Management &nbsp; System</h1>
</div>

    </h1>
</div>
<div id="mylib_content" >
  <h2>delete book</h2>

  <div id="submenu"> 
        
    <input type="button" value="Return" onclick="javascript:location.href='librarian_index.jsp'"/>
        
    <form action="" method="post" name="frm_hist" id="f">
   	    <p style=" margin:10px auto; color:#666">
        <INPUT TYPE="radio" NAME="way" value="name" style="font-size:20px" checked>By Name
		<INPUT TYPE="radio" NAME="way" value="ID"  style="font-size:20px">By ID
        <INPUT TYPE="radio" NAME="way" value="author"   style="font-size:20px">By Author
        <INPUT TYPE="radio" NAME="way" value="press"   style="font-size:20px">By Press
   		 &nbsp;&nbsp;&nbsp;</p>

        <p style="margin:10px auto;">
        <span><input name="search" type="text" value="Please enter keywords" size="30" style="font-size:20px"/></span>
        <span><input type="submit" value="searchse enter keywords" style="font-size:20px" onclick="sel()"/></span>
		</p>
    </form>
	  <script language="javascript">

          function sel(){

              document.frm_hist.submit();

          }

	  </script>
	  <!--form action="/delete">
		  <p style="margin:10px auto;">
			  <span><input name="book_delete" type="text" value="Enter the ID to delete" size="30" style="font-size:20px"/></span>
			  <span><input type="submit" value="delete" style="font-size:20px"/></span>
		  </p>
	  </form-->
  </div>   
  
  
  <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC" class="table_line">
				<tr bgcolor="#d8d8d8" class="greytext">
					<td   width="10%"  align="center">ID</td>
					<td   width="10%" align="center">Name</td>
					<td   width="10%" align="center">Author</td>
					<td   width="10%" align="center">Reference</td>
					<td   width="10%" align="center">Location</td>
				    <td   width="10%" align="center">Publish</td>
					<td   width="10%" align="center">State</td>
					<td   width="20%" align="center">Introduction</td>
                    <!--td   width="10%" align="center">Tags</td-->
				</tr>
	  <%
		  Database database = Database.accessDatabase();
		  LibraryManagementSystem library = LibraryManagementSystem.getInstance();
		  String search = "";
		  database.startConnection();
		  String way = request.getParameter("way");
		  search = request.getParameter("search");
		  ArrayList<Book> list = new ArrayList<>();
		  if (way != null)
		  {
			  switch (way)
			  {
				  case "name":
					  list = library.inquireByName(database.getConnection(),search);
					  break;
				  case "ID":
					  list = library.inquireByISBN(database.getConnection(),search);
					  break;
				  case "author":
					  list = library.inquireByAuthor(database.getConnection(),search);
					  break;
				  case "press":
					  list = library.inquireByPress(database.getConnection(),search);
					  break;
				  default:
					  list = library.inquireByName(database.getConnection(),"");
					  break;
			  }
		  }

		  if (list!= null && !(list.isEmpty()))
		  {
			  for (Book book :
					  list)
			  {
			      out.println("<form action=\"/delete\" method=\"get\">");
				  out.println("<tr>");
				  out.println("<td bgcolor=\"#FFFFFF\" class=\"whitetext\" width=\"10%\">"+book.getBook_id()+"</td>");
				  out.println("<td bgcolor=\"#FFFFFF\" class=\"whitetext\"  width=\"10%\">"+book.getBook_name()+"</td>");
				  out.println("<td bgcolor=\"#FFFFFF\" class=\"whitetext\"  width=\"10%\">"+book.getBook_author()+"</td>");
				  out.println("<td bgcolor=\"#FFFFFF\" class=\"whitetext\"  width=\"10%\">"+book.getBook_copy()+"</td>");
				  out.println("<td bgcolor=\"#FFFFFF\" class=\"whitetext\"  width=\"10%\" align=\"center\">"+book.getBook_location()+"</td>");
				  out.println("<td bgcolor=\"#FFFFFF\" class=\"whitetext\"  width=\"10%\">"+book.getBook_publish()+"</td>");
				  out.println("<td bgcolor=\"#FFFFFF\" class=\"whitetext\"  width=\"10%\" align=\"center\">"+book.getBook_state()+"</td>");
				  out.println("<td bgcolor=\"#FFFFFF\" class=\"whitetext\"  width=\"20%\" align=\"center\">"+book.getBook_introduction()+"</td>");
				  out.println("</tr>");
				  out.println("</form>");
			  }
		  }

	  %>
                <!--tr>
					<td bgcolor="#FFFFFF" class="whitetext" width="5%">1</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
                    <td bgcolor="#FFFFFF" class="whitetext" width="20%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="5%"><input type="submit" value="delete"/></td>
				</tr-->
   
  </table>
	<form action="/delete" method="post">
		<p style="margin:10px auto;">
			<span><input name="del_book" type="text" value="Please enter the id of book" size="30" style="font-size:20px"/></span>
			<span><input type="submit" value="delete" style="font-size:20px"/></span>
		</p>
	</form>

	        <div class="clear"></div>
</div>


<div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>

</body>
</html>
