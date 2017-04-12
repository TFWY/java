package command;

public class Functionbutton {

	private Command exitcomm,helpcomm;
	
	public Functionbutton(Command help,Command exit)
	{
		this.helpcomm=help;
		this.exitcomm=exit;
		
	}
	
	public void help()
	{
		helpcomm.execute();
	}
	
	public void exit()
	{
		exitcomm.execute();
	}
}
