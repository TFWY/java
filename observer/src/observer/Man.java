package observer;

public class Man implements Myobserver
{
	int boo=0;
	public void response(double num) 
	{
		if(num>5.0)
		{
			System.out.println("��Ʊ�Ƿ���5%");
			boo=1;
		}
		else if(num<-5.0)
		{
			System.out.println("��Ʊ�µ���5%");
			boo=1;
		}
	}
	
	public void notimform() 
	{
			System.out.println("δ�յ�֪ͨ");
	}

}
