package JohnsonAlg.JohnsonAlg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Priority {

	ArrayList<Task> schedule = new ArrayList<Task>();
	ArrayList<Task> n1 = new ArrayList<Task>();
	ArrayList<Task> n2 = new ArrayList<Task>();
	
	public void setSchedule(ArrayList<Task> schedule) {
		this.schedule = schedule;
	}
	
	public ArrayList<Task> getSchedule() {
		return this.schedule;
	}
	
	public void addN1(Task task) {
		n1.add(task);
	}
	
	public void setN1(ArrayList<Task> n1) {
		this.n1 = n1;
	}
	
	public ArrayList<Task> getN1() {
		return this.n1;
	}
	
	public void addN2(Task task) {
		n2.add(task);
	}
	
	public void setN2(ArrayList<Task> n2) {
		this.n2 = n2;
	}
	
	public ArrayList<Task> getN2() {
		return this.n2;
	}
	
	public void sortN1() {
		
		Collections.sort(n1, new Comparator<Task>()
	    {
	      public int compare(Task task1, Task task2)
	      {
	        return task1.getModedTime1() - task2.getModedTime1();
	      }
	    });
	}
	
	public void sortN2() {
		Collections.sort(n2, new Comparator<Task>()
	    {
	      public int compare(Task task1, Task task2)
	      {
	        return task2.getModedTime2() - task1.getModedTime2();
	      }
	    });
	}
	
	public void schedule() {
		
		this.sortN1();
		this.sortN2();
		
		for(Task task : n1) 
			schedule.add(task);
		
		for(Task task : n2) 
			schedule.add(task);
		
	}
	
	public void printSchedule() {
		
		App.print("\nSchedule for tasks:");
		String sch = "->";
		
		for(Task task : schedule) {
			sch+=" Z"+task.getTaskNumber()+" ->";
		}
		
		App.print(sch);
	}
}
