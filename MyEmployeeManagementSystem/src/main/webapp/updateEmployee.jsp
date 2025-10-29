<%@ page import="model.MyEmployee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
</head>
<body>
    <h2>Update Employee</h2>

    <%
        String error = (String)request.getAttribute("error");
        if (error != null) {
    %>
        <div style="color:red;"><%= error %></div>
    <%
        }

        MyEmployee employee = (MyEmployee) request.getAttribute("employee");
        if (employee != null) {
    %>

    <form method="post" action="updateEmployee">
        <div>
            <label for="eid">Employee ID:</label>
            <input type="number" id="eid" name="eid" value="<%= employee.getEid() %>" readonly>
        </div>

        <div>
            <label for="ename">Employee Name:</label>
            <input type="text" id="ename" name="ename" value="<%= employee.getEname() %>" required>
        </div>

        <div>
            <label for="edept">Department:</label>
            <input type="text" id="edept" name="edept" value="<%= employee.getEdept() %>" required>
        </div>

        <button type="submit">Update Employee</button>
    </form>

    <%
        }
    %>

    <br>
    <a href="getMyEmployee">← Back to Employee List</a>
</body>
</html>