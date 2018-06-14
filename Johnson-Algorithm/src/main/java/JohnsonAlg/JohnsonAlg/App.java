package JohnsonAlg.JohnsonAlg;

public class App {
	
	 public static TaskManager tm = new TaskManager();
	 public static MachineManager mm = new MachineManager();
	  public static ReadFile rf = new ReadFile();
	  public static Graphic g =  new Graphic();
	 
	 public static void print(String text)
	  {
	    System.out.println(text);
	  }
	 
	  public static void clearScreen()
	  {
	    System.out.print("\033[H\033[2J");
	  }
	  
	  public static void closeApp(String text)
	  {
	    print(text);
	    System.exit(0);
	  }
	  
	  
	  public static void main(String args[]) {
		  
		  String filename = "data.txt";
		  rf.prepareFile(filename);
		  tm.calculateModedDurations();
		  tm.prepareSchedules();
		  tm.displayAllTasks();
		  mm.displayAllMachines();
		  g.tasks = tm.tasks;
		  g.schedule = mm.machines;
		  g.makeChart();
	  }
}
