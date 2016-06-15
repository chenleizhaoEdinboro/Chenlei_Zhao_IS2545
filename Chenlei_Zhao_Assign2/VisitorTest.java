import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class VisitorTest {
	
	
	//When the visitor be initialized first time, his/her visit times to the 
	//City is 0. This is checking whether the object initialized correctly.
	@Test
	public void testGetTimeOfVisit(){
		String[] place = {"Squirrel Hill","Downtown","Point"};
		Visitor v = new Visitor(1,"Student",place);
		assertEquals(0,v.getTimeOfVisit());
		
	}
	
	//Check whether the place is the visitor's preference location.
	//Compare the passing in place as an argument to each liking locations.
	@Test
	public void testIsLikePlace(){
		String[] place1= {"Squirrel Hill","Downtown","Point"};
		Visitor v = new Visitor(1,"Student",place1);
		assertFalse(v.isLikePlace("The Cathedral of Learning"));
		
	}
	
	//The visitor's visit times of the city is initialized with 0,
	//each time the addVisitTime() being called, the visitor's visit times should be incremented by 1
	@Test
	public void testAddVisitTime(){
		String[] place2= {"Squirrel Hill","Downtown","Point"};
		Visitor v = new Visitor(1,"Student",place2);
		v.addVisitTime();
		assertEquals(1,v.getTimeOfVisit());
	}
	
	//The visitor should be considered has been visited the city if the visitor's visit
	//time is more than 0 time, otherwise he has not been considered visit the city
	@Test
	public void testHasVisitedTimes(){
		
		Visitor v = Mockito.mock(Visitor.class);
		CitySim9002 city = new CitySim9002(333);
        boolean flag = city.hasVisited(v);
		assertEquals(flag,false);
	}
	
	

}
