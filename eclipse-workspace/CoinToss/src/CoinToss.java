import java.util.Random ;
public class CoinToss {
	public static final int HEADS = 1 ;
	public static final int TAILS = 0 ;
	public static final int MAX_TOSSES = 10000 ;
	public static void main(String[] args) {

		Random generator = new Random() ;
		int flip = generator.nextInt(2) ;
		int totalHeads = 0 ;
		int heads = 0 ;
		int tails = 0 ;
		
		for (int count = 0; (count < MAX_TOSSES); count++) {
			flip = generator.nextInt(2) ;
		
		if (flip == HEADS) {
				heads = heads + 1 ;
			}
		totalHeads = heads ;
		}
		
		int totalTails = 10000 - totalHeads ;
			
			
			
			System.out.print("there were " 
			+ totalHeads + " heads flipped and " + totalTails + "tails" );
			
			
			
			
			
			
			
			
			
			
	}

}
