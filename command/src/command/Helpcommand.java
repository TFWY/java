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
		// TODO �Զ����ɵķ������
		hcobj.display();
	}
}
