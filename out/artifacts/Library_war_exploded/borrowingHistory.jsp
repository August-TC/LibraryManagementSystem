<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
				<!--<li><a href="index.jsp" >index</a></li>-->
                <li><a href="accountInformation.html" >accountInformation</a></li>
                <li><a href="reserveBook.html" >reserveBook</a></li>
                <li><a href="borrowingHistory.jsp" >borrowingHistory</a></li>
                <li><a href="modifyInformation.jsp" >modifyInformation</a></li>
                <li><a href="modifyPwd.html" >modifyPassword</a></li>
                <li><a href="book_shelf.php" ></a></li>
                <li><a href="book_loss.php" ></a></li>
                <li><a href="redr_lost.php" ></a></li>
                <li><a href="account.php" ></a></li>
                <li><a href="fine_pec.php" ></a></li>
                <li><a href="book_rv.php" ></a></li>
			</ul>
		</div>

 <div id="mylib_content">
  		<h2>borrowing history</h2>
      			
      <form action="" method="post" name="frm_hist" id="f">
      	<p style=" margin:10px auto;">
        <INPUT TYPE="radio" NAME="para_string" value="all" onclick="frm_hist.submit();" checked>Show all
		<INPUT TYPE="radio" NAME="para_string" value="page"  onclick="frm_hist.submit();" >Pagination
       		&nbsp;&nbsp;&nbsp;</p>
     </form>  
			<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC" class="table_line">
				<tr>
					<td bgcolor="#d8d8d8" class="greytext"></td> 
					<td bgcolor="#d8d8d8" class="greytext">Barcode</td>
					<td bgcolor="#d8d8d8" class="greytext">Name</td>
					<td bgcolor="#d8d8d8" class="greytext">Author</td>
					<td bgcolor="#d8d8d8" class="greytext">BorrowDate</td>
					<td bgcolor="#d8d8d8" class="greytext">ReturnDate</td>
					<td bgcolor="#d8d8d8" class="greytext">Document Location</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">1</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">2099653</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0003588370">&#x5929;&#x4f7f;&#x4e0e;&#x9b54;&#x9b3c;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x0028;&#x7f8e;&#x0029;&#x0020;&#x4e39;&#x00b7;&#x5e03;&#x6717;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2017-02-26</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2017-03-20</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">五层 社科图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">2</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">1508441</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0001277385">&#x004a;&#x0061;&#x0076;&#x0061;&#x9762;&#x5411;&#x5bf9;&#x8c61;&#x7a0b;&#x5e8f;&#x8bbe;&#x8ba1;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x5317;&#x4eac;&#x6bd4;&#x7279;&#x585e;&#x5a01;&#x65af;&#x56fe;&#x4e66;&#x670d;&#x52a1;&#x4e8b;&#x4e1a;&#x90e8;&#x7ec4;&#x7f16;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-09-04</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-10-14</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">四层 科技图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">3</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">2081224</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0003576968">&#x75af;&#x72c2;&#x004a;&#x0061;&#x0076;&#x0061;&#x8bb2;&#x4e49;&#x002e;&#x7b2c;&#x0032;&#x7248;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x674e;&#x521a;&#x7f16;&#x8457;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-09-03</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-09-04</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">四层 科技图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">4</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">1982328</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0002847197">&#x75af;&#x72c2;&#x0041;&#x006e;&#x0064;&#x0072;&#x006f;&#x0069;&#x0064;&#x8bb2;&#x4e49;&#x002e;&#x7b2c;&#x0032;&#x7248;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x674e;&#x521a;&#x7f16;&#x8457;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-07-19</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-08-08</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">东馆南三层 科技图书阅览室</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">5</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">2174647</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0003669043">&#x4e92;&#x8054;&#x7f51;&#x002b;&#x91d1;&#x878d;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x4e54;&#x6d77;&#x66d9;&#x7b49;&#x8457;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-05-31</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-07-07</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">五层 社科图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">6</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">1790830</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0001764737">&#x91d1;&#x9675;&#x5341;&#x4e8c;&#x9497;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x6768;&#x5927;&#x8fdc;&#x8457;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-05-25</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-07-07</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">五层 社科图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">7</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">2096610</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0001887306">&#x68a6;&#x65ad;&#x4ee3;&#x7801;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x0028;&#x7f8e;&#x0029;&#x0020;&#x0053;&#x0063;&#x006f;&#x0074;&#x0074;&#x0020;&#x0052;&#x006f;&#x0073;&#x0065;&#x006e;&#x0062;&#x0065;&#x0072;&#x0067;&#x8457;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-04-18</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-05-16</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">四层 科技图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">8</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">2058123</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0003447228">&#x004d;&#x0041;&#x0054;&#x004c;&#x0041;&#x0042;&#x5b9e;&#x7528;&#x6559;&#x7a0b;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x4e3b;&#x7f16;&#x5468;&#x660e;&#x534e;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-04-08</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-05-14</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">四层 科技图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">9</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">2079911</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0003565966">&#x004d;&#x0041;&#x0054;&#x004c;&#x0041;&#x0042;&#x9762;&#x5411;&#x5bf9;&#x8c61;&#x7a0b;&#x5e8f;&#x8bbe;&#x8ba1;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x82d7;&#x5fd7;&#x5b8f;&#x002c;&#x0020;&#x9a6c;&#x91d1;&#x5f3a;&#x7f16;&#x8457;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-04-08</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-05-14</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">四层 科技图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">10</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">2078332</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0003575455">&#x004d;&#x0061;&#x0074;&#x006c;&#x0061;&#x0062;&#x51fd;&#x6570;&#x548c;&#x5b9e;&#x4f8b;&#x901f;&#x67e5;&#x624b;&#x518c;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x9648;&#x660e;&#x002c;&#x0020;&#x90d1;&#x5f69;&#x4e91;&#x002c;&#x0020;&#x5f20;&#x94ee;&#x7f16;&#x8457;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-04-08</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2016-05-14</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">四层 科技图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">11</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">1871244</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0002000917">&#x5de5;&#x79d1;&#x6570;&#x5b66;&#x5206;&#x6790;&#x4f8b;&#x9898;&#x4e0e;&#x4e60;&#x9898;&#x003a;&#x7cbe;&#x7b80;&#x7248;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x5b59;&#x632f;&#x7eee;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2015-09-29</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2015-10-21</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">三层 基础学科图书阅览区</td>
				</tr>
				<tr>
					<td bgcolor="#FFFFFF" class="whitetext"  width="5%">12</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="10%">1418735</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="25%"><a class="blue" href="../opac/item.php?marc_no=0000920762">&#x6570;&#x5b66;&#x5206;&#x6790;&#x7684;&#x7406;&#x8bba;&#x3001;&#x65b9;&#x6cd5;&#x4e0e;&#x6280;&#x5de7;</a></td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">&#x9093;&#x4e50;&#x658c;&#x7f16;</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2015-09-29</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="12%">2015-10-21</td>
					<td bgcolor="#FFFFFF" class="whitetext" width="15%">三层 基础学科图书阅览区</td>
				</tr>
			</table>
  </div>
  <div class="clear"></div>
  
<div id="footer"><div id="copy"><p>Northwestern Polytechnical University</p></div></div>
</body>
</html>
