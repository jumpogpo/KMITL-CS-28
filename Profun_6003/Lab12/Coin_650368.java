class Coin {
    String colorHead;
    String colorTail;
    double radius;
    int currentFace = 0;

    Coin() {
        radius = 1.0;
        colorHead = "red";
        colorTail = "red";
    }
    Coin(double radius) {
        this.radius = radius;
    }
    double getRadius() {
        return radius;
    }
    void setRadius(double radius) {
        this.radius = radius;
    }
    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    double getCircumference() {
        return radius * 2 * Math.PI;
    }
    public String toString() {
        return "Cirle[radius=" + radius + "]";
    }
    String getColor() {
        if (currentFace == 0) {
            return "colorHead = " + colorHead;
        } else {
            return "colorTail = " + colorTail;
        }
    }
    void setColor(String color) {
        if (currentFace == 0) {
            this.colorHead = color;
        } else {
            this.colorTail = color;
        }
    }
    void flip() {
        currentFace = (currentFace == 0) ? 1 : 0;
    }
   }
   