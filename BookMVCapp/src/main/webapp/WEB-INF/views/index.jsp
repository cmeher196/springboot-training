<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<html>


<body>

<h4> Purchase Book</h4>
<form method="post" action="addbook" modelAttribute="bookobj">

Enter Customerid <input type=text name="bookid"><br>
Enter customername <input type=text name="bookname"><br>


<button type=submit>Add Book</button>
</form>



<table border="2">

<tr>
<td>Bookid</td>
<td>Book Name</td>
 
</tr>

<c:forEach items="${books}" var="bookobj">
<tr>
<td>${bookobj.bookid}</td>
<td>${bookobj.bookname}</td>
 
<td><a href="deleteclient?qryid=${bookobj.bookid}">Delete</a></td>
<td><a href="viewclient?qryid=${bookobj.bookid}">Modify</a> </td>
<tr>
</c:forEach>



</table>


<form action="update" modelAttribute="clientmodi">

Enter Customerid <input type=text name="clientid" value=${clientfound.clientid}><br>
Enter customername <input type=text name="clientname" value=${clientfound.clientname}><br>
Enter Location <input type=text name="location" value=${clientfound.location}><br>

<button type=submit>Modify Client</button>
</form>

</body>
</html>
