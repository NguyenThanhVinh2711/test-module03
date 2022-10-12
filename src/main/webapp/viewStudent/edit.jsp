<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit student</title>
</head>
<body style="background-color: lemonchiffon;">
<center>
    <h1>Edit</h1>
    <h2 align="center">
        <a href="/students?action=students"><input type="button" value="Return List Student"> </a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1px"  width="700px"  style="font-size: 30px " bgcolor="#ffb6c1">
            <c:if test="${showEditStudent != null}">
                <input type="hidden" name="idStudent" value="<c:out value='${showEditStudent.idStudent}' />"/>
            </c:if>
            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name" size="60"
                           value="<c:out value='${showEditStudent.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Date Of Birth:</th>
                <td>
                    <input type="text" name="dateOfBirth" size="60"
                           value="<c:out value='${showEditStudent.note}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="60"
                           value="<c:out value='${showEditStudent.note}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input type="text" name="phoneNumber" size="60"
                           value="<c:out value='${showEditStudent.note}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="60"
                           value="<c:out value='${showEditStudent.note}' />"
                    />
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>Class Room:</th>--%>
<%--                <td>--%>
<%--                    <select name="id_classRoom">--%>
<%--                        <c:forEach var="class" items="${classList }">--%>
<%--                            <option value="${class.id}"><c:out value="${class.className}"/></option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
