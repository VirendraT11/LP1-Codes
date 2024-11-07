
import java.util.*;
public class fcfs {
	public static void main(String[] args) {
	
		Scanner sc= new Scanner(System.in);		
		System.out.println("ENTER THE SIZE OF AT");
		int n=sc.nextInt();

		int PID[]=new int[n];
		int AT[]=new int[n];
		int BT[]=new int[n];
		int CT[]=new int[n];
		int TAT[]=new int[n];
		int WT[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the process Id");
			PID[i]=sc.nextInt();
			System.out.println("Enter the Arrival Time");
			AT[i]=sc.nextInt();
			System.out.println("Enter the Bus Time");
			BT[i]=sc.nextInt();
		}
		
		
		for(int i=0;i<n;i++)
		{
			for (int j=0;j<n-1;j++)
			{
				if(AT[j]>AT[j+1])
				{
					int temp=AT[j];
					AT[j]=AT[j+1];
					AT[j+1]=temp;
					
					temp=BT[j];
BT[j]=BT[j+1];
					BT[j+1]=temp;
					
					temp=PID[j];
					PID[j]=PID[j+1];
					PID[j+1]=temp;
				}
			}
		}
		for(int i=0;i<n;i++) 
		{
			if(i==0)
			{
				CT[i]=AT[i]+BT[i];
			}
			else
			{
				if(AT[i]>CT[i-1])
				{
					CT[i]=AT[i]+BT[i];
				}
				else
				{
					CT[i]=CT[i-1]+BT[i];
				}
			}
			
		}
		
		for(int i=0;i<n;i++)
		{
			TAT[i]=CT[i]-AT[i];
			WT[i]=TAT[i]-BT[i];
		}
		
		
		
		System.out.println("Process\tAT\tBT\tCT\tTAT\tWT");
		
		for(int i=0;i<n;i++)
		{
		System.out.println(PID[i] +"\t" +AT[i] +"\t" +CT[i] +"\t" +BT[i] +"\t" +TAT[i] +"\t" + WT[i]);
		}
	sc.close();
	}
	}
