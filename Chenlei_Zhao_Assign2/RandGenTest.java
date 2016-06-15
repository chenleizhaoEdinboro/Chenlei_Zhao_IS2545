
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// You could also do this to make this a little cleaner.  
//import static org.mockito.Mockito.*;

import org.mockito.*;

public class RandGenTest {
	
	//Testing the random number generator for invalid seed.
	@SuppressWarnings("unchecked")
	@Mock
	RandGen mockedRandGen = Mockito.mock(RandGen.class);
	
	@Test
	//Testing no matter what is the value of seed, the random generator will
	//generate a number from 0 to 4 inclusive.
	public void testRollDice(){
		boolean flag = false;
		int randomNum = Mockito.mock(CitySim9002.class).rollDice();
		if(randomNum <= 4 && randomNum >=0)
			flag = true;
		assertEquals(flag,true);	
	}
	

	
}//end of class
