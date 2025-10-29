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

@WebServlet("/updateEmployee")
public class UpdateEmployeeController extends HttpServlet {

    // Handle GET - show the update employee form with existing data
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int eid = Integer.parseInt(request.getParameter("eid"));
            MyEmployeeDAO dao = new MyEmployeeDAO();
            MyEmployee employee = dao.getEmployeeById(eid);

            if (employee != null) {
                request.setAttribute("employee", employee);
                RequestDispatcher rd = request.getRequestDispatcher("updateEmployee.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("getMyEmployee");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("getMyEmployee");
        }
    }

    // Handle POST - process the update form submission
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int eid = Integer.parseInt(request.getParameter("eid"));
            String ename = request.getParameter("ename");
            String edept = request.getParameter("edept");

            MyEmployee employee = new MyEmployee();
            employee.setEid(eid);
            employee.setEname(ename);
            employee.setEdept(edept);

            MyEmployeeDAO dao = new MyEmployeeDAO();
            boolean success = dao.updateEmployee(employee);

            if (success) {
                response.sendRedirect("getMyEmployee");
            } else {
                request.setAttribute("error", "Failed to update employee.");
                request.setAttribute("employee", employee);
                RequestDispatcher rd = request.getRequestDispatcher("updateEmployee.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("updateEmployee.jsp");
            rd.forward(request, response);
        }
    }
}