//Alexandra
public class DatingClass {
	private static int x=0;

	public static String getResponse1(String statement)
	{
		statement= statement.toLowerCase();
		String response = "";
		if (Miscellaneous.findKeyword(statement, "Date me",0) >= 0)
		{
			response = "Do you want to go on a computer date?";
			x=1;
		}
		if (Miscellaneous.findKeyword(statement, "yes",0) >=0 && x==1 )
		{
			response = "Of course you do. Everyone does. What would you say is your best personality trait?";	
		}
		
		if(statement.indexOf(" compliment ")>= 0)
		{
			response = datepun(); 
		}
		
		if(Miscellaneous.findKeyword(statement, "no",0) >=0 )
		{
					
		response = "I dont take no for an answer.";
		}
		return response;
	}
		
		static private String datepun()
		{
			String[] responseList = {"You know you look really good when you wear makeup",
									"Your eyes would be really pretty if they were blue",
									"You are prettier than a buffalo",
									"I don't usually go for people like you... But lets see how this works out",
									"Hmm..Maybe we could talk about something else."};
			final int NUMBER_OF_RESPONSES = 5;
			double r = Math.random();
			int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
			return responseList[whichResponse];
		}
		
		
		

	
}