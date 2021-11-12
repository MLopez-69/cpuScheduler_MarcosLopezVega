package models;

public class priorityScheduler extends ganttChart{
	private int maxValue;
	private int priorityMax;
	//max is going to store the largest priority
	private int processCount; 
	//count in this algorithm is going to use the count to keep track of the number of processes
	
	
	public priorityScheduler(int maxInt) {
		super();
		maxValue=maxInt;
		priorityMax=0;
		processCount=0;
	}

	public void queue(process process,int Priority) {

		ganttCell newCell= new ganttCell(process);
		newCell.setPriority(Priority);
		setMaxIfLarger(Priority);
		addCell(newCell);
		processCount++;
		
	}

	
	public float calculateWaitTime() {
		float waitTime=0;
		int count=0;
		 while(count<processCount) {
			 ganttCell newCell= getCell();
			 waitTime+=newCell.getWaitTime();
			 addCell(newCell);
			 count++;
		 }
		 waitTime=waitTime/processCount;
		return waitTime;
	}
	
	public float calculateTATime() {
		float taTime=0;
		int count=0;
		 while(count<processCount) {
			 ganttCell newCell= getCell();
			 taTime+=newCell.getTaTime();
			 addCell(newCell);
			 count++;
		 }
		 taTime=taTime/processCount;
		return taTime;
	}
	
	public void setTimes() {
		int previousTATime=0;
		int maxCounter=0;// keeps track of priority values
		
		while(maxCounter<=priorityMax) {//max counter deals with the values
			
			int count=0;	
			while(count<processCount) { //goes through linked list
				ganttCell newCell=getCell();
				
				if(newCell.getPriority()==maxCounter) {// 
				newCell.setWaitTime(previousTATime);
				previousTATime+=newCell.getProcess().getBurstTime();
				newCell.setTaTime(previousTATime);
				System.out.println(newCell);
				}
				addCell(newCell);
				count++;
			}
			maxCounter++;
		}
		System.out.println();
	}

	

	public int getPriorityMax() {
		return priorityMax;
	}

	public void setPriorityMax(int priorityMax) {
		this.priorityMax = priorityMax;
	}

	private void setMaxIfLarger(int newMax) {
		if(priorityMax<newMax) {
			priorityMax=newMax;
		}
	}
	
	public void clearPriority() {
		clear();
		priorityMax=0;
		processCount=0;
	}
	
	
}
