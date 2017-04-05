import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class SJF implements ProcessQueue {
	protected LinkedList<Process> processes;
	protected FCFS fcfs;
	protected int time;
	
	public SJF() {
		processes = new LinkedList<Process>();
		time = 0;
		fcfs = new FCFS();
	}
	
	public SJF addProcess(Process p) {
		ListIterator<Process> it = processes.listIterator();
		
		fcfs.addProcess(p);
		
		Process current;
		int currentTime = 0;
		time = 0;
		int real = 0; // last process come time
		
		while(it.hasNext()) {
			current = it.next();
			
			if(p.comeTime <= current.comeTime) {
				if(p.workTime < current.workTime) {
					it.set(p);
					it.add(current);
					return this;
				} else {

				}
			} else {
				if(p.workTime < current.workTime) {
					if(p.comeTime > current.comeTime) {
						it.add(p);
						return this;
					}
				}
			}
		}
		
		it.add(p);
		return this;
	}
	
	public int countAverageWaitingTime() {
		int n = 1000; // amount of loop iteration
		int totalTime = 0;
		int i = 0;
		
		totalTime += fcfs.countAverageWaitingTime();
		i++;
		
		for(int j = 0; j < n; j++) {
			totalTime += countSingleAverageWaitingTime();
			i++;
		}
		
		return totalTime / i;
	}
	
	public int countSingleAverageWaitingTime() {
		Iterator<Process> it = processes.iterator();
		
		int processesNumber = processes.size();
		int waitingTime = 0;
		int totalWaitingTime = processesNumber * processesNumber;
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
