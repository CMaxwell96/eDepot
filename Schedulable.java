
import java.util.List;

public interface Scheduleable {
	public Boolean isAvailable(String startDate, String endDate);
	public void addSchedule(WorkSchedule workShedule);
	public List<WorkSchedule> getSchedule();
	
	
}
