import java.sql.*;
import java.util.Scanner;

public class ExecuteScalar {
    public static Object executeScalar(Connection con, String sql) throws SQLException {
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getObject(1);
            }
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter database name:");
        String database = sc.nextLine();
        System.out.println("Enter scalar SQL query (e.g. SELECT COUNT(*) FROM your_table):");
        String sql = sc.nextLine();

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/" + database;
        try (Connection con = DriverManager.getConnection(url, "root", "root")) {
            Object result = executeScalar(con, sql);
            System.out.println("Scalar result: " + result);
        }
        sc.close();
    }
}
