// คำสั่ง Run java Lab4Q365368.java 2 3 4 5 20 22 123

public class Lab4Q365368 {
    public static void main(String ... args) {
        int amountCharge = 0; // กำหนดให้ amountCharge เป็นประเภท Int และมีค่าเป็น 0
        int hrsPark = 0; // กำหนดให้ hrsPart เป็นประเภท Int และมีค่าเป็น 0
        int remaining = 0; // กำหนดให้ remaining เป็นประเภท Int และมีค่าเป็น 0

        // args = [2, 3, 4, 5, 20, 22, 123] เนื่องจากเวลาเรา Run เราใช้คำสั่ง "java Lab4Q365368.java 2 3 4 5 20 22 123" ค่าที่ใส่หลัง Lab4Q365368.java จะคือ args โดยมีค่าเป็น Array

        for (int i = 0; i < args.length; i++) { // For Loop ทำงานไปเรื่อยๆ จนกว่ามีค่าน้อยกว่า args.length
            hrsPark = Integer.parseInt(args[i]); // กำหนดให้ hrsPart มีค่าเท่ากับ Args ตำแหน่งที่ i
            remaining = hrsPark; // เปลี่ยนค่าของ remaining ให้มีค่าเป็น hrsPart
            amountCharge = 0; // Reset ค่า amountCharge เป็น 0 เนื่องจากถ้าคำนวณอันแรกไปแล้วค่าจะได้ถูกรีเซ็ตเป็น 0

            while (remaining > 0) { // สร้าง Loop ให้ทำงานก็ต่อเมื่อ hrsPart > 0
                if (remaining <= 2) { // เช็คว่า hrsPart <= 2 ถ้าใช่ให้ทำงาน
                    amountCharge += 4; // บวก 4 เข้าไปใน amountCharge
                    remaining -= 2; // ลบ 2 เข้าไปใน hrsPart
                } else if (remaining > 2 && remaining <= 4) { // ถ้าไม่เข้าเงื่อนไขแรก (บรรทัด 10) เช็คว่า hrsPart มากกว่า 2 และ น้อยกว่าหรือเท่ากับ 4 ไหมถ้าใช่ก็ให้ทำงาน
                    amountCharge += 3; // บวก 3 เข้าไปใน amountCharge
                    remaining -= 1; // ลบ 1 เข้าไปใน hrsPart
                } else if (remaining > 4 && remaining < 18) { // ถ้าไม่เข้าเงื่อนไขสอง (บรรทัด 13) เช็คว่า hrsPart มากกว่า 4 และ น้อยกว่าหรือเท่ากับ 18 ไหมถ้าใช่ก็ให้ทำงาน
                    amountCharge += 1; // บวก 1 เข้าไปใน amountCharge
                    remaining -= 1; // ลบ 1 เข้าไปใน hrsPart
                } else { // ถ้าไม่เข้าเงื่อนไขไหนเลย (บรรทัด 10 13 16) ให้ทำงาน
                    amountCharge += 24; // บวก 24 เข้าไปใน amountCharge
                    remaining -= 24; // ลบ 24 เข้าไปใน hrsPart
                }
            }

            System.out.printf("Parking for %d hrs, pay %d baht.%n", hrsPark, amountCharge); // แสดงผล amountCharge
        }
    }
}