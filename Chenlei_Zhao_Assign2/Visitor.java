public class Visitor{

	// a Student, a Professor, a Business Person, or a Blogger
	private String type;
	private String[] likePlace;
	private int timeOfVisit;
	private int visitNumber;


	public Visitor(int number, String newType, String[] places){
		visitNumber = number;
		type = newType;
		likePlace = places;
		timeOfVisit =0;
	}

	public void addVisitTime(){
		timeOfVisit++;
	}

	public int getVisitorNumber(){
		return visitNumber;
	}
	public String getVisitorType(){
		return type;
	}
	public int getTimeOfVisit(){
		return timeOfVisit;
	}
	public boolean isLikePlace(String place){
        for(String l:likePlace){
        	if(l.equals(place))
        		return true;
        }
        return false;
	}

}