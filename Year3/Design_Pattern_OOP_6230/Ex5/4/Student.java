public class Student {
  public String name, university;
  public int age;

  public Student(String name, String university) {
    this.name = name;
    this.university = university;
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();

    sb.append("name: " + name + "\n");
    if (this.university != null) {
      sb.append("university: '" + university + "'\n");
    }

    if (this.age != 0) {
      sb.append("age: " + age);
    }
    return sb.toString();
  }       
}
