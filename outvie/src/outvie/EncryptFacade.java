package outvie;

public class EncryptFacade 
{
	FileReader reader;
	CipherMachine cipher;
	FileWriter writer;
	
	public EncryptFacade()
	{
		reader=new FileReader();
		cipher=new CipherMachine();
		writer=new FileWriter();
	}
	
	public void fileencrypt(String filenamesrc,String filenamedes)
	{
		String plainstr=reader.read(filenamesrc);
		String encryptstr=cipher.encyypt(plainstr);
		writer.write(encryptstr, filenamedes);
	}
	
}
