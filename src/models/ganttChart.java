package models;

import java.util.LinkedList;

public class ganttChart {
	
	private LinkedList<ganttCalculations> chart;
	
	public ganttChart() {
		chart=new LinkedList<ganttCalculations>();
		
		
	}
	
	public void addCell(ganttCalculations newCell) {
		chart.add(newCell);
		
	}
	
	public ganttCalculations getCell() {
		ganttCalculations cell=chart.pop();
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
	public void next() {
		addCell(getCell());
	}
	
	public void clear() {
		chart.clear();
	}

}
