package manager;

public class ManagerMenu {
    ProductManager manager = new ProductManager();

    public void menu() {

        int choice;
        do {
            String menu = """
                    ______________________________________________
                    ---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----
                    Chọn chức năng theo số (để tiếp tục)
                    1. Xem danh sách sinh viên
                    2. Thêm mới
                    3. Cập nhật
                    4. Xóa
                    5. Sắp xếp
                    6. Đọc từ file
                    7. Ghi vào file
                    8. Thoát     
                    Chọn chức năng:
                    """;
            System.out.println(menu);

            choice = manager.checkInt();

            switch (choice) {
                case 1 -> manager.showAllStudent();
                case 2 -> manager.addStudent();
                case 3 -> manager.update();
                case 4 -> manager.delete();
                case 5 -> manager.sort();
                case 6 -> manager.read();
                case 7 -> manager.write();
                case 8 -> System.exit(0);
                default -> System.out.println("Chọn lại!");
            }
        } while (true);
    }
}
