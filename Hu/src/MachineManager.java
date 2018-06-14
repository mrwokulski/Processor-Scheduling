import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MachineManager
{
  public static ArrayList<Machine> machines = new ArrayList<Machine>();
  public static void addMachine(Machine machine)
  {
    machines.add(machine);
  }

  public static void displayScheduleList(ArrayList<Task> tasksToSchedule)
  {
    if (!tasksToSchedule.isEmpty())
    {
      System.out.print("   ");
      for (Task task : tasksToSchedule)
      {
        if (task.getTaskNumber() == 0)
        {
          System.out.print("(0) ");
        }
        else
        {
          String taskToDisplay = "Z" + task.getTaskNumber();
          while (taskToDisplay.length() < 3)
          {
            taskToDisplay = " " + taskToDisplay;
          }
          System.out.print(taskToDisplay + " ");
        }
      }
    }
    else
    {
      System.out.print("empty");
    }
  }

  public static void showSchedule()
  {
    System.out.println("\n\n-------------------------");

    int max = 0;
    for (Machine machine : machines)
    {
      if (max < machine.getSchedule().size())
      {
        max = machine.getSchedule().size();
      }
    }

    System.out.println("Time");
    System.out.print("   ");
    for (int i = 1; i <= max; i++)
    {
      String numberToDisplay = new String();
      numberToDisplay = numberToDisplay + i;
      while (numberToDisplay.length() <  3)
      {
        numberToDisplay = " " + numberToDisplay;
      }
      System.out.print(numberToDisplay + " ");
    }
    System.out.print("\n");

    for (Machine machine : machines)
    {
      System.out.println("Machine " + "M" + machine.getMachineNumber());
      displayScheduleList(machine.getSchedule());
      System.out.print("\n");
    }
  }

  public static void setSchedule()
  {
	  if (TaskManager.sum == 1) {
			int outTree = 0;
			for (Task task : TaskManager.tasks) {
				outTree += task.getOutTree();
			}
			if (outTree == TaskManager.tasks.size()) {
				System.out.println("Tree is out-tree");
				for(Task task : TaskManager.tasks){
					ArrayList<Task> prevTasks = task.getPrevTasks();
					task.setPrevTasks(task.getNextTasks());
					task.setNextTasks(prevTasks);
				}
				Collections.reverse(TaskManager.tasks);
			}
		} else {

			System.out.println("in-tree correct");
			if (TaskManager.sum != TaskManager.tasks.get(TaskManager.tasks.size() - 1).getForest()) {
				Main.error("Error detected");
			}
		}
	  
    while (!TaskManager.isFinished(TaskManager.tasks))
    {
      ArrayList<Task> availableTasks = new ArrayList<Task>();
      ArrayList<Task> tasksToMachines = new ArrayList<Task>();

      for (Task task : TaskManager.tasks)
        if (task.getPrevTasks().isEmpty() && !task.getIsCompleted())
          availableTasks.add(task);
    
      System.out.println("\nKolejna iteracja przez podane zadania o tym samym poziomie:");
      for (Task task : availableTasks){
    	  System.out.println(task.getTaskNumber());
      }

      if (availableTasks.size() <= machines.size())
      {
        tasksToMachines = availableTasks;
        while (tasksToMachines.size() < machines.size())
        {
          tasksToMachines.add(new Task(0));
        }
      }
      else
      {
        for (int i = 0; i < machines.size(); i++)
        {
          tasksToMachines.add(i, availableTasks.get(i));
        }
      }
      System.out.println("\nZadania wchodzace do maszyn:");
      int j=1;
      for (Task task : tasksToMachines){
    	  System.out.println("M"+j+": "+task.getTaskNumber());
    	  j++;
      }
      j=0;
      for (int i = 0; i < machines.size(); i++)
      {
        Task taskToProceed = tasksToMachines.get(i);
        machines.get(i).getSchedule().add(taskToProceed);
        TaskManager.completeTaskByNumber(taskToProceed.getTaskNumber());
      }
    }
  }
  
  

  
}
