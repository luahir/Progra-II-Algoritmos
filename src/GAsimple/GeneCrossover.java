package GAsimple;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class GeneCrossover {
    private static final double MUTATIONFACTOR = 0.1;
    private static int GENESIZEPOWER;
    
    /**
     * 
     * @param pParent1 WeaponIndividual, whose genes are going to be crossed.
     * @param pParent2 WeaponIndividual, whose genes are going to be crossed.
     * @return WeaponIndividual, pParent1 and 2's offspring.
     */
    public static WeaponIndividual crossover(WeaponIndividual pParent1, WeaponIndividual pParent2) {
        WeaponIndividual theChild = new WeaponIndividual();
        GENESIZEPOWER = (int) (Math.log10(pParent1.size()) / Math.log10(2));
        
        theChild.setColorGenes(crossGenes(pParent1.getColorGenes(), pParent2.getColorGenes()));
        theChild.setShapeGenes(crossGenes(pParent1.getShapeGenes(), pParent2.getShapeGenes()));
        theChild.setSpreadGenes(crossGenes(pParent1.getSpreadGenes(), pParent2.getSpreadGenes()));
        theChild.setThicknessGenes(crossGenes(pParent1.getThicknessGenes(), pParent2.getThicknessGenes()));
        
        return theChild;
    }
    
    /**
     * 
     * @param pParent1Genes byte that represent a WeaponIndividual's genes
     * @param pParent2Genes byte that represent a WeaponIndividual's genes
     * @return genes after cross and mutation.
     */
    private static byte crossGenes(byte pParent1Genes, byte pParent2Genes) {
        int crossoverBit;
        byte crossedGenes;
        int parent1Shift;
        int parent2Shift;
        
        crossoverBit = (int) (GENESIZEPOWER*Math.random());
        //System.out.println("Crossover bit: " + crossoverBit);
        
        parent1Shift = GENESIZEPOWER - crossoverBit;
        parent2Shift = crossoverBit;
        
        //The conversion from byte to int changes the sign bit, so this has to be changed back to get the expected result.
        pParent1Genes = (byte) ((pParent1Genes & 0xFF) >> parent1Shift);
//        System.out.println("CrossGenes1 shift r1: " + (pParent1Genes & 0xFF) + " " + pParent1Genes + " Parentshift1: " + parent1Shift);
        pParent1Genes = (byte) ((pParent1Genes & 0xFF) << parent1Shift);
//        System.out.println("CrossGenes1 shift l1: " + (pParent1Genes & 0xFF) + " " + pParent1Genes + " Parentshift1: " + parent1Shift);
        pParent2Genes = (byte) ((pParent2Genes & 0xFF) << parent2Shift);
//        System.out.println("CrossGenes2 shift l2: " + (pParent2Genes & 0xFF) + " " + pParent2Genes + " Parentshift2: " + parent2Shift);
        pParent2Genes = (byte) ((pParent2Genes & 0xFF) >> parent2Shift);
//        System.out.println("CrossGenes1 shift r2: " + (pParent2Genes & 0xFF) + " " + pParent2Genes + " Parentshift2: " + parent2Shift);
//
//        System.out.println("CrossGenes1: " + (pParent1Genes & 0xFF) + " " + pParent1Genes);
//        System.out.println("CrossGenes2: " + (pParent2Genes & 0xFF) + " " + pParent2Genes);
        crossedGenes = (byte) (pParent1Genes + pParent2Genes);
//        System.out.println("CrossGenesFinal: " + (crossedGenes & 0xFF));
        
                        
        return mutate(crossedGenes);
    }
    
    /**
     * 
     * @param pCrossedGenes BitSet to mutate
     * @return mutated (if eligible) BitSet genes.
     */
    private static byte mutate(byte pCrossedGenes) {
        byte mutatedGenes;
        double mutationProb = Math.random();
        
        if(mutationProb < MUTATIONFACTOR) {
            int bitIndex = (int)(GENESIZEPOWER*Math.random());
            mutatedGenes = (byte) (pCrossedGenes ^ (1 << bitIndex));
            //System.out.println("¡Mutante! en bit " + bitIndex);
        }
        else
            mutatedGenes = pCrossedGenes;
        
        return mutatedGenes;
    }
    
//    public static void main(String[] args) {
//        WeaponIndividual pruebaCruce1 = new WeaponIndividual();
//        WeaponIndividual pruebaCruce2 = new WeaponIndividual();
//        WeaponIndividual hijoPrueba = new WeaponIndividual();
//        
//        pruebaCruce1.generateWeaponIndividual();
//        pruebaCruce2.generateWeaponIndividual();
//        System.out.println("Color padre1: " + pruebaCruce1.getColorInt());
//        System.out.println("Color padre2: " + pruebaCruce2.getColorInt());
//        
//        hijoPrueba = GeneCrossover.crossover(pruebaCruce1, pruebaCruce2);
//        
//        System.out.println("Color hijo: " + hijoPrueba.getColorInt());
        //System.out.println((byte)((206 &0xFF) >> 4));
//    }
}
