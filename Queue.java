import java.util.*;

class AQueue
{
	private int max;
	private int[] arr;
	private int rear;
	private int front;

	public AQueue(int size)
	{
		arr = new int[size];
		max = size;
		rear = -1;
		front = -1;
	}

	public void Enqueue(int val)
	{
		if(rear == -1)
		{
			rear++;
			arr[rear] = val;
			front++;
		}
		else if(rear == max-1)
		{
			System.out.println("Queue Overflow...");
			return;
		}
		else
		{
			rear++;
			arr[rear] = val;
		}
		System.out.println("Element added into queue....");
	}

	public void Dequeue()
	{
		if(front == -1 || front > rear)
		{
			System.out.println("Queue Underflow...");
			rear = -1;
			front = -1;
			return;
		}
		else
		{
			int temp = arr[front];
			System.out.println("Element Dequeued From queue : " + temp);
			front++;
		}
	}

	public void PeekFront()
	{
		if(front == -1)
		{
			System.out.println("Queue Underflow...");
		}
		else
		{
			System.out.println("Peek element at front : " + arr[front]);
		}
	}

	public void PeekRear()
	{
		if(rear == -1)
		{
			System.out.println("Queue Underflow...");
		}
		else
		{
			System.out.println("Peek element at Rear : " + arr[rear]);
		}
	}

	public void Display()
	{
		if(rear == -1 && front == -1)
		{
			System.out.println("Stack Underflow....");
			return;
		}
		System.out.println("Elements in queue : ");
		for(int i = 0;i<=rear;i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

}


public class Queue
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int n;
		int ch;

		System.out.println("Enter size of Queue : ");
		n = sc.nextInt();

		AQueue a = new AQueue(n);

		do
		{
			System.out.println("\n**** Queue Implementation ****");
			System.out.println("1. Enqueue an Element in queue.");
			System.out.println("2. Dequeue an Element from queue.");
			System.out.println("3. Peek at Front");
			System.out.println("4. Peek at rear");
			System.out.println("5. Display element in Queue");
			System.out.println("6. Exit...");
			System.out.println("Enter Your choice : ");
			ch = sc.nextInt();

			switch(ch)
			{
				case 1 :
					System.out.println("Enter value : ");
					a.Enqueue(sc.nextInt());
					break;
				case 2 :
					a.Dequeue();
					break;
				case 3 :
					a.PeekFront();
					break;
				case 4 :
					a.PeekRear();
					break;
				case 5 :
					a.Display();
					break;
				case 6 :
					System.out.println("Exiting....");
					break;
				default:
					System.out.println("Incorrect input...");
			}	
		}while(ch != 6);

		
	}
}