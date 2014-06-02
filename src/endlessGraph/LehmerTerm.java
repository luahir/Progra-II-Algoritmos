package endlessGraph;

/**
 * 
 * @author L. Antonio Hidalgo R.
 *
 */
public class LehmerTerm {
	private final static int _SEED = 1;
	private final static long a = 1_664_525L;
	private final static long m = 4294967296L;
	private final static long c = 1_013_904_223L;
	
	/**
	 * 
	 * @param pSeed from which to calculate a term in the random number generator.
	 * @return the term of the recurrent relation.
	 */
	private static long term(long pSeed) {
		
		return (a * pSeed + c) % m;
	}
	/**
	 * 
	 * @param pNumber a long number that determines the nth term for _SEED.
	 * @return the nth term of the linear congruential random number generator.
	 */
	public static long nthTerm(long pNumber) {
		long tempSeed = _SEED;
		
		for(long index = 0; index < pNumber; index++) {
			tempSeed = term(tempSeed);
		}
		return tempSeed;
	}
	
	public static void main(String[] args) {
		System.out.println(LehmerTerm.nthTerm(0));
		System.out.println(LehmerTerm.nthTerm(1));
		System.out.println(LehmerTerm.nthTerm(2));
	}
}
