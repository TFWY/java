package com.sqlite.tfnews2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.Log;

public class Copydbtools {

	public static void begincopydb(Context context,String dbname,
			String copytopath,boolean isrewrite){
		try{
			File file=new File(copytopath+dbname);
			
			if(file.exists()==false){
				Log.e("!","���ݿⲻ����");
				InputStream isref=context.getResources().openRawResource(R.raw.news);
				FileOutputStream fosref=new FileOutputStream(file);
				byte[]byteArray=new byte[2];
				int readLength=isref.read(byteArray);
				while(readLength!=-1){
					fosref.write(byteArray,0,readLength);
					readLength=isref.read(byteArray);
				}
				fosref.close();
				isref.close();
			}else{
				if(isrewrite==true){
					Log.e("!","���ݿ����ɾ���ɵ�д�µ�");
					if(file.delete()==true){
						Log.e("�������","ɾ���ɵ�д�µ�");
						InputStream isref=context.getResources().openRawResource(R.raw.news);
						FileOutputStream fosref=new FileOutputStream(file);
						byte[]byteArray=new byte[2];
						int readLength=isref.read(byteArray);
						while(readLength!=-1){
							fosref.write(byteArray,0,readLength);
							readLength=isref.read(byteArray);
						}
						fosref.close();
						isref.close();
					}
				}
			}
				
		}catch(NotFoundException e){
			e.printStackTrace();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
