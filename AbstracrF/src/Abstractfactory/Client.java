package Abstractfactory;

public class Client {

	public static void main(String args[])
	{
		try
		{
			DBFactory factory;
			Connection conn;
			Statement state;
			factory=new OracleFactory();
			conn=factory.createConnection();
			conn.connection();
			state=factory.createStatement();
			state.statement();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
