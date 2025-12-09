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
    CLongLong(16);
    private int size; // In bytes
    private TypeCode(int size) {this.size = size;}
    public int sizeOf(){return size;}

    public static int compareSizeOf(TypeCode t1, TypeCode t2) {
        int r1,r2;
        return ((r1=t1.sizeOf())==(r2=t2.sizeOf()) ? (0) : (r1>r2?1:-1) );
    }
}