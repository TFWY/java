package observer;

import java.util.ArrayList;

public abstract class Mysubject 
{
	protected ArrayList observers=new ArrayList();
	protected double changenum;
	
	
	public void attach(Myobserver observer)
	{
		observers.add(observer);
	}
	
	public void detach(Myobserver observer)
	{
		observers.remove(observer);
	}
	
	public abstract void inform();
	
}
