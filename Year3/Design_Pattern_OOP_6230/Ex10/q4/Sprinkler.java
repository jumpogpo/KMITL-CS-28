public class Sprinkler extends Component {
    public Sprinkler(Mediator mediator) {
        super(mediator);
    }

    public void doSprinkler() {
        System.out.println("I am sprinkler,... doing my task");
        mediator.notify(this, "SPRINKLER_DONE");
    }
}
