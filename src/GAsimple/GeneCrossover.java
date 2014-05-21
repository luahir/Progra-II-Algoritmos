package GAsimple;

import java.util.BitSet;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class GeneCrossover {
    private static final double MUTATIONFACTOR = 0.1;
    
    /**
     * 
     * @param pParent1 WeaponIndividual, whose genes are going to be crossed.
     * @param pParent2 WeaponIndividual, whose genes are going to be crossed.
     * @return WeaponIndividual, pParent1 and 2's offspring.
     */
    public static WeaponIndividual crossover(WeaponIndividual pParent1, WeaponIndividual pParent2) {
        WeaponIndividual theChild = new WeaponIndividual();
        
        theChild.setColorGenes(crossGenes(pParent1.getColorGenes(), pParent2.getColorGenes()));
        theChild.setShapeGenes(crossGenes(pParent1.getShapeGenes(), pParent2.getShapeGenes()));
        theChild.setSpreadGenes(crossGenes(pParent1.getSpreadGenes(), pParent2.getSpreadGenes()));
        theChild.setThicknessGenes(crossGenes(pParent1.getThicknessGenes(), pParent2.getThicknessGenes()));
        
        return theChild;
    }
    
    /**
     * 
     * @param pParent1Genes BitSet that represent a WeaponIndividual's genes
     * @param pParent2Genes BitSet that represent a WeaponIndividual's genes
     * @return genes after cross and mutation.
     */
    private static BitSet crossGenes(BitSet pParent1Genes, BitSet pParent2Genes) {
        int crossoverBit;
        BitSet crossedGenes = new BitSet(pParent1Genes.size());
        crossedGenes.clear();
        
        crossoverBit = (int) (pParent1Genes.size()*Math.random());
        
        crossedGenes.or(pParent1Genes.get(0, crossoverBit));
        crossedGenes.or(pParent2Genes.get(crossoverBit, pParent2Genes.size()));
                        
        return mutate(crossedGenes);
    }
    
    /**
     * 
     * @param pCrossedGenes BitSet to mutate
     * @return mutated (if eligible) BitSet genes.
     */
    private static BitSet mutate(BitSet pCrossedGenes) {
        BitSet mutatedGenes = new BitSet();
        double mutationProb = Math.random();
        
        mutatedGenes.clear();
        
        if(mutationProb < MUTATIONFACTOR) {
            int bitIndex = (int)((pCrossedGenes.size()-1)*Math.random());
            pCrossedGenes.flip(bitIndex);
        }
        
        return mutatedGenes;
    }
}
