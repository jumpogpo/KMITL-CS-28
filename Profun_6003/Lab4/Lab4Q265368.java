// คำสั่ง Run java Lab4Q265368.java ราคาที่ 1 ราคาที่ 2 ราคาที่ 3

public class Lab4Q265368 {
    public static void main(String... args) {
        // args = {ราคาที่ 1, ราคาที่ 2, ราคาที่ 3}

        int leastPrice = Integer.MAX_VALUE; // กำหนดให้ leastPrice เป็นประเภท Int และมีค่าเป็น ค่า Integer ที่สูงที่สุดคือ 2147483647
        int sum = 0; // กำหนดให้ sum มีค่าเป็นประเภท Int และมีค่าเป็น 0
        int price = 0; // กำหนดให้ price มีค่าเป็นประเภท Int และมีค่าเป็น 0

        for (int i = 0; i < args.length; i++) { // For Loop โดยให้ทำงานไปเรื่อยๆจนกว่า i < priceArray.length
            price = Integer.parseInt(args[i]); // กำหนดให้ price เป็นประเภท Int โดยให้มีค่าเป็น args[i] (โดยใช้ Integer.parseInt แปลงค่าประเภทให้เป็น Int)

            if (price < leastPrice) { // เช็คว่า price < leastPrice ถ้าใช่ให้ทำงาน
                leastPrice = price; // เปลี่ยนค่า leastPrice ให้มีค่าเป็น price
            }
        }

        for (int priceIndex = 0; priceIndex < args.length; priceIndex++) { // For Loop โดยให้ทำงานไปเรื่อยๆจนกว่า priceIndex < priceArray.length
            sum += Integer.parseInt(args[priceIndex]); // บวกค่า priceArray[priceIndex] (โดยใช้ Integer.parseInt แปลงให้เป็นค่าประเภท Int) เข้าไปใน sum
        }

        System.out.println("Total: " + (sum) + " Baht"); // แสดงราคารวมของผลบวกราคาที่มากที่สุด 2 ชิ้น
    }
}
