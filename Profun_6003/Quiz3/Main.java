import java.util.*;

public class Main{
    ArrayList<Profun14Employee> eList;
    String targetDept = null;

    Main() {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        eList = new ArrayList<>();

        for (int time = 0; time < size; time++) {
            String str = sc.nextLine();
            String[] data = str.split(" ");
            eList.add(new Profun14Employee(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
        }

        targetDept = sc.next();
        sc.close();
    }

    void oldWay() {
        // Q1
        List<String> empNameList = new ArrayList<>();

        for (Profun14Employee eData : eList) {
            empNameList.add(eData.getName());
        }

        System.out.println(empNameList);

        // Q2
        int yearThreshold = 2015;
        List<String> empBefore2015 = new ArrayList<>();

        for (Profun14Employee eData : eList) {
            if (eData.getYearStart() < yearThreshold) {
                empBefore2015.add(eData.toString());
            }
        }

        System.out.println(empBefore2015);

        // Q3
        int sumSalary = 0;

        for (Profun14Employee eData : eList) {
            sumSalary += eData.getSalary();
        }

        System.out.println(sumSalary);

        // Q4
        Profun14Employee empLowSalaryEmp = null;
        int lowSal = Integer.MAX_VALUE;

        for (Profun14Employee eData : eList) {
            if (eData.getSalary() < lowSal) {
                lowSal = eData.getSalary();
                empLowSalaryEmp = eData;
            }
        }

        System.out.println(empLowSalaryEmp.toString());

        // Q5
        List<String> sameDept = new ArrayList<>();

        for (Profun14Employee eData : eList) {
            if (eData.getDepartment().equals(targetDept)) {
                sameDept.add(eData.toString());
            }
        }

        System.out.println(sameDept);
    }

    public static void main(String[] args){
        Main demo = new Main();
        demo.oldWay();
    }
}

class Profun14Employee {
    String name;
    String dept;
    int salary;
    int yearStart;

    Profun14Employee(String n, String d, int sal, int yr) {
        name = n;
        dept = d;
        salary = sal;
        yearStart = yr;
    }

    String getName() {
        return name;
    }

    String getDepartment() {
        return dept;
    }

    int getYearStart() {
        return yearStart;
    }

    int getSalary() {
        return salary;
    }

    public String toString() {
        return String.format("%s %s(%d) %d", dept, name, yearStart, salary);
    }
}