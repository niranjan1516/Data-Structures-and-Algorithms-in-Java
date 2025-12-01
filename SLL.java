import java.util.*;

class Node
{
	int data;
	Node next;

	public Node(int data)
	{
		this.data = data;
		next = null;
	}

	
}

class List
{
	Node head;
	
	public List()
	{
		head = null;
	}

	//insert data into node
	public void Insert(int val)
	{
		Node t = new Node(val);

		if(head == null)
		{
			head = t; 
			return;
		}

		//traverse all nodes and link t at end
		Node tmp = head;
		while(tmp.next != null)
		{
			tmp = tmp.next;	
		}

		tmp.next = t;

		System.out.println("Value Inserted...");
	}

	
	//Search
	public void Search(int val)
	{
		Node tmp = head;
		boolean flag = false;
		while(tmp != null)
		{
			if(tmp.data == val)
			{
				flag = true;
				break;
			}
			tmp = tmp.next;
		}

		if(flag)
		{
			System.out.println(val + " Found in List");
		}
		else
		{
			System.out.println(val + " Not Found in List");
		}
	}

	//Count
	public int Count()
	{
		Node tmp = head;
		int cnt = 0;
		while(tmp != null)
		{
			cnt++;
			tmp = tmp.next;
		}

		return cnt;
	}
	//Delete
	public void Delete(int val)
	{
		Node tmp = head;
		Node prev = null;
		boolean flag;
		while(tmp != null)
		{
			if(tmp.data == val)
			{
				flag = true;
				break;
			}

			prev = tmp;
			tmp = tmp.next;
		}

		//singular node deletion
		if(tmp == head && tmp.next == null)
		{
			head = null;
		}
		else if(tmp == head)
		{
			head = tmp.next;
		}
		else if(tmp.next == null)
		{
			prev.next = null;
		}
		else
		{
			prev.next = tmp.next;
		}
		
		System.out.println("Node Deleted..");
	}

	//Display method
	public void Display()
	{
		System.out.print("Elements in List : ");
		Node tmp = head;
		while(tmp != null)
		{
			System.out.print(tmp.data + "->");
			tmp = tmp.next;
		
		}
	}

	
	//Reverse A Linked list
	public void Reverse()
	{
		//1st Approach
		/*Node tmp = head;
		System.out.println("Reversed Linked List : ");

		int arr[] = new int[Count()+1];
		int tos= 0;
		
		while(tmp != null)
		{
			arr[tos] = tmp.data;
			tmp = tmp.next;
			tos++;
		}
		
		for(tos = tos-1;tos >= 0;tos--)
		{
			System.out.print(arr[tos] + "->");
		}
		*/

		//2nd Approach

		Node prev = null;
		Node curr = head;
		Node next = null;

		while(curr != null)
		{
			//10->20->30
			next = curr.next; //10
			curr.next = prev;//null
			

			prev = curr;//10
			curr = next;//10
		}

		head = prev;

		System.out.println("Reversed Linked List : ");
		Display();
	}
	
	//Middle element in List
	public void Middle()
	{
		int cnt = 0;
		Node tmp = head;	
		int mean = Count() / 2 ;
		while(tmp != null)
		{
			if(cnt == mean)
			{
				System.out.println("Middle element in List - " + tmp.data);
				return;	
			}
			tmp = tmp.next;
			cnt++;
		}
		
	}
	//Maximum element From List
	public void Max()
	{
		Node tmp = head;
		int max = 0;
		while(tmp != null)
		{
			if(max < tmp.data)
			{
				max = tmp.data;
			}
			tmp = tmp.next;
		}
		System.out.println("Maximum Element in List : " + max);
	}

	//Minimum element from list
	public void Min()
	{
		Node tmp = head;
		int min = tmp.data;
		while(tmp != null)
		{
			if(min > tmp.data)
			{
				min = tmp.data;
			}
			tmp = tmp.next;
		}
		System.out.println("Minimum Element in List : " + min);
	}

	//Delete n'th Node from the last
	public void LDelete(int idx)
	{
		Reverse();
		Node tmp = head;
		Node prev = null;
		int cnt = 0;
		while(tmp != null)
		{
			cnt++;
			if(cnt == idx)
			{
				prev.next = tmp.next;
				System.out.println("\nAfter Deleting n th Node : ");
				Display();
				return;
			}
		
			prev = tmp;
			tmp = tmp.next;
			
		}
		
		
	} 

	//Sort the Linked List
	public void Sort()
	{
		Node current,index;
		int tmp;
		
		for(current = head; current != null;current = current.next)
		{
			for(index = current.next;index != null;index = index.next)
			{
				if(current.data > index.data)
				{
					tmp = current.data;
					current.data = index.data;
					index.data = tmp; 
				}
			}
		}

		System.out.println("Linked List Sorted...");
		
	}
		
}

class SLL
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		List s = new List();
		int ch;

		do
		{
			System.out.println("\n***** Singly Linked-List *****");
			System.out.println("1. Insert into Linked List");
			System.out.println("2. Delete From List");
			System.out.println("3. Display From List");
			System.out.println("4. Search in List");
			System.out.println("5. Count Number of Nodes in List");
			System.out.println("6. Reverse Linked List");
			System.out.println("7. Exit");
			System.out.println("8. Find Middle element in List  ");
			System.out.println("9. Find Maximum element from List ");
			System.out.println("10. Find Minimum element from List ");
			System.out.println("11. Delete n'th Element From End");
			System.out.println("12. Sort the Linked list");

			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch(ch)
			{
				case 1 :
					int data;
					System.out.println("Enter value : ");
					data = sc.nextInt();
					s.Insert(data);
					break;
				case 2 :
					System.out.println("Enter value to Delete : ");
					data = sc.nextInt();
					s.Delete(data);
					break;
				case 3 :
					s.Display();
					break;
				case 4 :
					System.out.println("Enter value to Search : ");
					data = sc.nextInt();
					s.Search(data);
					break;
				case 5 :
					System.out.println("Nodes in List - " + s.Count());
					break;
				case 6 : 
					s.Reverse();
					break;
				case 7 :
					System.out.println("Exiting...");
					break;
				case 8 :
					s.Middle();
					break;
				case 9 :
					s.Max();
					break;
				case 10 :
					 s.Min();
					 break;
				case 11 :
					System.out.println("Enter n'th Node to delete from last : ");
					data = sc.nextInt();
					s.LDelete(data);
					break;
				case 12 :
					s.Sort();
					break;
				default:
					System.out.println("Incorrect input...");
					break;
			}
		}while(ch != 7);
	
	
	}
}