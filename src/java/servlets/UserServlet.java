package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // create user service object
        UserService userService = new UserService();
        // create role service object
        RoleService roleService = new RoleService();
        // create List object to store user information
        List<User> userList = null;

        try {
            // retrieve all users in the DB
            userList = userService.getAll();
            // display the users to the main page
            request.setAttribute("userList", userList);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Display the main page
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email, firstName, lastName, password, isActive;
        int role;
        boolean activeStatus;

        // create user service object
        UserService userService = new UserService();
        // grabs the actions available in the application
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "add":
                    // grabs the email from the input field
                    email = request.getParameter("input_email");
                    // grabs the email from the input field
                    firstName = request.getParameter("input_firstName");
                    // grabs the email from the input field
                    lastName = request.getParameter("input_lastName");
                    // grabs the password from the input field
                    password = request.getParameter("input_password");
                    // grabs the role from the dropdown list
                    role = Integer.parseInt(request.getParameter("select_role"));
                    // grabs the isActive from the checkbox
                    isActive = request.getParameter("input_active");
                    activeStatus = false;
                    // checks if user has entered all the necessary information
                    if (!email.equals("") && !firstName.equals("") && !lastName.equals("") && !password.equals("")) {
                        if (isActive != null) {
                            activeStatus = true;
                        }

                        userService.insert(email, activeStatus, firstName, lastName, password, role);
                    }
                    break;
                // PERSIST ERRORS: IN PROGRESS
                case "update":
                    // grabs the email from the input field
                    email = request.getParameter("email_identifier");
                    // grabs the email from the input field
                    firstName = request.getParameter("edit_firstName");
                    // grabs the email from the input field
                    lastName = request.getParameter("edit_lastName");
                    // grabs the password from the input field
                    password = request.getParameter("edit_password");
                    // grabs the role from the dropdown list
                    role = Integer.parseInt(request.getParameter("edit_role"));
                    // grabs the isActive from the checkbox
                    isActive = request.getParameter("edit_active");
                    activeStatus = true;

                    // checks if user has entered all the necessary information
                    if (!email.equals("") && !firstName.equals("") && !lastName.equals("") && !password.equals("")) {
                        if (isActive != null) {
                            activeStatus = true;
                        }

                        userService.update(email, activeStatus, firstName, lastName, password, role);
                    }
                    break;

                case "delete":
                    // grabs the email from the input field
                    email = request.getParameter("delete_email");
                    if (email != null || !email.equals("")) {
                        userService.delete(email);
                    }
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

        // send the user to the main page
        response.sendRedirect("UserServlet");
    }
}
