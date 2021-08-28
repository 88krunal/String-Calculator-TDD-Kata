import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {

	public static int add(String input) {
		if(input.isEmpty())
			return 0;
		String delimiter=",|\n";
		if(input.startsWith("//")) {
			String inputparts[]=input.split("\n",2);
			delimiter=inputparts[0].substring(2);
			input=inputparts[1];
		}
		Stream<String> Numbers= Arrays.stream(input.split(delimiter));
		return Numbers.mapToInt(Integer::parseInt).sum();
	
	}
}
