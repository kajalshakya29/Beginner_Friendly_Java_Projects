<%@ page import="java.util.*, model.MyEmployee" %>
<html>
<head>
    <title>All Employees</title>
</head>
<body>
    <h2>All Employees</h2>
    <a href="addEmployee" class="add-btn">Add New Employee</a>
    <%
       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
       response.setHeader("Pragma", "no-cache");
       response.setDateHeader("Expires", 0);
    %>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>EID</th>
            <th>Employee Name</th>
            <th>Department</th>
            <th>Operations</th>
        </tr>
        <%
            List<MyEmployee> employees = (List<MyEmployee>) request.getAttribute("myEmployees");
            if (employees != null && !employees.isEmpty()) {
                for (MyEmployee emp : employees) {
        %>
                    <tr>
                        <td><%= emp.getEid() %></td>
                        <td><%= emp.getEname() %></td>
                        <td><%= emp.getEdept() %></td>
                        <td><a href="viewEmployee?eid=<%= emp.getEid() %>">View</a> |
                        <a href="updateEmployee?eid=<%= emp.getEid() %>">Update</a> |
                        <a href="deleteEmployee?eid=<%= emp.getEid() %>" onclick="return confirm('Delete this employee?')">Delete</a>
                        </td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="3">No employee data found.</td>
                </tr>
        <%
            }
        %>
    </table>
    <form action="logout" method="post">
    <input type="submit" value="Logout">
    </form>
</body>
</html>

