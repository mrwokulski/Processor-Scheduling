
public class Main
{
	
	
  public static void error(String text)
  {
	    System.out.println(text);
	    System.exit(0);
  }
	  
  public static void main(String args[])
  {   
    FileData.getData("data.txt");
    MachineManager.setSchedule();
    MachineManager.showSchedule();
  }
}