<%--
  Created by IntelliJ IDEA.
  User: august
  Date: 17-10-20
  Time: 上午10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Database.*" %>
<%@ page import="RelatedObjects.Reader" %>
<%@ page import="RelatedObjects.Book" %>
<html>
<head>
    <title>Borrower</title>
</head>
<body>
<form action="" method="post" name="frm_hist_reader" id="f_reader">
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

</script>
<div id="mylib_info" >
    <table width="100%" border="0" cellpadding="5" cellspacing="1" style="padding:8px">
        <%
            Database database = Database.accessDatabase();
            DBData dbData = DBData.getInstance();
            database.startConnection();
            String reader_id = request.getParameter("reader_id");
            Reader reader = dbData.getReaderByID(database.getConnection(), reader_id);
            database.closeConnection();
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

</body>
</html>
