public class ProxyImage implements IImage {
    private Image realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new Image(fileName); // Load image only when needed
        }
        realImage.display();
    }
}
