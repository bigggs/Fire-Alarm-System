package prototype;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner; 

public class fireSystem  {
		public static boolean alarm = true;
		public static boolean vents = true;
		public static boolean doors = true;
		public static boolean sprinklers = true;
		public static boolean logs = true;
		public static boolean em = true;
		public static boolean fire = false;
		public static boolean directionIndicator = true;
		public static boolean lockedDoors = true;
		public static boolean exitLifts = true;
		
	public static void  main(String[] args)   {
		while(fire == false) {
		welcome(); 
		}
		while(fire == true) {
			fireDetected();
		}
		
		fireChoice();
	
	}
	

	// FIRE DETECTED
	public static void fireDetected() {
		if (alarm == true) {
		    triggerAlarm();

	    }
	    if (vents == true) {
	    openVents();
	    }
	    if (doors == true) {
	    closeDoors();
	    }
	    if (sprinklers == true) {
	    activateSprinklers();
	    }
		 if (em == true) {
	    callES();
		    }
		 if(logs ==true) {
	    logDB();
		  }
		 if(directionIndicator ==true) {
			 activateLights();
				  }
		 if(lockedDoors ==true) {
		 lockDoor();
				  }
		 if(exitLifts ==true) {
		 disableLifts();
				  }
		 
	    disableAlarm();
	    }
		
		
	
	//WELCOME AND EDIT CONFIG

	public static void welcome() {
		
		 System.out.println("Welcome to Bucks fire alarm");
		    System.out.println("Build version: Prototype 1.1");
		    System.out.println("        System Controls ");
		    System.out.println("  ............................. ");
		    
		    
		    
		    Scanner controls = new Scanner(System.in);
		    //CONTROLLS
		    System.out.println("To trigger fire alarm X ");
		    System.out.println("To view database enter DB ");
		    System.out.println("To edit automatic configuration enter EC ");
		    System.out.println("To run a fire drill enter FD ");


		   String choice = controls.nextLine();
		   	//SHOWS DATABASE
		    if(choice.equals("DB")) {
			System.out.println("      Fire Event Database"); 
		    System.out.println("  ............................. ");
		    System.out.println("     Mon, 2 Mar 2019 17:02:46 GMT\r\n"); 
		    System.out.println("     Thu, 14 Mar 2019 17:02:46 GMT\r\n"); 
		    System.out.println("     Sat, 16 Mar 2019 17:02:46 GMT\r\n"); 
		    System.out.println("     Thu, 28 Mar 2019 17:02:46 GMT\r\n"); 
		    System.out.println("     Tue, 2 Apr 2019 17:02:46 GMT\r\n"); 
		    System.out.println("     Fri, 4 Apr 2019 17:02:46 GMT\r\n"); 
		    System.out.println("     Thu, 10 Apr 2019 17:02:46 GMT\r\n"); 
		    System.out.println("     Tue, 14 Apr 2019 17:02:46 GMT\r\n"); 
		    System.out.println("     Thu, 16 Apr 2019 17:02:46 GMT\r\n"); 
		    
		  }
		    //ALARM
		    else if(choice.equals("X")) {
		        System.out.println("Are you sure you want to trigger the alarm? Y/N");

				   String confirmFire = controls.nextLine();
		        
		        if(confirmFire.contentEquals("Y")) {
		        fireDetected();	
		        }
		        else {
					    System.out.println("Alarm cancelled");
		            	welcome();
				        }
				 

		        }
		         
		        
		    
		 
			    	
		    
		    //fire drill
		    else if (choice.contentEquals("FD")) {
		    	fireChoice();
		    }
		    //EDIT CONFIG
		    else if(choice.equals("EC")) {

			    Scanner editConfig = new Scanner(System.in);
		    	
				   //SOUND CONFIG
				   System.out.println("Would you like Automatic selection to trigger sound alarm?  Y/N ");
				   String alarmChoice = editConfig.nextLine();
			    if(alarmChoice.equals("Y")) {
			    	 alarm = true;
			    }
			    else {
			    	 alarm = false;
			    }
			    
			    Scanner editVents = new Scanner(System.in);
		    	
				   //VENT CONFIG
				   System.out.println("Would you like Automatic opening of vents?  Y/N ");
				   String ventChoice = editVents.nextLine();
			    if(ventChoice.equals("Y")) {
			    	 vents = true;
			    }
			    else {
			    	 vents = false;
			    }
			    	//DOOR CONFIG
			    Scanner editDoors = new Scanner(System.in);
		    	
				   
				   System.out.println("Would you like Automatic opening of doors?  Y/N ");
				   String doorChoice = editDoors.nextLine();
			    if(doorChoice.equals("Y")) {
			    	 doors = true;
			    }
			    else {
			    	 doors = false;
			    }
			    	//SPRINKLER CONFIG
			    Scanner editSprinklers = new Scanner(System.in);
		    	
				   
				   System.out.println("Would you like Automatic selection to trigger sprinklers?  Y/N ");
				   String sprinklerChoice = editSprinklers.nextLine();
			    if(sprinklerChoice.equals("Y")) {
			    	 sprinklers = true;
			    }
			    else {
			    	 sprinklers = false;
			    }
			    	//LOG CONFIG
			    Scanner editLogs = new Scanner(System.in);
		    	
				   
				   System.out.println("Would you like Automatic database logs created?  Y/N ");
				   String logChoice = editLogs.nextLine();
			    if(logChoice.equals("Y")) {
			    	 logs = true;
			    }
			    else {
			    	 logs = false;
			    }
			    Scanner editEm = new Scanner(System.in);
		    	
				   		//EMERGENCY CONFIG
				   System.out.println("Would you like Automatic selection to call emergency services?  Y/N ");
				   String emChoice = editEm.nextLine();
			    if(emChoice.equals("Y")) {
			    	 em = true;
			    }
			    else {
			    	 em = false;
			    }
		   		//LIGHTING CONFIG
			    Scanner editLight = new Scanner(System.in);

		   System.out.println("Would you like Automatic lighting strips to be turned on?  Y/N ");
		   String lightChoice = editLight.nextLine();
	    if(lightChoice.equals("Y")) {
	    	directionIndicator = true;
	    }
	    else {
	    	directionIndicator = false;
	    }
   			//DOOR CONFIG
	    	Scanner editLock = new Scanner(System.in);

	    	System.out.println("Would you like Automatic locking zones off?  Y/N ");
	    	String lockChoice = editLock.nextLine();
	    		if(lockChoice.equals("Y")) {
	    			lockedDoors = true;
}
	    		else {
	    			lockedDoors = false;
}
	    		//LIFT CONFIG
		    	Scanner lockLifts = new Scanner(System.in);

		    	System.out.println("Would you like to bring lifts to closest exit and lock them?  Y/N ");
		    	String liftChoice = lockLifts.nextLine();
		    		if(liftChoice.equals("Y")) {
		    			exitLifts = true;
	}
		    		else {
		    			exitLifts = false;
	}
		    }
		
		
	}
		//MANUAL OR AUTOMATIC
	public static void fireChoice()  {
		 Scanner userChoice = new Scanner(System.in);

		    System.out.println("Would you like to use Manual or Automatic? M/A ");

		   String choice = userChoice.nextLine();
		   	//MANUAL CHOSEN
		    if(choice.equals("M")) {
		    System.out.println("You have chosen Manual"); 
		    manual();
		    disableAlarm();
		    
		  }
		    //AUTOMATIC CHOSEN
		    else if(choice.equals("A")) {
			    System.out.println("You have chosen Automatic"); 
			    if (alarm == true) {
				    triggerAlarm();

			    }
			    if (vents == true) {
			    openVents();
			    }
			    if (doors == true) {
			    closeDoors();
			    }
			    if (sprinklers == true) {
			    activateSprinklers();
			    }
				 if (em == true) {
			    callES();
				    }
				 if(logs ==true) {
			    logDB();
				  }
				 if(directionIndicator ==true) {
					 activateLights();
						  }
				 if(lockedDoors ==true) {
				 lockDoor();
						  }
				 if(exitLifts ==true) {
				 disableLifts();
						  }
				 
			    disableAlarm();
			    }
		
	}
		//TRIGGER ALARM
	public static void triggerAlarm() {
	    System.out.println("Triggering Alarm");

			//LOOPING FLOORS AND ROOMS
		for (int floor = 0; floor < 6; floor++) {
		    try {
				Thread.sleep(3000);
		        System.out.println(".................................");
				System.out.println("Alarm Triggering on floor  " + floor );
		        System.out.println(".................................");

				for (int room = 0; room < 8; room++) {

				System.out.println("Alarm Triggering in Room " + room);
				}
		    } catch (InterruptedException e) {
			}
		}
		System.out.println("Alarm triggered in all floors and rooms");

		    
	}
	//OPEN VENTS
	public static void openVents() {
		
	    System.out.println("Opening Vents");
	    	//LOOPS FLOORS WITH VENTS CLOSING
		for (int floor = 0; floor < 6; floor++) {
		    try {
				Thread.sleep(1000);
				System.out.println("Vent opening on Floor " + floor );
		        System.out.println(".................................");
			} catch (InterruptedException e) {
			}


		
		}
		System.out.println("Vents opened on all floors");

	}
			//CLOSE DOORS
	public static void closeDoors() {
		
			
		System.out.println("Closing all fire doors ");
			//CLOSING DOORS LOADING
		for (int x = 0; x < 6; x++) {
		    try {
				System.out.println(".................................");
				Thread.sleep(500);

			} catch (InterruptedException e) {
			


		
		}
		}
		System.out.println("Fire doors all closed");

	}
	//ACTIVATE SPRINKLERS
	public static void activateSprinklers() {
		
		System.out.println("Detecting for individuals in sprinkler zone");
		System.out.println(".................................");
		try {
			Thread.sleep(700);
		System.out.println("No people detected");
		System.out.println("Activating Sprinklers ");
		
		//SPRINKLERS LOADING
	for (int x = 0; x < 6; x++) {
	    try {
			System.out.println(".................................");
			Thread.sleep(500);

		} catch (InterruptedException a) {
		


	
	}
	}
		}
		catch (InterruptedException e) {


		System.out.println("Sprinklers Activated");
		}
	}
		
		//ACTIVATE DIRECTION STRIPS
		public static void activateLights() {
			
			System.out.println("Directional lights turning on");
			System.out.println(".................................");
			try {
				Thread.sleep(700);
			}
			catch (InterruptedException e) {
			}
			
	
			System.out.println("Lights Activated ");
				
				
		}
		//DISABLING LIFTS
		public static void disableLifts() {
			
			System.out.println("Disabling lifts");
			
			for(int i = 1; i <5; i++) {
						
			System.out.println("Lift " +i + " opening at nearest floor");
			try {
				Thread.sleep(700);
			}
			catch (InterruptedException e) {
			}
			}
		
			System.out.println("Lifts Disabled ");
				
				
		}
		//locking doors
		public static void lockDoor() {
			int zone = 1;
			
			for(zone = 1; zone < 4; zone++ ) {
			System.out.println("Searching zone " +zone + " for personel" );
			System.out.println("..............................");

			try {
				Thread.sleep(700);
			}
			catch (InterruptedException e) {
			}
			}
			{
			System.out.println("Isolating doors initiated");
			for(zone = 1; zone < 4;) { 
			for(int i = 1; i <9; i++) {
			int x = 3;
			System.out.println("Locking door " +i + " in zone " +zone);
			System.out.println("..............................");

			try {
				Thread.sleep(300);
			}
			catch (InterruptedException e) {
			}
			}
			System.out.println("Zone "+zone + " secured");
			zone++;

			}
			
			}
			}	
		
			
		//LOG DATABASE
	public static void logDB() {
		//DB LOADING
	System.out.println("Logging alarm in database ");
	for (int x = 0; x < 6; x++) {
	    try {
			System.out.println(".................................");
			Thread.sleep(500);

		} catch (InterruptedException e) {
		


	
	}
	}
	System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));

	System.out.println("Saved in database");

}

	//CALL EMERGENCY SERVICES
	public static void callES() {
    System.out.println("Calling emergency services");

		for (int x = 0; x < 6; x++) {
	    try {
			Thread.sleep(3000);
	        System.out.println(".................................");
			
			
	    } catch (InterruptedException e) {
		}
	}
	System.out.println("Location sent");
	System.out.println("Emergency services called");
	System.out.println("Fire Brigade is on the way ");


	    
}
	public static void disableAlarm() {
	Scanner userChoice = new Scanner(System.in);

	 
	 
	 //SOUND ALARM
	    System.out.println("To disable alarm enter press X");

	    // String input
	   String choice = userChoice.nextLine();

	    if(choice.equals("X")) 
	    {
		    System.out.println("Alarm Deactivated");
		    	fire = false;
	    		welcome();
	    			
	  }


	    
}











//MANUAL CONFIGURATION


public static void manual() {
    
	 Scanner userChoice = new Scanner(System.in);

	 
	 
	 //SOUND ALARM
	    System.out.println("Would you like to activate sound alarm? Y/N ");

	    // String input
	   String choice = userChoice.nextLine();

	    if(choice.equals("Y")) {
	        triggerAlarm();

	  }
	    else {
	    	System.out.println("No sound alarm activated");
	    }
	    
	    //VENTS
	    
	    System.out.println("Would you like to open air vents? Y/N ");

	    // String input
	   String ventChoice = userChoice.nextLine();

	    if(ventChoice.equals("Y")) {
	        openVents();

	  }
	    else {
	    	System.out.println("Vents not opened");
	    }
	    
	    
 //DOORS
	    
	    System.out.println("Would you like to close all fire doors? Y/N ");

	    // String input
	   String doorChoice = userChoice.nextLine();

	    if(doorChoice.equals("Y")) {
	        closeDoors();

	  }
	    else {
	    	System.out.println("Doors not closed");
	    }
	    
	    
	    
	    	//SPRINKLERS
	    
	    System.out.println("Would you like to activate sprinklers? Y/N ");

	    // String input
	   String sprinklerChoice = userChoice.nextLine();

	    if(sprinklerChoice.equals("Y")) {
	        activateSprinklers();

	  }
	    else {
	    	System.out.println("Sprinklers not activated");
	    }
	    
	    
    	//CALL EMERGECNY SERVIES
System.out.println("Would you like to call emergency services? Y/N ");

// String input
String logChoice = userChoice.nextLine();

if(logChoice.equals("Y")) {
    callES();

}
else {
	System.out.println("Emergency services not called");
}
	    

    
    	//DIRECTION LIGHTS
    System.out.println("Would you like to turn on the directional lighting? Y/N ");

    // String input
   String lightChoice = userChoice.nextLine();

    if(lightChoice.equals("Y")) {
        activateLights();

  }
    else {
    	System.out.println("Lights not activated");
    }
    
    System.out.println("Would you like to lock off zones? Y/N ");

    // String input
   String zoneChoice = userChoice.nextLine();

    if(zoneChoice.equals("Y")) {
        lockDoor();

  }
    else {
    	System.out.println("Zones not locked off");
    }
	    //DISABLE LIFTS
    System.out.println("Would you like to disable lifts? Y/N ");

    // String input
   String liftChoice = userChoice.nextLine();

    if(liftChoice.equals("Y")) {
        disableLifts();

  }
    else {
    	System.out.println("Lights not activated");
    } 
	    
	//LOG DATABASE
System.out.println("Would you like to log this in the database? Y/N ");

// String input
String esChoice = userChoice.nextLine();

if(esChoice.equals("Y")) {
logDB();

}
else {
System.out.println("Fire not logged");
