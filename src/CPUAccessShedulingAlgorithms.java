
public class CPUAccessShedulingAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FCFS fcfs = new FCFS();
		
		fcfs.addProcess(new Process(0, 0, 19));
		fcfs.addProcess(new Process(1, 1, 12));
		fcfs.addProcess(new Process(2, 2, 5));
		fcfs.addProcess(new Process(3, 3, 27));
		fcfs.addProcess(new Process(4, 4, 3));
		fcfs.addProcess(new Process(5, 5, 10));
		fcfs.addProcess(new Process(6, 6, 47));
		fcfs.addProcess(new Process(7, 7, 17));
		fcfs.addProcess(new Process(8, 8, 7));
		fcfs.addProcess(new Process(9, 9, 32));
		
		System.out.println(fcfs.countAverageWaitingTime());
		
		
		SJF sjf = new SJF();
		
		sjf.addProcess(new Process(0, 0, 19));
		sjf.addProcess(new Process(1, 1, 12));
		sjf.addProcess(new Process(2, 2, 5));
		sjf.addProcess(new Process(3, 3, 27));
		sjf.addProcess(new Process(4, 4, 3));
		sjf.addProcess(new Process(5, 5, 10));
		sjf.addProcess(new Process(6, 6, 47));
		sjf.addProcess(new Process(7, 7, 17));
		sjf.addProcess(new Process(8, 8, 7));
		sjf.addProcess(new Process(9, 9, 32));
		
		System.out.println(sjf.countAverageWaitingTime());
		
		RR rr = new RR();
		
		rr.addProcess(new Process(0, 0, 19));
		rr.addProcess(new Process(1, 1, 12));
		rr.addProcess(new Process(2, 2, 5));
		rr.addProcess(new Process(3, 3, 27));
		rr.addProcess(new Process(4, 4, 3));
		rr.addProcess(new Process(5, 5, 10));
		rr.addProcess(new Process(6, 6, 47));
		rr.addProcess(new Process(7, 7, 17));
		rr.addProcess(new Process(8, 8, 7));
		rr.addProcess(new Process(9, 9, 32));
		
		System.out.println(rr.countAverageWaitingTime());
	}

}
