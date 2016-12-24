import java.util.Scanner;

/**
 * JokeBot Magpie Assignment
 * Jia Hua Zhu, Helal Chowdhury, Alexandra Gostev
 * AP Computer Science - Java
 */
public class BotRunner
{

	public static void main(String[] args)
	{
		JokeBotMain jokeBot = new JokeBotMain();
		System.out.println (jokeBot.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();		
		
		while (!statement.equals("bye"))
		{
			System.out.println (jokeBot.getResponse(statement));
			statement = in.nextLine();
		}
	}
}
