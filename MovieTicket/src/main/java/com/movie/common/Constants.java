 package com.movie.common;

public final class Constants {
	
	public static final String success = "Success";
	public enum Status{
		
		ACTIVE("active",1),INACTIVE("inactive",2);
		 int id=0;
		 String abbr;
		
		
		
	
		public int getId(String s) {
			for(Status sa: Status.values()) {
				if(sa.getAbbr().equals(s)) {
					return sa.id;
				}
			}
			return 0;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getAbbr() {
			return abbr;
		}
		public void setAbbr(String abbr) {
			this.abbr = abbr;
		}
		private Status( String abbr,int id) {
			this.id = id;
			this.abbr = abbr;
		}
	}
	
	
	public enum Role {
	    ADMIN, USER;
	    
	    public String authority() {
	        return "ROLE_" + this.name();
	    }
	}
	  public enum SeatStatus { 
		    SEAT_BOOKED, 
		    SEAT_NOT_BOOKED; 
		} 
		  
		public enum MovieStatus { 
		    Movie_Available, 
		    Movie_NotAvailable; 
		} 
		  
		public enum MovieType { 
		    ENGLISH, 
		    HINDI; 
		} 
		  
		public enum SeatType { 
		    NORMAL, 
		    EXECUTIVE, 
		    PREMIUM, 
		    VIP; 
		} 
		  
		public enum PaymentStatus { 
		    PAID, 
		    UNPAID; 
		}
}
