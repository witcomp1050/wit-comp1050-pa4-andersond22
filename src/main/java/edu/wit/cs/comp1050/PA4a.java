package edu.wit.cs.comp1050;

//Command-line program that helps to decrypt a message that has been encrypted using a Caesar cipher
public class PA4a {
	
	/**
	 * Error if incorrect command-line arguments are supplied
	 */
	public static final String ERR_USAGE = "Please supply correct inputs: <encrypted string> <substring>";
	
	/**
	 * Error if shift could not be found
	 */
	public static final String ERR_NONE = "No valid shifts found.";

	/**
	 * Outputs all shifts of the encrypted string
	 * that contain the supplied substring
	 * 
	 * @param args command-line arguments: <encrypted string> <substring>
	 */
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println(ERR_USAGE);
			System.exit(0);
		}
		StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < args.length - 1; i++) {
	    	sb.append(args[i]).append(" ");
	    }
	    String main = sb.toString();
	    String sub = args[args.length - 1];

	    Shifter e = new Shifter(main);
	    int[] found = e.findShift(sub);
	    if(found.length == 0) {
	    	System.out.println(ERR_NONE);
	    	System.exit(0);
	    }
	    for(int j = 0; j < found.length; j++) {
	    	if(found[j] < 10) {
	    		System.out.print("0" + found[j] + ": "); 
	    	}else {
	    	System.out.print(found[j] + ": "); 
	    	}
	    	for(int k = 0; k < main.length(); k++) {
	    	System.out.print(Shifter.shift1(main.charAt(k), found[j]));
	    }
	    	System.out.println();
	    }
}
}
