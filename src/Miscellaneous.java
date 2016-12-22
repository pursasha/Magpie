//Jia Hua Zhu, AP Comp Sci Java, Miscellaneous tools/ methods library
public class Miscellaneous {
	//memory section
	private static String[] memory = new String[3]; //memo stores up to a certain amt strings before it starts rewriting data
	private static int memSlot = 0; //determines where the string is placed at the memory array
	public static boolean memory(String statement, String usage) { //memory can either store strings or access strings
		boolean verify = false;
		if (usage.compareTo("store") == 0) { //stores string in as part of the memory array
			memory[memSlot] = statement;
			memSlot ++;
			if (memSlot == memory.length-1) {
				memSlot = 0;
			}
		}
		else if (usage.compareTo("access") == 0) { //loops through the memory array, searching for statement
			for(int x = 0; x < memory.length; x++) {
				if (memory[x] == null) { //passes through null elements to avoid errors
					continue;
				}
				else if (findKeyword(memory[x], "yes") >= 0 //ignores certain words so that they can be used more than once
						||findKeyword(memory[x], "no") >= 0
						||findKeyword(memory[x], "joke") >= 0
						||findKeyword(memory[x], "date") >= 0) {
					continue;
				}
				if (statement.compareTo(memory[x]) == 0) {
					verify = true; //change [verify] to true so it'll confirm that statement has been used recently
					break; //if true, breaks the loop and goes instantly to return so that time isn't wasted
				}
			}
		}
		return verify;
	}
	
	//findKeyword was from the original reference, but moved to this class and made public because 2 classes require it
	public static int findKeyword(String statement, String goal) {
		return findKeyword (statement, goal, 0);
	}
	
	public static int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
}