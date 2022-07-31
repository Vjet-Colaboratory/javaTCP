/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.sql.*;

/**
 *
 * @author huyho
 */
public class ConnectionDatabase {

    Connection conn = null;
    private static String database;
    private static String username;
    private static String password;

    public static boolean getConnect() {
        // lay chuoi vua cat gan qua cho bien moi de thuc hien ket noi
        database = ServerThread.database;
        username = ServerThread.username;
        password = ServerThread.password;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1:9999;" + "databaseName=" + database + ";user=" + username + ";password=" + password;
            System.out.println(url);
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Da ket noi voi database " + conn.getCatalog());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addStudent(Student student) {
        String sql = ("INSERT INTO ThongtinSV (MaSV,TenSV, DiemToan, DiemVan, DiemAnh) VALUES (?,?,?,?,?)");
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, student.getID());
            ps.setString(2, student.getName());
            ps.setDouble(3, student.getMarkMath());
            ps.setDouble(4, student.getMarkLiteratire());
            ps.setDouble(5, student.getMarkEnglish());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
