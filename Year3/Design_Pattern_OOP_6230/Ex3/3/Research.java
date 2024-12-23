import java.util.List;
class Research
{
  /*public Research(Relationships relationships)
  {
    // high-level: find all of john's children
    List<Triplet<Person, RelationshipStatus, Person>> relations = relationships.getRelations();
    relations.stream()
      .filter(x -> x.getValue0().name.equals("John")
              && x.getValue1() == RelationshipStatus.PARENT)
      .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));
  }*/

  public static List<Person> research(IRelationshipBrowser browser, String name, RelationshipStatus status) {
    return browser.findAllStatusOf(name, status);
  }
}
