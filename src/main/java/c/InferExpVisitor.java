package c;

import c.Absyn.*;

/// Visitor for inferring the type of expressions.
public class InferExpVisitor implements Exp.Visitor<TypeCode,Object> {

    // SINGLETON
    private InferExpVisitor() {
    }

    private static class SingletonHelper {
        private static final InferExpVisitor BILL_PUGH_SINGLETON_INSTANCE = new InferExpVisitor();
    }

    public static InferExpVisitor getInstance() {
        return SingletonHelper.BILL_PUGH_SINGLETON_INSTANCE;
    }

    // INTERFACE IMPLEMENTATION
    @Override
    public TypeCode visit(Ecomma p, Object arg) {
        return p.exp_2.accept(this, arg);
    }

    @Override
    public TypeCode visit(Eassign p, Object arg) {
        return p.exp_1.accept(this, arg);
    }

    @Override
    public TypeCode visit(Econdition p, Object arg) {
        return TypeCode.CVoid;
    }

    @Override
    public TypeCode visit(Elor p, Object arg) {
        return TypeCode.CChar;
    }

    @Override
    public TypeCode visit(Eland p, Object arg) {
        return TypeCode.CChar;
    }

    @Override
    public TypeCode visit(Ebitor p, Object arg) {
        return inferBitwiseOp(p.exp_1.accept(this,arg),p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Ebitexor p, Object arg) {
        return inferBitwiseOp(p.exp_1.accept(this,arg),p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Ebitand p, Object arg) {
        return inferBitwiseOp(p.exp_1.accept(this,arg),p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Eeq p, Object arg) {
        return inferCompOp(p.exp_1.accept(this,arg), p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Eneq p, Object arg) {
        return inferCompOp(p.exp_1.accept(this,arg), p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Elthen p, Object arg) {
        return inferCompOp(p.exp_1.accept(this,arg), p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Egrthen p, Object arg) {
        return inferCompOp(p.exp_1.accept(this,arg), p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Ele p, Object arg) {
        return inferCompOp(p.exp_1.accept(this,arg), p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Ege p, Object arg) {
        return inferCompOp(p.exp_1.accept(this,arg), p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Eleft p, Object arg) {
        return inferBitwiseOp(p.exp_1.accept(this,arg),p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Eright p, Object arg) {
        return inferBitwiseOp(p.exp_1.accept(this,arg),p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Eplus p, Object arg) {
        return inferBinOp(p.exp_1.accept(this,arg),p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Eminus p, Object arg) {
        return inferBinOp(p.exp_1.accept(this,arg),p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Etimes p, Object arg) {
        return inferBinOp(p.exp_1.accept(this,arg),p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Ediv p, Object arg) {
        return inferBinOp(p.exp_1.accept(this,arg),p.exp_2.accept(this,arg));
    }

    @Override
    public TypeCode visit(Emod p, Object arg) {
        TypeCode c1 =p.exp_1.accept(this,arg),c2=p.exp_2.accept(this,arg);
        if(isIntegral(c1) && isIntegral(c2)) return c1;
        else throw new RuntimeException();
    }

    @Override
    public TypeCode visit(Etypeconv p, Object arg) {
        TypeCode toMatch = p.exp_.accept(this,arg);

        p.type_name_.accept(new Type_name.Visitor<TypeCode[], Object>(){
            @Override
            public TypeCode[] visit(PlainType p, Object arg) {
                for(Spec_qual s : p.listspec_qual_){
                    s.accept(new Spec_qual.Visitor<TypeCode[], Object>() {
                        @Override
                        public TypeCode[] visit(TypeSpec p, Object arg) {
                            p.type_specifier_.accept(new Type_specifier.Visitor<TypeCode, Object>() {
                                @Override public TypeCode visit(Tvoid p, Object arg)    {return TypeCode.CVoid;}
                                @Override public TypeCode visit(Tchar p, Object arg)    {return TypeCode.CChar;}
                                @Override public TypeCode visit(Tshort p, Object arg)   {return TypeCode.CShort;}
                                @Override public TypeCode visit(Tint p, Object arg)     {return TypeCode.CInt;}
                                @Override public TypeCode visit(Tlong p, Object arg)    {return TypeCode.CLong;}
                                @Override public TypeCode visit(Tfloat p, Object arg)   {return TypeCode.CFloat;}
                                @Override public TypeCode visit(Tdouble p, Object arg)  {return TypeCode.CDouble;}
                                @Override public TypeCode visit(Tsigned p, Object arg)  {return TypeCode.CSigned;}
                                @Override public TypeCode visit(Tunsigned p, Object arg){return TypeCode.CUnsigned;}
                                @Override public TypeCode visit(Tstruct p, Object arg)  {return TypeCode.CStruct;}
                                @Override public TypeCode visit(Tenum p, Object arg)    {return TypeCode.CEnum;}
                                @Override public TypeCode visit(Tname p, Object arg)    {return TypeCode.CName;}
                            },arg);
                        }

                        @Override
                        public TypeCode[] visit(QualSpec p, Object arg) {
                            return new TypeCode[0];
                        }
                    }, arg);
                }
            }

            @Override
            public TypeCode visit(ExtendedType p, Object arg) {
                return null;
            }
        },arg);
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

    // HELPER METHODS
    private TypeCode inferCompOp(TypeCode c1, TypeCode c2)
    {
        if(isNAN(c1)||isNAN(c2)) throw new RuntimeException();
        if(isIntegral(c1) && isIntegral(c2)) return getLargest(c1,c2);
        if(isFloatingPoint(c1) && isFloatingPoint(c2)) return getLargest(c1,c2);
        throw new RuntimeException();
    }

    private TypeCode inferBitwiseOp(TypeCode c1, TypeCode c2) {
        // Check if types are integral.
        if(isIntegral(c1) && isIntegral(c2)) {
            return getLargest(c1,c2);
        } else { // Not integral type
            throw new RuntimeException();
        }
    }

    private TypeCode inferBinOp(TypeCode c1, TypeCode c2) {
        if(isNAN(c1) || isNAN(c2)) {throw new RuntimeException();}
        boolean isIntc1 = isIntegral(c1),isIntc2 = isIntegral(c2),
                isFpc1=isFloatingPoint(c1),isFpc2=isFloatingPoint(c2);
        if(isIntc1 && isIntc2 || isFpc1 && isFpc2)
            return getLargest(c1,c2);
        else {
            if(isFpc1)
                return getLargest(c1,TypeCode.CFloat);
            if(isFpc2)
                return getLargest(c2,TypeCode.CFloat);
            else throw new RuntimeException();
        }
    }

    private boolean isIntegral(TypeCode c){
        return (c==TypeCode.CChar
                || c==TypeCode.CShort
                || c==TypeCode.CInt
                || c== TypeCode.CLong
                || c== TypeCode.CSigned
                || c== TypeCode.CUnsigned
                || c==TypeCode.CHex
                || c==TypeCode.CUHex
                || c==TypeCode.CHexLong
                || c==TypeCode.CUHexLong
                || c==TypeCode.COct
                || c==TypeCode.CUOct
                || c==TypeCode.COctLong
                || c==TypeCode.CUOctLong
                || c==TypeCode.CLongLong);
    }
    private TypeCode getLargest(TypeCode c1, TypeCode c2) {
        if(TypeCode.compareSizeOf(c1,c2)==-1) return c1; // c1 < c2
        if(TypeCode.compareSizeOf(c1,c2)==1) return c2; // c1 > c2
        return c1;                                     // c1 == c2
    }
    private boolean isFloatingPoint(TypeCode c){
        return (c==TypeCode.CFloat
        || c==TypeCode.CDouble
        || c==TypeCode.CDoubleLong);
    }
    private boolean isNAN(TypeCode c){
        return (c==TypeCode.CVoid);
    }
}
