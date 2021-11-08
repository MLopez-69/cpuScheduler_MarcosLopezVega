package models;

public class process {
	private int burstTime;
	private String name;
	private int waitTime;
	private int taTime;
	
	public process(String name,int burstTime) {
		this.name=name;
		this.burstTime=burstTime;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "process [burstTime=" + burstTime + ", name=" + name + "]";
	}
	
	

}
