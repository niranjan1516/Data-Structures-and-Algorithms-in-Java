import java.util.*;

class ParanthesisBal
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String expr;

		System.out.println("Enter Expression : ");
		expr = sc.nextLine();

		System.out.println("\nThe expression : " + expr);

		if(isBalanced(expr))
		{
			System.out.println("The paranthesis are balanced...");
		}
		else
		{
			System.out.println("The paranthesis are NOT balanced...");
		}
		
	}

	public static Boolean isBalanced(String ex)
	{
		char stack[] = new char[ex.length()];
		int tos = -1;

		for(int i = 0; i<ex.length();i++)
		{
			char ch = ex.charAt(i);
			
			if(ch == '(')
			{
				tos++;
				stack[tos] = ch;
			}
			else if(ch == ')')
			{
				if(tos == -1)
				{
					return false;
				}
				tos--;
			}
			
		}

		return tos==-1;	
	}
}