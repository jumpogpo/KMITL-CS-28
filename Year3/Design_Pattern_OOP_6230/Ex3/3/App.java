public class App {
    public static void main(String[] args) {
        Person dad = new Person("John");
        Person mom = new Person("Marry");
        Person olderBrother = new Person("Chris");
        Person youngerBrother = new Person("Matt");

        // low-level module
        Relationships relationships = new Relationships();
        relationships.addParentAndChild(dad, olderBrother);
        relationships.addParentAndChild(dad, youngerBrother);
        relationships.addParentAndChild(mom, olderBrother);
        relationships.addParentAndChild(mom, youngerBrother);
        relationships.addSibling(olderBrother, youngerBrother);

        Research.research(relationships, "John", RelationshipStatus.PARENT).forEach(ch -> System.out.println("John has a child called " + ch.name));
        Research.research(relationships, "Marry", RelationshipStatus.PARENT).forEach(ch -> System.out.println("Marry has a child called " + ch.name));
        Research.research(relationships, "Chris", RelationshipStatus.CHILD).forEach(ch -> System.out.println("Chris has a parent called " + ch.name));
        Research.research(relationships, "Matt", RelationshipStatus.SIBLING).forEach(ch -> System.out.println("Matt has a called called " + ch.name));
    }
}
