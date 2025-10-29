<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Login</title></head>
<body>
    <h2>Login Page</h2>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
                out.println("<p style='color:red;'>" + message + "</p>");
            }
            Cookie[] cookies = request.getCookies();
            String savedUsername = "";
            String savedPassword = "";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        savedUsername = cookie.getValue();
                    }
                    if (cookie.getName().equals("password")) {
                        savedPassword = cookie.getValue();
                    }
                }
            }
        %>
<form method="post" action="auth">
        <label>Username: <input type="text" name="username"/></label><br/>
        <label>Password: <input type="password" name="password"/></label><br/>
        <label>Remember me: <input type="checkbox" name="remember"/></label><br/>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>

