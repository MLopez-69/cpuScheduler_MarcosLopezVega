package models;

import java.util.HashMap;
import java.util.TreeMap;


public class shortestJobFirst implements calculations{
	private HashMap<Integer,ganttCalculations> map;
	private int max;
	int count;

	public shortestJobFirst(int maxInt) {
		map=new HashMap<Integer,ganttCalculations>(maxInt);
		max=0;
		count=0;
	}
	
	public void addCell(process process) {
		ganttCalculations newCell= new ganttCalculations(process);
		setMaxIfLarger(newCell.getProcess().getBurstTime());
		map.put(newCell.getProcess().getBurstTime(), newCell);
	}
	
	public void addCell(ganttCalculations newCell) {
		setMaxIfLarger(newCell.getProcess().getBurstTime());
		map.put(newCell.getProcess().getBurstTime(), newCell);
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
	

}
