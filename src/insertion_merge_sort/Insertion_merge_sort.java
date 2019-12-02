
package insertion_merge_sort;

import java.util.ArrayList;
import java.util.Random;

public class Insertion_merge_sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long startTime, endTime;
        double duration;
        
        // generate list of any number of Strings
        ArrayList<String> list = new ArrayList<>();
        
        // to control number of items in list just change number of 
        // second condition ( i < anynumber )
        for(int i=0;i<200;i++){
            list.add(randomString());
        }
        
        //you can comment any function to test other function
        //comment this "startInsertionSort" or this "startMergeSort"
        startTime = System.currentTimeMillis();
        //startInsertionSort(list);
        startMergeSort(list);
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime));
        System.out.println("duration is "+duration);
        
    }
    
    public static void startInsertionSort(ArrayList<String> myList){
       int i,j;
       String key;
        ArrayList<String> inputArray = myList ;
        
        //show lift before sorting
        System.out.print("[");
        for(String item : inputArray){
            System.out.print(item +" , ");
        }
        System.out.println("]");
        
        // sorting
        for (j = 1; j < inputArray.size(); j++) { 
          key = inputArray.get(j);
          i = j - 1;
            while (i >= 0) {
            if (key.compareTo(inputArray.get(i)) > 0) {
                break;
            }
             inputArray.set(i+1 , inputArray.get(i)) ;
             i--;
            }
            
            inputArray.set(i+1, key);
            
           // to show list after each loop
          System.out.print("[");
          for(String item : inputArray){
              System.out.print(item+" , ");
          }
          System.out.println("]");
        }
        
        // show final result after sorting
        System.out.print("\n final result\n");
        System.out.print("[");
        for(String item : inputArray){
            System.out.print(item+" , ");
        }
        System.out.println("]");
    } 
      
    public static void startMergeSort(ArrayList<String> list){
        System.out.print("[");
        for(String item : list){
            System.out.print(item +" , ");
        }
        System.out.println("]");
        
        mergeSort(list, 0, list.size() - 1);
    }
    
    public static void mergeSort(ArrayList<String> a, int from, int to) {
        
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // sort the first and the second half
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
        
        //show in sorting
        System.out.print("[");
        for(String item : a){
            System.out.print(item +" , ");
        }
        System.out.println("]");
    }

    public static void merge(ArrayList<String> a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[] b = new String[n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {
            if (a.get(i1).compareTo(a.get(i2)) < 0) {
                b[j] = a.get(i1);
                i1++;
            } else {
                b[j] = a.get(i2);
                i2++;
            }
            j++;
        }

        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {
            b[j] = a.get(i1);
            i1++;
            j++;
        }

        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[j] = a.get(i2);
            i2++;
            j++;
        }

        // copy back from the temporary array
        for (j = 0; j < n; j++) {
           // a[from + j] = b[j];
           a.set(from + j, b[j]);
        }
    }
    
     // generate random string consist of 6 char
    public static String randomString(){
      String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz";
      String word = "";
      Random random = new Random();
    
      for ( int i=0 ; i<6 ; i++ ){ 
          word += allChars.charAt(random.nextInt(allChars.length()));
      }
      return word;
    }
 
}
