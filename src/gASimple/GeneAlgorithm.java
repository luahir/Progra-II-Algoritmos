package gASimple;

import java.util.ArrayList;
import java.util.List;

import lib.Weapon;

public class GeneAlgorithm {
	private WeaponPopulation _Population = new WeaponPopulation();
	private WeaponIndividual _TheWeapon = new WeaponIndividual(); 
	
	public GeneAlgorithm() {
		
	}
	
	public void addWeapon() {
		WeaponIndividual tempIndividual = new WeaponIndividual();
		tempIndividual.generateWeaponIndividual();
		_Population.addIndividual(tempIndividual);
		crossIndividuals();
	}
	
	public Weapon getTheWeapon() {
		Weapon newWeapon;
		newWeapon = new Weapon(_TheWeapon.getColorInt(), _TheWeapon.getShapeInt(), _TheWeapon.getSpreadInt(), _TheWeapon.getThicknessInt());
		return newWeapon;
	}
	
	/**
	 * Prospective parents are crossed only if their rank is 2 or above. If there are
	 * no individuals that have this quality, 2 individuals are selected at random, to
	 * keep the algorithm going.
	 */
	private void crossIndividuals() {
		List<WeaponIndividual> possibleParents = new ArrayList<>();
		
		if(_Population.size() > 1) {
			
			for(WeaponIndividual prospectParent : _Population.getPopulation()) {
				if(AdaptabilityFunction.rankIndividual(prospectParent) >= 2) {
					possibleParents.add(prospectParent);
				}
			}
			
			int parent1 = (int)Math.random()*possibleParents.size();
			int parent2 = (int)Math.random()*possibleParents.size();
			
			if(possibleParents.size() > 0)
				_TheWeapon = GeneCrossover.crossover(possibleParents.get(parent1), possibleParents.get(parent2));
			else {
				parent1 = (int)Math.random()*_Population.size();
				parent2 = (int)Math.random()*_Population.size();
				_TheWeapon = GeneCrossover.crossover(_Population.getPopulation().get(parent1), _Population.getPopulation().get(parent2));
			}
			
		}
		else
			_TheWeapon = GeneCrossover.crossover(_Population.getPopulation().get(0), _Population.getPopulation().get(0));
	}
	
	
}
