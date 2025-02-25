public class App {
    public static void main(String[] args) {
        IImage myImage = new ProxyImage("test.jpg");
        myImage.display();
    }
}
