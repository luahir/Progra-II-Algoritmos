package GAsimple;

/**
 *
 * @author L. Antonio Hidalgo
 */
public enum ColorType {
    GREENT(0), 
    YELLOWT(63),
    REDT(127),
    SURPRISET(192);
    
    private final int _LowerByteBoundary;
        
    private ColorType(int pLowerByteBoundary) {
        _LowerByteBoundary = pLowerByteBoundary;
    }
    
    public static ColorType getColorType(int pLowerBoundary) {
        ColorType zone = null;
        
        for(ColorType tryZone : values()) {
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
