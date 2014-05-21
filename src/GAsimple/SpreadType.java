package GAsimple;

/**
 *
 * @author L. Antonio Hidalgo
 */
public enum SpreadType {
    oneLane(0), 
    twoLanes(86),
    threeLanes(171);
    
    private final int _LowerByteBoundary;
    
    private SpreadType(final int pLowerByteBoundary) {
        _LowerByteBoundary = pLowerByteBoundary;
    }
    
    public static SpreadType getSpreadType(int pLowerBoundary) {
        SpreadType zone = oneLane;
        
        for(SpreadType tryZone : values()) {
            if(tryZone._LowerByteBoundary <= pLowerBoundary)
                zone = tryZone;
        }
        return zone;
    }
    
//    public static void main(String[] args) {
//        
//        System.out.println(SpreadType.getZoneType(95));
//    }
}
