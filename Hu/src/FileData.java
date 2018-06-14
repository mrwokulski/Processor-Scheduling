import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileData {
	static ArrayList<String> fileData = new ArrayList<String>();
	static ArrayList<ArrayList<String>> fileTasks = new ArrayList<ArrayList<String>>();

	public static void getData(String fileName) {
		try {
			Scanner file = new Scanner(new FileReader(fileName));
			while (file.hasNextLine()) {
				fileData.add(file.nextLine());
			}
			file.close();
		} catch (FileNotFoundException e) {
			Main.error(e.getMessage());
		}
		for (String line : fileData) {
			String[] splited = line.split(" ");
			ArrayList<String> splitResult = new ArrayList<String>();
			for (String part : splited) {
				splitResult.add(part);
			}
			fileTasks.add(splitResult);
		}

		int machines = Integer.parseInt(fileTasks.get(0).get(0));

		for (int i = 1; i <= machines; i++)
			MachineManager.addMachine(new Machine(i));

		for (int i = 1; i < fileTasks.size(); i++) {
			int taskNumber = Integer.parseInt(fileTasks.get(i).get(0));
			Task task = new Task(taskNumber);
			if(fileTasks.get(i).size() == 1){
				TaskManager.sum += 1;
				task.setOutTree(1);
				task.setForest(1);
			}
			TaskManager.addTask(task);
		}

		for (int i = 2; i < fileTasks.size(); i++) {
			int taskNumber = Integer.parseInt(fileTasks.get(i).get(0));
			if(fileTasks.get(i).size()>1){
				for (int j = 1; j < fileTasks.get(i).size(); j++) {
					TaskManager.addPrevNodes(
							TaskManager.tasks.get(Integer.parseInt(fileTasks.get(i).get(j)) - 1).getTaskNumber(),
							TaskManager.tasks.get(taskNumber - 1).getTaskNumber());
				}
			}
		}
	}
}
