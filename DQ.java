import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;

	Node(int data)
	{
		this.data = data;
		next = null;
		prev = null;
	}
}

class DQueue
{
	Node front;
	Node rear;

	public DQueue()
	{
		front = null;
		rear = null;	
	}

	//EnqueueFront
	public void EnqueueFront(int data)	
	{
		Node t = new Node(data);

		if(front == null)
		{
			front = t;
			rear = t;
		}
		else 
		{
			t.next = front;
			front.prev = t;
			front = t;
		}

		System.out.println("Node Inserted at Front..");
	}

	//EnqueueRear
	public void EnqueueRear(int data)	
	{
		Node t = new Node(data);

		if(rear == null)
		{
			front = t;
			rear = t;
		}
		else 
		{
			rear.next = t;
			t.prev = rear;
			rear = t;
		}

		System.out.println("Node Inserted at Rear..");
	}

	//DequeueFront
	public void DequeueFront()
	{
		Node tmp = front;
		if(front == null)
		{
			System.out.println("Queue Underflow..");
			return;
		}
		else if(front == rear)
		{
			rear = null;
			front = null;
		}
		else
		{
			front = front.next;
			front.prev = null;
		}

		System.out.println("Element Removed from FRONT : " + tmp.data);
		
	}
	
	//DequeueRear
	public void DequeueRear()
	{
		Node tmp = rear;
		if(rear == null)
		{
			System.out.println("Queue Underflow..");
			return;
		}
		else if(front == rear)
		{
			rear = null;
			front = null;
		}
		else
		{
			rear = rear.prev;
			rear.next = null;
		}

		System.out.println("Element Removed from REAR : " + tmp.data);
		
	}
	//Display
	public void Display()
	{
		if(rear == null)
		{
			System.out.println("Queue UnderFlow..");
			return;
		}
	
		Node tmp = front;
		System.out.print("NULL <-> ");
		while(tmp != null)
		{
			System.out.print(tmp.data + " <-> ");
			tmp = tmp.next;
		}
		System.out.println(" NULL");
	}
}

class DQ
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		DQueue d = new DQueue();
		int ch;
	
		do
		{
			System.out.println("\n****** Double Ended Queue *****");
			System.out.println("1. Equeue Front");
			System.out.println("2. Enqueue Rear");
			System.out.println("3. Dequeue Front");
			System.out.println("4. Dequeue Rear");
			System.out.println("5. Display Queue");
			System.out.println("6. Exit");
			System.out.print("Enter your choice : ");
			ch  = sc.nextInt();

			switch(ch)
			{
				case 1 :
					int data;
					System.out.println("Enter Data : ");
					data = sc.nextInt();
					d.EnqueueFront(data);
					break;
				case 2 :
					System.out.println("Enter Data : ");
					data = sc.nextInt();
					d.EnqueueRear(data);
					break;
				case 3 :
					d.DequeueFront();
					break;
				case 4 :
					d.DequeueRear();
					break;
				case 5 :
					d.Display();
					break;
				case 6 :
					System.out.println("Exiting...");
					break;
				default :
					System.out.println("Incorrect choice....");
					break;

			}

		}while(ch != 6);
	}
}