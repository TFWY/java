package compon;

public class VideoFile extends AbstractFile
{
	private String filename;
	
	public VideoFile(String filename)
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
