package student;

import java.io.Serializable;

public class Student implements Serializable {
    private String idStudent;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double point;

    public Student() {
    }

    public Student(String idStudent, String name, int age, String gender, String address, double point) {
        this.idStudent = idStudent;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.point = point;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return  idStudent +
                "," + name + '\'' +
                "," + age +
                "," + gender + '\'' +
                "," + address + '\'' +
                "," + point +"\n"
                ;
    }
}
