import java.util.*;

class InToPost
{
	public static void main(String []args)
	{
		String expr;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Expression : ");
		expr = sc.nextLine();

		String res = infixToPostfix(expr);

		System.out.println("Result : " + res);

		//int result = calPostEval(res);

		//System.out.println("Result : " + result);

	}

	public static String infixToPostfix(String ex)
	{
		char[] s = new char[ex.length()-1];
		int tos = -1;
		StringBuilder res = new StringBuilder();

		for(int i = 0;i<ex.length();i++)
		{
			char ch = ex.charAt(i);
			if(Character.isLetterOrDigit(ch))
			{
				res.append(ch);
			}
			else if(tos == -1)
			{
				tos++;
				s[tos] = ch; 
			}
			else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
			{				
				while(tos != -1 && precedence(s[tos]) >= precedence(ch))
				{
					res.append(s[tos--]);
				}
				s[++tos] = ch;
			}
		}
		while(tos != -1)
		{
			res.append(s[tos--]);
 		}  
 
		return res.toString();
	}

	public static int precedence(char op)
	{
		switch(op)
		{
			case '+':
			case '-':
				 return 1;
			case '*':
			case '/':
				 return 2;
			default:
				return -1;
		}
	}

	public static int calPostEval(String ex)
	{
		int stack[] = new int[ex.length()-1];

		int tos = -1;
		
		for(int i = 0; i< ex.length()-1;i++)
		{
			int ch = ex.charAt(i);

			if(Character.isDigit(ch))
			{
				tos++;
				stack[tos] = ch - '0';
			}
			else if(ch == '+' || ch == '-' || ch == '*' || ch =='/')
			{
				int n2 = stack[tos];
				tos--;
				int n1 = stack[tos];
				tos--;

				int res = 0;
				switch(ch)
				{
					case '+':
						 res = n1 + n2;
						 break;
					case '-':
						 res = n1 - n2;
						 break;
					case '/':
						 res = n1 / n2;
						 break;
					case '*':
						 res = n1 * n2;
						 break;
				}
				tos++;
				stack[tos] = res;
			}
		}
		return stack[tos];
		
	}	

}