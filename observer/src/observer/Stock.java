package observer;

public class Stock extends Mysubject
{

	public Stock(double num) 
	{
		changenum=num;
	}


	public void inform() 
	{
		System.out.println("¹ÉÆ±±ä»¯£º"+changenum+"%");
		System.out.println("----------------------------------");
		if((changenum<-5.0)||(changenum>5.0))
		{
			for(Object obs:observers)
			{
				((Myobserver)obs).response(changenum);
			}
		}
		else
		{
			for(Object obs:observers)
			{
				((Myobserver)obs).notimform();
			}
		}
		
	}
	
}
