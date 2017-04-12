package Factory;

public class FileLogFactory implements LogFactory {
	public Log createLog()
	{
		System.out.println("创建文件日志");
		return new FileLog();
	}
}
