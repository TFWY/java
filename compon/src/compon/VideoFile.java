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
		System.out.println("Ìí¼Ó"+filename);
		
	}
	
	public void remove(AbstractFile element)
	{
		System.out.println("É¾³ý"+filename);
	}
	
	public void display()
	{
		System.out.println(filename);
	}

}
