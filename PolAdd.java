import java.util.*;

class Node
{
	int coef;
	int expo;
	Node next;

	public Node(int coef,int expo)
	{
		this.coef = coef;
		this.expo = expo;
		next = null;
	}

}

class Polynomial
{
	Node head;
	
	public Polynomial()
	{
		head = null;
	}

	//insert
	public void Insert(int coef,int expo)
	{
		Node t = new Node(coef,expo);

		if(head == null)
		{
			head = t;
		}
		else
		{
			Node tmp = head;
			Node prev = null;
		
			while(tmp != null && t.expo < tmp.expo)
			{
				prev = tmp;
				tmp = tmp.next;
			}

			if(tmp == head)
			{
				t.next = tmp;
				head = t;
			}
			else if(tmp == null)
			{
				prev.next = t;
			}
			else
			{
				prev.next = t;
				t.next = tmp;
			}
			
		}
		
	}
	
	//addition

	//display
	public void Display()
	{
		Node tmp = head;
		
		if(tmp == null)
		{
			System.out.println("Empty Linked List");
			return;
		}

		while(tmp != null)
		{
			System.out.print(tmp.coef + "X" + tmp.expo);
			if(temp.next != null)
			{
				System.out.print(" + ");
			}
			tmp = tmp.next;
		}

		
	}
}

public class PolAdd
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();

		System.out.println();
	}
}