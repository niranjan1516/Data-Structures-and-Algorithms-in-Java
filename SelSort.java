import java.util.*;

class SelSort
{
	public static void main(String []args)
	{
		int n,i,j,temp;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter number of element to be store in array : ");
		n = input.nextInt();
		
		int[] arr = new int[n];

		for(i = 0;i<n;i++)
		{
			System.out.print(i+1 + " : ");
			arr[i] = input.nextInt();
		}

		// 3 4 1 5 7

		for(i=0;i<n;i++)
		{
			
			int minIdx = i; // 4

			for(j=i+1;j<n;j++) // 5 7
			{
				if(arr[j] < arr[minIdx]) // 5 < 4
				{
					minIdx = j; // j = 3; 
				}
			}

			temp = arr[i];	// temp = 4
			arr[i] = arr[minIdx]; // i = 4
 			arr[minIdx]= temp; // min = 4
			
		} 

		// 1,4 3 5 7 pass 1
		// 1 3,4 5 7 pass 2
		// 1 3 4,5 7 pass 3

		System.out.println("Sorted array : ");
		for(i=0;i<n;i++)
		{
			System.out.println(arr[i]);
		}
		
	}
}