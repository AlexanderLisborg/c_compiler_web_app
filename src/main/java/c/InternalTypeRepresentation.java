package c;

// TODO : Implement const pointers

public class InternalTypeRepresentation {
    private TypeCode typeCode;
    private int nrOfPointers; // 0 for non pointer types
    private int nrOfFieldDimensions; // 0 for type that is not a field
    private boolean isConst;
    private boolean isVolatile;
    public InternalTypeRepresentation() {

    }
    public static boolean checkEquals(InternalTypeRepresentation type1, InternalTypeRepresentation type2)
    {
        return type1.getTypeCode() == type2.getTypeCode()
                && type1.nrOfPointers == type2.nrOfPointers
                && type1.nrOfFieldDimensions == type2.nrOfFieldDimensions
                && type1.isConst == type2.isConst
                && type1.isVolatile == type2.isVolatile;
    }

    public static boolean isFieldElemType(InternalTypeRepresentation type1, InternalTypeRepresentation type2, int fieldLevel){
        throw new UnsupportedOperationException();
    }

    public static boolean isIntegral(InternalTypeRepresentation type){
        return type.getNrOfPointers() == 0
                && type.getNrOfFieldDimensions() == 0
                && TypeCode.isIntegral(type.getTypeCode());
    }

    public static boolean isFloatingPoint(InternalTypeRepresentation type){
        return type.getNrOfPointers() == 0
                && type.getNrOfFieldDimensions() == 0
                && TypeCode.isFloatingPoint(type.getTypeCode());
    }

    public static boolean isNAN(InternalTypeRepresentation type){
        return type.getNrOfPointers() == 0
                && type.getNrOfFieldDimensions() == 0
                && TypeCode.isNAN(type.getTypeCode());
    }

    public static boolean isPointer(InternalTypeRepresentation type){
        return ((type.getNrOfPointers() != 0) && (type.getTypeCode()!=null));
    }

    // GETTERS
    public TypeCode getTypeCode() {return typeCode;}
    public int getNrOfPointers() {return nrOfPointers;}
    public int getNrOfFieldDimensions() {return nrOfFieldDimensions;}
    public boolean isConst() {return isConst;}
    public boolean isVolatile() {return isVolatile;}

}
