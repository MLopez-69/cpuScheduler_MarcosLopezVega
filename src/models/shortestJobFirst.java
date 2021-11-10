package models;

import java.util.HashMap;
import java.util.TreeMap;


public class shortestJobFirst implements calculations{
	private HashMap<Integer,ganttCalculations> map;
	private int max;
	private int processCount; //made due to realization that the program deadlocks
	int count;

	public shortestJobFirst(int maxInt) {
		map=new HashMap<Integer,ganttCalculations>(maxInt);
		max=0;
		count=0;
		processCount=1;
	}
	
	public void addCell(process process) {
		ganttCalculations newCell= new ganttCalculations(process);
		//newCell.setPriority(processCount);	
		
		setMaxIfLarger(newCell.getProcess().getBurstTime());
		map.put(processCount, newCell);
		processCount++;
	}
	
	
	public ganttCalculations getCell(int burstTime) {
		return map.get(burstTime);
	}

	@Override
	public float calculateWaitTime() {
		int processCount=0;
		float waitTime=0;
		 while(count<max) {
			 if(getCell(count)!=null) {
			 waitTime+=getCell(count).getWaitTime();
			 processCount++;
			 }
			 count++;
		 }
		 waitTime=waitTime/processCount;
		 count=0;
		return waitTime;
		
	}

	@Override
	public float calculateTATime() {
		int processCount=0;
		float taTime=0;
		 while(count<max) {
			 if(getCell(count)!=null) {
				 taTime+=getCell(count).getTaTime();
				 processCount++;
			 }
			 count++;
		 }
		 taTime=taTime/processCount;
		 count=0;
		return taTime;
	}

	@Override
	public void setTimes() {
		int previousTATime=0;
		int programCounter=1;// this keeps track of the processes
		int newPriority=1; //uses the built in priority to help set these things
		while(count<=max) {
				
			 while(programCounter<processCount) {
				 
				 ganttCalculations newCell=getCell(programCounter);
			if(newCell.getProcess().getBurstTime()==count) {
				newCell.setWaitTime(previousTATime);
				previousTATime+=newCell.getProcess().getBurstTime();
				
				newCell.setTaTime(previousTATime);
				newCell.setPriority(newPriority);
				
				System.out.println(newCell);
				map.replace(programCounter, newCell); //replaces old value at index with new value
				 newPriority++;
			}
			
			programCounter++;
				 
			 }
			
			 programCounter=1;
			count++;
		}
		
		count=0;
		System.out.println();
		
	}
	
	private void setMaxIfLarger(int newMax) {
		if(max<newMax) {
			max=newMax;
		}
	}
	
	public int getMax() {
		return max;
	}
	
	
	
	public void clear() {
		map.clear();
		max=0;
		count=0;
		processCount=1;
	}

	public int getProcessCount() {
		return processCount;
	}
	
	

}
