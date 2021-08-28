import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculator {
	@Test
	public void TestEmptyString() {
		assertEquals(Calculator.add(""),0);
	}
}
