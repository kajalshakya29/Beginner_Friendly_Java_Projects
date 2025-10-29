package controller;

import DAO.MyEmployeeDAO;
import model.MyEmployee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

@WebServlet("/addEmployee")
public class AddEmployeeController extends HttpServlet {

    // Handle GET - show the add employee form
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Use forward slash for root directory
        RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
        rd.forward(request, response);
    }

    // Handle POST - process the form submission
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get parameters from form
            int eid = Integer.parseInt(request.getParameter("eid"));
            String ename = request.getParameter("ename");
            String edept = request.getParameter("edept");

            // Create employee object
            MyEmployee employee = new MyEmployee();
            employee.setEid(eid);
            employee.setEname(ename);
            employee.setEdept(edept);

            // Add to database
            MyEmployeeDAO dao = new MyEmployeeDAO();
            boolean success = dao.addEmployee(employee);

            if (success) {
                // Redirect to employee list on success
                response.sendRedirect("getMyEmployee");
            } else {
                // Show error message
                request.setAttribute("error", "Failed to add employee. Employee ID might already exist.");
                RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
                rd.forward(request, response);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid Employee ID. Please enter a number.");
            RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
            rd.forward(request, response);
        }
    }
}