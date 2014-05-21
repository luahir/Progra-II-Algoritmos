package GAsimple;

/**
 *
 * @author L. Antonio Hidalgo
 */
public enum ThicknessType {
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
    
    private ThicknessType(final int pLowerByteBoundary) {
        _LowerByteBoundary = pLowerByteBoundary;
    }
    
    public static ThicknessType getThicknessType(int pLowerBoundary) {
        ThicknessType zone = fivePx;
        
        for(ThicknessType tryZone : values()) {
            if(tryZone._LowerByteBoundary <= pLowerBoundary)
                zone = tryZone;
        }
        return zone;
    }
    
//    public static void main(String[] args) {
//        
//        System.out.println(ThicknessType.getThicknessType(95));
//    }
}
