public class Client implements Canpay {
    private String name;
    private MemberTypeWithDiscount memberType;

    Client(String name) {
        this.name = name;
        memberType = MemberTypeWithDiscount.None;
    }

    public void spend(int direction) {
        switch (direction) {
            case 1:
                promoteMember();
                break;
            case -1:
                demoteMemberType();
                break;
        }

        showMembershipStatus();
    }

    private void promoteMember() {
        switch(memberType) {
            case None:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case SILVER:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.PREMIUM;
                break;
        }
    }

    private void demoteMemberType() {
        switch(memberType) {
            case PREMIUM:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
        }
    }

    public void showMembershipStatus() {
        System.out.printf("You are now %s %.0f%%discount on Product %.0f%% on service%n", memberType, memberType.getProductDiscount() * 10, memberType.getServiceDiscount() * 10);
    }
}