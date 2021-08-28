import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
		String NegativenumberSequence=getNumbers().filter(n -> n<0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		 
		if(!NegativenumberSequence.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed: "+NegativenumberSequence);
		}
	}
	
	private IntStream getNumbers() {
		if(numbers.isEmpty()) {
			return IntStream.empty();
		}
		else {
			return Stream.of(numbers.split(delimiter))
				.mapToInt(Integer::parseInt);
		}
	}
	
	public static int add(String input) {
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
