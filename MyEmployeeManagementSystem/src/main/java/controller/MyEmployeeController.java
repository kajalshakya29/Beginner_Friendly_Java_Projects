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
import java.util.List;


@WebServlet("/getMyEmployee")
public class MyEmployeeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int eid = Integer.parseInt(request.getParameter("eid"));
        MyEmployeeDAO dao = new MyEmployeeDAO();
        List<MyEmployee> list = dao.getAllEmployees();
        request.setAttribute("myEmployees", list);
        RequestDispatcher rd = request.getRequestDispatcher("showMyEmployee.jsp");
        rd.forward(request, response);
    }
}
