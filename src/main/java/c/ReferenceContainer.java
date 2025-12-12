package c;
/// Used to pass by reference or simply store a reference.
public class ReferenceContainer<T> {
    public T value;
    public ReferenceContainer() {}
    public ReferenceContainer(T value) {this.value = value;}
    public void setReference(T value) {this.value = value;}
}
