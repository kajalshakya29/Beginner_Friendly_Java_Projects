<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Employee</title>
</head>
<body>
    <div class="container">
        <h2>Add New Employee</h2>

        <%-- Display error message if any --%>
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <div class="error"><%= error %></div>
        <%
            }
        %>

        <form method="post" action="addEmployee">
            <div class="form-group">
                <label for="eid">Employee ID:</label>
                <input type="number" id="eid" name="eid" required>
            </div>

            <div class="form-group">
                <label for="ename">Employee Name:</label>
                <input type="text" id="ename" name="ename" required>
            </div>

            <div class="form-group">
                <label for="edept">Department:</label>
                <input type="text" id="edept" name="edept" required>
            </div>

            <button type="submit" class="btn">Add Employee</button>
        </form>

        <a href="getMyEmployee" class="back-link">← Back to Employee List</a>
    </div>
</body>
</html>