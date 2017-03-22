import java.util.ArrayList;
import java.util.Iterator;

public class FCFS implements ProcessQueue {
	private ArrayList<Process> processes;
	
	public FCFS() {
		processes = new ArrayList<Process>();
	}
	
	public FCFS addProcess(Process p) {
		processes.add(p);
		
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
