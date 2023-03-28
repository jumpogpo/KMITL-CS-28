public class Assignment9code_65050368 {
    public static void main(String[] args) {
        System.out.println("h=1 && y1 = "+Euler(1));
        System.out.println("h=0.1 & y1 = "+Euler(0.1));
        System.out.println("h=0.01 & y1 = "+Euler(0.01));
        System.out.println("h=0.001 & y1 = "+Euler(0.001));
    }
    static String Euler(double n){
        double yst = 3;
        double ans = 0;
        double h = 0;
        for(int i = 0; i < (int)(1/n); i++){
            if(i==0){
                ans = fx(h,yst,n);
            }else{
                ans = fx(h, ans, n);
            }
            h+=n;
        }
        return String.format("%.5f", ans);
    }
    static double fx(double x, double y,double h){
        double fans = 0;
        fans = y + h*((6*Math.pow(x, 2))-(3*Math.pow(x, 2)*y));
        return fans;
    }
}
