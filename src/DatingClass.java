//Alexandra Gostev
//DatingClass
//Mr.Levin BTHS CS 
//12.20.16
public class DatingClass 
{
	private static int x=0; //variable used only in this class

	public static String getResponse1(String statement) //gets customized responses from user when a certain keyword is said/
	{
		statement= statement.toLowerCase(); // Makes sure that there are no capitalization errors
		String response = "";
		if (Miscellaneous.findKeyword(statement, "Date",0) >= 0) //uses the method findkeyword in class miscellaneous.
		{
			response = "Do you want to go on a computer date?";
			x=1;
		}
		else if (Miscellaneous.findKeyword(statement, "yes",0) >=0 && (x==1))// This x==1 will make sure that this doesnt run when they arent on a date.
		{
			response = "Of course you do. Everyone does. Do you think I am hot ?";	
			x=2;
		}
		else if(Miscellaneous.findKeyword(statement, "no",0) >=0 && (x==1)) // Numbers allow for the robot to have a conversation 
		{
			response = "I dont take no for an answer. Do you think I am hot? "; 
			x=2;
		}
		else if(Miscellaneous.findKeyword(statement, "yes",0) >=0 && (x==2))
		{
			response = "Well obviousely I am hot, I am sizzling. What about you? Are you sizzling hot? "; 
			x=3;
		}
		
		else if(Miscellaneous.findKeyword(statement, "no",0) >=0 && (x==2))
		{
			response = "I think you mistook me for yourself. I am sizzling hot. What about you? Are you sizzling hot? ";
			x=3;
		}
		else if(Miscellaneous.findKeyword(statement, "yes",0) >=0 && (x==3))
		{
			response = "Dont even play yourself. Try taking a look in the mirror. ";
			x=4;
		}
		else if(Miscellaneous.findKeyword(statement, "no",0) >=0 && (x==3))
		{
			response = "Yea you're right. You ugly as hell. ";
			x=4;
		}
		else
		{
			response = datepun(); //refers to the random response list/ 
		}
		
		return response;
	}
	 // random responses used in other parts of the this class
		static private String datepun()
		{
			String[] responseList = {"You know you look really good when you wear makeup",
									"Its ok, You are prettier than a buffalo",
									"I don't usually go for ugly people... But lets see how this works out",
									"your face is giving me nightmares!."};
			final int NUMBER_OF_RESPONSES = responseList.length;
			double r = Math.random();
			int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
			return responseList[whichResponse];
		}
		
		
		

	
}