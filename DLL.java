import java.util.*;

//DNode template
class DNode
{
	int data;
	DNode next;
	DNode prev;

	public DNode(int data)
	{
		this.data = data;
		next = null;
		prev = null;
	}

}

//DList template
class DList
{
	DNode head;
	DNode tail;
	
	public DList()
	{
		head = null;
		tail = null;
	}

	//insert
	public void Insert(int data)
	{
		DNode t = new DNode(data);
		
		if(head == null)
		{
			head = t;
			tail = t;
		}
		else
		{
			tail.next = t;
			tail = t;
		}

		System.out.println("Node inserted..");
		
	}
	//delete

	//search
	
	//count
	public void Count()
	{
		DNOde tmp = head;
		int cnt = 0;
		
		while(tmp != null)
		{
			cnt++;
			tmp = tmp.next;
		}

		System.out.println("Number of Nodes in List : " + cnt);
	}
	//Display
	public void Display()
	{
		DNode tmp = head;
		
		System.out.print("DLL contains : NULL < - >");
		while(tmp != null)
		{
			System.out.print(tmp.data + " < - > ");
			tmp = tmp.next;
		}
		System.out.println(" NULL ");
	}
}


//DLL class
class DLL
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		DList d = new DList();
		int ch;

		do
		{
			System.out.println("\n ***** Doubly Linked List *****");
			System.out.println("1. Insert a Node in DLL");
			System.out.println("2. Delete a Node from DLL");
			System.out.println("3. Search a Node in DLL");
			System.out.println("4. Count Number of Nodes in DLL");
			System.out.println("5. Display Nodes from DLL");
			System.out.println("6. Exit");
			System.out.print("Enter your Choice : ");
			ch = sc.nextInt();

			switch(ch)
			{
				case 1 : 
					int data;
					System.out.print("Enter value : ");
					data = sc.nextInt();
					d.Insert(data);
					break;
				case 2 : 
					break;
				case 3 : 
					break;
				case 4 : 
					break;
				case 5 : 
					d.Display();
					break;
				case 6 : 
					System.out.println("Exiting....");
					break;
				default:
					System.out.println("Incorrect Choice !");
					break;	
			}
		}while(ch != 6);
		
	}
}