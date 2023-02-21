public enum MemberTypeWithDiscount {
    None(0, 0),
    SILVER(0.5, 0.5),
    GOLD(1.0, 2.0),
    PREMIUM(3.0, 4.5);
   
    private double getProductDiscount;
    private double serviceDiscountRate;

    MemberTypeWithDiscount(double p, double s) {
        getProductDiscount = p;
        serviceDiscountRate = s;
    }

    public double getProductDiscount() {
        return getProductDiscount;
    }

    public double getServiceDiscount() {
        return serviceDiscountRate;
    }
}