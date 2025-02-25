package q2;

class ScoreSubscriber implements Observer {
    private String name;

    public ScoreSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String score) {
        System.out.println(name + " live result: " + score);
    }
}
