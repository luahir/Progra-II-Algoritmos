/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GAsimple;

import java.util.List;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class AdaptabilityFunction {
    public static boolean checkApt(ZoneIndividual pIndividual, List<ZoneIndividual> pSameZoneIndividuals) {
        boolean apt = false;
        double positionsPerZone = 1. / pSameZoneIndividuals.size();
        double prizeOfIndividual = pIndividual.getCostOfIndividual();
        double prizesPerZoneSum = 0.;
        
        for(ZoneIndividual sameZoneIndividual : pSameZoneIndividuals) {
            prizesPerZoneSum += sameZoneIndividual.getCostOfIndividual();
        }
        
        if((prizeOfIndividual / prizesPerZoneSum) > positionsPerZone)
            apt = true;
        
        return apt;
        
    }
}
