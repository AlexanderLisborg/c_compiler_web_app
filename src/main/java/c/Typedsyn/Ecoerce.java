package c.Typedsyn;

import c.InternalTypeRepresentation;

public class Ecoerce extends Exp{
    public final c.Typedsyn.Exp exp_1;
    public Ecoerce(Exp e, InternalTypeRepresentation type) {
        super(type);
        exp_1 = e;
    }

    public <R,A> R accept(Visitor<R,A> v, A arg) { return v.visit(this, arg); }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Ecoerce) {
            Ecoerce x = (Ecoerce)o;
            return this.exp_1.equals(x.exp_1);
        }
        return false;
    }

    public int hashCode() {
        return 37*(this.exp_1.hashCode());
    }
}
