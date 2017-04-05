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
	
	public int countAverageWaitingTime() {
		Iterator<Process> it = processes.iterator();
		
		int waitingTime = 0;
		int totalWaitingTime = 0;
		int totalTime = 0;
		int n = 0;
		int realWaiting = 0;
		
		int wholeTime = 0;
		
		while(it.hasNext()) {
			n++;
			Process process = it.next();
			
			realWaiting = totalTime;
			
			waitingTime = realWaiting;
			totalTime += process.workTime + 5;

			totalWaitingTime += waitingTime;
		}
		
		return totalWaitingTime/n;
	}
}
