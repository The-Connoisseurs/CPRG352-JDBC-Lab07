<%-- 
    Document   : users
    Created on : Jul 5, 2021, 8:08:56 PM
    Author     : 855474
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User DB Management System</title>
    </head>
    <body>
        <div>
            <h3>Add User</h3>
            <input type="text" placeholder="Email" name="input_email" value=""><br>
            <input type="text" placeholder="First Name" name="input_firstName" value=""><br>
            <input type="text" placeholder="Last Name" name="input_lastName" value=""><br>
            <input type="text" placeholder="Password" name="input_password" value=""><br>
            <select>
                <option value="">system admin</option>
                <option value="">regular user</option>
                <option value="">company admin</option>
            </select> <br>
            <input type="checkbox" name="input_active" value=""><br>
            <input type="submit" name="save_Button" value="Save">
        </div>

        <div>
            <h3>Edit User</h3>
            <input type="text" placeholder="First Name" name="input_firstName" value=""><br>
            <input type="text" placeholder="Last Name" name="input_lastName" value=""><br>
            <input type="text" placeholder="Password" name="input_password" value=""><br>
            <select>
                <option value="">system admin</option>
                <option value="">regular user</option>
                <option value="">company admin</option>
            </select> <br>
            <input type="submit" name="save_Button" value="Save">
        </div>

        <div>
            <c:forEach var="user" items="${userList}">

            </c:forEach>
        </div>
    </body>
</html>
