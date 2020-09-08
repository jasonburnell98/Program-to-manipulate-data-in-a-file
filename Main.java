/*
Author: Jason Burnell
Algorithms Project 2: Hurried Herding
Updated:3/7/20
Description: Inputs a filename containing data entry and outputs manipulated results based on the data
*/
import java.util.*;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
      /* Main method that gets a filename from STDIN, gets the contents, and
         prints out results based on indicators in the contents */ 
	public static void main(String[] args) {
    //receive file from scanner
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next(); 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
          //put data into hashmap
	        TreeMap<Integer, int[]> map = new TreeMap<>();
	        reader.readLine();
          String line = reader.readLine(); //first line
          // as long as there is data in file, continue
	        while(line != null) {
              // split up each line and designate the second column items to be action items
              	String[] item = line.split("\\s+");
		        int curr_id = Integer.parseInt(item[0]);
            	String action = item[1];
              // create array to place our info in with empty placeholders
		          int[] array = map.getOrDefault(curr_id, new int[]{0,0,0,0,100000000,0});
              //if item contains weighing, parse to new array 
		          int attr = Integer.parseInt(item[2]);
		          if (action.equals("W")) {
		            if (attr < array[4]) {
		                array[4] = attr;
		                array[5] = attr; 
		            }
		            if (Integer.parseInt(item[3]) >= array[2]) {
		              array[2] = Integer.parseInt(item[3]);
		              array[3] = attr;
                }
                //if contains milkings, get average 
		          }else if (action.equals("M")) {
		            array[1] += attr;
		            array[0] ++;
		          }
		          map.put(curr_id, array);
		          line = reader.readLine();
		        }
		        ArrayList<Map.Entry<Integer, int[]>> ans = new ArrayList<>();
		        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
              // only add an entry if item contains at least one milking and one weighing (Temperature is ignored)
		            if (entry.getValue()[1] != 0 && (entry.getValue()[5] != 0))
		                ans.add(entry);
            }
            //sort and print entries from our new arraylist 
		        Collections.sort(ans, (a, b) -> a.getValue()[5] - b.getValue()[5]);
		        for (Entry<Integer, int[]> entry : ans)
		        	System.out.println(entry.getKey() + " " + entry.getValue()[5] + " " + entry.getValue()[3] + " " + 
		        entry.getValue()[1]/entry.getValue()[0]);
			reader.close();
			} catch (Exception e) {			
	      }
	  }
}
