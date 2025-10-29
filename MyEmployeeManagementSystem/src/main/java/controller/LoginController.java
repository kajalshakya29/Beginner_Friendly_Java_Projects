package controller;

import DAO.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

@WebServlet("/auth")
public class LoginController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("LoginController doGet called");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }

    // Handle POST requests (when form is submitted)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Add your authentication logic here
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Login attempt - Username: " + username + ", Password: " + password);

        // Validate credentials
        if (isValidUser(username, password)) {
            System.out.println("Login SUCCESSFUL");
            // If "Remember me" is checked, set cookies
            if ("on".equals(request.getParameter("remember"))) {
                Cookie userCookie = new Cookie("username", username);
                Cookie passCookie = new Cookie("password", password); // Note: Store hashed password in real applications
                userCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
                passCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }
            response.sendRedirect("getMyEmployee");
        } else {
            System.out.println("Login FAILED");
            request.setAttribute("error", "Invalid credentials");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }

    private boolean isValidUser(String username, String password) {
        // This would query your database
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
