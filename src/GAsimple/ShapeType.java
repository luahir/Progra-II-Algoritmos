package GAsimple;

/**
 *
 * @author L. Antonio Hidalgo
 */
public enum ShapeType {
    S3POINT(0), 
    S4POINT(63),
    S5POINT(127),
    SSURPRISEPOINT(192);
    
    private final int _LowerByteBoundary;
        
    private ShapeType(int pLowerByteBoundary) {
        _LowerByteBoundary = pLowerByteBoundary;
    }
    
    public static ShapeType getColorType(int pLowerBoundary) {
        ShapeType zone = null;
        
        for(ShapeType tryZone : values()) {
            if(tryZone._LowerByteBoundary <= pLowerBoundary)
                zone = tryZone;
        }
        return zone;
    }
    
//    public static void main(String[] args) {
//        
//        System.out.println(ThicknessType.getZoneType(95));
//    }
}
