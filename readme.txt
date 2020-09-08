This rough algorithm is used to solve this problem:
1. Import file 
2. convert data from file into map
3. convert keys from map into array 
4. loop through map, looking for Milkings(M) and Weighings(W) for same key
5. When found, append the correct values needed to list O(n)
6. Loop through list and sort in ascending order O(nlogn)
7. Print results


Since we are adding each item to the list one at a time from our map, inserting each row into our list is going to be O(r) where r is the number of rows.
Once the items are in the list, sorting them in ascending order is done with javas built in method (.sort) and this is using O(clog(c)) time (c being the number of cows).

The program combines these scenarios, and we are able to achieve a runtime of
O(c*log(c) + r), which is what we were trying to accomplish.
