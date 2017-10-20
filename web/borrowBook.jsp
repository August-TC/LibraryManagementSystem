<%--
  Created by IntelliJ IDEA.
  User: august
  Date: 17-10-20
  Time: 上午10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Database.*" %>
<%@ page import="RelatedObjects.Reader" %>
<%@ page import="RelatedObjects.Book" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<form action="" method="post" name="frm_hist_book" id="f">
    <p style="margin:10px auto;">
        <span><input name="search" type="text" value="Please enter keywords" size="30" style="font-size:20px" onchange="book()"/></span>
        <!--<span><input type="submit" value="search" style="font-size:20px" onclick="sel()"/></span>-->
    </p>
</form>
<script language="JavaScript">
    function book(){

        document.frm_hist_book.submit();
//            window.alert("book change!")
    }
</script>
<%
    Database database = Database.accessDatabase();
    DBData dbData = DBData.getInstance();
    database.startConnection();
    String book_id = request.getParameter("book_id");
    Book book = dbData.getBookByID(database.getConnection(), book_id);
    database.closeConnection();
%>
<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC" class="table_line">
    <tr bgcolor="#d8d8d8" class="greytext">
        <td   width="5%"  align="center">ID</td>
        <td   width="10%" align="center">Name</td>
        <td   width="10%" align="center">Author</td>
        <td   width="10%" align="center">Location</td>
        <td   width="10%" align="center">Price</td>
        <td   width="10%" align="center">Publish</td>
        <td   width="10%" align="center">State</td>
        <td   width="25%" align="center">Introduction</td>
        <td   width="10%" align="center">Tags</td>
    </tr>
    <%
        if (book == null)
        {
    %>
    <
    <script type="text/javascript" language="JavaScript">
        window.alert("The book is not")
    </script>
    <%
        }
    %>
    <tr>
        <td bgcolor="#FFFFFF" class="whitetext" width="5%">1</td>
        <td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
        <td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
        <td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
        <td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
        <td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
        <td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
        <td bgcolor="#FFFFFF" class="whitetext" width="25%"></td>
        <td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
    </tr>

</table>
</body>
</html>
