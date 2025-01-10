public abstract class Customer { //make this class abstract
    public String generateCommunication() {
        String mail = createMail();
        String brochure = createBrochure();
        return brochure == null ? mail : mail + "\n" + brochure;
    }

    public abstract String createMail(); //make this method abstract'
    public abstract String createBrochure();
}
