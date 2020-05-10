package eDepotSystem;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import eDepotSystem.Vehicle;
import eDepotSystem.Driver;

public class WorkSchedule {
	
	private static List<WorkSchedule> workSchedule = new ArrayList<WorkSchedule>();
	private String jobRef;
	private  String depotLocation;
	private Vehicle vehicle;
	private Driver driver;
	private String client;
	private static String startDate;
	private static String endDate;
	private String status;
	private boolean update = false;
	
	
	
	 //method construction for the work schedule array
		public WorkSchedule(String jobRef, String client, String depotLocation, Driver driver, Vehicle vehicle, String startDate, String endDate) throws Exception {
			
			this.jobRef = jobRef;
			this.client = client;
			this.depotLocation = depotLocation;
			this.startDate = startDate;
			this.endDate = endDate;
			
			setVehicle(vehicle);
			setDriver(driver);
		}
		public WorkSchedule(String jobRef, String client, String depotLocation, Vehicle vehicle, String startDate, String endDate) throws Exception{
			
			this.jobRef = jobRef;
			this.client = client;
			this.depotLocation = depotLocation;
			this.startDate = startDate;
			this.endDate = endDate;

			setVehicle(vehicle);
		}
		public WorkSchedule(String jobRef, String client, String depotLocation, Driver driver, String startDate, String endDate) throws Exception {
			
			this.jobRef = jobRef;
			this.client = client;
			this.depotLocation = depotLocation;
			this.startDate = startDate;
			this.endDate = endDate;
			
			setDriver(driver);
		}

		public WorkSchedule(String jobRef,  String depotLocation, String startDate) throws Exception {
			
			this.jobRef = jobRef;
			this.depotLocation = depotLocation;
			this.startDate = startDate;
			
			
		}
		
		
	
		private Driver setDriver(Driver driver) {
			return driver;
		}

		private Vehicle setVehicle(Vehicle vehicle) {
			return vehicle;
		}
		
	public String getClient() {
		return client;
	}

	public void setClient(String Client) {
		Client = client;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String StartDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String EndDate) {
		EndDate = endDate;
	}
	public String toString(){
		return this.getClass().getSimpleName() + " >> " +
				jobRef + " " +
				depotLocation + " " +
				client.toString()+" " +
				startDate.format(DateTimeFormatter.ofPattern("dd MM yy HH:mm"));
	}
	public String getDepotName() {
		return depotLocation;
	}
	public String getJobRef() {
		return jobRef;
	}

	public Boolean isUpdate(){
		return update;
	}

	public void setUpdate(Boolean update){
		this.update = update;
	}
	
	public static WorkSchedule getJobRef(String jobRef) {
		
		
		for (WorkSchedule j: workSchedule) {
			if (j.getJobRef().equals(jobRef)){
				return j;
				
			}
			}
		return null;
	}
	}



