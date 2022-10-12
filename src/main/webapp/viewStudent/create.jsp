
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body style="background-color: lemonchiffon;">
<div>
  <h1 align="center" >Create new student </h1>
  <h2 align="center">   <a href="/students?action=students"> <input type="button" value="Return student list"> </a> </h2>
  <div align="center">
    <form method="post">
      <table border="1px"  width="700px"  style="font-size: 30px " bgcolor="#ffb6c1">
        <tr>
          <th>Name:</th>
          <td>
            <input type="text" name="name" id="name" size="70"/>
          </td>
        </tr>
        <tr>
          <th>Date of birth:</th>
          <td>
            <input type="text" name="dateOfBirth" id="dateOfBirth" size="70"/>
          </td>
        </tr><tr>
          <th>Address:</th>
          <td>
            <input type="text" name="address" id="address" size="70"/>
          </td>
        </tr><tr>
          <th>Phone number:</th>
          <td>
            <input type="text" name="phoneNumber" id="phoneNumber" size="70"/>
          </td>
        </tr><tr>
          <th>Email:</th>
          <td>
            <input type="text" name="email" id="email" size="70"/>
          </td>
        </tr><tr>
          <th>Class room:</th>
          <td>
            <input type="text" name="id_classRoom" id="id_classRoom" size="70"/>
          </td>
        </tr>

        <tr>
          <td colspan="2" align="center">
            <input type="submit" value="Save"/>
          </td>
        </tr>
      </table>
    </form>
  </div>
</div>
</body>
</html>
