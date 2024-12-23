public class Triplet <T, U, V>
{
    private final T first;
    private final U second;
    private final V third;

    public Triplet (T first, U second, V third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getValue0()    {return first;}
    public U getValue1()    {return second;}
    public V getValue2()    {return third;}
}
