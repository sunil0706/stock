<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>	
	<H3><center>Stock Price Details</center></H3>
	<form action="/getStockPrice">
	<span style="color:blue">${msg}</span>
	
	&nbsp;
		<table>
		<tr><td>&nbsp</td></tr>
			<tr><td>Stock Name : </td><td><input type="text" name="stockName"></td></tr>
			<tr><td>Quantity : </td><td><input type="text" name="quantity"></td></tr>
			<tr><td>&nbsp;</td><td><input type="submit" value="Get Price"/></td></tr>
		</table>
	</form>
</body>
</html>