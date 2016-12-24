//Helal
import java.util.Random;
public class JokeBotMain
{
	private int x = 0; 
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hello, let's talk. Spell out date for me please";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		statement= statement.toLowerCase();
		String response = "";

		if (statement.length() == 0)
		{
			response = "Say something, please. ";
		}
		else if (Tools.memory(statement, "access") == true)
		{
			response= "Are you brain dead? You just said that";
		}
		else if (x>0)
		{
			response = DatingClass.getResponse1(statement);	
			x--;
		}
		else if (statement.indexOf("?") >= 0)
		{
			response = "That is an interesting question. What do you think?";
		}

		else if (Tools.findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (Tools.findKeyword(statement, "mother") >= 0
				|| Tools.findKeyword(statement, "father") >= 0
				|| Tools.findKeyword(statement, "sister") >= 0
				|| Tools.findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (Tools.findKeyword(statement, "cat") >= 0
				|| Tools.findKeyword(statement, "dog") >= 0
				|| Tools.findKeyword(statement, "fish") >= 0)
		{
			response = "Tell me more about your pets.";
		}
		else if (Tools.findKeyword(statement, "joke") >= 0)	
		{
			response = getJoke();
		}
		else if (Tools.findKeyword(statement, "date") >= 0)	
		{
			x = 5;
			response = DatingClass.getResponse1(statement);			
		}
		else if (Tools.findKeyword(statement, "hi") >= 0
				|| Tools.findKeyword(statement, "hey") >= 0
				|| Tools.findKeyword(statement, "hello") >= 0)
		{
			response = "Hello, tell me about yourself";
		}

		// Responses which require transformations
		else if (Tools.findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		//  Part of student solution
		else if (Tools.findKeyword(statement, "I want", 0) >= 0)
		{
			response = transformIWantStatement(statement);
		}

		else
		{

			// Look for a two word (you <something> me)
			// pattern
			int psn = Tools.findKeyword(statement, "you", 0);

			if (psn >= 0
					&& Tools.findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else
			{
				//  Part of student solution
				// Look for a two word (I <something> you)
				// pattern
				psn = Tools.findKeyword(statement, "i", 0);

				if (psn >= 0
						&& Tools.findKeyword(statement, "you", psn) >= 0)
				{
					response = transformIYouStatement(statement);
				}
				else
				{
					response = getRandomResponse();
				}
			}
		}
		Tools.memory(statement, "store");

		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = Tools.findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}

	
	/*
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = Tools.findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	/*
	 * Take a statement with "you <something> me" and transform it into 
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfYou = Tools.findKeyword (statement, "you", 0);
		int psnOfMe = Tools.findKeyword (statement, "me", psnOfYou + 3);
		
		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
	
	/*
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = Tools.findKeyword (statement, "I", 0);
		int psnOfYou = Tools.findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}

	public static String getJoke()
	{
		String[] responseList = {"The ball was getting bigger, and then it hit me",
					"I looked in the mirror and it cracked, but then I realized you were next to me",
					"If you want to see a joke, take out your phone and put it on selfie mode",
					"You must have been born in the highway, because that's where most accidents happen",
					"You are so ugly, Hello Kitty said goodbye",
					};
		final int NUMBER_OF_RESPONSES = responseList.length;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		return responseList[whichResponse];
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-commit string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		return randomResponses [r.nextInt(randomResponses.length)];
	}
	
	
	private String [] randomResponses = {"Interesting, tell me more",
			"Hmmm that's cool. Ask me if I can tell a joke.",
			"Do you really think so?",
			"You don't say.",
			//  All you need to do is add lines here
			"Gee wilikers",
			"Is it getting hot in here?",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	
}
