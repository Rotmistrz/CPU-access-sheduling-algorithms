import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class SJF implements ProcessQueue {
	private ArrayList<Process> processes;
	
	public SJF() {
		processes = new ArrayList<Process>();
	}
	
	public SJF addProcess(Process p) {
		ListIterator<Process> it = processes.listIterator();
		
		Process current;
		
		while(it.hasNext()) {
			current = it.next();
			
			if(p.workTime < current.workTime) {
				it.set(p);
				it.add(current);
				return this;
			}
		}
		
		it.add(p);
		return this;
	}
	
	public double countAverageWaitingTime() {
		Iterator<Process> it = processes.iterator();
		
		int waitingTime = 0;
		int totalTime = 0;
		int n = 0;
		
		while(it.hasNext()) {
			n++;
			Process process = it.next();
			
			totalTime += waitingTime;
			waitingTime = process.workTime;
			
			System.out.println(process.id + " " + process.workTime + "(" + totalTime + ")");
		}
		
		double d = (double) totalTime/n;
		
		return d;
	}
}
