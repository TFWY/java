package com.sqlite.tfnews2;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
//import android.util.Log;
import android.util.Log;

public class MainActivity extends Activity{
	@Override
	public void onCreate (Bundle savedinstanceState){
		super.onCreate(savedinstanceState);
        setContentView(R.layout.main);
		Log.e("start","Verbose");
        Copydbtools.begincopydb(this, "news.db",
        		this.getApplication().getFilesDir().getParentFile().getPath()+"/", true);
		final ActionBar bar=getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
		
		bar.addTab(bar.newTab().setText("�ȵ�")
				.setTabListener(new TabListener<HotFragment>(
						this,"hot",HotFragment.class)));
		bar.addTab(bar.newTab().setText("����")
				.setTabListener(new TabListener<CounFragment>(
						this,"coun",CounFragment.class)));
		bar.addTab(bar.newTab().setText("����")
				.setTabListener(new TabListener<PeFragment>(
						this,"Pe",PeFragment.class)));
		bar.addTab(bar.newTab().setText("����")
				.setTabListener(new TabListener<EcoFragment>(
						this,"Eco",EcoFragment.class)));
		bar.addTab(bar.newTab().setText("����")
				.setTabListener(new TabListener<EduFragment>(
						this,"Edu",EduFragment.class)));
		
		
		 if(savedinstanceState !=null){
			 bar.setSelectedNavigationItem(savedinstanceState.getInt("tab", 0));
		 }
		
	}
	

}
