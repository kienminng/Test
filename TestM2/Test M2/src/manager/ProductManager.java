package manager;

import student.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public void showAllStudent() {
        if (students.isEmpty()) {
            System.out.println("Hiện tại chưa có sinh viên nào");
        } else {
            System.out.println("-------------Tổng Sinh Viên ---------");
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).toString());
            }
        }
    }
    public Student infProduct() {

        System.out.println("Nhập mã sinh viên: ");
        String code = scanner.nextLine();

        System.out.println("Nhập tên sinh viên: ");
        String name = scanner.nextLine();

        System.out.println("Nhập tuổi sinh viên: ");
        int age = checkInt();

        System.out.println("Nhập giới tính sinh viên: ");
        String gender = scanner.nextLine();

        System.out.println("Nhập địa chỉ sinh viên: ");
        String address = scanner.nextLine();

        System.out.println("Nhập điểm trung bình sinh viên sinh viên: ");
        double point;

        while (true) {
            try {
                point = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Sai định dạng! Vui lòng chọn lại");
            }
        }

        Student product = new Student(code, name, age, gender, address, point);
        System.out.println(product);
        return product;
    }



    public void  addStudent() {
        System.out.println("nhập id cho sinh viên");
        String id;
        while (true) {
            id = scanner.nextLine();
            if (students.isEmpty()) {
                break;
            } else {
                int index =findIdByName(id);
                if (index!=-1) {
                    System.out.println("id đã tồn tại");
                } else {
                    break;
                }
            }
        }
        System.out.println("nhập tên sinh viên");
        String name = scanner.nextLine();
        int age;
        while (true) {
            try {
                System.out.println("nhập tuổi ");
                age = Integer.parseInt(scanner.nextLine());
                if (age<18 || age>80){
                    System.out.println("tuổi ko phù hợp");
                } else {
                    break;
                }
            } catch (Exception e){
                System.out.println("Phải nhập số");
            }
        }
        System.out.println("nhập giới tính ");
        String gender;
        while (true) {
            gender = scanner.nextLine();
            if (gender.equals("nam") || gender.equals("nữ")){
                break;
            } else {
                System.out.println("Chỉ có thể nhập nam hoặc nữ");
            }
        }
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        System.out.println("Nhập điểm trung bình: ");
        double point;
        while (true) {
            try {
                point = Double.parseDouble(scanner.nextLine());
                break;
            }catch (Exception e){
                System.out.println("phải nhập dưới dạng số");
            }
        }

        Student student = new Student(id,name,age,gender,address,point);
        students.add(student);
    }

    public void update() {
        System.out.println("Nhập mã sinh viên bạn muốn sửa: ");
        String id = scanner.nextLine();
        int index = findIdByName(id);
        if (index!=-1) {
            students.set(index, infProduct());
        } else {
            System.out.println("ko tồn tại sinh viên này");
        }

    }





    public void sort() {
        int choose = 3;
        System.out.println("1. Sắp xếp điểm trung bình tăng dần.");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần.");
        System.out.println("3. Thoát.");
        System.out.println("Nhập số để lựa chọn: ");
        do {
            if (choose > 3) System.out.println("Vui lòng nhập lại");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose > 3);

        switch (choose) {
            case 1 -> ascending();
            case 2 -> decrease();
            case 3 -> System.out.println("oke");
        }
    }

    public void ascending() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getPoint() > students.get(j).getPoint()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        showAllStudent();
    }
    public void decrease() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getPoint() < students.get(j).getPoint()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }

        showAllStudent();

    }



    public int  findIdByName(String id) {
        if (students.isEmpty()){
            return -1;
        } else {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getIdStudent().equals(id)){
                    return i;
                }
            }return -1;
        }
    }

    public void delete() {
        System.out.println("nhập id student");
        String id = scanner.nextLine();
        int index = findIdByName(id);
        if (index!=-1) {
            students.remove(index);
        } else {
            System.out.println("ko có id sinh viên này");
        }

    }

    public int checkInt() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Sai định dạng! Vui lòng chọn lại");
            }
        }
        return choice;

    }





    public void read() {
        try (FileInputStream fis = new FileInputStream("Student.csv"); ObjectInputStream ois = new ObjectInputStream(fis)) {

            students = (ArrayList<Student>) ois.readObject();

        } catch (Exception ignored) {
        }
    }
    public void write() {
        try (FileOutputStream fos = new FileOutputStream("Student.csv"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(students);
        } catch (Exception ignored) {
        }
    }
}
