import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class App {
	
	static TaskManagement taskmanager = TaskManagement.getInstance();
	  
	public static void main(String[] args) throws IOException {
		 try {
	            readFromFile("data2.txt");
	        } catch(IOException e){
	            System.out.println("Could not read the file.");
	            e.printStackTrace();
	        }

	        if(!taskmanager.hasCycle()){
	        	taskmanager.calculateTimes();
	        	taskmanager.critPathMethod();
	        	taskmanager.print();
	        	taskmanager.printCritPath();
	        }
	}
	
	private static int[] convertToInt(String data){
        return Arrays.stream(data.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
	
	  public static void readFromFile(String fileName) throws IOException {
		  
	        BufferedReader br = new BufferedReader(new FileReader(fileName));
	        String nextLine;
	        while((nextLine = br.readLine()) != null){
	        	
	            String[] data = nextLine.split(",");
	            int[] node = convertToInt(data[0]);
	            if(node.length != 2) throw new IllegalArgumentException("Error. Dane_txt nie ma konstrukcji line=[nr czas, poprzednie_nodes]!");
	            taskmanager.addTask(node[0], node[1]);
	
	            if(data.length == 2){
	                int[] prev = convertToInt(data[1]);
	                for(int taskNr : prev){
	                	taskmanager.connect(taskNr, node[0]);
	                }
	            }
	        }
	    }
}
