package models;

public class ganttCalculations {
	private int waitTime;
	private int taTime;
	private process process;
	
	public ganttCalculations(process process) {
		this.process=process;
		waitTime=0;
		taTime=0;
	}
	
	public ganttCalculations(process process, int waitTime,int taTime) {
		this.process=process;
		this.waitTime=waitTime;
		this.taTime=taTime;
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

	@Override
	public String toString() {
		return "ganttCalculations [waitTime=" + waitTime + ", taTime=" + taTime + ", process=" + process + "]";
	}
	
	

}
