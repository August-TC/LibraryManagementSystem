<%@ page import="Database.*" %>
<%@ page import="RelatedObjects.Reader" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>deleteReader</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
</head>

<body>

<div id="header_opac">
	<h1>Online  &nbsp; Library &nbsp; Management &nbsp; System</h1>
</div>

    </h1>
</div>
<div id="mylib_content" >
  <h2>delete reader</h2>

  <div id="submenu"> 
  
    <input type="button" value="Return" onclick="javascript:location.href='librarian_index.jsp'"/>
        
    <form action="" method="post" name="frm_hist" id="f">
        <p style="margin:10px auto;">
        <span><input name="search" type="text" value="Please enter keywords" size="30" style="font-size:20px"/></span>
        <span><input type="submit" value="search" onclick="sel()" style="font-size:20px"/></span></p>
    </form>
	  <script language="javascript">

          function sel(){

              document.frm_hist.submit();

          }

	  </script>
  </div>   
  
  
  <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC" class="table_line">
				<tr bgcolor="#d8d8d8" class="greytext">
					<td   width="10%"  align="center">ID</td>
					<td   width="15%" align="center">Name</td>
					<td   width="10%" align="center">Type</td>
					<td   width="10%" align="center">State</td>
					<td   width="25%" align="center">Email</td>
					<td   width="25%" align="center">Tel</td>
                    <td   width="5%"  align="center">Fine</td>
				</tr>
	  <%
		  Database database = Database.accessDatabase();
		  DBData dbData = DBData.getInstance();
		  String search = "";
		  database.startConnection();
		  search = request.getParameter("search");
		  System.out.println(search);
		  database.startConnection();
		  ArrayList<Reader> readers = null;
		  try
		  {
			  readers = dbData.getReaders(database.getConnection(),search);
			  database.closeConnection();
		  } catch (SQLException e)
		  {
			  e.printStackTrace();
		  }

		  if (readers!= null && !(readers.isEmpty()))
		  {
			  for (Reader reader :
					  readers)
			  {
			      %>
	  <tr>
		  <td bgcolor="#FFFFFF" class="whitetext" width="10%"><%=reader.getReader_id()%></td>
		  <td bgcolor="#FFFFFF" class="whitetext" width="15%"><%=reader.getReader_name()%></td>
		  <td bgcolor="#FFFFFF" class="whitetext" width="10%"><%=reader.getReader_type()%></td>
		  <td bgcolor="#FFFFFF" class="whitetext" width="10%"><%=reader.getReader_state()%></td>
		  <td bgcolor="#FFFFFF" class="whitetext" width="25%"><%=reader.getReader_email()%></td>
		  <td bgcolor="#FFFFFF" class="whitetext" width="25%"><%=reader.getReader_TEL()%></td>
		  <td bgcolor="#FFFFFF" class="whitetext" width="5%"><%=reader.getReader_fine()%></td>
	  </tr>
	  <%
			  }
		  }
	  %>

   
  </table>
	<form action="delete" method="post">
		<p style="margin:10px auto;">
			<span><input name="del_reader" type="text" value="Please enter the id of reader" size="30" style="font-size:20px"/></span>
			<span><input type="submit" value="delete" style="font-size:20px"/></span>
		</p>
	</form>
	        <div class="clear"></div>
</div>


<div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>

</body>
</html>
