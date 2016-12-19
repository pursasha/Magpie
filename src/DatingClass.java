//Alexandra
public class DatingClass {
	private int x=0;

	public String getResponse1(String statement)
	{
		statement= statement.toLowerCase();
		String response = "";
		if (findKeyword(statement, "Date me",0) >= 0)
		{
			response = "Do you want to go on a computer date?";
			x=1;
		}
		if (findKeyword(statement, "yes",0) >=0 && x==1 )
		{
			response = "Of course you do. Everyone does. What would you say is your best personality trait?";	
		}
		
		if(statement.indexOf(" like ")>= 0)
		{
		
		}
	
			
		else if(findKeyword(statement, "no",0) >=0 )
		{
					
			
		}
		return response;
	}
		
		private String datepun()
		{
			final int NUMBER_OF_RESPONSES = 5;
			double r = Math.random();
			int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
			String response = "";
			
			if (whichResponse == 0)
			{
				response= ("You know you look really good when you wear makeup");
			}
			if (whichResponse == 1)
			{
				response= ("Your eyes would be really pretty if they were blue");
			}
			if (whichResponse == 2)
			{
				response= ("you are prettier than a buffalo");
			}
			if (whichResponse == 3)
			{
				response= ("I don't usually go for people like you... But lets see how this works out");
			}
			if (whichResponse == 4)
			{
				response= ("Maybe we could talk about something else.");
			}
			return response;
		}
		
		else if (findKeyword(statement, "joke") >= 0)
		{
			response = getJoke();
		}


		// Responses which require transformations
		if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		//  Part of student solution
		else if (findKeyword(statement, "I want", 0) >= 0)
		{
			response = transformIWantStatement(statement);
		}

		else
		{

			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0
					&& findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else
			{
				//  Part of student solution
				// Look for a two word (I <something> you)
				// pattern
				psn = findKeyword(statement, "i", 0);

				if (psn >= 0
						&& findKeyword(statement, "you", psn) >= 0)
				{
					response = transformIYouStatement(statement);
				}
				else
				{
					response = getRandomResponse();
				}
			}
		}
		return response;
	}
	



	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
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
