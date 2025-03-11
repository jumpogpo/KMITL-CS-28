public class Alarm extends Component {
    public Alarm(Mediator mediator) {
        super(mediator);
    }

    public void triggerAlarm() {
        mediator.notify(this, "ALARM_TRIGGERED");
    }
}
