import java.util.*;

class Node
{
	int data;
	int pr;
	Node next;

	public Node(int data,int pr)
	{
		this.data = data;
		this.pr = pr;
		next = null;
	}

}

class PQueue
{
	Node front;
	Node rear;
	
	public PQueue()
	{
		front = null;
		rear = null;
	}

	//Order Insertion
	public void Enqueue(int data,int pr)
	{
		Node t = new Node(data,pr);

		if(front == null)
		{
			front = t;
			rear = t;
		}
		else
		{
			Node tmp = front;
			Node prev = null;
			while(tmp != null && tmp.pr < t.pr)
			{
				prev = tmp;
				tmp = tmp.next;
			}		
			if(tmp == front)
			{
				t.next  = tmp;
				front = t;
			}
			else if(tmp == null)
			{
				rear.next = t;
				rear = t;
			}
			else
			{
				prev.next = t;
				t.next = tmp;
			}			
		}
		System.out.println("Node Inserted...");
		
	}
	//Dequeue
	public void Dequeue()
	{
		Node tmp = front;
		if(front == null)
		{
			System.out.println("Queue underflow..");
			return;
		}
		else
		{
			front = front.next;
		}
		
		System.out.println("Node Deleted : " + tmp.data + " | " + tmp.pr);

	}

	//Display
	public void Display()
	{
		if(front == null)
		{
			System.out.println("Queue Underflow...");
			return;
		}
		else
		{
			Node tmp = front;
			while(tmp != null)
			{
				System.out.print(tmp.data + " | "+tmp.pr + " -> ");
				tmp = tmp.next;
			}
		}

	}

	//PeekFront
	public void PeekFront()
	{
		if(front == null)
		{
			System.out.println("queue underflow..");
			return;
		}

		System.out.print("Peek Front Element : "+front.data+" | "+front.pr);
	}
	//PeekRear
	public void PeekRear()
	{
		if(rear == null)
		{
			System.out.println("queue underflow..");
			return;
		}

		System.out.println("Peek Rear Element : "+rear.data + " | " + rear.pr);
		
	}
}

class PQ
{
	public static void main(String []args)
	{
		PQueue p = new PQueue();
		Scanner sc = new Scanner(System.in);
		int ch;

		do
		{
			System.out.println("\n***** Priority Queue *****");
			System.out.println("1. Enqueue Node ");
			System.out.println("2. Dequeue Element");
			System.out.println("3. Peek Front");
			System.out.println("4. Peek Rear");
			System.out.println("5. Display Queue");
			System.out.println("6. Exit");
			System.out.print("Enter your choice : ");
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1:
					int data;
					int pr;
					System.out.print("Enter data : ");
					data = sc.nextInt();
					System.out.println("Enter priority : ");
					pr = sc.nextInt();
					p.Enqueue(data,pr);
					break;
				case 2:
					p.Dequeue();
					break;
				case 3:
					p.PeekFront();
					break;
				case 4:
					p.PeekRear();
					break;
				case 5:
					p.Display();
					break;
				case 6:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Incorrect input !");
					break;

			}
			
		}while(ch != 6);
	}
}

