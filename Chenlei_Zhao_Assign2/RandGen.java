import java.util.Random;

public class RandGen{
	
	public long seed;
	private Random randGen;

	public RandGen(long newSeed){
      seed = newSeed;
      randGen = new Random(seed);
	}
    //Generate a number from 0 to 4 with even chances.
    public int randNum(){
    	return randGen.nextInt(5);
    }

}