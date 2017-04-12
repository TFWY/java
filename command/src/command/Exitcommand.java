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
		// TODO 自动生成的方法存根
		seobj.exit();
	}
}
