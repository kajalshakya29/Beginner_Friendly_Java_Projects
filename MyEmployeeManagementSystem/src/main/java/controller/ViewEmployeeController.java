package controller;

import DAO.MyEmployeeDAO;
import model.MyEmployee;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/viewEmployee")
public class ViewEmployeeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int eid = Integer.parseInt(request.getParameter("eid"));
            MyEmployeeDAO dao = new MyEmployeeDAO();
            MyEmployee employee = dao.getEmployeeById(eid);

            if (employee != null) {
                request.setAttribute("employee", employee);
                RequestDispatcher rd = request.getRequestDispatcher("viewEmployee.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "Employee not found");
                RequestDispatcher rd = request.getRequestDispatcher("getMyEmployee");
                rd.forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("getMyEmployee");
        }
    }
}