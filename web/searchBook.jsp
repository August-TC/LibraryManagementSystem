<%@ page import="Database.Database" %>
<%@ page import="RelatedObjects.LibraryManagementSystem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="RelatedObjects.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>searchBook</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>

<body>

<div id="header_opac">
	<h1>Online  &nbsp; Library &nbsp; Management &nbsp; System</h1>
</div>
    </h1>
    <div class="header_right header_right_top">
      <p class="header_right_font">       </p>
      <p style="margin-top:60px;" class="header_right_font">
        <strong><a href="login.html" style="color:#666; font-size:24px;">login in</a></strong></p>
    </div>
</div>

		<div id="navsidebar">
			<ul id="nav_mylib">
                <li><a href="searchBook.jsp" >searchBook</a></li>
				<!--<li><a href="index.jsp" >index</a></li>-->
                <li><a href="accountInformation.html" >accountInformation</a></li>
                <li><a href="reserveBook.html" >reserveBook</a></li>
                <li><a href="borrowingHistory.html" >borrowingHistory</a></li>
                <li><a href="modifyInformation.html" >modifyInformation</a></li>
                <li><a href="modifyPwd.html" >modifyPassword</a></li>
                <li><a href="book_shelf.php" ></a></li>
                <li><a href="book_loss.php" ></a></li>
                <li><a href="redr_lost.php" ></a></li>
                <li><a href="account.php" ></a></li>
                <li><a href="fine_pec.php" ></a></li>
                <li><a href="book_rv.php" ></a></li>
			</ul>
		</div>

<div id="mylib_content" >
  	<h2>search book</h2>

  <div id="submenu"> 
        
    <form action="" method="post" name="frm_hist" id="f">
   	    <p style=" margin:10px auto;">
        <INPUT TYPE="radio" NAME="way" value="name" style="font-size:20px" checked>By Name
		<INPUT TYPE="radio" NAME="way" value="ID" style="font-size:20px">By ID
        <INPUT TYPE="radio" NAME="way" value="author" style="font-size:20px">By Author
        <INPUT TYPE="radio" NAME="way" value="press" style="font-size:20px">By Press
   		 &nbsp;&nbsp;&nbsp;</p>

    

        <p style="margin:10px auto;">
        <span><input name="search" type="text" value="Please enter keywords" size="30" style="font-size:20px"/></span>
        <span><input type="submit" value="search" style="font-size:20px" onclick="sel()"/></span>
        </p>
    </form>
      <script language="javascript">

          function sel(){

              document.frm_hist.submit();

          }

      </script>
  </div>
  
  
  <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC" class="table_line">
				<tr bgcolor="#d8d8d8" class="greytext">
					<td   width="10%">ID</td>
					<td   width="10%">Name</td>
					<td   width="10%">Author</td>
					<td   width="10%" align="center">Location</td>
				    <td   width="10%">Press</td>
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
                  out.println("<tr bgcolor=\"#d8d8d8\" class=\"greytext\">");
                  out.println("<td   width=\"10%\">"+book.getBook_id()+"</td>");
                  out.println("<td   width=\"10%\">"+book.getBook_name()+"</td>");
                  out.println("<td   width=\"10%\">"+book.getBook_author()+"</td>");
                  out.println("<td   width=\"10%\" align=\"center\">"+book.getBook_location()+"</td>");
                  out.println("<td   width=\"10%\">"+book.getBook_publish()+"</td>");
                  out.println("<td   width=\"10%\" align=\"center\">"+book.getBook_state()+"</td>");
                  out.println("<td   width=\"20%\" align=\"center\">"+book.getBook_introduction()+"</td>");
                  //out.println("<td   width=\"10%\" align=\"center\">"+book."</td>");
                  out.println("</tr>");
              }
          }

      %>
   
  </table>

	        <div class="clear"></div>
</div>


<div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>

</body>
</html>
