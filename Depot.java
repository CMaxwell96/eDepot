package eDepotSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Depot {
	
	private Driver driver;
	private eDepotSystem Systems;

	

	public Depot() {
		
		System.out.println("Welcome to the eDepotSystem\n");
		
		System.out.println("Please the following details to gain access to the system\n");      
		LogOn(); // Call LogOn method 
		
	}
	
	public void LogOn(){	
		
		//Declared Variables for later use 
		
		String userName = null;
		String Password = null; 
		Driver loggedInUser = null;
		Scanner s = new Scanner(System.in);
		String csvFile = "Users.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        //ArrayList to store DriverObjects 
        List<Driver> listOfUsers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) { // Try to real file if cant throw error message, While the file next input isnt null continue to read each line
            while ((line = br.readLine()) != null) { 

                // use comma as separator, split lines by comma and store them in string array 

                String[] sysusers = line.split(cvsSplitBy);  
               
                listOfUsers.add(new Driver(sysusers[0], sysusers[1], sysusers[2],sysusers[3])); // Create new object then add to list of usersarray

            }
// error Handling 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		 
        System.out.println("Enter Username: ");
		userName = s.nextLine();
		System.out.println("Enter Password: ");
		Password = s.nextLine();
		
	
		  for (Driver user : listOfUsers) // for the length of listofUsers array 
	        {
	            if (user.getUserName().equals(userName)) // if user input matches username on system 
	            {
	                if (user.getPassWord().equals(Password)) // if user name is match and password is match on same line 
	                {
	                    loggedInUser = user; // then that data is passed into a new Driver object called Logged in user

	                    // when a user is found, "break" stops iterating through the list
	                    break;
	                }
	            }
	        }
		  
		  
		
		  if (loggedInUser != null) //if object is not empty 
	        {
	            System.out.println("\nUser successfully logged in: "+loggedInUser.getUserName() + "\nUser Role: " + loggedInUser.getRole()); // print user name and role in company 
	            
	            
	            if(loggedInUser.getRole().equals("Manager")) { // if user role is manager present the manager menu with more options 
	            	eDepotSystem.ManagerMenu();
	            } else if(loggedInUser.getRole().equals("Driver")) { // if regular driver show them only basic options
	            	eDepotSystem.DriverMenu();
	            }
	        }
	        else
	        {
	            System.out.println("Invalid username/password combination"); // if neither present message
	            LogOn();
	        }
		
		
		
	}

	
	public Vehicle GetVehicle() {
		return null;
		
	}
	
	public Driver GetDriver() {
		return null;
		
	}
	
	public void makeJob(WorkSchedule job) {
		jobs.add(job);
		job.getDepotLocation();
		job.getDriver();
		job.getVehicle();
		job.getClient();
		job.getStartDate();
		job.getEndDate();

	}

	public void makeJob(String jobRef, Depot location, Driver driver, Vehicle vehicle, LocalDateTime jobStartDate) throws Exception {
		
	}
	public WorkSchedule getNextJob() {
		
		jobs.sort(Comparator.comparing(o -> o.getStartDate()));
		
		return jobs.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
		
	}
}



