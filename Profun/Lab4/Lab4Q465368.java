public class Lab4Q465368 {
    public static void main(String ... args) {
        int sum = 0; // กำหนดให้ sum เป็นประเภท Int และมีค่าเป็น 0
        int found = 0; // กำหนดให้ found เป็นประเภท Int และมีค่าเป็น 0

        for (int checkPerfectNumber = 1; checkPerfectNumber <= 1000 && found < 3; checkPerfectNumber++) { // For Loop ให้ทำงานก็ต่อเมื่อ checkPerfectNumber <= 1000 และ found < 3 จึงให้ทำงาน
            sum = 0; // Reset ค่า sum เป็น 0 เนื่องจากคำนวณครั้งที่ 1 เสร็จต้องรีค่าเป็น 0 ไม่งั้นจะบวกต่อไปเรื่อยๆ

            for (int i = 1; i < checkPerfectNumber; i++) { // For Loop ให้ทำงานก็ต่อเมื่อ i < checkPerfectNumber
                if (checkPerfectNumber % i == 0) { // เช็คว่าถ้านำ checkPerfectNumber ไป Modulus กับ i แล้วได้ 0 ให้ทำงาน
                    sum += i; // บวกค่า i เข้าไปใน sum
                }
            }

            if (checkPerfectNumber == sum) { // เช็คว่าถ้า checkPerfectNumber มีค่าเท่ากับ sum ให้ทำงาน
                System.out.println(sum); // แสดงผลค่า sum
                found += 1; // บวก 1 เข้าไปใน found
            }
        }
    }
}
