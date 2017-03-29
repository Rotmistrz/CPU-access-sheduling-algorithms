import java.util.ListIterator;

public class SJFw extends SJF {
	
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
			} else if(p.workTime < current.workTime && currentTime < p.comeTime) {
				it.set(p);
				it.add(current);
				return this;
			}
			else {
				if(p.workTime < current.workTime && p.comeTime > current.comeTime) {
					it.add(p);
					return this;
				}
			}
			
			currentTime += current.workTime;
			
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
}
