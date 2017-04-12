package com.sqlite.tfnews2;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentTransaction;

public  class TabListener<T extends Fragment> implements ActionBar.TabListener {

	private final Activity mActivity;
	private final String mTag;
	private final Class<T>mClass;
	private final Bundle mArgs;
	private Fragment mFragment;
	
	
	public TabListener(Activity activity,String tag,Class<T>clz){
	
		this(activity,tag,clz,null);
	}


	public TabListener(Activity activity, String tag, Class<T> clz,Bundle args) {
		
		mActivity=activity;
		mTag=tag;
		mClass=clz;
		mArgs=args;
		
		
		this.mFragment=mActivity.getFragmentManager().findFragmentByTag(mTag);
		if(mFragment!=null&&!mFragment.isDetached()){
			FragmentTransaction ft=mActivity.getFragmentManager().beginTransaction();
			ft.detach(mFragment);
			ft.commit();
		}
	}
	
	public void onTabSelected(Tab tab,FragmentTransaction ft){
		if(mFragment==null){
			mFragment=Fragment.instantiate(mActivity, mClass.getName(), mArgs);
			ft.add(android.R.id.content,mFragment,mTag);
		}else{
			ft.attach(mFragment);
		}
	}
	
	public void onTabUnselected(Tab tab,FragmentTransaction ft){
		if(mFragment!=null){
			ft.detach(mFragment);
		}
	}
	

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		if(mFragment==null){
			mFragment=Fragment.instantiate(mActivity, mClass.getName(), mArgs);
			ft.add(android.R.id.content,mFragment,mTag);
		}else{
			ft.attach(mFragment);
		}
	}
	
	
}