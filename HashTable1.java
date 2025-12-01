//Hashing techniques

import java.util.*;

class HashTable1
{
	private Integer[] table;
	private int size;
	private int capacity;

	public HashTable1(int capacity)
	{
		this.capacity = capacity;
		table = new Integer[capacity];
		size = 0;
	}

	// hash function - Digit extraction
	private int hash(int key)
	{
		return (key%100)%capacity;
	} 

	//using hash function insert keys into table
	public void Insert(int key)
	{
		if(size > capacity)
		{
			System.out.println("Hash table is Full !");
			return;
		}
	
		int index = hash(key);
		
		while(table[index] != null)
		{
			//linear probing
			index = (index + 1) % capacity; 
		}

		table[index] = key;
		size++;
	}
	
	//display the hash table
	public void Display()
	{

		for(int i = 0;i<capacity;i++)
		{
			if(table[i] != null)
			{
				System.out.println("index " + i + " : " + table[i]);
			}
			else
			{
				System.out.println("index " + i + " : Null");
			}
		}
	}

	public static void main(String []args)
	{
		int keys[] = {10,200,30,40,50,60,70,80};

		HashTable1 h = new HashTable1(15);
		for(int key : keys)
		{
			h.Insert(key);
		}

		h.Display();
	}
	
	

}
