package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.UserService;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // create user service object
        UserService userService = new UserService();

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
                // PERSIST ERRORS: IN PROGRESS
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

                    // checks if user has entered all the necessary information
                    if (email != null || !email.equals("") && firstName != null || !firstName.equals("") && lastName != null || !lastName.equals("") && password != null || !password.equals("")) {
                        if (isActive != null || !isActive.equals("")) {
                            activeStatus = true;
                        } else {
                            activeStatus = false;
                        }
                    }
                    break;

                case "update":
                    break;

                case "delete":
                    // grabs the email from the input field
                    email = request.getParameter("delete_email");
                    if (email != null || !email.equals("")){
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
