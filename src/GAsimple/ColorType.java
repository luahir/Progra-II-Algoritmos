package GAsimple;

/**
 *
 * @author L. Antonio Hidalgo
 */
public enum ColorType {
    green(0), 
    yellow(63),
    red(127),
    surpriseColor(192);
    
    private final int _LowerByteBoundary;
    
    private ColorType(final int pLowerByteBoundary) {
        _LowerByteBoundary = pLowerByteBoundary;
    }
    
    public static ColorType getColorType(int pLowerBoundary) {
        ColorType zone = green;
        
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
