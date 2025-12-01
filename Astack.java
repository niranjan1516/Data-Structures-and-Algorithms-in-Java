import java.util.*;

class stack
{
	private int max;
	private int[] array;
	private int tos;

	public stack(int size)
	{
		array = new int[size];
		tos = -1;
		max = size;
	}

	public void Push(int val)
	{
		if(tos == max-1)
		{
			System.out.println("Stack overflow...");
			return;
		}
		else
		{
			tos++;
			array[tos] = val;
			System.out.println("Element added on stack...");
		}
	}

	public void Pop()
	{
		if(tos == -1)
		{
			System.out.println("Stack Underflow...");
			return;
		}
		else
		{
			int e = array[tos];
			tos--;
			System.out.println(e + " Element popped from stack...");
			
		}
	}

	public void Peek()
	{
		if(tos == -1)
		{
			System.out.println("Stack underflow....");
			return;
		}
		else
		{
			System.out.println("Element at peek on stack : " + array[tos]);
		}
	}

	public void Display()
	{
		if(tos == -1)
		{
			System.out.println("Stack UnderFlow...");
			return;
		}
		else
		{
			System.out.println("Elements in Stack : ");
			for(int i = tos;i>=0;i--)
			{
				System.out.println(array[i]);
			}
		}
	}
	
}

class Astack
{
	public static void main(String []args)
	{
		int n;
		int choice;
		int num;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of stack : ");
		n = sc.nextInt();

		stack s = new stack(n);

		do
		{
			System.out.println("Menu : ");
			System.out.println("1. Push element on stack");
			System.out.println("2. Pop element From stack");
			System.out.println("3. Peek element at stack");
			System.out.println("4. Display element in stack");
			System.out.println("5. Exit...");

			System.out.println("Enter yout choice (1 to 5): ");
			choice = sc.nextInt();
	
			int val;
			switch(choice)
			{
				case 1:
					System.out.println("Enter value : ");
					val = sc.nextInt();
					s.Push(val);
					break;
				case 2:
					s.Pop();
					break;
				case 3:
					s.Peek();
					break;
				case 4:
					s.Display();
					break;
				case 5:
					System.out.println("")
					break;
				default:
					System.out.println("Please enter correct input....");
			}

		}while(choice != 5);	

		
	}
}