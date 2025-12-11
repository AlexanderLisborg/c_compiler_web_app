package c;

public enum TypeCode {
    CVoid(0),
    CChar(1),
    CShort(2),
    CInt(4),
    CLong(8),
    CFloat(4),
    CDouble(4),
    CSigned(4),
    CUnsigned(4),
    CHex(4),
    CUHex(4),
    CHexLong(8),
    CUHexLong(8),
    COct(4),
    CUOct(4),
    COctLong(8),
    CUOctLong(8),
    CDoubleLong(4),
    CLongLong(16),
    CULong(8)
    ;
    private int size; // In bytes, 0 represents undefined
    private TypeCode(int size) {this.size = size;}
    public int sizeOf(){return size;}

    public static int compareSizeOf(TypeCode t1, TypeCode t2) {
        int r1,r2;
        return ((r1=t1.sizeOf())==(r2=t2.sizeOf()) ? (0) : (r1>r2?1:-1) );
    }

    public static boolean isIntegral(TypeCode c){
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
                || c==TypeCode.CLongLong
                || c==TypeCode.CULong);
    }
    public static boolean isLit(TypeCode c){
        return (c==TypeCode.CHex
                || c==TypeCode.CUHex
                || c==TypeCode.CHexLong
                || c==TypeCode.CUHexLong
                || c==TypeCode.COct
                || c==TypeCode.CUOct
                || c==TypeCode.COctLong
                || c==TypeCode.CUOctLong);
    }

    public static boolean isFloatingPoint(TypeCode c){
        return (c==TypeCode.CFloat
                || c==TypeCode.CDouble
                || c==TypeCode.CDoubleLong);
    }

    public static boolean isNAN(TypeCode c){
        return (c==TypeCode.CVoid);
    }

    public static TypeCode getLargest(TypeCode c1, TypeCode c2) {
        if(TypeCode.compareSizeOf(c1,c2)==-1) return c1; // c1 < c2
        if(TypeCode.compareSizeOf(c1,c2)==1) return c2; // c1 > c2
        return c1;                                     // c1 == c2
    }
}