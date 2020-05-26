import static org.junit.Assert.*;

import org.junit.Test;


public class ArithTest {

	@Test
	public void testValidatePrefixOrder() 
	{
		String  a[] =  {"+",  "2",  "5"};
		String b[] =  {"*", "+",  "2",  "5", "7"};
		String c[] =  {"*", "12",  "-",  "5", "7"};
		String d[] =  {"9",  "-",  "5"};
		String  e[] =  {};
		
		assertTrue(BonusAssignment.validatePrefixOrder(a));
		assertTrue(BonusAssignment.validatePrefixOrder(b));
		assertTrue(BonusAssignment.validatePrefixOrder(c));
		assertFalse(BonusAssignment.validatePrefixOrder(d));
		assertFalse(BonusAssignment.validatePrefixOrder(e));
	}

	@Test
	public void testValidatePostfixOrder() {
		String  a[] =  {"2",  "3",  "+"};
		String b[] =  {"8", "9",  "2",  "/", "-"};
		String c[] =  {"9", "12",  "-",  "43", "*"};
		String d[] =  {"9",  "-",  "5"};
		String  e[] =  {};
		
		assertTrue(BonusAssignment.validatePostfixOrder(a));
		assertTrue(BonusAssignment.validatePostfixOrder(b));
		assertTrue(BonusAssignment.validatePostfixOrder(c));
		assertFalse(BonusAssignment.validatePostfixOrder(d));
		assertFalse(BonusAssignment.validatePostfixOrder(e));
	}

	@Test
	public void testEvaluatePrefixOrder() {
		String  a[] =  {"+",  "2",  "5"};
		String b[] =  {"*", "+",  "2",  "5", "7"};
		String c[] =  {"*", "12",  "-",  "8", "7"};
		String d[] =  {"-",  "9",  "5"};
		String  e[] =  {};
		
		assertEquals(7, BonusAssignment.evaluatePrefixOrder(a));
		assertEquals(49, BonusAssignment.evaluatePrefixOrder(b));
		assertEquals(12, BonusAssignment.evaluatePrefixOrder(c));
		assertNotEquals(7, BonusAssignment.evaluatePrefixOrder(d));
		assertEquals(-99999, BonusAssignment.evaluatePrefixOrder(e));
	}

	@Test
	public void testEvaluatePostfixOrder() {
		String  a[] =  {"5",  "2",  "-"};
		String b[] =  {"3", "6",  "2",  "/", "+"};
		String c[] =  {"15", "12",  "-",};
		String d[] =  {"10",  "9",  "*"};
		String  e[] =  {};
		
		assertEquals(3, BonusAssignment.evaluatePostfixOrder(a));
		assertEquals(6, BonusAssignment.evaluatePostfixOrder(b));
		assertEquals(3, BonusAssignment.evaluatePostfixOrder(c));
		assertNotEquals(2, BonusAssignment.evaluatePostfixOrder(d));
		assertEquals(-99999, BonusAssignment.evaluatePostfixOrder(e));
	}
	
	@Test
	public void testConvertPrefixToPostfix() {
		String  a[] =  {"+",  "2",  "5"};
		String b[] =  {"*", "+",  "2",  "5", "7"};
		String c[] =  {"*", "12",  "-",  "5", "7"};
		String d[] =  {"9",  "-",  "5"};
		String  e[] =  {};
		
		assertTrue(BonusAssignment.validatePostfixOrder(BonusAssignment.convertPrefixToPostfix(a)));
		assertTrue(BonusAssignment.validatePostfixOrder(BonusAssignment.convertPrefixToPostfix(b)));
		assertTrue(BonusAssignment.validatePostfixOrder(BonusAssignment.convertPrefixToPostfix(c)));
		assertFalse(BonusAssignment.validatePostfixOrder(BonusAssignment.convertPrefixToPostfix(d)));
		assertFalse(BonusAssignment.validatePostfixOrder(BonusAssignment.convertPrefixToPostfix(e)));
	}

	@Test
	public void testConvertPostfixToPrefix() {
		String  a[] =  {"5",  "2",  "-"};
		String b[] =  {"3", "6",  "2",  "/", "+"};
		String c[] =  {"15", "12",  "-",};
		String d[] =  {"10",  "9",  "*"};
		String  e[] =  {};

		//String  aa[] = ;
		String  bb[] = BonusAssignment.convertPostfixToPrefix(b);
		String  cc[] = BonusAssignment.convertPostfixToPrefix(c);
		String  dd[] = BonusAssignment.convertPostfixToPrefix(d);
		String  ee[] = BonusAssignment.convertPostfixToPrefix(e);
		
		assertTrue(BonusAssignment.validatePrefixOrder(BonusAssignment.convertPostfixToPrefix(a)));
		assertTrue(BonusAssignment.validatePrefixOrder(bb));
		assertTrue(BonusAssignment.validatePrefixOrder(cc));
		assertFalse(BonusAssignment.validatePrefixOrder(dd));
		assertFalse(BonusAssignment.validatePrefixOrder(ee));
	}

	@Test
	public void testConvertPrefixToInfix() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertPostfixToInfix() {
		fail("Not yet implemented");
	}


}
