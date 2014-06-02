package gASimple;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author L. Antonio Hidalgo R.
 */
public class WeaponPopulation {
    private List<WeaponIndividual> _Population = new ArrayList<>();
    private final int MAXPOPULATION = 20;
    
    public void addIndividual(WeaponIndividual pIndividual) {
        if(_Population.size() == 20) {
            killIndividual();
        }
        
        _Population.add(pIndividual);
            
    }
    
    public List<WeaponIndividual> getPopulation() {
        return _Population;
    }
    
    private void killIndividual() {
        int whoDies = (int)(20*Math.random());
        _Population.remove(whoDies);
    }
}
