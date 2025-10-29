package controller;

import DAO.MyEmployeeDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int eid = Integer.parseInt(request.getParameter("eid"));
            MyEmployeeDAO dao = new MyEmployeeDAO();
            boolean success = dao.deleteEmployee(eid);

            if (success) {
                response.sendRedirect("getMyEmployee");
            } else {
                request.setAttribute("error", "Failed to delete employee.");
                response.sendRedirect("getMyEmployee");
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("getMyEmployee");
        }
    }
}