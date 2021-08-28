import java.util.Arrays;

public class Calculator {

	private String delimiter;
	private String numbers;
	
	private Calculator(String delimiter,String numbers) {
		this.delimiter=delimiter;
		this.numbers=numbers;
	}
	
	private int addUtil() {
		return Arrays.stream(numbers.split(delimiter))
				.mapToInt(Integer::parseInt).sum();
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
