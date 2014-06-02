package lib;

/**
 * 
 * @author L. Antonio Hidalgo R.
 *
 */

public enum Direction {
	CENTER1(1),
	LEFT2(2),
	RIGHT2(3),
	LEFT3(4),
	CENTER3(5),
	RIGHT3(6);
	
	private final int _DirectionValue;
	
	private Direction(int pDirectionValue) {
		_DirectionValue = pDirectionValue;
	}

	public int getDirectionValue() {
		return _DirectionValue;
	}
}