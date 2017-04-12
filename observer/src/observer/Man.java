package observer;

public class Man implements Myobserver
{
	int boo=0;
	public void response(double num) 
	{
		if(num>5.0)
		{
			System.out.println("股票涨幅超5%");
			boo=1;
		}
		else if(num<-5.0)
		{
			System.out.println("股票下跌超5%");
			boo=1;
		}
	}
	
	public void notimform() 
	{
			System.out.println("未收到通知");
	}

}
