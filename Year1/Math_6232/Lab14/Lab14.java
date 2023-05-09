public class Lab14 {
    public static void main(String[] args) {
        Lab14 lab14 = new Lab14();
        Lab14.MyFixedPoint fixedPoint = lab14.new MyFixedPoint();
        Lab14.MyFixedPoint addValueFix = lab14.new MyFixedPoint();
        Lab14.MyFixedPoint subtractsValueFix = lab14.new MyFixedPoint();
        Lab14.MyFixedPoint multiplyValueFix = lab14.new MyFixedPoint();
        Lab14.MyFixedPoint divideValueFix = lab14.new MyFixedPoint();
        addValueFix.data = 1555;
        subtractsValueFix.data = 1000;
        multiplyValueFix.data = 1000;
        divideValueFix.data = 2000;

        Lab14.MyFloatingPoint floatingPoint = lab14.new MyFloatingPoint();
        Lab14.MyFloatingPoint addValueFloat = lab14.new MyFloatingPoint();
        Lab14.MyFloatingPoint subtractsValueFloat = lab14.new MyFloatingPoint();
        Lab14.MyFloatingPoint multiplyValueFloat = lab14.new MyFloatingPoint();
        Lab14.MyFloatingPoint divideValueFloat = lab14.new MyFloatingPoint();
        addValueFloat.data = 1.555f;
        subtractsValueFloat.data = 1f;
        multiplyValueFloat.data = 1f;
        divideValueFloat.data = 2f;


        long startTime,endTime;
        startTime = System.currentTimeMillis();

        for(int i =0;i<10000;i++) {
            fixedPoint.adds(addValueFix);
            fixedPoint.subtracts(subtractsValueFix);
            fixedPoint.multiplies(multiplyValueFix);
            fixedPoint.divides(divideValueFix);
        }

        System.out.println(fixedPoint.getReal());
        endTime =System.currentTimeMillis();
        long duration = endTime-startTime;
        System.out.println("FixedPoint Duration = " + duration);

        startTime = System.currentTimeMillis();

        for(int i =0;i<10000;i++) {
            floatingPoint.adds(addValueFloat);
            floatingPoint.subtracts(subtractsValueFloat);
            floatingPoint.multiplies(multiplyValueFloat);
            floatingPoint.divides(divideValueFloat);
        }

        System.out.println(floatingPoint.getReal());
        endTime = System.currentTimeMillis();
        duration =endTime-startTime;
        System.out.println("FloatingPoint duration = " + duration);
    }

    class MyFixedPoint {
        public int data ;

        float getReal() {
            return data/1000.0f;
        }

        void adds(MyFixedPoint b) {
            this.data = this.data + b.data;
        }

        void subtracts(MyFixedPoint b) {
            this.data = this.data - b.data;
        }

        void multiplies(MyFixedPoint b) {
            this.data = (int)(this.data /(b.data/1000));
        }

        void divides(MyFixedPoint b) {
            this.data = (int)(this.data /(b.data/1000));
        }
    }
    
    class MyFloatingPoint {
        public float data;

        float getReal() {
            return data;
        }
        
        void adds(MyFloatingPoint b) {
            data = data + b.data;
        }
        
        void subtracts(MyFloatingPoint b) {
            data = data - b.data;
        }
        
        void multiplies(MyFloatingPoint b) {
            data = data * b.data;
        }
        
        void divides(MyFloatingPoint b) {
           data = data / b.data;
        }
    }
}