package command;

public class Exitcommand implements Command{

	private Systemexitclass seobj;
	
	public Exitcommand()
	{
		seobj=new Systemexitclass();
	}

	@Override
	public void execute() 
	{
		// TODO �Զ����ɵķ������
		seobj.exit();
	}
}
