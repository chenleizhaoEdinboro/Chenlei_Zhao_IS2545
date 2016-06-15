
public class CitySim9002{

	public RandGen randGen;
	public Visitor[] visitor;

	public CitySim9002(long seed){

		randGen = new RandGen(seed);
		visitor = new Visitor[5];
	}

	public CitySim9002(){

	}

	public int rollDice(){
		int randNum = randGen.randNum();
		return randNum;
	}

	public boolean hasVisited(Visitor v){
		return (v.getTimeOfVisit()>0);
	}

	public boolean isValidSeed(String[] arg){
		if(arg.length !=1)
			return false;
		else
			return true;
	}

	public static void main(String args[]){
        long seed;

        CitySim9002 city0 = new CitySim9002();
        //check valid
        if(city0.isValidSeed(args)){


        System.out.println("Welcome to CitySim!  Your seed is "+args[0]);
        String[] locs = {"The Cathedral of Learning","Downtown","Squirrel Hill","Point","Left"};

        Visitor[] visitor = new Visitor[5];
        
		seed = Long.parseLong( args[0]);
	    CitySim9002 city = new CitySim9002(seed);

	    String[] studentPlace = {"Squirrel Hill","Downtown","Point"};
		Visitor numOne = new Visitor(1, "Student", studentPlace);
		visitor[0] = numOne;

		String[] busPlace = {"Squirrel Hill","Downtown"};
        Visitor numTwo = new Visitor(2, "Business Person",busPlace);
        visitor[1] = numTwo;
       

        String[] profPlace = locs;
        Visitor numThree = new Visitor(3,"Professor",profPlace);
        visitor[2] = numThree;
        
      
        String[] blogPlace = {" "};
        Visitor numFour = new Visitor(4,"Blogger",blogPlace);
        visitor[3] = numFour;
      

		Visitor numFive = new Visitor(5, "Student", studentPlace);
		visitor[4] = numFive;
	
		for(int i=0; i < visitor.length; i++){

			System.out.println("Visitor "+visitor[i].getVisitorNumber()+" is a "+visitor[i].getVisitorType());

		    int randNum = -1;
		    
		    while(randNum != 4 || visitor[i].getTimeOfVisit()==0){
		   	    
		    	//if(randNum ==4 && visitor[i].getTimeOfVisit()!=0)
		    		if(randNum ==4 && city.hasVisited(visitor[i]))
		    		System.out.println("Visitor "+ visitor[i].getVisitorNumber()+" has left the city");

		    	else{
		    		//Generate a number from 0 to 4 with even chances.
		    		randNum = city.rollDice();
		    		//check if randNum is in the boundary

		    		if(randNum == 4)
		    			continue;
		    		else{

			    		System.out.println("Visitor "+ visitor[i].getVisitorNumber()+" is going to "+locs[randNum]);
			    			if(visitor[i].isLikePlace(locs[randNum]))
			    				System.out.println("Visitor "+ visitor[i].getVisitorNumber()+" did like "+locs[randNum]);
			    			 else
			    				System.out.println("Visitor "+ visitor[i].getVisitorNumber()+" did not like "+locs[randNum]);
		    		}
		    	}
		    	
		    	visitor[i].addVisitTime();
			}
			System.out.println("visitor "+ (i+1)+" has left the City");
			
			System.out.println("***");
   		}//end of forloop
   	}else{
   		System.out.println("Please enter one integer argument, seed");
   	}
	}//end of main()
}//end of class