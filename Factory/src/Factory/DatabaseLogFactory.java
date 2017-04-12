package Factory;

public class DatabaseLogFactory implements LogFactory{

	public Log createLog()
	{
		System.out.println("创建数据库日志");
		return new FileLog();
	}
}
