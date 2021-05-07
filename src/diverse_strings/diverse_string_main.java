package diverse_strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class diverse_string_main {
	static StringBuilder sb = new StringBuilder();
	static char[] alphabet = new char[3];;
	static int freq = 0;
    static boolean isfound = false;

	public static void main(String[] args) {
		System.out.println("Enter 3 numbers (a,b,c) : ");
		Scanner scan = new Scanner(System.in);
		int anum = scan.nextInt(); 
		int bnum = scan.nextInt(); 
		int cnum = scan.nextInt();
		scan.close(); 
		
		Integer[] arr = { anum, bnum, cnum};
		Arrays.sort(arr , Collections.reverseOrder()); 
		
		sortAlpha(arr, anum, bnum, cnum);
		
		while(anum > 0 || bnum > 0 || cnum > 0 ) {
			for(int x=0; x < arr.length ; x++) {
				if(arr[x] > 0) {
					arr[x] = stringUpdater(arr[x]);
				}
				
				switch(sb.charAt(sb.length()-1)) {
				case 'a': anum = arr[x]; break;
				case 'b': bnum = arr[x]; break;
				case 'c': cnum = arr[x]; break;
				}
				
				freq = (freq == 2) ? 0 : freq+1;
			}
			
			if(isfound) {
				break;
			}
		}
		
		System.out.println("Longest diverse string: " + sb);
	}
	
	public static int stringUpdater(int x) {
		String prevString = sb.toString();
		for(int y=0; y<2 && y <x ;y++, x--) {
			sb.append(alphabet[freq]);
		}
		 if(isValid()) {
			isfound = true; 
            sb = new StringBuilder(prevString);
		}
		return x; 
	}
	
	public static boolean isValid() {
		String ps = "([a-zA-Z])\\1\\1+";
		Pattern p = Pattern.compile(ps);
		Matcher match = p.matcher(sb);
		return match.find();
	}
	
	 // Function to sort map by Key
    public static void sortAlpha(Integer[] arr, int a , int b, int c)
    {
    	boolean isA = false;
    	boolean isB = false; 
    	boolean isC = false; 
    	
		alphabet = new char[3];
		for(int x=0; x < arr.length ; x++) {
			if(arr[x]==a && !isA) {
				alphabet[x]='a';
				isA = true; 
			} else if(arr[x]==b && !isB) {
				alphabet[x]='b';
				isB = true;
			} else if(arr[x]==c && !isC) {
				alphabet[x]='c';
				isC = true;
			}
		}    
    }
}
