import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class CityTest {
	// Test the valid seed for the city.
		@Test
		public void testHasValidSeed(){
			boolean flag = false;
			flag = Mockito.mock(CitySim9002.class).isValidSeed(null);
	      
			assertEquals(flag,false);
		}
		

}
