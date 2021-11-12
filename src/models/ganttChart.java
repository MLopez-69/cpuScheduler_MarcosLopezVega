package models;

import java.util.LinkedList;

public class ganttChart {
	
	private LinkedList<ganttCell> chart;
	
	public ganttChart() {
		chart=new LinkedList<ganttCell>();
		
	}
	
	public void addCell(ganttCell newCell) {
		chart.add(newCell);
		
	}
	
	public ganttCell getCell() {
		ganttCell cell=chart.pop();
		return cell;
	}
	
	public int getWaitTime() {
		int waitTime=chart.peek().getWaitTime();
		return waitTime;
	}
	
	public int getTATime() {
		int taTime=chart.peek().getTaTime();
		return taTime;
	}
	
	public int getPriority() {
		int priority=chart.peek().getPriority();
		return priority;
	}
	
	public void next() {
		addCell(getCell());
	}
	
	public void clear() {
		chart.clear();
	}

}
