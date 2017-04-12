package compon;

public class Client 
{
	public static void main(String a[])
	{
		AbstractFile obj1,obj2,obj3,obj4,obj5,obj6;
		Folder folder1,folder2,folder3,folder4;
		
		obj1=new ImageFile("图像文件");
		obj2=new TextFile("文本文件");
		folder1=new Folder("文件夹");
		folder1.add(obj1);
		folder1.add(obj2);
		
		obj3=new VideoFile("声音文件");
		obj4=new TextFile("文本文件");
		folder2=new Folder("文件夹");
		folder2.add(folder1);
		folder2.add(obj3);
		folder2.add(obj4);
		
		obj5=new ImageFile("图像文件");
		folder3=new Folder("文件夹");
		folder3.add(obj5);
		
		obj6=new VideoFile("声音文件");
		folder4=new Folder("文件夹");
		folder4.add(obj6);
		folder4.add(folder2);
		folder4.add(folder3);
		
		folder4.display();
		obj3.add(obj3);
		obj2.remove(obj2);
	}
	
}
