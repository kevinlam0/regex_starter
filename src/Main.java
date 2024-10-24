import java.util.*;

public class Main{

	/* A quicker way to print things out */
	public static void p(String toPrint){
		System.out.println(toPrint);
	}

	public static void main(String[] args){

		/* Reads in the input and calls appropriate methods. */
		/* You DO NOT need to change anything here, but should read it over. */

		p("Enter Regular Expression:");

		Scanner in = new Scanner(System.in);
		String regEx = in.next();

		p("The expression you entered is: " + regEx);

		/* Build the NFA from the regular expression */
		NFA nfa = buildNFA(regEx);

		/* You can uncomment this line if you want to see the */
		/* machine your buildNFA method produced */
		//p("Machine: " + nfa);

		/* Read in the number of strings */
		int n = in.nextInt();

		for(int i=0; i<n; i++){
			String input = in.next();

			/* See if the NFA accepts it! */
			if(nfa.acceptsString(input)) p("YES");
			else p("NO");
		}
	}


	/*
	 * buildNFA: Given a regular expression as a string, build the NFA object that
	 * represents a machine that would accept that regular expression.
	 * Psuedo-code is provided for your convenience
	 */
	public static NFA buildNFA(String exp){

		/* TODO: IMPLEMENT THIS METHOD */
		/* --------------------------------------------- */

		/* Case 1 - Base Case: exp is empty string, nothing to do */
		if (exp.length() == 0) { return null;}

		/* Case 2 - Look for U operator (will never be inside parens so don't need to worry about that) */

		/*
		If exp contains "U" operators
			Split exp into all the segments between the Us (e.g., aaUddUda => [aa,dd,da])
			
			Recursively call buildNFA on each individual segment (e.g., aa)
			
			Call the union() method on the NFA objects returns to patch them together.
			
			return the unioned NFA
		*/
		if (exp.contains("U")) {
			String[] segments = exp.split("U");
			NFA[] builtNfas = new NFA[segments.length];
			for (int i = 0; i < segments.length; i++) {
				builtNfas[i] = buildNFA(segments[i]);
			}

			NFA mainNfa = builtNfas[0];
			for (int j = 0; j < builtNfas.length; j++) {
				mainNfa.union(builtNfas[j]);
			}
		}





		/* Case 3 - First character of exp is 'a' or 'd' */

		/*
		If first character is 'a' or 'd'
			Create an NFA object that has start state and single 'a' / 'd'
			transition to a final state

			If the character after the 'a' or 'd' is the * operator
				call star() on the nfa you just built
				concatenate() with the NFA for rest of the expression (after the star)
			Else if the character after 'a' or 'd' is not the * operator
				just concatenate() with the NFA for rest of the expression

			Return the NFA that was built
		*/
		

		

		/* Case 4 - First character is an open paren */

		/*
		If first character is open paren
			Work your way down the exp to find index of closing paren that matches this one.

			Call buildNFA() on everything within the parentheses

			Call star() on this NFA (because right paren must have * after it)

			Concatenate with the NFA for the rest of the expression after the *
		*/

		/* --------------------------------------------- */

		/* Should never happen...but here so code compiles */
		return null;

	}
}