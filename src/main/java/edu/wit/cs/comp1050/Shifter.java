package edu.wit.cs.comp1050;

import java.util.ArrayList;

//Constructed with the encrypted string, and then has methods to both shift by an arbitrary amount and find substrings across all shifts.
public class Shifter {
	
	private String s;
	
	/**
	 * Number of letters in the English alphabet
	 */
	public static final int NUM_LETTERS = ('z' - 'a') + 1;
	
	/**
	 * Initializes the shifter
	 * 
	 * @param s encrypted string
	 */
	public Shifter(String s) {
		this.s = s;
	}

    /**
     * A static method that shifts a character
     * by n positions (either positive or negative).
     * Ignores any non-letter characters.
     *
     * @param c the character
     * @param n amount to shift
     * @return shifted character by a supplied amount
     * 
     * @param n number of places to shift 
     * @return shifted string
     */
    public static char shift1(char c, int n) {
        if((c < 'A') || (c > 'z')) {
        	return c;
        }
        if((c < 'a') && (c > 'Z')){
        	return c;
        }
        
        if(c >= 'A' && c <= 'Z') {
        	char d = (char) (c + n);
    		if(d > 'Z') {
    			while(d > 'Z') {
    				d = (char) (d - 26);
    			}
    			return d;
    		}
    		if(d < 'A') {
    			while(d < 'A') {
    				d = (char) (d + 26);
    			}
    			return d;
    		}
    		return d;
        	}
        
        if(c >= 'a' && c <= 'z') {
        	char d = (char) (c + n);
    		if(d > 'z') {
    			while(d > 'z') {
    				d = (char) (d - 26);
    			}
    			return d;
    		}
    		if(d < 'a') {
    			while(d < 'a') {
    				d = (char) (d + 26);
    			}
    			return d;
    		}
    		return d;
        	}
        return ' ';
        
    }
	
	/**
	 * Returns the result of shifting
	 * by a supplied amount
	 * 
	 * @param n number of places to shift 
	 * @return shifted string
	 */
	public String shift(int n) {
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i < s.length(); i++) {
			sb.setCharAt(i, shift1(s.charAt(i), n));
		}
		String result = sb.toString();
		return result;
	}
	
	/**
	 * Finds all shifts that contain
	 * the supplied substring
	 * 
	 * @param sub substring to find
	 * @return array of shifts (0-25) that contain the substring (in order)
	 */
	public int[] findShift(String sub) {
        ArrayList<Integer> found = new ArrayList<>();
        String a;
        for(int i = 0; i <= 25; i++) {
        	   StringBuilder sb = new StringBuilder(s);
			for(int j = 0; j < sb.length(); j++) {
				sb.setCharAt(j,  shift1(s.charAt(j), i));
				
			}	
			a = sb.toString();
			if(a.contains(sub)) {
				found.add(i);
			}
        }
        
        // Convert ArrayList to int array
        // Leave alone!
        int[] foundAsArray = new int[found.size()];
        for (int i = 0; i < found.size(); i++) {
            foundAsArray[i] = found.get(i);
        }

        return foundAsArray;
	}

}
