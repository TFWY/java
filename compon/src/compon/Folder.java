package compon;

import java.util.*;

public class Folder extends AbstractFile
{
	private ArrayList filelist=new ArrayList();
	private String filename;
	
	public Folder(String filename)
	{
		this.filename=filename;
	}
	
	public void add(AbstractFile element)
	{
		filelist.add(element);
	}
	
	public void remove(AbstractFile element)
	{
		filelist.remove(element);
	}
	
	public void display()
	{
		System.out.println(filename);
		for(Object object:filelist)
		{
			((AbstractFile)object).display();
		}
	}
}
