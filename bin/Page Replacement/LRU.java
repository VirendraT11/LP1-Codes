public class LRU {

    private static int getLRUPageIndex(int[] buffer, int[] reference, int currentIndex) {
        int lruIndex = 0;
        int leastRecentlyUsed = currentIndex; // Initialize with the current index

        // Iterate through each page in the buffer
        for (int i = 0; i < buffer.length; i++) {
            boolean found = false;
            // Check the history to find the least recently used page
            for (int j = currentIndex - 1; j >= 0; j--) {
                if (buffer[i] == reference[j]) {
                    found = true;
                    // If found, check if it's the least recently used
                    if (j < leastRecentlyUsed) {
                        leastRecentlyUsed = j;
                        lruIndex = i;
                    }
                    break;
                }
            }
            // If the page was never used, return this index for replacement
            if (!found) {
                return i;
            }
        }

        return lruIndex; // Return the index of the least recently used page
    }

    public static void main(String[] args) {
        int[] reference = {1, 2, 3, 4, 2, 1, 5, 6, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3, 6};
        int frame_len = 3, fault = 0, hit = 0;
        int ref_len = reference.length;
        int[] buffer = new int[frame_len]; 
        int[][] matrix = new int[ref_len][frame_len];
        
        // Initialize buffer with -1
        for (int i = 0; i < frame_len; i++) {
            buffer[i] = -1;
        }
        
        // Process each page reference
        for (int i = 0; i < ref_len; i++) {
            int search = -1;
            // Check if page is already in the buffer
            for (int j = 0; j < frame_len; j++) {
                if (buffer[j] == reference[i]) {
                    hit++;
                    search = 1;
                    break;
                }
            }

            // If the page is not found in the buffer, it's a page fault
            if (search == -1) {
                int replaceIndex = getLRUPageIndex(buffer, reference, i);
                buffer[replaceIndex] = reference[i]; // Replace the LRU page
                fault++;
            }

            // Update the matrix for visual output
            for (int j = 0; j < frame_len; j++) {
                matrix[i][j] = buffer[j];
            }
        }
        
        // Print the resulting page frames
        for (int i = 0; i < ref_len; i++) {
            for (int j = 0; j < frame_len; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
        
        // Print page fault and hit statistics
        System.out.println("Page fault: " + fault + "\tPage hit: " + hit);
    }
}
