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
			
			/**if(time < current.comeTime) {
				real = current.comeTime + current.workTime;
			} else {
				real = current.workTime;
			}
			
			time += real;**/
			
			/**if(p.workTime < current.workTime && p.comeTime <= time) {
				it.set(p);
				it.add(current);
				return this;
			}**/
		}
		
		//time = time + p.comeTime + p.workTime;
		
		it.add(p);
		return this;
	}
	
	public int countAverageWaitingTime() {
		int n = 15; // amount of loop iteration
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
			
			//wholeTime += process.workTime;
			
			//System.out.println(process.id + " " + process.workTime + "(" + totalWaitingTime + ")");
		}
		
		//System.out.println("Czas wszystkich procesów: " + totalTime);
		
		// double d = (double) totalWaitingTime/n;
		
		return (int) totalWaitingTime/n;
	}
	
	public double oldCountAverageWaitingTime() { // 30.03.2017
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

			totalWaitingTime += waitingTime + 2;
			
			wholeTime += process.workTime;
			
			System.out.println(process.id + " " + process.workTime + "(" + totalWaitingTime + ")");
		}
		
		System.out.println("Czas wszystkich procesów: " + wholeTime);
		
		//double d = (double) totalWaitingTime/n;
		
		return totalWaitingTime/n;
	}
	
	/**
	 * public double countAverageWaitingTime() {
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
	} **/
}
