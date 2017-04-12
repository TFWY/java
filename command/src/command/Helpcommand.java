package command;

public class Helpcommand implements Command{

	private Displayhelpclass hcobj;
	
	public Helpcommand()
	{
		hcobj=new Displayhelpclass();
	}
	
	@Override
	public void execute() 
	{
		// TODO 自动生成的方法存根
		hcobj.display();
	}
}
