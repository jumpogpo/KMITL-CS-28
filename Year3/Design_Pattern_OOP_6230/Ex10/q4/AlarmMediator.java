public class AlarmMediator implements Mediator {
    private Sprinkler sprinkler;
    private CoffeePot coffeePot;
    public void setSprinkler(Sprinkler sprinkler) {
        this.sprinkler = sprinkler;
    }

    public void setCoffeePot(CoffeePot coffeePot) {
        this.coffeePot = coffeePot;
    }

    public void setAlarm(Alarm alarm) {
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender instanceof Alarm && event.equals("ALARM_TRIGGERED")) {
            System.out.println("Alarm is sending event to all...");
            sprinkler.doSprinkler();
            coffeePot.doCoffeePot();
        } else if (sender instanceof Sprinkler || sender instanceof CoffeePot) {
            System.out.println("Alarm event ended from " + sender.getClass().getSimpleName());
        }
    }
}
