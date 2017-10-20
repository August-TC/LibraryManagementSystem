<%@ page import="Database.*" %>
<%@ page import="RelatedObjects.Reader" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>borrowBook</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
</head>

<body>

<div id="header_opac">
	<h1>Online  &nbsp; Library &nbsp; Management &nbsp; System</h1>
</div>

    </h1>
</div>
<div id="mylib_content" >
  <h2>borrow book</h2> 
        
    <input type="button" value="Return" onclick="javascript:location.href='librarian_index.jsp'"/>

	<form action="" method="post" name="frm_hist_reader" id="f">
		<p style="margin:10px auto;">
			<span><input name="reader_id" type="text" value="Please enter keywords" size="30" style="font-size:20px" onchange="reader()"/></span>
			<!--<span><input type="submit" value="search" style="font-size:20px" onclick="sel()"/></span>-->
		</p>
	</form>
	<script language="javascript">

        function reader(){

            document.frm_hist_reader.submit();
//			window.alert("reader change!")
        }

        function book(){

            document.frm_hist_book.submit();
//            window.alert("book change!")
        }

	</script>
    <div id="mylib_info" >
	<table width="100%" border="0" cellpadding="5" cellspacing="1" style="padding:8px">
		<%
			Database database = Database.accessDatabase();
			DBData dbData = DBData.getInstance();
			database.startConnection();
			String id = request.getParameter("reader_id");
			Reader reader = dbData.getReaderByID(database.getConnection(), id);
			if(reader != null)
			{
			    %>
		<TR >
			<TD rowspan="6" >
				<span style="padding-left:20px;"></span><br />

			</TD>
			<TD><span class="bluetext">name: <%=reader.getReader_name()%></span></TD>
			<TD><span class="bluetext">id: <%=reader.getReader_id()%> </span></TD>
		</TR>
		<TR >
			<TD ><span class="bluetext">email: <%=reader.getReader_email()%></span></TD>
			<TD ><span class="bluetext">Tel: <%=reader.getReader_TEL()%></span></TD>
		</TR>
		<TR>
			<TD ><span class="bluetext">Fine: <%=reader.getReader_fine()%></span></TD>
			<TD ><span class="bluetext">State: <%=reader.getReader_state()%></span></TD>
		</TR>
		<TR>
			<TD ><span class="bluetext">reader type: <%=reader.getReader_type()%> </span></TD>
		</TR>
		<%
			}
			else
			{
			    %>
		Lack of reader, please check reader's id.
		<%
			}
		%>

	</table>
</div>

	<form action="" method="post" name="frm_hist_book" id="f">
		<p style="margin:10px auto;">
			<span><input name="search" type="text" value="Please enter keywords" size="30" style="font-size:20px" onchange="book()"/></span>
			<!--<span><input type="submit" value="search" style="font-size:20px" onclick="sel()"/></span>-->
		</p>
	</form>
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

	        <div class="clear"></div>
</div>


<div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>

</body>
</html>
