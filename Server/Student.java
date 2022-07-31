/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;






/**
 *
 * @author huyho
 */
public class Student {

    private int ID;
    private String Name;
    private double MarkMath, MarkLiteratire, MarkEnglish;

    public Student() {
    }

    public Student(int ID, String Name, double MarkMath, double MarkLiteratire, double MarkEnglish) {
        this.ID = ID;
        this.Name = Name;
        this.MarkMath = MarkMath;
        this.MarkLiteratire = MarkLiteratire;
        this.MarkEnglish = MarkEnglish;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getMarkMath() {
        return MarkMath;
    }

    public void setMarkMath(double MarkMath) {
        this.MarkMath = MarkMath;
    }

    public double getMarkLiteratire() {
        return MarkLiteratire;
    }

    public void setMarkLiteratire(double MarkLiteratire) {
        this.MarkLiteratire = MarkLiteratire;
    }

    public double getMarkEnglish() {
        return MarkEnglish;
    }

    public void setMarkEnglish(double MarkEnglish) {
        this.MarkEnglish = MarkEnglish;
    }

}
