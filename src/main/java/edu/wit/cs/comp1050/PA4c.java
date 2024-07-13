package edu.wit.cs.comp1050;
import java.util.Scanner;
import java.util.ArrayList;

//Reads any number of integers from the console (via a Scanner), stores them in an ArrayList, removes duplicates from the list, and then outputs the remaining distinct values.
public class PA4c {
	
	/**
	 * Removes all duplicate values
	 * from the supplied list
	 * 
	 * @param list list from which to remove repeated elements
	 */
	public static void removeRepeated(ArrayList<Integer> list) {
		ArrayList<Integer> store = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
            if (!store.contains(list.get(i))) {
                store.add(list.get(i));
            }
        }
		 list.clear();
		 list.addAll(store);
	}

	/**
	 * Reads numbers from the keyboard and
	 * outputs the list of distinct values
	 * 
	 * @param args command-line arguments, ignored
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Enter integers: ");
		while(in.hasNextInt()) {
			int number = in.nextInt();
			list.add(number);
		}
		if(list.size() == 0) {
			System.out.println("No values entered.");
			System.exit(0);
		}
		removeRepeated(list);
		System.out.print("The distinct integer(s): " + list);
		in.close();
	}

}
