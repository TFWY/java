package iterator1;

public class Client 
{
	public static void display(Commodity comm)
	{
		Myiterator i=comm.createiterator();
		System.out.println("商品名：");
		while(!i.islast())
		{
			System.out.println(i.currentchannel().toString());
			i.next();
		}
	}
	
	public static void reversedisplay(Commodity comm)
	{
		Myiterator i=comm.createiterator();
		i.setchannel(7);
		System.out.println("逆序商品名：");
		while(!i.isfrist())
		{
			i.previous();
			System.out.println(i.currentchannel().toString());
		}
	}
	
	public static void main(String arg[])
	{
		Commodity commod=new Commodity();
		display(commod);
		System.out.println("--------------------------------");
		reversedisplay(commod);
		
	}
}
