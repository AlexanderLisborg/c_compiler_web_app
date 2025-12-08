package c;

import c.Absyn.*;

/// Visitor for inferring the type of expressions.
public class InferExpVisitor implements Exp.Visitor<TypeCode,Object> {

    @Override
    public TypeCode visit(Ecomma p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Eassign p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Econdition p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Elor p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Eland p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Ebitor p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Ebitexor p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Ebitand p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Eeq p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Eneq p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Elthen p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Egrthen p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Ele p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Ege p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Eleft p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Eright p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Eplus p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Eminus p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Etimes p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Ediv p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Emod p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Etypeconv p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Epreinc p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Epredec p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Epreop p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Ebytesexpr p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Ebytestype p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Earray p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Efunk p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Efunkpar p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Eselect p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Epoint p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Epostinc p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Epostdec p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Evar p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Econst p, Object arg) {
        return null;
    }

    @Override
    public TypeCode visit(Estring p, Object arg) {
        return null;
    }
}
