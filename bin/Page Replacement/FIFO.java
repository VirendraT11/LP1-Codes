import java.util.*;

public class FIFO {

    
    public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the reference string:");
        int refLength = sc.nextInt();

        System.out.println("Enter the size of the frame:");
        int frameSize = sc.nextInt();

        int pointer = 0;
        int hit = 0, fault = 0;
        int search;

        int[] buffer = new int[frameSize];
        int[][] memLayout = new int[refLength][frameSize];

        int[] reference = new int[refLength];
        System.out.println("Enter the reference string:");
        for (int i = 0; i < refLength; i++) {
            reference[i] = sc.nextInt();
        }

        for (int i = 0; i < frameSize; i++) {
            buffer[i] = -1;
        }

        for (int i = 0; i < refLength; i++) {
            search = -1;
            for (int j = 0; j < frameSize; j++) {
                if (reference[i] == buffer[j]) {
                    hit++;
                    search = j;
                    break;
                }
            }

            if (search == -1) {
                buffer[pointer] = reference[i];
                pointer++;
                fault++;
                if (pointer == frameSize) {
                    pointer = 0;
                }
            }

            for (int j = 0; j < frameSize; j++) {
                memLayout[i][j] = buffer[j];
            }
        }

        System.out.println("\nMemory Layout:");
        for (int i = 0; i < refLength; i++) {
            for (int j = 0; j < frameSize; j++) {
                if (memLayout[i][j] == -1) {
                    System.out.print("-1");
                } else {
                    System.out.print(memLayout[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("\nTotal Hits: " + hit);
        System.out.println("Total Faults: " + fault);

        sc.close();  
    }
    
}