package compon;

public class Client 
{
	public static void main(String a[])
	{
		AbstractFile obj1,obj2,obj3,obj4,obj5,obj6;
		Folder folder1,folder2,folder3,folder4;
		
		obj1=new ImageFile("ͼ���ļ�");
		obj2=new TextFile("�ı��ļ�");
		folder1=new Folder("�ļ���");
		folder1.add(obj1);
		folder1.add(obj2);
		
		obj3=new VideoFile("�����ļ�");
		obj4=new TextFile("�ı��ļ�");
		folder2=new Folder("�ļ���");
		folder2.add(folder1);
		folder2.add(obj3);
		folder2.add(obj4);
		
		obj5=new ImageFile("ͼ���ļ�");
		folder3=new Folder("�ļ���");
		folder3.add(obj5);
		
		obj6=new VideoFile("�����ļ�");
		folder4=new Folder("�ļ���");
		folder4.add(obj6);
		folder4.add(folder2);
		folder4.add(folder3);
		
		folder4.display();
		obj3.add(obj3);
		obj2.remove(obj2);
	}
	
}
