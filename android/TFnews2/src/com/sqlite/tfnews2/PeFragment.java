package com.sqlite.tfnews2;


import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class PeFragment extends Fragment {
	private static final String type="pe";
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle savedInstanceState){
		return inflater.inflate(R.layout.pefrag , container, false);
	}
	
	public void onStart(){
		super.onStart();
		ListView pelistview=(ListView)getActivity().findViewById(R.id.listview_pe);
		Button pebutton=(Button)getActivity().findViewById(R.id.button_pe);

		final DBAdapter dbadapter=new DBAdapter(getActivity());
		dbadapter.open();
		News[] news=dbadapter.queryAllData(type);
		
		pebutton.setText("¸ü¶à");
		pebutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				dbadapter.close();
				Intent intent=new Intent(getActivity(),MoreNewsActivity.class);
				Bundle bundle=new Bundle();
				bundle.putString("type", type);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		List<String>pelist=new ArrayList<String>();
		for(int i=0;i<10;i++){
			pelist.add(news[i].name);
		}
		ArrayAdapter<String>peadapter=new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1,pelist);
		pelistview.setAdapter(peadapter);
	
			 OnItemClickListener pelvlistener=
				new OnItemClickListener(){
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							long arg3) {
						// TODO Auto-generated method stub
						dbadapter.close();
						Intent intent=new Intent(getActivity(),NewsActivity.class);
						Bundle bundle=new Bundle();
						bundle.putString("type", type);
						bundle.putLong("id",(arg3+1));
						intent.putExtras(bundle);
						startActivity(intent);
					}
		};
		pelistview.setOnItemClickListener(pelvlistener);
		
	} 
}

