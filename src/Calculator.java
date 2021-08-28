import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {

	public static int add(String input) {
		if(input.isEmpty())
			return 0;
		Stream<String> Numbers= Arrays.stream(input.split(",|\n"));
		return Numbers.mapToInt(Integer::parseInt).sum();
	
	}
}
