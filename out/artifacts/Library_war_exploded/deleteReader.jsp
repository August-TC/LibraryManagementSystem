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
  
    <input type="button" value="Return" onclick="javascript:location.href='index.jsp'"/>
        
    <form action="" method="post" name="frm_hist" id="f">
   	    <p style=" margin:10px auto; color:#666">
        <INPUT TYPE="radio" NAME="para_string" value="name" onclick="frm_hist.submit();" style="font-size:20px" checked>By ID
		<INPUT TYPE="radio" NAME="para_string" value="ISBN"  onclick="frm_hist.submit();" style="font-size:20px">By Name
        <INPUT TYPE="radio" NAME="para_string" value="author"  onclick="frm_hist.submit();" style="font-size:20px">By Email
        <INPUT TYPE="radio" NAME="para_string" value="press"  onclick="frm_hist.submit();" style="font-size:20px">By Tel
   		 &nbsp;&nbsp;&nbsp;</p>
    </form>
    
    <form action="" method="post">
        <p style="margin:10px auto;">
        <span><input type="text" value="Please enter keywords" size="30" style="font-size:20px"/></span>
        <span><input type="submit" value="search" style="font-size:20px"/></span>
    </form>
        </p>
  </div>   
  
  
  <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC" class="table_line">
				<tr bgcolor="#d8d8d8" class="greytext">
					<td   width="10%"  align="center">ID</td>
					<td   width="15%" align="center">Name</td>
					<td   width="10%" align="center">State</td>
					<td   width="25%" align="center">Email</td>
					<td   width="25%" align="center">Tel</td>
				    <td   width="10%" align="center">Type</td>
                    <td   width="5%"  align="center"></td>
				</tr>
                <tr>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">1</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%"></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="5%"><input type="submit" value="delete"/></td>
				</tr>
   
  </table>

	        <div class="clear"></div>
</div>


<div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>

</body>
</html>
