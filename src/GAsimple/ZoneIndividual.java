package GAsimple;

import java.util.BitSet;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class ZoneIndividual extends Individual {
    private double _CostOfIndividual;
    private SpreadType _ZoneOfIndividual;
    
    public void generateIndividual(PrizeType pPrize) {
        setCostOfIndividual(pPrize);
        setIgenes(setZoneGene());
    }
    
    public void setCostOfIndividual(PrizeType pPrize) {
        _CostOfIndividual = pPrize.getPrizeValue();
    }
    
    public double getCostOfIndividual() {
        return _CostOfIndividual;
    }
    
    public void setZoneOfIndividual(int pGeneInt) {
        // Since SpreadType can't be instantiated, we call zone1 (or any other zone)
        // to get the actual zone that corresponds to pGeneInt.
        _ZoneOfIndividual = SpreadType.zone1.getZoneType(pGeneInt);
    }
    
    public SpreadType getZoneOfIndividual() {
        return _ZoneOfIndividual;
    }
    
    private BitSet setZoneGene() {
        int geneInt;
        int geneLength = ZoneIndividual.DEFAULTGENELENGTH;
        BitSet bits = new BitSet(geneLength);
        
        geneInt = (int) ((int)geneLength*Math.random());
        
        //System.out.println(geneInt);
        setZoneOfIndividual(geneInt);
        bits = convertFromInt(geneInt);
        //System.out.println(bits);
        return bits;
    }
    
    private BitSet convertFromInt(int pGeneInt) {
        BitSet bits = new BitSet();
        int position = 0;
        
        while(pGeneInt != 0) {
            if(pGeneInt % 2 != 0) {
                bits.set(position);
            }
            
            position++;
            pGeneInt = pGeneInt >>> 1;
        }
        return bits;
    }
    
    @Override
    public String toString() {
            return getIgenes().toString();
    }
    
//    public static void main(String[] args) {
//        ZoneIndividual prueba = new ZoneIndividual();
//        prueba.generateIndividual(PrizeType.K100);
//        System.out.println(prueba.getCostOfIndividual());
//        System.out.println(prueba.getZoneOfIndividual());
//        System.out.println(prueba);
//    }
}
