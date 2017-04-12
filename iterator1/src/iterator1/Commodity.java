package iterator1;

public class Commodity implements Mycollection
{
	private Object[] obj={"商品1","商品2","商品3","商品4","商品5","商品6","商品7"};
	public Myiterator createiterator() 
	{
		return new commiterator();
	}
	
	private class commiterator implements Myiterator
	{
		private int currentindex=0;
		
		public void setchannel(int i) 
		{
			currentindex=i;
		}

		public void next() 
		{
			if(currentindex<obj.length)
			{
				currentindex++;
			}
		}
		
		public void previous() 
		{
			if(currentindex>0)
			{
				currentindex--;
			}
		}
		
		public boolean islast() 
		{
			return currentindex==obj.length;
		}
		
		public Object currentchannel() 
		{
			return obj[currentindex];
		}

		public boolean isfrist() 
		{
			return currentindex==0;
		}
		
	}
}
