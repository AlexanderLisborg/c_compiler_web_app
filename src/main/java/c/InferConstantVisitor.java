package c;

import c.Absyn.*;
/// Visitor for inferring constant literal types.
public class InferConstantVisitor implements Constant.Visitor<TypeCode,Object> {

    // SINGLETON
    private InferConstantVisitor() {
    }

    private static class SingletonHelper {
        private static final InferConstantVisitor BILL_PUGH_SINGLETON_INSTANCE = new InferConstantVisitor();
    }

    public static InferConstantVisitor getInstance() {
        return InferConstantVisitor.SingletonHelper.BILL_PUGH_SINGLETON_INSTANCE;
    }

    // INTERFACE IMPLEMENTATION
    @Override
    public TypeCode visit(Efloat p, Object arg) {
        return TypeCode.CFloat;
    }

    @Override
    public TypeCode visit(Echar p, Object arg) {
        return TypeCode.CChar;
    }

    @Override
    public TypeCode visit(Eunsigned p, Object arg) {
        return TypeCode.CUnsigned;
    }

    @Override
    public TypeCode visit(Elong p, Object arg) {
        return TypeCode.CLong;
    }

    @Override
    public TypeCode visit(Eunsignlong p, Object arg) {
        return TypeCode.CUnsigned;
    }

    @Override
    public TypeCode visit(Ehexadec p, Object arg) {
        return TypeCode.CHex;
    }

    @Override
    public TypeCode visit(Ehexaunsign p, Object arg) {
        return TypeCode.CUHex;
    }

    @Override
    public TypeCode visit(Ehexalong p, Object arg) {
        return TypeCode.CHexLong;
    }

    @Override
    public TypeCode visit(Ehexaunslong p, Object arg) {
        return TypeCode.CUHexLong;
    }

    @Override
    public TypeCode visit(Eoctal p, Object arg) {
        return TypeCode.COct;
    }

    @Override
    public TypeCode visit(Eoctalunsign p, Object arg) {
        return TypeCode.CUOct;
    }

    @Override
    public TypeCode visit(Eoctallong p, Object arg) {
        return TypeCode.COctLong;
    }

    @Override
    public TypeCode visit(Eoctalunslong p, Object arg) {
        return TypeCode.CUOctLong;
    }

    @Override
    public TypeCode visit(Ecdouble p, Object arg) {
        return TypeCode.CDouble;
    }

    @Override
    public TypeCode visit(Ecfloat p, Object arg) {
        return TypeCode.CFloat;
    }

    @Override
    public TypeCode visit(Eclongdouble p, Object arg) {
        return TypeCode.CDoubleLong;
    }

    @Override
    public TypeCode visit(Eint p, Object arg) {
        return TypeCode.CInt;
    }

    @Override
    public TypeCode visit(Elonger p, Object arg) {
        return TypeCode.CLongLong;
    }

    @Override
    public TypeCode visit(Edouble p, Object arg) {
        return TypeCode.CDouble;
    }
}
