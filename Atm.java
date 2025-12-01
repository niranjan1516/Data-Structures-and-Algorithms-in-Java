class Atm
{
	public static void main(String [] args)
	{
		int amt = 1800;

		int n100 = 0;
		int n200 = 0;
		int n500 = 0;

		if(amt % 100 != 0)
		{
			System.out.println("Cannot make dispensions.");
			
		}
		else
		{
			n500 = amt / 500;
			int r = amt - n500 * 500;
			n200 = r / 200;
			r = r - n200 * 200;
			n100 = r/100;
		
			System.out.println("500 Notes : " + n500);
			System.out.println("200 Notes : " + n200);
			System.out.println("100 Notes : " + n100);
		}
	}
}