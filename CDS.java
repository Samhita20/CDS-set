package cds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class CDS {

	public static void selectionSort(int[] a,int low,int high) //3.32
	{
		for(int i=low;i<high;i++) // running the loop from start to end
		{
			int maximum = a[i];
			int index = i;
			
			for(int j=i+1;j<high;j++) // finding minimum and storing the element and index
			{
				if(a[j]>=maximum)
				{
					maximum = a[j];
					index = j;
				}
			}
			
			int t = a[i];  //swap the ith element with the minimum element
			a[i] = maximum;
			a[index] = t;
		}
		
		//for(int i=low;i<high;i++)
			//System.out.print(a[i]+" ");
	}
	
	public static int mismatch(int n, int[] a, int[] b) //3.30
	{
		int count = 0;
		
		for(int i=0;i<n;i++) // iterate through all the elements - O(n^2)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i]+b[j]==0) //n && -n; 0 && 0
					count++;
			}
		}
		return n-count;
	}
	 public static void commonElements(int n1, int n2, int[] a, int[] b) //3.28
	 {
			Set<Integer> set = new HashSet<Integer>(); // set so that repeated elements are not counted
			int size = 0;
			
			for(int i=0;i<n1;i++)
			{
				for(int j=0;j<n2;j++)
				{
					if(a[i]==b[j])
					{
						set.add(a[i]);
						size++;
					}
				}
			}
			
			for(Integer i : set) //printing elements of set
				System.out.print(i+" ");
			
	}
	public static int firstElementFound(int n1, int n2, int[] a, int[] b) //3.25
	{
		int firstElement=-1;
		ArrayList<Integer> blist = new ArrayList<>();
		
		for(int i=0;i<n2;i++)
			blist.add(b[i]);
		
		for(int i=0;i<n1;i++)
		{
			if(blist.contains(a[i])==true)
				continue;
			else
				firstElement = a[i];
		}
		
		return firstElement;
	}
	public static void reverseBetweenIndexes(int low, int high, int n, int[] a) //3.16
	{
		selectionSort(a,low,high);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
	}
	public static int checkForAllIntegers(int[] a, int n) //3.12
	{
		for(int i=0;i<n;i++)
		{
			if(a[i]!=i)
				return i;
		}
		return -1;
	}
	public static void checkValues(int p, int q,int r, int s) //1.7
	{
		if((r>0) && (s>0) && (p%2==0))
		{
			if((q>r) && (s>p) && (r+s>p+q))
				System.out.println("Correct values");
			else
				System.out.println("Wrong values");
		}
		else
			System.out.println("Wrong input");
	}
	public static boolean checkMultiple(int n, int m)//1.9
	{
		if(m%n==0)
			return true;
		else
			return false;
	}
	public static void findDivisors(int n)//1.16
	{
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
				System.out.println(i);
		}
	}
	public static void swapElements(int[] a) //1.17
    {
        int n = 5;
        int i,j;
        
        for(i=0,j=n-1;i<n/2;i++,j--)
        {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        
        for(i=0;i<n;i++)
            System.out.println(a[i]+" ");
    } 
	public static int mSum(int N) //1.18; doubt; not getting the right answer; 1.19 and 1.20 related
	{
		int num = 14;
		int sum = 0; 
		int m; //m4 number
		int i = 1;  //14+24+44+... the difference is in AP with a common difference = 10, 
		//so keep increasing the i with +1*10
		m = 1;
		while (m <= N)
		{
			sum += num;
			num += i * 10;
			
			i++;
			m = num / 10;
		}
		
		return sum;
	}
	public static int distanceBetween(int[] a, int n, int x, int y) //3.11
	{
		int separation = 10000;
		int posX = -1;
		int posY = -1;
		
		for(int i=0;i<n;i++)
		{
			if(a[i]==x)
				posX = i;
			else if(a[i]==y)
				posY = i;
			
			if(posX!=-1 && posY!=-1)
				separation = Math.min(separation,Math.abs(posX-posY));
		}
		separation--;
		if(posX==-1 || posY==-1)
			return -1;
		else
			return separation;
	}
	public static int closestValue(int[] a, int n, int target) //3.10
	{
		int index = 0;
		int diff = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++)
		{
			if(Math.abs(target-a[i])<diff)
			{
				diff = Math.abs(target-a[i]);
				index = i;
			}
		}
		
		return index;
	}
	public static void dotsAndStars(int n, int m, int N, int M) //1.22
	{
		/*
		 <-----M----->
			   <--m-->
		^   .............
		|   .............
		|   .............
		| ^ ...***...
		| | ...***...
		N n ...***...
		| | ...***...
		| ^ ...***...
		|   .............
		|   .............
		^   .............
		 */
		//top lines - dots
		for(int i=0;i<(N-n)/2;i++)
		{
			for(int j=0;j<M;j++) //for one line
				System.out.print(".");	
			
			System.out.println(); //got to next line
		}
		
		//middle lines with stars
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<(M-m)/2;j++) //first set of dots
				System.out.print(".");
			
			for(int j=0;j<m;j++) //set of stars
				System.out.print("*");
			
			for(int j=0;j<(M-m)/2;j++) //second set of dots
				System.out.print(".");
			
			System.out.println();//got next line
		}
		
		//bottom lines - dots
		for(int i=0;i<(N-n)/2;i++)
		{
			for(int j=0;j<M;j++) //for one line
				System.out.print(".");	
			
			System.out.println(); //got to next line
		}
	}
	public static void printOddNumbers(int start, int finish) //1.26
	{
		if(start%2==0)
			start--;
		if(finish%2==0)
			finish++;
		
		int count = 0;
		
		for(int i=start;i>=finish;i=i-2)
		{
			if(count%7==0)
				System.out.println();
			
			count++;
			
			System.out.print(i+" ");
		}
	}
	public static void truncatedTriangle(int N, int T, int R) //1.28
	{
		// T - no of stars in top row
		// N - no of stars in base row
		//R - no of rows for triangle to be centered
		
		for(int i=T;i<=N;i=i+2)  // move from top to bottom; the star count increases by 2 as we go down
		{
			for(int j=0;j<(R-i)/2;j++) // spaces before stars
				System.out.print(" "); 
			
			for(int j=0;j<i;j++) // print stars
				System.out.print("*");
			
			System.out.println(); // next line
		}
	}
	public static void shaggyTruncatedTriangle(int N, int T, int R) //1.29
	{
		for(int i=T;i<N;i++)
		{
			for(int j=0;j<(R-i);j++) //spaces
				System.out.print(" "); 
			
			for(int j=0;j<i;j++)
				System.out.print("/");
			
			System.out.print("|");
			
			for(int j=0;j<i;j++)
				System.out.print("\");
			
			System.out.println(); //next line
		}
	}
	public static void pineTree(int levels) // didn't understand this
	{
		shaggyTruncatedTriangle(2,0,levels+1);
		
	}
	public static void randomNumberHistogram(long N) //2.2
	{
		
	}
	public static void charactersOfFive() //2.4.2
	{
		// 500 characters divided into 5 lines of 100 characters each and each line has 
		// groups of 5 characters
		
		char ch = 'a'; //with ASCII of beginning letter all other letters will be   
					   //randomly generated, by randomly generating the ASCII
		
		char randomCharacter; // this will store the random character generated
		
		Random rand = new Random(); //instance of random class
	    int upperbound = 26; 
		
		for(int i=0;i<500;i++)
		{
			randomCharacter = (char)(rand.nextInt(upperbound)+ch); //generate random character
			System.out.print(randomCharacter);
			
			if(i%5==0) // 5 characters have been generated
				System.out.print(" ");
			
			if(i%100==0) // 1 line has been generated
				System.out.println();
		}
		
	}
	public static void randomWords(int N, int maxWordSize) //2.5
	{
		int maxLineSize = 50; // given in question
		int lineLength = 0;
		int wordLength = 0;
		
		char randomCharacter;
		char ch = 'a';
		
		Random rand = new Random(); // instance of random class
		
		wordLength = rand.nextInt(maxWordSize); // generate word length randomly

		for(int i=0;i<N;i++) // for generating N words of random characters
		{
			if((lineLength + wordLength)>maxLineSize) // line overflow
			{
				System.out.println(); // got to next line
				lineLength = 0; // reset line length to 0 for the start of next line
			}
			
			randomCharacter = (char)(rand.nextInt(26)+ch); // generate random character
			System.out.print(randomCharacter);
			
			wordLength--; // word length gets decreased
			lineLength++; // line length increases to reach the maxLineSize
			
			if(wordLength==0)
			{
				System.out.print(" ");
				lineLength++;
				
				while(wordLength==0) // get a new word size if the present one is zero
					wordLength = rand.nextInt(maxWordSize);
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int maxWordSize = sc.nextInt();
		randomWords(N, maxWordSize);
	}

}
