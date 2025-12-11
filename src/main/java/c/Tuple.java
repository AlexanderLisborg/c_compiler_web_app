package c;

public class Tuple<T,A> {
    public T fst;
    public A snd;
    public Tuple(T fst, A snd) {
        this.fst = fst;
        this.snd = snd;
    }
    public void set(T fst, A snd){this.fst = fst;this.snd = snd;}
    public void setFst(T fst){this.fst = fst;}
    public void setSnd(A snd){this.snd = snd;}
}
