
public class Calculator {

	public static int add(String input) {
		if(input.isEmpty())
			return 0;
		else if(input.contains(",")){
			String NumberList[]=input.split(",");
			return Integer.parseInt(NumberList[0])+Integer.parseInt(NumberList[1]);
		}	
		else {
			return Integer.parseInt(input);
		}
	}

}
