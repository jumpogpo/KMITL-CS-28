import java.util.Scanner; // Import Scanner มาใช้ในการรับ Input จาก Keyboard

public class CF {
  public static void main(String[] args) {
    System.out.println("Please enter F (Fahrenheit) that you want to change to C (Celcius): "); // แสดงข้อความบอกให้ User ใส่ค่าองศา F
    Scanner Input = new Scanner(System.in); // สร้างตัวแปร Input โดยมีค่าเป็นการเก็บข้อมูลจากแป้นพิมพ์

    double F = Input.nextDouble(); // รับค่าเป็น Double
    System.out.println(((F - 32) / 9) * 5); // แสดงผลค่า C ที่แปลงจาก F ดังสูตร ((F - 32) / 9) * 5

    Input.close(); // ปิดการรับ Input ของบรรทัดที่ 6
  }
}
