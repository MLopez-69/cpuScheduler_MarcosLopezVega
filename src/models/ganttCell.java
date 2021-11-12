package models;

public class ganttCell{
	private int waitTime;
	private int taTime;
	private int priority;
	private process process;
	
	public ganttCell(process process) {
		this.process=process;
		waitTime=0;
		taTime=0;
		priority=0;
	}
	
	public ganttCell(process process, int waitTime,int taTime) {
		this.process=process;
		this.waitTime=waitTime;
		this.taTime=taTime;
	}
	
	public ganttCell(process process, int waitTime,int taTime, int priority) {
		this.process=process;
		this.waitTime=waitTime;
		this.taTime=taTime;
		this.priority=priority;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public int getTaTime() {
		return taTime;
	}

	public void setTaTime(int taTime) {
		this.taTime = taTime;
	}

	public process getProcess() {
		return process;
	}

	public void setProcess(process process) {
		this.process = process;
	}
	

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "ganttCalculations [waitTime=" + waitTime + ", taTime=" + taTime + ", priority=" + priority
				+ ", process=" + process + "]";
	}

	
	
	

}
