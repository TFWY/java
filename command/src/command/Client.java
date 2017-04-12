package command;

public class Client {

	public static void main(String arg[])
	{
		Command helpcomm,exitcomm;
		
		helpcomm=new Helpcommand();
		exitcomm=new Exitcommand();
		
		Functionbutton click=new Functionbutton(helpcomm,exitcomm);
		
		click.help();
		click.exit();
		
	}
}
