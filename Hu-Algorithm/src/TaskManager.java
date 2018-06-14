import java.util.ArrayList;

public class TaskManager {
	public static ArrayList<Task> tasks = new ArrayList<Task>();
	public static int sum=0;
	
	public static void addTask(Task task) {
		tasks.add(task);
	}

	public static void addPrevNodes(int number1, int number2) {
		
		Task task1 = tasks.get(number1 - 1);
		Task task2 = tasks.get(number2 - 1);

		if (task1.getTaskNumber() == task2.getTaskNumber())
			Main.error("Connection with eachother");

		if (task1.getTaskNumber() > task2.getTaskNumber())
			Main.error("Higher number task, can't be before lower one");

		if (tasks.contains(task1) && tasks.contains(task2)) {
			task1.getNextTasks().add(task2);
			task2.getPrevTasks().add(task1);
			task2.setForest(task2.getForest()+task1.getForest());
			if(sum == 1) task2.setOutTree(1);
			task1.setForest(0);
		} else {
			Main.error("One of tasks, doesn't exist");
		}
	}

	public static Boolean isFinished(ArrayList<Task> tasks) {
		for (Task task : tasks) {
			if (!task.getIsCompleted())
				return false;
		}
		return true;
	}

	public static void removeFromPrev(Task taskToRemove) {
		for (Task task : tasks) {
			if (task.getPrevTasks().contains(taskToRemove)) {
				task.getPrevTasks().remove(taskToRemove);
			}
		}
	}

	public static void completeTaskByNumber(int taskNumber) {
		for (Task task : tasks) {
			if (task.getTaskNumber() == taskNumber) {
				task.setIsCompleted(true);
				tasks.remove(task);
				removeFromPrev(task);
				break;
			}
		}
	}
}
