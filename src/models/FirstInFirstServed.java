package models;


public class FirstInFirstServed extends ganttChart implements calculations{
	private int max;
	int count;
	
	public FirstInFirstServed(int maxInt) {
		super();
		max=maxInt;
		count=0;
	}

	public void queue(process process) {
		ganttCell newCell= new ganttCell(process);
		addCell(newCell);
	}

	
	public float calculateWaitTime() {
		float waitTime=0;
		 while(count<max) {
			 ganttCell newCell= getCell();
			 waitTime+=newCell.getWaitTime();
			 addCell(newCell);
			 count++;
		 }
		 waitTime=waitTime/max;
		 count=0;
		return waitTime;
	}
	
	public float calculateTATime() {
		float taTime=0;
		 while(count<max) {
			 ganttCell newCell= getCell();
			 taTime+=newCell.getTaTime();
			 addCell(newCell);
			 count++;
		 }
		 taTime=taTime/max;
		 count=0;
		return taTime;
	}
	
	public void setTimes() {
		int previousTATime=0;
		while(count<max) {
			ganttCell newCell=getCell();
			if(count==0) {
				newCell.setWaitTime(0);
				int burstTime=newCell.getProcess().getBurstTime();
				newCell.setTaTime(burstTime);
				previousTATime=burstTime;
				System.out.println(newCell);
				
			}else {
				newCell.setWaitTime(previousTATime);
				int burstTime=newCell.getProcess().getBurstTime();
				previousTATime+=burstTime;
				newCell.setTaTime(previousTATime);
				System.out.println(newCell);
				
			}
			addCell(newCell);
			count++;
		}
		count=0;
		System.out.println();
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
	
}
