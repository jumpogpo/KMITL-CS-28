public class Customer implements Canpay {
    private String name;
    private MemberType memberType;

    Customer(String name) {
        this.name = name;
        memberType = MemberType.None;
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
                memberType = MemberType.SILVER;
                break;
            case SILVER:
                memberType = MemberType.GOLD;
                break;
            case GOLD:
                memberType = MemberType.PREMIUM;
                break;
        }
    }

    private void demoteMemberType() {
        switch(memberType) {
            case PREMIUM:
                memberType = MemberType.GOLD;
                break;
            case GOLD:
                memberType = MemberType.SILVER;
                break;
        }
    }

    public void showMembershipStatus() {
        System.out.println("You are now " + memberType);
    }
}