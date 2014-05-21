package GAsimple;

/**
 *
 * @author L. Antonio Hidalgo
 */
public enum ColorType {
    fivePx(0), 
    sixPx(23),
    sevenPx(47),
    eightPx(70),
    ninePx(94),
    tenPx(117),
    elevenPx(141),
    twelvePx(164),
    thirtPx(187),
    fourtPx(210),
    fiftPx(233);
    
    private final int _LowerByteBoundary;
    
    private ColorType(final int pLowerByteBoundary) {
        _LowerByteBoundary = pLowerByteBoundary;
    }
    
    public static ColorType getZoneType(int pLowerBoundary) {
        ColorType zone = fivePx;
        
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
