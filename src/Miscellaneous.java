public class Miscellaneous {
	//memory section
	private static String[] memory = new String[10]; //memo stores up to a certain amt strings before it starts rewriting data
	private static int memSlot = 0; //determines where the string is placed at the memory array
	public static boolean memory(String statement, String usage) { //memory can either store strings or access strings
		boolean verify = false;
		if (usage.compareTo("store") == 0) { //stores string in as part of the memory array
			memory[memSlot] = statement;
			memSlot ++;
			if (memSlot == memory.length) {
				memSlot = 0;
			}
		}
		else if (usage.compareTo("access") == 0) { //loops through the memory array, searching for statement
			for(int x = 0; x < memory.length; x++) {
				if (memory[x] == null) { //passes through null elements to avoid errors
					continue;
				}
				else if (statement.compareTo(memory[x]) == 0) {
					verify = true; //change [verify] to true so it'll confirm that statement has been used recently
					break; //if true, breaks the loop and goes instantly to return so that time isnt wasted
				}
			}
		}
		return verify;
	}
}