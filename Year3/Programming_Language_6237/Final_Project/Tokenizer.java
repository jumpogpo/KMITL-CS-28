import java.io.*;
import java.util.*;

public class Tokenizer {
    // Set of operators (เครื่องหมายทางคณิตศาสตร์หรือการเปรียบเทียบ)
    private static final Set<String> operators = new HashSet<>(Arrays.asList(
            "+", "-", "*", "/", "=", ">", ">=", "<", "<=", "==", "++", "--"
    ));
    
    // Set of keywords (คำสั่งสำคัญในภาษาโปรแกรม)
    private static final Set<String> keywords = new HashSet<>(Arrays.asList(
            "if", "then", "else", "endif", "while", "do", "endwhile", "print", "newline", "read"
    ));
    
    // Symbol table (ตารางสำหรับเก็บตัวแปรหรือ identifier)
    private static final Set<String> symbolTable = new HashSet<>();
    
    public static void main(String[] args) {
        try {
            // อ่านไฟล์ตามชื่อที่ใส่เข้าไป
            BufferedReader reader = new BufferedReader(new FileReader("test_case2.txt"));
            String line;
            
            // อ่านแต่ละบรรทัดในไฟล์ทีละบรรทัด
            while ((line = reader.readLine()) != null) {
                tokenize(line); // เรียกฟังก์ชัน tokenize เพื่อตรวจสอบแต่ละบรรทัด
            }
            
            reader.close(); // ปิดไฟล์หลังจากอ่านเสร็จ
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    // ฟังก์ชัน tokenize สำหรับแยกแต่ละคำหรือสัญลักษณ์ในบรรทัด
    private static void tokenize(String line) {
        // สร้าง StringBuilder สำหรับเก็บค่าของตัวอักษรที่เจอ
        StringBuilder token = new StringBuilder();
        
        // ตัวแปรเพื่อบอกว่าเราอยู่ในสตริงหรือตัวแปรชนิดข้อความหรือไม่
        boolean inString = false;
        
        // ตัวแปรเพื่อบอกว่าเราอยู่ในคอมเมนต์แบบหลายบรรทัดหรือไม่
        boolean inComment = false;

        // แบ่งบรรทัดออกเป็นคำตามช่องว่าง (space)
        String[] tokens = line.split("\\s+");
        
        // วนลูปตรวจสอบแต่ละคำ
        for (String part : tokens) {
            // ถ้าอยู่ในคอมเมนต์หลายบรรทัด
            if (inComment) {
                if (part.endsWith("*/")) {
                    inComment = false; // คอมเมนต์สิ้นสุดแล้ว
                }
                continue; // ข้ามส่วนที่เหลือของคอมเมนต์
            }
            
            // ถ้าอยู่ในสตริง (ข้อความในเครื่องหมาย " ")
            if (inString) {
                token.append(" ").append(part); // รวมคำที่อยู่ในสตริง
                if (part.endsWith("\"")) { // ถ้าสิ้นสุดสตริง
                    inString = false;
                    System.out.println("string: " + token.toString());
                    token.setLength(0); // ล้างตัวแปร token
                }
            }
            // ตรวจสอบการเริ่มต้นสตริง
            else if (part.startsWith("\"") && !part.endsWith("\"")) {
                inString = true; // เริ่มต้นสตริง
                token.append(part);
            }
            // ตรวจสอบ operator
            else if (operators.contains(part)) {
                System.out.println("operator: " + part);
            }
            // ตรวจสอบวงเล็บหรือ semicolon
            else if (part.matches("[();]+")) {
                System.out.println("parentheses or semicolon: " + part);
            }
            // ตรวจสอบคำสำคัญ (keyword)
            else if (keywords.contains(part)) {
                System.out.println("keyword: " + part);
            }
            // ตรวจสอบตัวเลขจำนวนเต็ม
            else if (part.matches("\\d+")) { // \d+ หมายถึงตัวเลข 1 ตัวขึ้นไป
                System.out.println("integer: " + part);
            }
            // ตรวจสอบ identifier (ตัวแปรหรือชื่อฟังก์ชัน)
            else if (part.matches("[a-zA-Z][a-zA-Z0-9]*")) { // ชื่อ identifier จะขึ้นต้นด้วยตัวอักษร
                if (symbolTable.contains(part)) {
                    System.out.println("identifier \"" + part + "\" already in symbol table");
                } else {
                    symbolTable.add(part); // เพิ่ม identifier ใหม่ใน symbol table
                    System.out.println("new identifier: " + part);
                }
            }
            // ตรวจสอบคอมเมนต์หลายบรรทัดที่เริ่มต้นด้วย /*
            else if (part.startsWith("/*")) {
                if (!part.endsWith("*/")) {
                    inComment = true; // ยังไม่จบคอมเมนต์ ต้องหา */
                }
            }
            // ตรวจสอบคอมเมนต์บรรทัดเดียวที่เริ่มด้วย //
            else if (part.startsWith("//")) {
                continue; // ข้ามส่วนที่เหลือของบรรทัดนี้
            }
            // ตรวจสอบสตริงที่เป็นคำเดียว (เริ่มและจบด้วย " ")
            else if (part.startsWith("\"") && part.endsWith("\"")) {
                System.out.println("string: " + part);
            }
            // ถ้าหาโทเค็นไม่เจอ
            else {
                System.out.println("error: unrecognized token \"" + part + "\"");
                System.exit(1); // หยุดโปรแกรมเมื่อพบข้อผิดพลาด
            }
        }
    }
}
