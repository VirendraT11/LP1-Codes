public class optimal {

    private static int getOptimalPageIndex(int[] buffer, int[] reference, int currentIndex) {
        int farthest = currentIndex;
        int replaceIndex = 0;

        for (int i = 0; i < buffer.length; i++) {
            int j;
            for (j = currentIndex + 1; j < reference.length; j++) {
                if (buffer[i] == reference[j]) {
                    if (j > farthest) {
                        farthest = j;
                        replaceIndex = i;
                    }
                    break;
                }
            }
            if (j == reference.length) {
                return i;
            }
        }

        return replaceIndex;
    }
	public static void main(String[] args) {
		int[] reference = {1,2,3,4,2,1,5,6,1,2,3,7,6,3,2,1,2,3,6};
		int frame_len = 3, fault = 0, hit = 0,pointer = 0;
		int ref_len = reference.length;
		int[] buffer = new int[3]; 
		int[][] matrix = new int[ref_len][frame_len];
		int[] index = new int[frame_len];
		
		for(int i = 0; i< frame_len;i++) {
			buffer[i]=-1;
		}
		
		for(int i = 0; i< ref_len;i++) {
			
			int search = -1;
			for(int j = 0; j<frame_len;j++) {
				if(buffer[j]==reference[i]) {
					hit++;
					search = 1;
					break;
				}
			}
			
			if(search == -1) {
				int replaceIndex = getOptimalPageIndex(buffer, reference, i);
                buffer[replaceIndex] = reference[i];
                fault++;
				if(pointer == frame_len) pointer =0;
				
			}

			for(int j = 0;j<frame_len; j++) {
					matrix[i][j] = buffer[j];
				}
		}
		
		for(int i=0; i<ref_len;i++) {
			for(int j=0; j<frame_len;j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("Page fault: "+fault+"\tPage hit: "+hit);

	}

}
