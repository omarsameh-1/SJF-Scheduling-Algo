package node;

public class Node {
	
	private double ID;
	private Double ArrivalTime;
	private Double BurstTime;
	private Double CompletionTime;
	private Double TurnAroundTime;
	private Double WaitingTime;
	private Node next;
	private Node prev;
	
	public Node(){
        next=null;
	    prev=null;
        }
	
	public Node(Double ID,Double ArrivalTime,Double BurstTime) {
		this.ID=ID;
		this.ArrivalTime=ArrivalTime;
		this.BurstTime=BurstTime;
		next=null;
		prev=null;
	}
	
	public Double getID() {
		return ID;
	}
	public void setID(Double ID) {
		this.ID=ID;
	}
	
	public Double getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(Double ArrivalTime) {
		this.ArrivalTime=ArrivalTime;
	}
	
	public Double getBurstTime() {
		return BurstTime;
	}
	public void setBurstTime(Double BurstTime) {
		this.BurstTime=BurstTime;
	}
	
	public Double getCompletionTime() {
		return CompletionTime;
	}
	public void setCompletionTime (Double CompletionTime) {
		this.CompletionTime=CompletionTime;
	}
	
	public Double getTurnAroundTime() {
		return TurnAroundTime;
	}
	public void setTurnAroundTime(Double TurnAroundTime) {
		this.TurnAroundTime=TurnAroundTime;
	}
	
	public Double getWaitingTime() {
		return WaitingTime;
	}
	public void setWaitingTime(Double WaitingTime) {
		this.WaitingTime=WaitingTime;
	}
	
	public Node getnext() {
		return next;
	}
	public void setnext(Node next) {
		this.next=next;
	}
	
	public Node getprev() {
		return prev;
	}
	public void setprev(Node prev) {
		this.prev=prev;
	}
	
	}
