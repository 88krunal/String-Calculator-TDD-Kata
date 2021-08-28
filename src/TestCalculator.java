import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(OrderAnnotation.class)
public class TestCalculator {
	@Test
	@Order(1)
	public void TestEmptyString() {
		assertEquals(Calculator.add(""),0);
	}
	
	@Test
	@Order(2)
	public void TestOneNumberString() {
		assertEquals(Calculator.add("1"),1);
	}
	
	@Test
	@Order(3)
	public void TestTwoNumberString() {
		assertEquals(Calculator.add("1,2"),3);
		assertEquals(Calculator.add("2,3"),5);
	}
	@Test
	@Order(4)
	public void TestMorethanTwoNumberString() {
		assertEquals(Calculator.add("1,2,3"),6);
	}
	
	@Test
	@Order(5)
	public void TestNumberStringNewLineDelimiter() {
		assertEquals(Calculator.add("1\n2,3"),6);
	}
	
	@Test
	@Order(6)
	public void TestDifferentDelimiter() {
		assertEquals(Calculator.add("//;\n1;2"),3);
	}

	@Test
	@Order(7)
	public void TestoneNegativeNumber() {
		try {
			Calculator.add("-1,2");
		}
		catch(IllegalArgumentException e){
			assertEquals(e.getMessage(),"negatives not allowed: -1");
		}
	}
	
	@Test
	@Order(8)
	public void TestMultipleNegativeNumber() {
		try {
			Calculator.add("-1,2,-10,-12");
		}
		catch(IllegalArgumentException e){
			assertEquals(e.getMessage(),"negatives not allowed: -1,-10,-12");
		}
	}
	
	@Test
	@Order(9)
	public void TestCountAddmethodinvoked() {
		assertEquals(Calculator.GetCalledCount(),8);
	}
	
	@Test
	@Order(10)
	public void Testignorenumberbiggerthanthousand() {
		assertEquals(Calculator.add("1001,2"),2);
	}
	
	@Test
	@Order(11)
	public void Testmetacharacterasdelimiter() {
		assertEquals(Calculator.add("//.\n1.2"),3);
	}
	
	@Test
	@Order(12)
	public void TestAnylengthDelimiter() {
		assertEquals(Calculator.add("//[***]\n1***2***3"),6);
	}
	
	@Test
	@Order(13)
	public void TestMultipleDelimiter() {
		assertEquals(Calculator.add("//[*][%]\n1*2%3"),6);
	}
	
	@Test
	@Order(14)
	public void TestMultipleDelimiterwithlengthmorethanonechar() {
		assertEquals(Calculator.add("//[**][%%]\n1**2%%3"),6);
	}
	
}
	