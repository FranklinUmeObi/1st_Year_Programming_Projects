
	import java.util.ArrayList ;
	
	public class BonusAssignment {

		  /**
		   * Validation method for prefix notation.
		   *
		   * @param prefixLiterals : an array containing the string literals hopefully in prefix order.
		   * The method assumes that each of these literals can be one of:
		   * - "+", "-", "*", or "/"
		   * - or a valid string representation of an integer.
		   *
		   * @return true if the parameter is indeed in prefix notation, and false otherwise.
		   **/
		  public static boolean validatePrefixOrder(String prefixLiterals[])
		  {
		    int counter = 1;
		    boolean wasZeroOrNeg = false ;
		    for(String character : prefixLiterals)
		    {
		      if(counter <= 0) wasZeroOrNeg = true ;
		      if(character == "+" || character == "-" || character == "*" || character == "/") counter++;
		      else counter--;
		    }
		    if(wasZeroOrNeg == true) return false ;
		    else if (counter == 0) return true;
		    else return false ;
		  }


		  /**
		   * Validation method for postfix notation.
		   *
		   * @param postfixLiterals : an array containing the string literals hopefully in postfix order.
		   * The method assumes that each of these literals can be one of:
		   * - "+", "-", "*", or "/"
		   * - or a valid string representation of an integer.
		   *
		   * @return true if the parameter is indeed in postfix notation, and false otherwise.
		   **/

		  public static boolean validatePostfixOrder(String postfixLiterals[])
		  {
		    /*
		    Initialize the counter to 0.
		    When you see a literal, increment the counter.
		    When you see a binary operator, decrement the counter twice,
		    then increment it later after checking if it fell below 0.
		    At the end of the string, if the counter is 1, and if it
		    never went below 0, the string is valid
		    */
		    int counter = 0;
		    boolean wasNeg = false ;
		    boolean incrementNeeded = false;
		    for(String character: postfixLiterals)
		    {
		      if(character == "+" || character == "-" || character == "*" || character == "/")
		      {
		        counter -= 2;
		        incrementNeeded = true;
		      }
		      else if(Integer.parseInt(character) > -99999 ) counter++ ;// check if its an int

		      if(counter < 0) wasNeg = true ;
		      if(incrementNeeded) counter++;
		      incrementNeeded = false;
		    }
		    if(wasNeg == true) return false ;
		    else if (counter == 1) return true;
		    else return false ;
		  }


		  //~ Evaluation  methods ...............................................................................................................................................

		  
		  /**
		   * Evaluation method for prefix notation.
		   *
		   * @param prefixLiterals : an array containing the string literals in prefix order.
		   * The method assumes that each of these literals can be one of:
		   * - "+", "-", "*", or "/"
		   * - or a valid string representation of an integer.
		   *
		   * @return the integer result of evaluating the expression
		   **/
		  public static int evaluatePrefixOrder(String prefixLiterals[])
		  {
			  int finalResult = -99999;
			  if(validatePrefixOrder(prefixLiterals))
			  {
				  ArrayList<String> stack = new ArrayList<String>();
				  for(int i=prefixLiterals.length-1 ; i > -1 ; i--)
				  {
		            String element = prefixLiterals[i];
		            if(element == "+" || element == "-" || element == "*" || element == "/")
				      {
				        int n1 = Integer.parseInt(stackPop(stack)) ;
				        int n2 = Integer.parseInt(stackPop(stack)) ;
				        int result = -99999;
				        if(element == "+") result = n1 + n2;
				        else if(element == "-") result = n1 - n2;
				        else if(element == "*") result = n1 * n2;
				        else if(element == "/") result = n1 / n2;
				        stackPush(stack, Integer.toString(result));
				        finalResult = result;
				      }
		            else if(Integer.parseInt(element) > -90000 ) stackPush(stack, element) ;// check if its a number then push
		          }

			  }
		    return finalResult;
		  }


		  /**
		   * Evaluation method for postfix notation.
		   *
		   * @param postfixLiterals : an array containing the string literals in postfix order.
		   * The method assumes that each of these literals can be one of:
		   * - "+", "-", "*", or "/"
		   * - or a valid string representation of an integer.
		   *
		   * @return the integer result of evaluating the expression
		   **/
		  public static int evaluatePostfixOrder(String postfixLiterals[])
		  {
			  int finalResult = -99999;
			  if(validatePostfixOrder(postfixLiterals))
			  {
				  ArrayList<String> stack = new ArrayList<String>();
				  for(String element : postfixLiterals)
			  		{
					  if(element == "+" || element == "-" || element == "*" || element == "/")
				      {
				        int n2 = Integer.parseInt(stackPop(stack)) ;
				        int n1 = Integer.parseInt(stackPop(stack)) ;
				        int result = -99999;
				        if(element == "+") result = n1 + n2;
				        else if(element == "-") result = n1 - n2;
				        else if(element == "*") result = n1 * n2;
				        else if(element == "/") result = n1 / n2;
				        stackPush(stack, Integer.toString(result));
				        finalResult = result;
				      }
				      else if(Integer.parseInt(element) > -90000 ) stackPush(stack, element) ;// check if its a number then push
			  		}
			  }
			 // else System.out.println("That was not a valid Postfix equation");
			  return finalResult;
		  }


		  //~ Conversion  methods .................................................................................................................................................


		  /**
		   * Converts prefix to postfix.
		   *
		   * @param prefixLiterals : an array containing the string literals in prefix order.
		   * The method assumes that each of these literals can be one of:
		   * - "+", "-", "*", or "/"
		   * - or a valid string representation of an integer.
		   *
		   * @return the expression in postfix order.
		   **/
		  public static String[] convertPrefixToPostfix(String prefixLiterals[])
		  {
			  String equation = "";
			  if(validatePrefixOrder(prefixLiterals))
			  {
				  ArrayList<String> stack = new ArrayList<String>();
				  for(int i = prefixLiterals.length - 1 ; i > -1 ; i--)
				  {
		            String element = prefixLiterals[i];
		            if(element == "+" || element == "-" || element == "*" || element == "/")
				      {
				        String op1 = stackPop(stack) ;
				        String op2 = stackPop(stack) ;
				        String result = op1 + "  " + op2+ "  "+ element ;
				        stackPush(stack, result) ;
				      }
		            else stackPush(stack, element) ;// check if its a number then push
				  }
				  equation = stackPop(stack);
				 // System.out.println(equation);
			  }
			 // else System.out.println("That was not a valid Prefix equation");
			  equation.replaceAll("\\s+"," ");
			  String[] postfix = equation.split("  ");
			  return postfix;
		  }


		  /**
		   * Converts postfix to prefix.
		   *
		   * @param prefixLiterals : an array containing the string literals in postfix order.
		   * The method assumes that each of these literals can be one of:
		   * - "+", "-", "*", or "/"
		   * - or a valid string representation of an integer.
		   *
		   * @return the expression in prefix order.
		   **/
		  public static String[] convertPostfixToPrefix(String postfixLiterals[])
		  {
			  String equation = "";
			  if(validatePostfixOrder(postfixLiterals))
			  {
				  ArrayList<String> stack = new ArrayList<String>();
				  for(int i = 0 ; i < postfixLiterals.length ; i++)
				  {
		            String element = postfixLiterals[i];
		            if(element == "+" || element == "-" || element == "*" || element == "/")
				      {
				        String op1 = stackPop(stack) ;
				        String op2 = stackPop(stack) ;
				        String result = element + " " +  op2 + " " + op1 ;
				        stackPush(stack, result) ;
				      }
		            else stackPush(stack, element) ;// check if its a number then push
				  }
				  equation = stackPop(stack);
				  //System.out.println(equation);
			  }
			  //else System.out.println("That was not a valid Postfix equation");
			  equation.replaceAll("\\s+"," ");

			  String[] prefix = equation.split(" ");
			  return prefix;
		  }

		  /**
		   * Converts prefix to infix.
		   *
		   * @param infixLiterals : an array containing the string literals in prefix order.
		   * The method assumes that each of these literals can be one of:
		   * - "+", "-", "*", or "/"
		   * - or a valid string representation of an integer.
		   *
		   * @return the expression in infix order.
		   **/
		  public static String[] convertPrefixToInfix(String prefixLiterals[])
		  {
			  /*
			   * Read the Prefix expression in reverse order (from right to left)
				If the symbol is an operand, then push it onto the Stack
				If the symbol is an operator, then pop two operands from the Stack
				Create a string by concatenating the two operands and the operator between them.
				string = (operand1 + operator + operand2)
				And push the resultant string back to Stack
				Repeat the above steps until end of Prefix expression.
			   */

			  String equation = "";
			  if(validatePrefixOrder(prefixLiterals))
			  {
				  ArrayList<String> stack = new ArrayList<String>();
				  for(int i = prefixLiterals.length - 1 ; i > -1 ; i--)
				  {
		            String element = prefixLiterals[i];
		            if(element == "+" || element == "-" || element == "*" || element == "/")
				      {
		            	//String operator = stackPop(stack) ;
				        String op1 = stackPop(stack) ;
				        String op2 = stackPop(stack) ;
				        String result = "(" + op1 + element + op2 + ")" ;
				        System.out.println(result);
				        stackPush(stack, result) ;
				      }
		            else stackPush(stack, element) ;// check if its a number then push
				  }
				  equation = stackPop(stack);
				 // System.out.println(equation);
			  }
			  else System.out.println("That was not a valid Prefix equation");
			  String[] infix = equation.split("");
			  return infix;
		  }

		  /**
		   * Converts postfix to infix.
		   *
		   * @param infixLiterals : an array containing the string literals in postfix order.
		   * The method assumes that each of these literals can be one of:
		   * - "+", "-", "*", or "/"
		   * - or a valid string representation of an integer.
		   *
		   * @return the expression in infix order.
		   **/
		  public static String[] convertPostfixToInfix(String postfixLiterals[])
		  {
			  /*
			   * While there are input symbol left
				Read the next symbol from the input.
				If the symbol is an operand Push it onto the stack.
				Otherwise,the symbol is an operator.
				Pop the top 2 values from the stack.
				Put the operator, with the values as arguments and form a string.
				Push the resulted string back to stack.
				If there is only one String equation = "";
				*/

			  String equation = "";
			  if(validatePostfixOrder(postfixLiterals))
			  {
				  ArrayList<String> stack = new ArrayList<String>();
				  for(int i = 0 ; i < postfixLiterals.length ; i++)
				  {
		            String element = postfixLiterals[i];
		            if(element == "+" || element == "-" || element == "*" || element == "/")
				      {
				        String op1 = stackPop(stack) ;
				        String op2 = stackPop(stack) ;
				        String result =  "(" + op2 + element + op1 + ")" ;
				        stackPush(stack, result) ;
				      }
		            else stackPush(stack, element) ;// check if its a number then push
				  }
				  equation = stackPop(stack);
				  //System.out.println(equation);
			  }
			  else System.out.println("That was not a valid Postfix equation");
			  String[] infix = equation.split("");
			  return infix;


		  }


		  	//
		    //  --MY PERSONAL METHODS--
		    //

		  public static void stackPush(ArrayList<String> stack, String element)
		  {
		    stack.add(element);
		  }
		  public static String stackPop(ArrayList<String> stack)
		  {
		    int indexToPop = stack.size() - 1;
		    String poppedElement = stack.get(indexToPop);
		    stack.remove(indexToPop);
		    return poppedElement;
		  }

	}

