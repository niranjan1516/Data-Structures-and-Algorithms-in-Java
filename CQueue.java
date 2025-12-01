import java.util.*;

class CQueueImpl
{
	int max;
	int[] qArray;
	int rear;
	int front;
	int cnt;

	CQueueImpl(int size)	
	{
		max = size;
		qArray = new int[size];
		rear = -1;
		front = -1;
		cnt = 0;
	}

	//enqueue method
	public void Enqueue(int val)
	{
		if(cnt == max)
		{
			System.out.println("Queue Overflow !");
			return;
		}

		if(cnt == 0)
		{
			front = 0;
		}

		//any other element
		rear = (rear + 1) % max;
		qArray[rear] = val;
		cnt++;
	}

	//dequeue method
	public void Dequeue()
	{
		if(rear == -1)
		{
			System.out.println("queue underflow ! ");
			return;
		}

		int x = qArray[front];

		if(rear == front)
		{
			front = -1;
			rear = -1;
		}
		else
		{
			front = (front + 1) % max;
		}

		System.out.println("Element Removed : " + x);
		cnt--;
	}

	//display the queue
	public void Display()
	{
		System.out.print("Elements in Queue : ");

		int j = front;
		for(int i = 1;i<=cnt;i++)
		{
			System.out.print(qArray[j] + " ");
			j = (j + 1) % max;
		}
	}

	//Peek front
	public void PeekFront()
	{
		if(front == -1)
		{
			System.out.println("Queue Underflow ! ");
			return;
		}

		System.out.println("Element at Front : " + qArray[front]);	
	}

	//Peek rear
	public void PeekRear()
	{
		if(rear == -1)
		{
			System.out.println("Queue Underflow ! ");
			return;
		}
		
		System.out.println("Element at Rear : " + qArray[rear]);
	}
}

class CQueue
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int ch;
		CQueueImpl c = new CQueueImpl(5);

		do
		{
			System.out.println("***** Circular Queue *****");
			System.out.println("1. Enqueue in Queue");
			System.out.println("2. Dequeue from Queue");
			System.out.println("3. Display the Queue");
			System.out.println("4. Peek at front");
			System.out.println("5. Peek at rear");
			System.out.println("6. Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch(ch)
			{
				case 1 :
					System.out.println("Enter value : ");
					c.Enqueue(sc.nextInt());
					break;
				case 2 :
					c.Dequeue();
					break;
				case 3 :
					c.Display();
					break;
				case 4 :
					c.PeekFront();
					break;
				case 5 :
					c.PeekRear();
					break;
				case 6 :
					System.out.println("Exsiting...");
					break;
				default :
					System.out.println("Incorrect Input...! please Enter correct choice.");
					break;
			}

		}while(ch != 6);
		
	}
}