import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Calculator {

	private String delimiter;
	private String numbers;
	
	private Calculator(String delimiter,String numbers) {
		this.delimiter=delimiter;
		this.numbers=numbers;
	}
	
	private int addUtil() {
		NoNegativeNumbers();
		return getNumbers().sum();
	}
	
	private void NoNegativeNumbers() {

		if(getNumbers().anyMatch(n -> n<0)) {
			String NegativenumberSequence=getNumbers().filter(n -> n<0).mapToObj(Integer::toString)
					.collect(Collectors.joining(","));
			throw new IllegalArgumentException("negatives not allowed: "+NegativenumberSequence);
		}
	}
	private IntStream getNumbers() {
		return Arrays.stream(numbers.split(delimiter))
				.mapToInt(Integer::parseInt);
	}
	public static int add(String input) {
		if(input.isEmpty())
			return 0;
		return parseinput(input).addUtil();
	}
	
	private static Calculator parseinput(String input) {
		if(input.startsWith("//")) {
			String inputparts[]=input.split("\n",2);
			return new Calculator(inputparts[0].substring(2),inputparts[1]);
		}
		else {
			return new Calculator(",|\n",input);
		}
	}
}
