package compon;

public class TextFile extends AbstractFile
{
	private String filename;
	
	public TextFile(String filename)
	{
		this.filename=filename;
	}
	
	public void add(AbstractFile element)
	{
		System.out.println("���"+filename);
		
	}
	
	public void remove(AbstractFile element)
	{
		System.out.println("ɾ��"+filename);
	}
	
	public void display()
	{
		System.out.println(filename);
	}

}
