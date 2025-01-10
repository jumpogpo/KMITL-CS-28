public class BuilderFacadeDemo {
    public static void main(String[] args) {
        StudentBuilder st = new StudentBuilder("Thanapat", "KMITL");
        Student student = st
        .age()
            .setAge(21)
        .build();
        System.out.println(student);
    }        
}
