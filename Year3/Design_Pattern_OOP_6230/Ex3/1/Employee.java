public class Employee implements ISalary {
    private Salary salary;

    public Employee() {
        this.salary = new Salary();
    }
    
    public void salary() {
        salary.salary();
    }
}
