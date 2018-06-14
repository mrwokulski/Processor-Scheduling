package JohnsonAlg.JohnsonAlg;
import java.util.ArrayList;
import java.util.Collection;

public class Task
{
  private int number;               // numer zadania
  private ArrayList<Integer> durations; // czasy trwania na maszynach
  private int modedTime1;             // zmodyfikowany czas wykonania 1
  private int modedTime2;             // zmodyfikowany czas wykonania 2
  private int n;

  public Task()
  {
    super();
  }

  public Task(int taskNumber, ArrayList<Integer> durations,
              int modedTime1, int modedTime2)
  {
    super();
    this.number = taskNumber;
    this.durations = durations;
    this.modedTime1 = modedTime1;
    this.modedTime2 = modedTime2;
  }
  
  public void setN(int n)
  {
	  this.n = n;
  }
  public int getN() 
  {
	  return this.n;
  }

  public int getTaskNumber()
  {
    return number;
  }
  public void setTaskNumber(int taskNumber)
  {
    this.number = taskNumber;
  }

  public ArrayList<Integer> getDurations()
  {
    return durations;
  }
  public void setDurations(ArrayList<Integer> durations)
  {
    this.durations = durations;
  }

  public int getModedTime1()
  {
    return modedTime1;
  }
  public void setModedTime1(int modDuration1)
  {
    this.modedTime1 = modDuration1;
  }

  public int getModedTime2()
  {
    return modedTime2;
  }
  public void setModedTime2(int modDuration2)
  {
    this.modedTime2 = modDuration2;
  }


}
