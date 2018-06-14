package JohnsonAlg.JohnsonAlg;
import java.util.ArrayList;

public class TaskManager {

	  public static ArrayList<Task> tasks = new ArrayList<Task>();
	  
	  public static MachineManager mm = new MachineManager();
	  
	  
	  public static void addTask(Task task){
	    tasks.add(task);
	  }
	  
	  public static void displayAllTasks(){
	    App.print("\n");
	    for (Task task : tasks){
	      App.print("Task " + "Z" + task.getTaskNumber() + ": "
	              + task.getDurations() + " T1: " + task.getModedTime1() + " T2: "
	              + task.getModedTime2());
	    }
	    
	  }
	  
	  public static void calculateModedDurations(){
		  
	    for (Task task : tasks){
	    	
	      int modedTime1 = task.getDurations().get(0) + task.getDurations().get(1);
	      int modedTime2 = task.getDurations().get(1) + task.getDurations().get(2);
	      
	      task.setModedTime1(modedTime1);
	      task.setModedTime2(modedTime2);
	    }
	    
	  }
	  
	  public static void prepareSchedules() {
		  
		  Priority priority = new Priority();
		  
		  for(Task task : tasks){
			  if (task.getModedTime1() < task.getModedTime2()) {
				  task.setN(1);
				  priority.addN1(task);
			  }
			  else if (task.getModedTime1() >= task.getModedTime2()) {
				  task.setN(2);
				  priority.addN2(task);
			  }
		  }
		  
		  priority.schedule();
		  priority.printSchedule();
		  
		  ArrayList<Task> schedule = priority.getSchedule();

		  int time = 0;
		  
		  for (Task task : schedule){
			  
		      for (int i = 0; i < task.getDurations().get(0); i++)
		          	mm.machines.get(0).getSchedule().add(task);
		      
		      for (int i = 0; i < task.getDurations().get(1); i++){
		    	  
		        if (mm.machines.get(0).getSchedule().size() > time)
		        {
		          if (mm.machines.get(0).getSchedule().get(time).getTaskNumber() == task.getTaskNumber())
		          {
		            mm.machines.get(1).getSchedule().add(new Task(0, new ArrayList<Integer>(), 0, 0));
		            i--;
		          }
		        }
		        else
		        {
		          mm.machines.get(1).getSchedule().add(task);
		        }
		        time++;
		      }
		  }
		  
		  time = 0;
		  
		  for (Task task : schedule){
			  
		      for (int i = 0; i < task.getDurations().get(2); i++){
		    	  
		        if (mm.machines.get(0).getSchedule().size() > time && mm.machines.get(1).getSchedule().size() > time)
		        {
		          if (mm.machines.get(0).getSchedule().get(time).getTaskNumber() == task.getTaskNumber() || mm.machines.get(1).getSchedule().get(time).getTaskNumber() == task.getTaskNumber())
		          {
		            mm.machines.get(2).getSchedule().add(new Task(0, new ArrayList<Integer>(), 0, 0));
		            i--;
		          }
		          else
		          {
		            mm.machines.get(2).getSchedule().add(task);
		          }
		          time++;
		        }
		        else
		        {
		          mm.machines.get(0).getSchedule().add(new Task(0, new ArrayList<Integer>(), 0, 0));
		          mm.machines.get(1).getSchedule().add(new Task(0, new ArrayList<Integer>(), 0, 0));
		          i--;
		        }
		        
		      }
		      
		   }

		    int longestSchedule = 0;
		    
		    for (Machine machine : mm.machines)
		      if (longestSchedule < machine.getSchedule().size())
		          	longestSchedule = machine.getSchedule().size();
		    

		    for (Machine machine : mm.machines)		    
		      while (machine.getSchedule().size() < longestSchedule)
		           machine.getSchedule().add(new Task(0, new ArrayList<Integer>(), 0, 0));
		    
		    for (int i = 0; i < longestSchedule; i++){
		      if (mm.machines.get(0).getSchedule().get(i).getTaskNumber() == 0 &&
		    		  mm.machines.get(1).getSchedule().get(i).getTaskNumber() == 0 &&
		    		  	mm.machines.get(2).getSchedule().get(i).getTaskNumber() == 0) {
		        mm.machines.get(0).getSchedule().remove(i);
		        mm.machines.get(1).getSchedule().remove(i);
		        mm.machines.get(2).getSchedule().remove(i);
		      }
		    }
		    
		    System.out.println("\nCmax = "+(longestSchedule-1));
	  }
}
