import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculator {
	@Test
	public void TestEmptyString() {
		assertEquals(Calculator.add(""),0);
	}
	@Test
	public void TestOneNumberString() {
		assertEquals(Calculator.add("1"),1);
	}
	@Test
	public void TestTwoNumberString() {
		assertEquals(Calculator.add("1,2"),3);
		assertEquals(Calculator.add("2,3"),5);
	}
	@Test
	public void TestMorethanTwoNumberString() {
		assertEquals(Calculator.add("1,2,3"),6);
	}
	
	@Test
	public void TestNumberStringNewLineDelimiter() {
		assertEquals(Calculator.add("1\n2,3"),6);
	}
	@Test
	public void TestDifferentDelimiter() {
		assertEquals(Calculator.add("//;\n1;2"),3);
	}

	@Test
	public void TestoneNegativeNumber() {
		try {
			Calculator.add("-1,2");
		}
		catch(IllegalArgumentException e){
			assertEquals(e.getMessage(),"negatives not allowed: -1");
		}
	}
	@Test
	public void TestMultipleNegativeNumber() {
		try {
			Calculator.add("-1,2,-10,-12");
		}
		catch(IllegalArgumentException e){
			assertEquals(e.getMessage(),"negatives not allowed: -1,-10,12");
		}
	}
}
	