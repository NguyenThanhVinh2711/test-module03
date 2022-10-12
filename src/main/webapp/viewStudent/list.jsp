<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student Manager</title>

</head>
<body style="background-color: lemonchiffon;">
<h1 align="center" >List Student</h1>
<form  action="/students?action=find" method="post">
    <input type="text" name="name" placeholder="name">
    <input type="submit" value="findByNameStudent">
</form>
<div class="wrapper" align="center" >
        <h2 align="center" > <a href="/students?action=create"> <input type="button" value="Create new category">  </a></h2>
    <table border="1px"  width="700px"  style="font-size: 30px " bgcolor="#ffb6c1">
        <%--    <caption><h2>List Catalog </h2></caption>--%>
        <tr align="center" >
            <th align="center">Name</th>
            <th align="center">Date Of Birth</th>
            <th align="center">Address</th>
            <th align="center">Phone Number</th>
            <th align="center">Email</th>
            <th align="center">Class Room</th>
        </tr>
        <c:forEach var="student" items="${studentList}">
            <tr>
                <td style="text-align: left" ><c:out value="${student.name}"/></td>
                <td style="text-align: left"><c:out value="${student.dateOfBirth}"/></td>
                <td style="text-align: left"><c:out value="${student.address}"/></td>
                <td style="text-align: left"><c:out value="${student.phoneNumber}"/></td>
                <td style="text-align: left"><c:out value="${student.email}"/></td>
                <td style="text-align: left"><c:out value="${student.className}"/></td>
                <td align="center">
                    <a href="/students?action=edit&idStudent=${student.idStudent}"> <input type="button" value="Edit"> </a>
                    <a href="/students?action=delete&idStudent=${student.idStudent}">  <input type="button" value="Delete"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
