package Factory;

public class DatabaseLogFactory implements LogFactory{

	public Log createLog()
	{
		System.out.println("�������ݿ���־");
		return new FileLog();
	}
}
