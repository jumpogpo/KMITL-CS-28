package kmitl.cs.entp.thanapat;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InitialContext initialContext;
        Queue requestQueue;
        Queue replyQueue;

        try {
            initialContext = new InitialContext();
            requestQueue = (Queue) initialContext.lookup("RequestQueue");
            replyQueue = (Queue) initialContext.lookup("ReplyQueue");

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        try (ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             JMSContext jmsContext = connectionFactory.createContext()) {
            JMSProducer producer = jmsContext.createProducer();

            // สร้าง Map สำหรับเก็บ Student ตาม ID
            Map<String, Student> studentMap = new HashMap<>();

            // สร้างอาร์เรย์ของ Student (3 คน)
            Student[] students = {
                    new Student(12345, "Donal Trump", 2.5),
                    new Student(12346, "Alisa Manobal", 3.5),
                    new Student(12347, "Mo Salah", 3.6),
            };

            // ตั้งค่า Consumer สำหรับรับข้อความตอบกลับ
            JMSConsumer responseConsumer = jmsContext.createConsumer(replyQueue);
            TextListener listener = new TextListener(studentMap); // ส่ง studentMap ไปด้วย
            responseConsumer.setMessageListener(listener);

            // ส่งข้อมูลไปยัง RequestQueue
            for (Student student : students) {
                ObjectMessage message = jmsContext.createObjectMessage(student);
                String correlationID = String.valueOf(student.getId());
                message.setJMSReplyTo(replyQueue);
                message.setJMSCorrelationID(correlationID);
                producer.send(requestQueue, message);

                // เก็บข้อมูลนักศึกษาเพื่อใช้ตอนรับข้อความตอบกลับ
                studentMap.put(correlationID, student);

                System.out.println("Sending student id: " + student.getId());
            }

            // Scanner เพื่อรอให้โปรแกรมไม่ปิดตัวเอง
            String ch;
            Scanner inp = new Scanner(System.in);
            while (true) {
                System.out.println("Press q to quit ");
                ch = inp.nextLine();
                if (ch.equals("q")) {
                    break;
                }
            }

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
