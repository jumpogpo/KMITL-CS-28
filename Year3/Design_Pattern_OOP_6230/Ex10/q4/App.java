public class App {
    public static void main(String[] args) {
        AlarmMediator mediator = new AlarmMediator();

        Sprinkler sprinkler = new Sprinkler(mediator);
        CoffeePot coffeePot = new CoffeePot(mediator);
        Alarm alarm = new Alarm(mediator);

        mediator.setSprinkler(sprinkler);
        mediator.setCoffeePot(coffeePot);
        mediator.setAlarm(alarm);

        alarm.triggerAlarm();
    }
}
