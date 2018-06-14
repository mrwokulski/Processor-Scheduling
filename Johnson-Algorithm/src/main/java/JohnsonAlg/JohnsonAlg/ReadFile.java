package JohnsonAlg.JohnsonAlg;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	//ilosc_maszyn
	//nr_zad czas1 czas2 czas3
	 static ArrayList<String> fileContent = new ArrayList<String>();
	  static ArrayList<ArrayList<String>> tasksFromFile = new ArrayList<ArrayList<String>>();

	  public static TaskManager tm = new TaskManager();
	  public static MachineManager mm = new MachineManager();

	  public static void prepareFile(String fileToPrepare)
	  {
	    Scanner in;
	    String filename = fileToPrepare;
	    String outString = new String();

	    try 
	    {
	      in = new Scanner(new FileReader(filename));
	      while(in.hasNextLine()) {
	          fileContent.add(in.nextLine());
	      }
	      in.close();
	    }
	    catch (FileNotFoundException e)
	    {
	      App.closeApp("Couldn't open " + filename + "!");
	    }

	    if (fileContent.isEmpty())
	    {
	      App.closeApp("File " + filename + " is empty!");
	    }
	    else
	    {
	      // przypadek, kiedy plik nie jest pusty
	      for (String line : fileContent){
	    	  
	        String[] splited = line.split(" ");
	        ArrayList<String> splitResult = new ArrayList<String>();
	        for (String part : splited)
	        {
	          splitResult.add(part);
	        }
	        tasksFromFile.add(splitResult);
	      }

	      int machinesNumber = Integer.parseInt(tasksFromFile.get(0).get(0));
	      
	      if (machinesNumber <= 0)
	    	  App.closeApp("Err: Number of machines <= 0!");
	      

	      for (int i = 0; i < machinesNumber; i++)
	        mm.addMachine(new Machine((i+1), new ArrayList<Task>()));
	      

	      for (int i = 1; i < tasksFromFile.size(); i++){
	    	  
	        int taskNumber = Integer.parseInt(tasksFromFile.get(i).get(0));
	        if(taskNumber > tasksFromFile.size() - 1)
	        {
	          App.closeApp("Err: Tasks are not in proper order in the file.");
	        }
	        tm.addTask(new Task(taskNumber, new ArrayList<Integer>(), 0, 0));
	      }
	      

	      for (int i = 1; i < tasksFromFile.size(); i++){
	    	  
	        if (tasksFromFile.get(i).size() < mm.machines.size() + 1)
	          App.closeApp(tasksFromFile.get(i) + " - podano za mało argumentów! Powinno być: " + (mm.machines.size()+1));
	      
	        else if (tasksFromFile.get(i).size() > mm.machines.size() + 1)
	          App.closeApp(tasksFromFile.get(i) + " - podano za dużo argumentów! Powinno być: " + (mm.machines.size()+1));
	        
	        else {
	        	
	          int taskNumber = Integer.parseInt(tasksFromFile.get(i).get(0));
	          ArrayList<Integer> durations = new ArrayList<Integer>();
	          int max=0;
	          int machine=0;
	          int prevMachine=0;
	          for (int j = 1; j <= mm.machines.size(); j++)
	          {
	            int duration = Integer.parseInt(tasksFromFile.get(i).get(j));
	            if (max < duration) {
					max = duration;
					machine=j;		
				}
				if(machine==2)App.closeApp("Machine 2 is dominating 1 and 3");
				if(j>1 && machine!=prevMachine) App.closeApp("Machine 2 is dominated by different machines");
				prevMachine=machine;
	            durations.add(duration);
	          }
	          tm.tasks.get(taskNumber-1).setDurations(durations);
	          
	        }
	      }
	      
	    }
	    
	  }
}