import java.util.Scanner;

public class Fcfs {
	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp;
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	};
	
	public static void main(String[] args) {
		// Testing values
		// int[] pid = {1,2,3,4,5};
		// int[] arrival = {5,3,2,2,5};
		// int[] burst = {10,2,4,4,2};
		
		// int[] completion = {0,0,0,0,0};
		// int[] wait = {0,0,0,0,0};
		// int[] turnaround = {0,0,0,0,0};

		// For taking inputs
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no. of processes: ");
		int n = s.nextInt();
		int[] pid = new int[n];
		int[] arrival = new int[n];
		int[] burst = new int[n];
		int[] completion = new int[n];
		int[] wait = new int[n];
		int[] turnaround = new int[n];

		for (int i = 0; i < n; i++) {
			pid[i] = i;
			System.out.println("Enter arrival for P" + i);
			arrival[i] = s.nextInt();
			System.out.println("Enter burst for P" + i);
			burst[i] = s.nextInt();
		}
		s.close();
		
    System.out.println("FCFS Scheduling");
		System.out.println("\nBEFORE SORT\n");
		System.out.println("PID AT BT");
		for (int i = 0; i < arrival.length; i++) {
			System.out.println(pid[i] + "   " + arrival[i] + "  " + burst[i]);
		}
		
		// Sorting
		for (int i = 0; i < arrival.length - 1; i++) {
			for (int j = 0; j < arrival.length - 1; j++) {
				if (arrival[j] > arrival[j+1]) {
					int temp;
					
					// Modifying arrival
					temp = arrival[j+1];
					arrival[j+1] = arrival[j];
					arrival[j] = temp;
					
					// Modifying pid
					temp = pid[j+1];
					pid[j+1] = pid[j];
					pid[j] = temp;
					
					// Modifying burst
					temp = burst[j+1];
					burst[j+1] = burst[j];
					burst[j] = temp;
				}
			}
		}
		
		// Print test
		System.out.println("\nAFTER SORT\n");
		System.out.println("PID AT BT");
		for (int i = 0; i < arrival.length; i++) {
			System.out.println(pid[i] + "   " + arrival[i] + "  " + burst[i]);
		}
		
		// Computing values
		completion[0] = arrival[0] + burst[0];
		for (int i = 1; i < arrival.length; i++) {
			if (arrival[i] > completion[i-1]) {
				completion[i] = burst[i] + arrival[i];
			} else {
				completion[i] = burst[i] + completion[i-1];
			}
		}
		
		float totalwt = 0;
		float totaltat = 0;
		
		for (int i = 0; i < arrival.length; i++) {
			turnaround[i] = completion[i] - arrival[i];
			wait[i] = turnaround[i] - burst[i];
			totalwt += wait[i];
			totaltat += turnaround[i];
		}
		
		
		System.out.println("\nFINAL RESULT\n");
		System.out.println("PID AT BT CT WT TAT");
		for (int i = 0; i < arrival.length; i++) {
			System.out.println(pid[i] + "   " + arrival[i] + "  " + burst[i] + "  " + completion[i] + "  " + wait[i] + "  " + turnaround[i]);
		}
		
		// Printing averages
		System.out.println("Avg. Waiting: " + totalwt/5 + "  Avg. TAT: " + totaltat/5);
	}
}
