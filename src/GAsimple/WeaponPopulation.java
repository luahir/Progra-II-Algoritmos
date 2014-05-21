package GAsimple;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class WeaponPopulation {
    private List<WeaponIndividual> _Population = new ArrayList<>();
    
    public WeaponPopulation() {
        
        for(int individual = 0; individual < 9; ++individual) {
            WeaponIndividual tempIndividual = new WeaponIndividual();
            
            tempIndividual.generateIndividual(PrizeType.REG);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 7; ++individual) {
            WeaponIndividual tempIndividual = new WeaponIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K20);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 6; ++individual) {
            WeaponIndividual tempIndividual = new WeaponIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K50);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 6; ++individual) {
            WeaponIndividual tempIndividual = new WeaponIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K100);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 4; ++individual) {
            WeaponIndividual tempIndividual = new WeaponIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K200);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 4; ++individual) {
            WeaponIndividual tempIndividual = new WeaponIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K500);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 2; ++individual) {
            WeaponIndividual tempIndividual = new WeaponIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K1M);
            
            _Population.add(tempIndividual);
        }
        
    }
    
    public List<WeaponIndividual> getPopulation() {
        return _Population;
    }
}
