package DAO;

import model.MyEmployee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyEmployeeDAO {

    public List<MyEmployee> getAllEmployees() {
        List<MyEmployee> employees = new ArrayList<>();

        try (Connection conn = DBConnectionManager.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM my_employee")) {

            while (rs.next()) {
                MyEmployee emp = new MyEmployee();
                emp.setEid(rs.getInt("eid"));
                emp.setEname(rs.getString("ename"));
                emp.setEdept(rs.getString("edept"));
                employees.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
    public boolean addEmployee(MyEmployee employee) {
        String sql = "INSERT INTO my_employee (eid, ename, edept) VALUES (?, ?, ?)";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employee.getEid());
            stmt.setString(2, employee.getEname());
            stmt.setString(3, employee.getEdept());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error adding employee: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    public MyEmployee getEmployeeById(int eid) {
        MyEmployee employee = null;
        String sql = "SELECT * FROM my_employee WHERE eid = ?";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eid);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employee = new MyEmployee();
                employee.setEid(rs.getInt("eid"));
                employee.setEname(rs.getString("ename"));
                employee.setEdept(rs.getString("edept"));
            }
            rs.close();

        } catch (SQLException e) {
            System.err.println("Error getting employee: " + e.getMessage());
            e.printStackTrace();
        }

        return employee;
    }
    public boolean updateEmployee(MyEmployee employee) {
        String sql = "UPDATE my_employee SET ename = ?, edept = ? WHERE eid = ?";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getEname());
            stmt.setString(2, employee.getEdept());
            stmt.setInt(3, employee.getEid());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating employee: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteEmployee(int eid) {
        String sql = "DELETE FROM my_employee WHERE eid = ?";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eid);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
