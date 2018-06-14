import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskManagement {

    private ArrayList<Task> tasks;
    private ArrayList<Task> critPath;
    private int critPathTime;
    
    private static TaskManagement instance = new TaskManagement();
    public static TaskManagement getInstance() {
        return instance;
    }
    
    private TaskManagement() {
        tasks = new ArrayList<>();
        critPath = new ArrayList<>();
    }

    public List<Task> getAll(){
    	return tasks;
    }
    
    public Task getOne(int nr){
    	
        for(Task task : tasks)
            if(task.getNr() == nr) return task;
        
        return null;
    }
    
    public void addTask(int number, int duration){
        tasks.add(new Task(number, duration));
    }

    public void connect(int prevNr, int nextNr){
    	
        if(prevNr >= nextNr) 
        	throw new IllegalArgumentException("Previous-process must occur before after-process.");
        Task prev = getOne(prevNr);
        Task next = getOne(nextNr);

        prev.addAfterTasks(next);
        next.addPreviousTasks(prev);
    }
    
    public void calculateTimes() {
    	
	   for(Task task : tasks){
           if(task.getPrev().isEmpty()){
               task.setEarlyS(0);
               task.setEarlyF(task.getTime());
           } 
           else {
        	   int[] finishTimes = new int[task.getPrev().size()];
        	   
               for (int i = 0; i < task.getPrev().size(); i++)
                  finishTimes[i] = task.getPrev().get(i).getEarlyF();
               
               Arrays.sort(finishTimes);
               int maxFinishTime = finishTimes[finishTimes.length - 1];
               task.setEarlyS(maxFinishTime);
               task.setEarlyF(task.getEarlyS() + task.getTime());
           }
       }
    }
    
    public void setCritPath(List<Task> path){
    	
        Task prevTask = path.stream()
                .max(Comparator.comparingInt(Task::getEarlyF))
                .get();
        
        critPath.add(prevTask);
        if(!prevTask.getPrev().isEmpty())
            setCritPath(prevTask.getPrev());
    }
    
    public ArrayList<Task> getCriticalPath(){
    	return critPath;
    }
    
    public void critPathMethod() {
    	
    	setCritPath(tasks);
	    critPathTime = critPath.get(0).getEarlyF();
	    Collections.reverse(critPath);
	    System.out.print("Critical path: ");
	    for(Task task : critPath)
	          System.out.print("Z" + task.getNr() + " ");
	
	    System.out.println("\nCritical Path Time: " + critPathTime);
      }
    
    public void printCritPath() { 
    	String harm = "START		";
    	for(Task task : critPath) {
    		harm += "Z"+task.getNr()+"| Start: "+task.getEarlyS()+"  Finish: "+task.getEarlyF()+" Time:"+task.getTime()+" |";
    		System.out.println(harm);
    		harm += " --->";
    	}
    }
    
    public boolean hasCycle() {
	    List<Integer> visited = new ArrayList<>();
	    for (int i = 0; i < tasks.size(); ++i) {
	      if (hasCycle(i, visited)) {
	        return true;
	      }
	    }
		return false;
	  }

    private boolean hasCycle(int node, List<Integer> visited) {
        if (visited.contains(node)) {
          return true;
        }
        visited.add(node);
        for (Task task : tasks.get(node).getAfter()) {
          if (hasCycle(task.getNr(), visited)) {
            return true;
          }
        }
        visited.remove(visited.size() - 1);
        return false;
      }
    
    public void print() {
            System.out.printf("%6s | %6s | %6s | %6s | %-13s | %-13s\n", "TASK", "TIME", "START", "END", "PREVIOUS_NODES", "NEXT_NODES");
            String prev ="";
            String after ="";
            
            for(Task task : tasks){
            	
            	prev="";
            	after="";
            	for(Task i : task.getPrev())
            		prev += " "+i.getNr();
            	
            	for(Task j : task.getAfter())
               	 	after += " "+j.getNr();
            	
                System.out.printf("%6d | %6d | %6d | %6d | %-13s | %-13s\n", task.getNr(), task.getTime(), task.getEarlyS(), task.getEarlyF(), prev, after);
            }

            System.out.println("================================================================");
    }

}



