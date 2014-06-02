package gASimple;

/**
 *
 * @author L. Antonio Hidalgo R.
 */

public enum ThicknessType {
    T5PX(0), 
    T6PX(23),
    T7PX(47),
    T8PX(70),
    T9PX(94),
    T10PX(117),
    T11PX(141),
    T12PX(164),
    T13PX(187),
    T14PX(210),
    T15PX(233);
    
    private final int _LowerByteBoundary;
    
    private ThicknessType(final int pLowerByteBoundary) {
        _LowerByteBoundary = pLowerByteBoundary;
    }
    
    public static ThicknessType getThicknessType(int pLowerBoundary) {
        ThicknessType zone = T5PX;
        
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
