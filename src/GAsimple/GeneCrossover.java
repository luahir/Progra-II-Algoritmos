/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GAsimple;

import java.util.BitSet;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class GeneCrossover {
    private static double MUTATIONFACTOR = 0.07;
    
    public static ZoneIndividual crossover(ZoneIndividual pParent1, ZoneIndividual pParent2) {
        ZoneIndividual theChild = new ZoneIndividual();
        int crossoverBit = 0;
        double mutationProb = Math.random();
        BitSet parent1MixBits = new BitSet(8);
        BitSet parent2MixBits = new BitSet(8);
        
        crossoverBit = (int) (6*Math.random());
        
        parent1MixBits = pParent1.getIgenes().get(0, crossoverBit);
        parent2MixBits = pParent2.getIgenes().get(crossoverBit, pParent2.getIgenes().length());
        
        theChild.getIgenes().clear();
        theChild.getIgenes().or(parent1MixBits);
        theChild.getIgenes().or(parent2MixBits);
        
        if(mutationProb < MUTATIONFACTOR) {
            theChild.getIgenes().flip((int)(7*Math.random()));
        }
        
        return theChild;
    }
}
