package gASimple;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class AdaptabilityFunction {
    public static int rankIndividual(WeaponIndividual pIndividual) {
        int rank = 0; 
        SpreadType weaponSpread;
        
        weaponSpread = SpreadType.getSpreadType(pIndividual.getSpreadInt());
        
        switch (weaponSpread) {
            case ONELANE:
                rank = 1;
                break;
            case TWOLANES:
                rank = 2;
                break;
            case THREELANES:
                rank = 3;
                break;
        }
        return rank;        
    }
}
