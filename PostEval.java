class PostEval
{
	public static void main(String []args)
	{
		String expr = "24*5/39-12*-";
		
		int result = calPostEval(expr);

		System.out.println("Result of expression {24*5/39-12*-} : " + result);
	}//end of psvm

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
