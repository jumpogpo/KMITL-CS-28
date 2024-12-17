public class AndSpecification<T> implements ISpecification<T> {
    private ISpecification<T> first, second, thrid;

    public AndSpecification(ISpecification<T> first, ISpecification<T> second) {
        this.first = first;
        this.second = second;
    }

    public AndSpecification(ISpecification<T> first, ISpecification<T> second, ISpecification<T> third) {
        this.first = first;
        this.second = second;
        this.thrid = third;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item) && (thrid == null || (thrid != null && thrid.isSatisfied(item)));
    }
}
