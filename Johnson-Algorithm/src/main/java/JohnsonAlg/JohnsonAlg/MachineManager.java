package JohnsonAlg.JohnsonAlg;
import java.util.ArrayList;

public class MachineManager {
	
	public static ArrayList<Machine> machines = new ArrayList<Machine>();

	  public static TaskManager tm = new TaskManager();
	  
	  
	  public static void addMachine(Machine machine){
	    machines.add(machine);
	  }

	  public static void displayAllMachines(){
		  
	    App.print("\n");
	    App.print("MACHINES:\n");

	    int longestSchedule = 0;
	    for (Machine machine : machines)
	    {
	      if (longestSchedule < machine.getSchedule().size())
	      {
	        longestSchedule = machine.getSchedule().size();
	      }
	    }

	    App.print("[Time]");
	    System.out.print("   ");
	    
	    for (int i = 0; i < longestSchedule; i++){
	      String myTime = "" + (i+1);
	      while (myTime.length() < 2) myTime = " " + myTime;
	      System.out.print(myTime + " ");
	    }
	    
	    System.out.print("\n");

	    for (Machine machine : machines){
	      App.print("[Machine " + "M" + machine.getMachineNumber() + "]");
	      System.out.print("   ");
	      
	      for (Task task : machine.getSchedule()){
	        if (task.getTaskNumber() == 0)
	        	System.out.print("-- ");
	        else
	          System.out.print("Z" + task.getTaskNumber() + " ");   
	      }
	      
	      System.out.print("\n");
	    }
	    
	  }
}
