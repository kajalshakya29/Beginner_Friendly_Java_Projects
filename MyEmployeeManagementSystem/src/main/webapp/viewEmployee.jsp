<%@ page import="model.MyEmployee" %>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
    <h2>Employee Details</h2>

    <%
        MyEmployee employee = (MyEmployee) request.getAttribute("employee");
        if (employee != null) {
    %>
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>Employee ID:</th>
                <td><%= employee.getEid() %></td>
            </tr>
            <tr>
                <th>Employee Name:</th>
                <td><%= employee.getEname() %></td>
            </tr>
            <tr>
                <th>Department:</th>
                <td><%= employee.getEdept() %></td>
            </tr>
        </table>
    <%
        } else {
    %>
        <p>Employee not found.</p>
    <%
        }
    %>

    <br>
    <a href="getMyEmployee">Back to Employee List</a>
</body>
</html>