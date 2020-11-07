package processQueue;

import node.Node;



public class ProcessQueue {
	private Node front;
	private Node rear;
	private int size;
	
	public ProcessQueue() {
		front =null;
		rear=null;
		size=0;
	}
	
	public boolean isEmpty() {
		return rear==null;
	}
	
	public Node getFront() {
		return front;
	}
	
	public Node display() {
		Node q=new Node();
		if (!isEmpty()) {
			q=front;
		}
		return q;
	}

	public int displaySize() {
		return size;
	}
	
	
	public void CH_CT(Node p) {//change completion time
        Node q = new Node();
        q = p.getnext();
        q.setprev(p);

        while (q != null) {
            q.setCompletionTime(q.getprev().getCompletionTime() - q.getBurstTime());
            q = q.getnext();
        }

    }
	
	
	public void enqueue(Double ID_in, Double ArrivalTime_in, Double BurstTime_in) {
        Node p = new Node(ID_in, ArrivalTime_in, BurstTime_in);

        if (front == null) {
            rear = p;
            front = p;
            p.setprev(null);
            p.setnext(null);
            front.setnext(null);
            rear.setnext(null);
            size++;
            if (p.getArrivalTime() != 0) {
                p.setCompletionTime((ArrivalTime_in + BurstTime_in));
            } else {
                p.setCompletionTime(BurstTime_in);
            }

            p.setTurnAroundTime((p.getCompletionTime() - p.getArrivalTime()));
            p.setWaitingTime((p.getTurnAroundTime() - p.getBurstTime()));

        } else {
            if (front.getnext() == null) {
                rear.setnext(p);
                rear = p;
                p.setprev(front);
                p.setCompletionTime(p.getprev().getCompletionTime() + p.getBurstTime());
                p.setTurnAroundTime((p.getCompletionTime() - p.getArrivalTime()));
                p.setWaitingTime((p.getTurnAroundTime() - p.getBurstTime()));
                size++;
            } else {
                Node q1 = new Node(ID_in, ArrivalTime_in, BurstTime_in);
                q1 = front.getnext();
                q1.setprev(front);
                int flag = 0;
                int x = 0;
                while (flag ==0 || x ==0) {

                    if (p.getBurstTime() < q1.getBurstTime()) {
                        q1.getprev().setnext(p);
                        p.setprev(q1.getprev());
                        q1.setprev(p);
                        p.setnext(q1);
                        p.setCompletionTime((p.getprev().getCompletionTime() + p.getBurstTime()));
                        p.setTurnAroundTime((p.getCompletionTime() - p.getArrivalTime()));
                        p.setWaitingTime((p.getTurnAroundTime() - p.getBurstTime()));
                        flag = 1;
                        size++;
                        break;

                    } else if (q1.getnext() == null) {
                        q1.setnext(p);
                        p.setprev(q1);
                        rear = p;
                        p.setprev(q1);
                        p.setCompletionTime((p.getprev().getCompletionTime() + p.getBurstTime()));
                        p.setTurnAroundTime((p.getCompletionTime() - p.getArrivalTime()));
                        p.setWaitingTime((p.getTurnAroundTime() - p.getBurstTime()));
                        size++;
                        x=1;
                        break;
                    }
                    q1 = q1.getnext();

                }

                if (flag == 1) {
                    Node q = new Node(ID_in, ArrivalTime_in, BurstTime_in);
                    q = p.getnext();
                    while (q != null) {
                        q.setCompletionTime((q.getprev().getCompletionTime() + q.getBurstTime()));
                        q.setTurnAroundTime((q.getCompletionTime() - q.getArrivalTime()));
                        q.setWaitingTime((q.getTurnAroundTime() - q.getBurstTime()));
                        q = q.getnext();
                    }
                }
            }
        }

    }
	
	
	
	
	 public Double avgWaitingTime(Node q) {
			 Double sum = 0.0;
			 for (int i=0;i<size;i++) {
			 	sum += q.getWaitingTime();
			 	q=q.getnext();
			 }
			 Double avg = sum /size;
			 return avg;
		 }
	 
	 public void display_1() {
	        Node q= new Node();
	            q = front;
	        System.out.println("ID" + " | " + "ArrivalTime" + " | " + "BusrtTime" + " | "
	                + "TurnArouTime" + " | " + " WaitingTime");
	        
	        System.out.println("_________________________________________________________");
	        while(q != null){
	            System.out.print(" " + q.getID() + "\t   " + q.getArrivalTime() + "\t\t" + q.getBurstTime() + "\t  "
	            + q.getTurnAroundTime() + "\t \t " + q.getWaitingTime());
	            System.out.println();
	            System.out.println("_________________________________________________________");
	            
	            q = q.getnext();
	        }

	    }
	 
	 public Double avgTurnAroundTime(Node q) {
		 Double sum = 0.0;
		 for (int i=0;i<size ;i++) {
		 	sum += q.getTurnAroundTime();
		 	q=q.getnext();
		 }
		 Double avg = sum /size;
		 return avg;
	 }
	
	 
	
	/* public static void main(String arg[])	{
		
		 
		 ProcessQueue a =new ProcessQueue();
		 	a.enqueue(1.0, 0.0, 6.0);
		 	a.enqueue(2.0, 2.0, 8.0);
		 	a.enqueue(3.0, 4.0, 7.0);
		 	a.enqueue(4.0, 5.0, 3.0);
		 	System.out.println("size :"+a.displaySize());
		 	System.out.println("At"+" "+"Bt"+" "+" ct"+" "+" tat"+" "+" wt ");
		 	System.out.println(a.display().getArrivalTime()+" "+a.display().getBurstTime()+" "+a.display().getCompletionTime()+" "+a.display().getTurnAroundTime()+" "+a.display().getWaitingTime());
		 	System.out.println(a.display().getnext().getArrivalTime()+" "+a.display().getnext().getBurstTime()+" "+a.display().getnext().getCompletionTime()+" "+a.display().getnext().getTurnAroundTime()+" "+a.display().getnext().getWaitingTime());
		 	System.out.println(a.display().getnext().getnext().getArrivalTime()+" "+a.display().getnext().getnext().getBurstTime()+" "+a.display().getnext().getnext().getCompletionTime()+" "+a.display().getnext().getnext().getTurnAroundTime()+" "+a.display().getnext().getnext().getWaitingTime());
		 	System.out.println(a.display().getnext().getnext().getnext().getArrivalTime()+" "+a.display().getnext().getnext().getnext().getBurstTime()+" "+a.display().getnext().getnext().getnext().getCompletionTime()+" "+a.display().getnext().getnext().getnext().getTurnAroundTime()+" "+a.display().getnext().getnext().getnext().getWaitingTime());
		 	System.out.println(a.avgTurnAroundTime(a.front));
		 	System.out.println(a.avgWaitingTime(a.front));
		 	System.out.println(" ");
		 	a.display_1();
			     
			
	
	 
	 	
	 	
	 }*/
	 
	 }




