package endlessGraph;

public class LehmerTerms {
	private final static int _SEED = 5;
	private final static long a = 1_664_525L;
	private final static long m = 4294967296L;
	private final static long c = 1_013_904_223L;
	
	private static long term(long pSeed) {
		
		return (a * pSeed + c) % m;
	}
	
	public static long nthTerm(long pNumber) {
		long tempSeed = term(_SEED);
		
		for(long index = 0; index < pNumber; index++) {
			tempSeed = term(tempSeed);
		}
		
		return tempSeed;
	}
	
	public static void main(String[] args) {
		System.out.println(LehmerTerms.nthTerm(0));
		System.out.println(LehmerTerms.term(5));
		System.out.println(LehmerTerms.nthTerm(245));
		
	}
}
