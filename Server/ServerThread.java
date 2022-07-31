/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import static Server.ConnectionDatabase.getConnect;
import com.sun.source.tree.BreakTree;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huyho
 */
public class ServerThread implements Runnable {

    private Socket socket;
    private ResultSet rs;
    DataInputStream din;
    DataOutputStream dout;
    ObjectInputStream oosi;
    ObjectOutputStream oout;
    //private ArrayList<Socket> list;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());
        new Thread(this).start();
    }

    public static String database;
    public static String username;
    public static String password;

    public void connectdb() {
        try {
            // doc , cat chuoi
            String str = din.readUTF();
            String[] ReadStr = str.split("#");
            database = ReadStr[0];
            username = ReadStr[1];
            password = ReadStr[2];
            System.out.println(database + username + password);

            // neu ket noi thanh cong thi gui chuoi ok qua cho client
            if (getConnect()) {
                dout.writeUTF("ok");
            } else {
                dout.writeUTF("failed");
            }
        } catch (IOException ex) {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        }
    }

    public void AddStudent() {
        try {
            oosi = new ObjectInputStream(socket.getInputStream());
            oout = new ObjectOutputStream(socket.getOutputStream());
            // doc doi tuong student tu client gui qua
            Student student = new Student();
            student = (Student) oosi.readObject();
            ConnectionDatabase con = new ConnectionDatabase();
            if (con.addStudent(student)) {
                oout.writeObject("ok");
            } else {
                oout.writeObject("ok");
            }
        } catch (Exception ex) {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        }
    }

    @Override
    public void run() {
        connectdb();
        AddStudent();

    }
}
