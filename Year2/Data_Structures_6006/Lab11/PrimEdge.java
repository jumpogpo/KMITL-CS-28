public class PrimEdge implements Comparable<PrimEdge> {
    private int u, v, weight;

    public PrimEdge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }

    public void setU(int u) {
        this.u = u;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(PrimEdge otherEdge) {
        return Integer.compare(weight, otherEdge.getWeight());
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", u, v, weight);
    }
}