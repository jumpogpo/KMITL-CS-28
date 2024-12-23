import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class Relationships implements IRelationshipBrowser { //low level module
    private List<Triplet<Person, RelationshipStatus, Person>> relations = new ArrayList<>();
    /*public List<Triplet<Person, RelationshipStatus, Person>> getRelations()
    {
        return relations;
    }*/
    public void addParentAndChild (Person parent, Person child)
    {
        relations.add(new Triplet<>(parent, RelationshipStatus.PARENT, child));
        relations.add(new Triplet<>(child, RelationshipStatus.CHILD, parent));
    }

    public void addSibling(Person sibling1, Person sibling2) {
        relations.add(new Triplet<>(sibling1, RelationshipStatus.SIBLING, sibling2));
        relations.add(new Triplet<>(sibling2, RelationshipStatus.SIBLING, sibling1));
    }

    public List<Person> findAllStatusOf(String name, RelationshipStatus status) {
        return relations.stream()
                .filter(x -> x.getValue0().name.equals(name)
                        && x.getValue1() == status)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
}


