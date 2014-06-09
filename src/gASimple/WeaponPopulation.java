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
        if(_Population.size() == MAXPOPULATION) {
            killIndividual();
        }
        
        _Population.add(pIndividual);    
    }
    
    public List<WeaponIndividual> getPopulation() {
        return _Population;
    }
    
    public int size() {
    	return _Population.size();
    }
    
    private void killIndividual() {
        System.out.println("Kill, kill, kill!");
    	int whoDies = (int)(MAXPOPULATION*Math.random());
        _Population.remove(whoDies);
    }
}
