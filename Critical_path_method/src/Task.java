import java.util.ArrayList;
import java.util.List;

public class Task {
	
	private int nr;
	private int time;
	private int earlyStart;
	private int earlyFinish;
	private int lateStart;
	private int lateFinish;
	List<Task> prev;
	List<Task> after;
	
	public Task(int time, int earlyStart, int earlyFinish, int lateStart, int lateFinish, List<Task> prev, List<Task> after) {
		
		this.time = time;
		this.earlyStart = earlyStart;
		this.lateStart = lateStart;
		this.lateFinish = lateFinish;
		this.prev = prev;
		this.after = after;
	}
	
	public Task(int nr, int time) {
		this.nr = nr;
		this.time = time;
        prev = new ArrayList<>();
        after = new ArrayList<>();
	}
	
	public int getNr( ) {
		return this.nr;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getEarlyS() {
		return this.earlyStart;
	}
	
	public int getEarlyF() {
		return this.earlyFinish;
	}
	
	public int getLateS() {
		return this.lateStart;
	}
	
	public int getLateF() {
		return this.lateFinish;
	}
	
	public List<Task> getPrev() {
		return this.prev;
	}
	
	public List<Task> getAfter() {
		return this.after;
	}
			
	public void setNr (int nr) {
		this.nr = nr;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void setEarlyS(int earlyStart) {
		this.earlyStart = earlyStart;
	}
	
	public void setEarlyF(int earlyFinish) {
		this.earlyFinish = earlyFinish;
	}
	
	public void setLateS(int lateStart) {
		this.lateStart = lateStart;
	}
	
	public void setLateF(int lateFinish) {
		this.lateFinish = lateFinish;
	}

	public void setPreviousTasks(List<Task> prev) {
		this.prev = prev;
	}
	
	public void setNextTasks(List<Task> after) {
		this.after = after;
	}
		
	public void addPreviousTasks(Task prevTask){
        prev.add(prevTask);
    }
    public void addAfterTasks(Task afterTask){
        after.add(afterTask);
    }

	
}
