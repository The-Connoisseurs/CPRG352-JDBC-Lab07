<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type='text/css' rel='stylesheet' href='./assets/styles/style.css'>
        <title>User DB Management System</title>
    </head>
    <body>
        <div class="input_fields" id="add-wrapper">
            <form action="" method="post">
                <h3>Add User</h3>
                <input type="text" placeholder="Email" name="input_email" value=""><br>
                <input type="text" placeholder="First Name" name="input_firstName" value=""><br>
                <input type="text" placeholder="Last Name" name="input_lastName" value=""><br>
                <input type="text" placeholder="Password" name="input_password" value=""><br>
                <select name="select_role">
                    <option value="1">System Admin</option>
                    <option value="2">Regular User</option>
                    <option value="3">Company Admin</option>
                </select> <br>
                <p style="display:inline-block;">Active?</p>
                <input type="checkbox" name="input_active" value=""><br>
                <input type="submit" name="save_Button" value="Save">
                <input type="hidden" name="action" value="add">
            </form>
        </div>

        <div class="input_fields" id="edit-wrapper">
            <form action="" method="post">
                <h3>Edit User</h3>
                <input type="text" placeholder="Email" name="email_identifier" value=""><br>
                <input type="text" placeholder="First Name" name="edit_firstName" value=""><br>
                <input type="text" placeholder="Last Name" name="edit_lastName" value=""><br>
                <input type="text" placeholder="Password" name="edit_password" value=""><br>
                <select name="edit_role">
                    <option value="">System Admin</option>
                    <option value="">Regular User</option>
                    <option value="">Company Admin</option>
                </select> <br>
                <p style="display:inline-block;">Active?</p>
                <input type="checkbox" name="edit_active" value=""><br>
                <input type="submit" name="edit_Button" value="Edit">
                <input type="hidden" name="action" value="update">
            </form>
        </div>

        <div class="input_fields" id="delete-wrapper">
            <form action="" method="post">
                <h3>Delete User</h3>
                <input type="text" placeholder="Email" name="delete_email" value=""><br>
                <input type="submit" name="delete_Button" value="Delete">
                <input type="hidden" name="action" value="delete">
            </form>
        </div>

        <div class="view_database">
            <h3 id="view-header">View Users</h3>
            <table>
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                </tr>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <th>${user.getEmail()}</th>
                        <th>${user.getFirstName()}</th>
                        <th>${user.getLastName()}</th>
                        <th>${user.getRole()}</th>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <p>${test_message}</p>
    </body>
</html>
