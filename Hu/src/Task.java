import java.util.ArrayList;

public class Task {
	private int taskNumber; // numer zadania
	private int duration = 1; // czas trwania
	private ArrayList<Task> prevTasks = new ArrayList<Task>();
	private ArrayList<Task> nextTasks = new ArrayList<Task>(); // zadania oczekujące na obecne
	private Boolean isCompleted = false; 
	private int forest = 0;
	private int outTree = 0;
	
	public Task() {

	}

	public Task(int taskNumber) {
		this.taskNumber = taskNumber;
	}
	
	public int getForest() {
		return forest;
	}

	public void setForest(int forest) {
		this.forest = forest;
	}

	public int getOutTree() {
		return outTree;
	}

	public void setOutTree(int outTree) {
		this.outTree = outTree;
	}

	public int getTaskNumber() {
		return taskNumber;
	}

	public void setTaskNumber(int taskNumber) {
		this.taskNumber = taskNumber;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public ArrayList<Task> getPrevTasks() {
		return prevTasks;
	}

	public void setPrevTasks(ArrayList<Task> prevTasks) {
		this.prevTasks = prevTasks;
	}

	public ArrayList<Task> getNextTasks() {
		return nextTasks;
	}

	public void setNextTasks(ArrayList<Task> nextTasks) {
		this.nextTasks = nextTasks;
	}

	public Boolean getIsCompleted() {
		return this.isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
}
