package observer;

public class Client 
{
	public static void main(String arg[])
	{
		double changenum=2.0;
		
		Mysubject sub=new Stock(changenum);
		
		Myobserver obj1,obj2;
		obj1=new Man();
		obj2=new Man();
		
		sub.attach(obj1);
		sub.attach(obj2);
		sub.inform();
	}
}
