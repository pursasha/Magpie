public class Miscellaneous {
	String[] memory = new String[10]; //memo stores up to a certain amt strings before it starts rewriting data
	int memSlot = 0; //determines where the 
	public boolean memory(String statement, String usage) { //memory can either store strings or access strings
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
				if (statement.compareTo(memory[x]) == 0) {
					verify = true; //change [verify] to true so it'll confirm that statement has been used recently
				}
			}
		}
		return verify;
	}
}