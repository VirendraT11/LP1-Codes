import java.util.Scanner;
public class BestFit {


public static class Firstfitt {
     public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of blocks: ");
        int m = sc.nextInt();
        int[] blockSize = new int[m];
        int[] blockNo=new int[m];
  
 

        System.out.println("Enter the block sizes:");
        for (int i = 0; i < m; i++) {
        	blockNo[i]=(i+1);
        	System.out.print("Block " + (i + 1) + ": ");
            blockSize[i] = sc.nextInt();
        }

        
        System.out.print("Enter the number of Jobs: ");
        int n = sc.nextInt();
        int[] JobSize = new int[n];
        int[] JobNo=new int[n];

        System.out.println("Enter the Jobs sizes:");
        for (int i = 0; i < n; i++) {
        	JobNo[i]=(i+1);
            System.out.print("Process " + (i + 1) + ": ");
            JobSize[i] = sc.nextInt();
        }
        
        for(int i=0;i<m-1;i++) 
        {
        	for(int j=0;j<i+1;j++)
        	{
        		if(blockSize[j]>blockSize[j+1])
        		{
        			int temp=blockSize[j];
        			blockSize[j]=blockSize[j+1];
        			blockSize[j+1]=temp;
        			
        			int temp1=blockNo[j];
        			blockNo[j]=blockNo[j+1];
        			blockNo[j+1]=temp1;
        		}
        	}
        }
        for(int i=0;i<n-1;i++) 
        {
        	for(int j=0;j<i+1;j++)
        	{
        		if(JobSize[j]>JobSize[j+1])
        		{
        			int temp2=JobSize[j];
        			JobSize[j]=JobSize[j+1];
        			JobSize[j+1]=temp2;
        			
        			int temp3=JobNo[j];
        			JobNo[j]=JobNo[j+1];
        			JobNo[j+1]=temp3;
        		}
        	}
        }
        
        int allocation[] = new int[n];
        int memoryWastage[] = new int[n];

        for(int i=0; i<allocation.length; i++){
            allocation[i] = -1;
            memoryWastage[i] = -1; 
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (blockSize[j] >= JobSize[i]){ 
                    allocation[i] = j; 
                    memoryWastage[i] = blockSize[j] - JobSize[i]; 
                    blockSize[j] -= JobSize[i];
                    break; 
            }
            }
        }

        
     
        
        System.out.println("\nJob No.\tJob Size\tBlock no.\tMemory Wastage"); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print(" " + JobNo[i] + "\t\t" +  JobSize[i] + "\t\t"); 
            if (allocation[i] != -1){ 
                System.out.print((blockNo[allocation[i]]) + "\t\t" + memoryWastage[i]);
                
            } 
            else{
                System.out.print("Not Allocated");
            }
            
            System.out.println(); 
        }
    }
}

}


