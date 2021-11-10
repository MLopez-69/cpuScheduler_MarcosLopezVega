package models;

import java.util.HashMap;
import java.util.TreeMap;


public class shortestJobFirst implements calculations, Comparable{
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
//		while(getCell(processCount)!=null) {
//			processCount++;
//		}
		newCell.setPriority(processCount);	
		setMaxIfLarger(newCell.getProcess().getBurstTime());
		map.put(processCount, newCell);
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
		while(count<=max) {
//			int programCounter=1;// this keeps track of the 
//			 
//			 while(count<max) {
//				 
//			 }
			ganttCalculations newCell=getCell(count);
			if(newCell!=null) {
				newCell.setWaitTime(previousTATime);
				int burstTime=newCell.getProcess().getBurstTime();
				previousTATime=previousTATime+burstTime;
				
				newCell.setTaTime(previousTATime);
				System.out.println(newCell);
				map.replace(burstTime, newCell); //replaces old value at index with new value
				
			}
			
			count++;
		}
		count=0;
		
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
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
