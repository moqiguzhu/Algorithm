package csy.search;

/**
 * 
 * Description: 
 */
public class BinarySearch {
	public <T extends Comparable> int search(T[] array, T target){
		int l = 0, r = array.length - 1;
		while(l <= r){
			int mid = (l + r) / 2;
			int cmp = target.compareTo(array[mid]);
			if(0 == cmp){
				return mid;
			}
			else if(cmp < 0){
				r = mid - 1;
			}
			else{
				l = mid + 1;
			}
		}
		return -1;//not found
	}
	
	public static void main(String[] args){
		BinarySearch so = new BinarySearch();
		Integer[] test1 = {1, 2, 3, 4, 5, 6, 7, 8};
		String[] test2 = {"andy", "bob", "cat", "doom", "ellen", "filcon"};
		System.out.println(so.search(test1, 5));
		System.out.println(so.search(test2, "cat"));
		System.out.println(so.search(test2, "gg"));
	}
}
