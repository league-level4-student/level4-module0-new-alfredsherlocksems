package _01_Encapsulate_the_Data;


public class EncapsulateTheData {

    /*
     * itemsReceived cannot be negative. All negative parameters should set
     * itemsReceived to 0.
     */

   private int itemsReceived;
   
   public int getItemsReceived() {
	   return itemsReceived;
   }
   
   public void setItemsRecieved(int itemsReceived) {
	   if (itemsReceived < 0) {
		   itemsReceived = 0;
	   }
	   this.itemsReceived = itemsReceived;
	  
   }

    /*
     * degreesTurned must be locked between 0.0 and 360.0 inclusive. All
     * parameters outside this range should set degreesTurned to the nearest
     * bound.
     */

   private double degreesTurned;
   public double getDegreesTurned() {
	   return degreesTurned;
   }
   
   public void setDegreesTurned(double degreesTurned) {
	   if (degreesTurned < 0) {
		   degreesTurned = 0;
	   }
	   else if (degreesTurned > 360) {
		   degreesTurned = 360;
	   }
	   this.degreesTurned = degreesTurned;
   }
    /*
     * nomenclature must not contain an empty String. An empty String parameter
     * should set nomenclature to a String with a single space.
     */

    private String nomenclature;
    
    public String getNoMenClature() {
    	return nomenclature;
    }
    
    public void setNoMenClature(String nomenclature) {
    	if (nomenclature.isEmpty()) {
    		nomenclature = " ";
    	}
    	this.nomenclature = nomenclature;
    }
    /*
     * memberObj must not be a String. A String parameter should set memberObj
     * to a new Object(); Hint: Use the instanceof operator.
     */

    private Object memberObj;

    public Object getMemberObj() {
    	return memberObj;
    }
    
    public void setMemberObj(Object memberObj) {
    	if (memberObj instanceof String) {
    		memberObj = new Object();
    	}
    	this.memberObj = memberObj;
    }
}
