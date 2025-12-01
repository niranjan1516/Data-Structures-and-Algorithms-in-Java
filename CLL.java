import java.util.*;

//CNode template
class CNode
{
	int data;
	CNode next;

	public CNode(int data)
	{
		this.data = data;
		next = null;
	}	
}

//CList template
class CList
{
	CNode head;
	CNode tail;
		
	public CList()
	{
		head = null;
		tail = null;
	}

	//insert
	public void Insert(int data)
	{
		//create new node 
		CNode t = new CNode(data);

		//first time Node insertion
		if(head == null)
		{
			head = t;
			tail = t;
		}
		else		//any other insert - at the end of CLL
		{ 
			tail.next = t;  //link new node to tail
			tail = t;	//update tail
		}
		
		tail.next = head;       //maintain circularity

		System.out.println("Node Inserted...");
		
	}
	//delete
	public void Delete(int data)
	{
		CNode tmp = head;
		CNode prev = null;
		boolean flag = false;
	
		do
		{
			if(tmp.data == data)
			{
				flag = true;
				break;
			}

			prev = tmp;
			tmp = tmp.next;
			
		}while(tmp != head);

		if(!flag)
		{
			System.out.println(data + " Not Found");
			return;
		}

		if(tmp == head && tmp == tail)
		{
			head = null;
			tail = null;
		}
		else if(tmp == head)
		{
			head = tmp.next;
			tail.next = head;
		}
		else if(tmp == tail)
		{
			tail = prev;
			tail.next = head;
		}
		else
		{
			prev.next = tmp.next;
		}

		System.out.println("Node Deleted : " + data);
	}

	//search
	public void Search(int data)
	{
		CNode tmp = head;
		boolean flag = false;

		do
		{
			if(data == tmp.data)
			{
				flag = true;
				break;
			}
			tmp = tmp.next;
		}while(tmp != head);
	
		if(flag)
		{
			System.out.println(data + " Is Found");
		}
		else
		{
			System.out.println(data + " Is Not Found");
		}
	}

	//count
	public void Count()
	{
		CNode tmp = head;
		int cnt = 0;

		do
		{	
			cnt++;
			tmp = tmp.next;

		}while(tmp != head);

		System.out.println("Number of Nodes in CLL : " + cnt);
	}
	
	//display
	public void Display()
	{
		System.out.print("CLL Contains : ");
		CNode tmp = head;
		do
		{
			System.out.print(tmp.data + "->");
			tmp = tmp.next;
		}while(tmp != head);

		System.out.println("Back to Head");
	}
}

//CLL class
class CLL
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		CList c = new CList();
		int ch;

		do
		{
			System.out.println("\n***** Circular Linked List *****");
			System.out.println("1. Insert Node in CLL");
			System.out.println("2. Delete Node from CLL");
			System.out.println("3. Search Node in CLL");
			System.out.println("4. Count Number of Nodes in CLL");
			System.out.println("5. Display Nodes From CLL");
			System.out.println("6. Exit");
			System.out.print("Enter Your Choice : ");
			ch = sc.nextInt();

			switch(ch)
			{
				case 1 : 
					int data;
					System.out.print("Enter Value : ");
					data = sc.nextInt();
					c.Insert(data);
					break;
				case 2 : 
					System.out.println("Enter Value to Delete : ");
					data = sc.nextInt();
					c.Delete(data);
					break;
				case 3 : 
					System.out.println("Enter value to search : ");
					data = sc.nextInt();
					c.Search(data);
					break;
				case 4 : 
					c.Count();
					break;
				case 5 : 
					c.Display();
					break;
				case 6 : 
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Incorrect Choice !");
					break;

			}
	
		}while(ch != 6);
	}
}