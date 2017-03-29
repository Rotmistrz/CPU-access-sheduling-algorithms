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
			totalTime += process.workTime + 2;

			totalWaitingTime += waitingTime;
			
			//wholeTime += process.workTime;
			
			//System.out.println(process.id + " " + process.workTime + "(" + totalWaitingTime + ")");
		}
		
		//System.out.println("Czas wszystkich procesów: " + totalTime);
		
		// double d = (double) totalWaitingTime/n;
		
		return (int) totalWaitingTime/n;
	}
	
	public double oldCountAverageWaitingTime() {
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
			
			realWaiting = totalTime - process.comeTime;
			
			if(realWaiting >= 0) {
				waitingTime = realWaiting;
				totalTime += process.workTime;
			} else {
				waitingTime = 0;
				totalTime += (Math.abs(realWaiting) + process.workTime);
			}

			totalWaitingTime += waitingTime;
			
			wholeTime += process.workTime;
			
			System.out.println(process.id + " " + process.workTime + "(" + totalWaitingTime + ")");
		}
		
		System.out.println("Czas wszystkich procesów: " + wholeTime);
		
		// double d = (double) totalWaitingTime/n;
		
		return (int) totalWaitingTime/n;
	}
}
