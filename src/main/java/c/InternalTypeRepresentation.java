package c;

// TODO : Implement const pointers

public class InternalTypeRepresentation {
    private TypeCode typeCode;
    private int nrOfPointers; // 0 for non pointer types
    private boolean isConst;
    private boolean isVolatile;
    public InternalTypeRepresentation(TypeCode typeCode, int nrOfPointers, boolean isConst, boolean isVolatile) {
        this.typeCode = typeCode; this.nrOfPointers = nrOfPointers; this.isConst = isConst; this.isVolatile = isVolatile;
    }
    public InternalTypeRepresentation(TypeCode typeCode) {
        this(typeCode,0,false,false);
    }
    public InternalTypeRepresentation(TypeCode typeCode, int nrOfPointers) {
        this(typeCode,nrOfPointers,false,false);
    }
    public InternalTypeRepresentation(TypeCode typeCode, int nrOfPointers, boolean isConst) {
        this(typeCode,nrOfPointers,isConst,false);
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof InternalTypeRepresentation) {
            InternalTypeRepresentation o = (InternalTypeRepresentation) other;
            return typeCode == o.typeCode
                    && nrOfPointers == o.nrOfPointers
                    && isConst == o.isConst
                    && isVolatile == o.isVolatile;
        } else {return false;}

    }
    public boolean isIntegral(){
        return nrOfPointers == 0
                && TypeCode.isIntegral(typeCode);
    }
    public boolean isFloatingPoint(){
        return nrOfPointers == 0
                && TypeCode.isFloatingPoint(typeCode);
    }
    public boolean isNAN(){
        return nrOfPointers == 0
                && TypeCode.isNAN(typeCode);
    }
    public boolean isPointer(){
        return nrOfPointers != 0 && typeCode != null;
    }
    public static boolean checkEquals(InternalTypeRepresentation type1, InternalTypeRepresentation type2)
    {
        return type1.getTypeCode() == type2.getTypeCode()
                && type1.getNrOfPointers() == type2.getNrOfPointers()
                && type1.isConst() == type2.isConst()
                && type1.isVolatile() == type2.isVolatile();
    }

    public static boolean isFieldElemType(InternalTypeRepresentation type1, InternalTypeRepresentation type2, int fieldLevel){
        throw new UnsupportedOperationException();
    }

    public static boolean isIntegral(InternalTypeRepresentation type){
        return type.getNrOfPointers() == 0
                && TypeCode.isIntegral(type.getTypeCode());
    }

    public static boolean isFloatingPoint(InternalTypeRepresentation type){
        return type.getNrOfPointers() == 0
                && TypeCode.isFloatingPoint(type.getTypeCode());
    }

    public static boolean isNAN(InternalTypeRepresentation type){
        return type.getNrOfPointers() == 0
                && TypeCode.isNAN(type.getTypeCode());
    }

    public static boolean isPointer(InternalTypeRepresentation type){
        return ((type.getNrOfPointers() != 0) && (type.getTypeCode()!=null));
    }


    // GETTERS
    public TypeCode getTypeCode() {return typeCode;}
    public int getNrOfPointers() {return nrOfPointers;}
    public boolean isConst() {return isConst;}
    public boolean isVolatile() {return isVolatile;}

}
