import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessList {
	private LinkedList<Process> processes;
	
	public ProcessList() {
		this.processes = new LinkedList<Process>();
	}
	
	public ProcessList add(Process process) {
		ListIterator<Process> it = processes.listIterator();
		
		Process current;
		
		while(it.hasNext()) {
			current = it.next();
			
			if(process.comeTime < current.comeTime) {
				it.set(process);
				it.add(current);
				
				return this;
			}
		}
		
		it.add(process);
		
		return this;
	}
	
	public Iterator iterator() {
		return processes.iterator();
	}
	
	public ListIterator listIterator() {
		return processes.listIterator();
	}
	
	public static ProcessList createFromFile(String filename) throws IOException {
		ProcessList processList = new ProcessList();
		
		int id;
		int comeTime;
		int workTime;
		
		String line;
		String[] data;
		
		Scanner file = new Scanner(Paths.get(filename), "UTF-8");
		
		try {
			while((line = file.nextLine()) != null) {
				data = Base.split(line, " ");
	
				//id = Integer.parseInt(data[0]);
				comeTime = Integer.parseInt(data[0]);
				workTime = Integer.parseInt(data[1]);
				
				Process process = new Process(comeTime, workTime);
				
				processList.add(process);
			}
		} catch(NoSuchElementException e) {
			
		} catch(Exception e) {
			throw e;
		} finally {
			file.close();
		}
		
		return processList;
	}
}
