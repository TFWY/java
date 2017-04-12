package outvie;

public class Client 
{
	public static void main(String[] args) 
	{
		EncryptFacade enc=new EncryptFacade();
		enc.fileencrypt("myfile", "myFileDes");
	
	}
}
