class bubbleSort
{
	public static void main(String []args)
	{
		int nums[] = {5,4,3,1,6};

		int temp,i,j;

		for(i = 0;i<nums.length;i++)
		{
		    for(j=0;j<nums.length - i -1;j++)
		    {
			if(nums[j] > nums[j+1])
			{
				temp = nums[j+1];
				nums[j+1] = nums[j];
				nums[j] = temp;
			}
		    }
		}
		
		System.out.println("Sorted array : ");
		for(i = 0;i<nums.length;i++)
		{
			System.out.println(nums[i]);
		}
	}
}