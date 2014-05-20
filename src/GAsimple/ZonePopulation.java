package GAsimple;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class ZonePopulation {
    private List<ZoneIndividual> _Population = new ArrayList<>();
    
    public ZonePopulation() {
        
        for(int individual = 0; individual < 9; ++individual) {
            ZoneIndividual tempIndividual = new ZoneIndividual();
            
            tempIndividual.generateIndividual(PrizeType.REG);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 7; ++individual) {
            ZoneIndividual tempIndividual = new ZoneIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K20);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 6; ++individual) {
            ZoneIndividual tempIndividual = new ZoneIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K50);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 6; ++individual) {
            ZoneIndividual tempIndividual = new ZoneIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K100);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 4; ++individual) {
            ZoneIndividual tempIndividual = new ZoneIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K200);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 4; ++individual) {
            ZoneIndividual tempIndividual = new ZoneIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K500);
            
            _Population.add(tempIndividual);
        }
        
        for(int individual = 0; individual < 2; ++individual) {
            ZoneIndividual tempIndividual = new ZoneIndividual();
            
            tempIndividual.generateIndividual(PrizeType.K1M);
            
            _Population.add(tempIndividual);
        }
        
    }
    
    public List<ZoneIndividual> getPopulation() {
        return _Population;
    }
}
