public class Integrate {
  public interface FofX {
      double eval(double x);
  }

  static final int LEFT_POINT = 0;
  static final int MID_POINT = 1;
  static final int RIGHT_POINT = 2;

  static double integrate(FofX f, double a, double b, int interval, int point) {
      double sum=0;
      double dx=(b-a)/interval;
      for(int i=0; i<interval; i++) {
          switch(point) {
              case LEFT_POINT: sum+=f.eval(a+i*dx)*dx; break;
              case MID_POINT: sum+=f.eval(a+i*dx+dx/2)*dx; break;
              case RIGHT_POINT: sum+=f.eval(a+i*dx+dx)*dx; break;
          }
      }
      return sum;
  }

  static double integrate2(FofX f, double a, double b, int interval, int point) {
      double sum=0;
      double d = b-a;
      double xi=0;
      double factor=interval*(interval+1)/2;
      for(int i=0; i<interval; i++) {
          double dxi = d*(interval-i)/factor;
          switch(point) {
              case LEFT_POINT: sum+=f.eval(xi)*dxi; break;
              case MID_POINT: sum+=f.eval(xi+dxi/2)*dxi; break;
              case RIGHT_POINT: sum+=f.eval(xi+dxi)*dxi; break;
          }

          xi+=dxi;
      }
      return sum;
  }

  public static void main(String args[]) {
      FofX f ;
      int interval = 0; 
      double inter;
      for (int k = 0; k < 2; k++) {
          if(k == 0){
              f = (x) ->  x*x;
              inter = 1/3.0;
              System.out.println("=========intergrate X^^2=========\n");
          }else{
              f = (x) ->  Math.pow(Math.exp(1), x);
              inter = Math.exp(1)-1;
              System.out.println("=========intergrate e^^x=========\n");
          }
          System.out.println("=====intergrate 1=====");
          for (int i = 0; i < 3; i++) {
              interval = 0;
              for (; interval < 1000; interval++) {
                  double s = integrate(f, 0, 1, interval, i);
                  if(Math.abs(s-inter) < 0.001) break;
              }
              System.out.println(i+" "+interval);
              
          }
          System.out.println("=====intergrate 2=====");
          for (int j = 0; j < 3; j++) {
              interval = 0;
              for (; interval < 1100; interval++) {
                  double s2 = integrate2(f, 0, 1, interval,j);
                  if(Math.abs(s2-inter) < 0.001) break;
              }
              System.out.println(j+" "+interval);
              
          }
          System.out.println("===============================\n");
      }
  }
}