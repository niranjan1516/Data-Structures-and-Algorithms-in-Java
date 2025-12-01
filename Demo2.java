class A
{
	public A(int num)
	{
		
		System.out.println("Parent class " + num);
		
	}
}

class B extends A
{
	public B(int num,int num1)
	{
		
		System.out.println("Child Class " + num1);
		super(num);
	}
	
}

class Demo2
{
	public static void main(String []args)
	{
		B b = new B(10,20);
		
	}
}