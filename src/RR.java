import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class RR implements ProcessQueue {
	private ArrayList<Process> processes;
	private int timeQuantum = 10;
	private int wholeTime;
	
	public RR(int timeQuantum) {
		processes = new ArrayList<Process>();
		this.timeQuantum = timeQuantum;
	}
	
	public RR addProcess(Process p) {
		processes.add(p);
		wholeTime += p.workTime;
		
		return this;
	}
	
	public int countAverageWaitingTime() {
		ListIterator<Process> it;
		ArrayList<Process> tmp = (ArrayList<Process>) processes.clone();
		
		int waitingTime = 0;
		int totalTime = 0;
		int n = tmp.size();
		int timeToAdd = 0;
		
		int tmpTime = 0;
		Process tmpProcess = null;
		Process process;
		
		boolean flag = false;
		
		while(countActiveProcessNumber(tmp) > 1) {
			it = tmp.listIterator();
			
			while(it.hasNext()) {	
				process = it.next();
				
				if(!process.active) {
					continue;
				}
				
				//System.out.println("tmpTime = " + tmpTime + " totalTime = " + totalTime);
				
				if(process.comeTime <= totalTime) {
					flag = false;
				}
				
				if(process.comeTime > totalTime && !flag) {
					tmpTime = totalTime;
					tmpProcess = process;
					
					continue;
				} else if(tmpTime == totalTime && flag) {
					totalTime = process.comeTime;
				}
				
				//System.out.println(process.id + " " + process.workTime + "(" + totalTime + ")");
				
				if(process.workTime > timeQuantum) {
					timeToAdd = timeQuantum;
					
					process.workTime -= timeQuantum;
					
				} else {
					timeToAdd = process.workTime;
					process.deactivate();
				}
				
				
				
				totalTime += timeToAdd + 2;
				
				process.increaseWaitingTime(totalTime - process.lastWaitingTime);
				
				process.lastWaitingTime = totalTime;
				
				if(countActiveProcessNumber(tmp) == 1) {
					break;
				}
			}
			
			flag = true;
		}
		
		it = tmp.listIterator();
		
		double tt = 0;
		int i = 0;
		
		while(it.hasNext()) {
			process = it.next();
			i++;
			tt += process.waitingTime;
		}
		
		//System.out.println("Czas wszystkich procesów: " + wholeTime);
		
		//double d = (double) tt/i;
		
		return (int) tt/i;
	}
	
	public int countActiveProcessNumber(ArrayList<Process> proc) {
		ListIterator<Process> it;
		
		it = proc.listIterator();
		
		int n = 0;
		
		while(it.hasNext()) {
			Process current = it.next();
			
			if(current.active) {
				n++;
			}
		}
		
		return n;
	}
}