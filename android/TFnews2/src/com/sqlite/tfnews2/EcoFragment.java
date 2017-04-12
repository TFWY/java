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

public class EcoFragment extends Fragment {
	private static final String type="eco";
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle savedInstanceState){
		return inflater.inflate(R.layout.ecofrag , container, false);
	}
	
		public void onStart(){
		super.onStart();
		ListView ecolistview=(ListView)getActivity().findViewById(R.id.listview_eco);
		Button ecobutton=(Button)getActivity().findViewById(R.id.button_eco);
		
		final DBAdapter dbadapter=new DBAdapter(getActivity());
		dbadapter.open();
		News[] news=dbadapter.queryAllData(type);

		ecobutton.setText("¸ü¶à");
		ecobutton.setOnClickListener(new View.OnClickListener() {
			
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
		
		List<String>ecolist=new ArrayList<String>();
		for(int i=0;i<10;i++){
			ecolist.add(news[i].name);
		}
		ArrayAdapter<String>ecoadapter=new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1,ecolist);
		ecolistview.setAdapter(ecoadapter);
	
			 OnItemClickListener ecolvlistener=
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
		ecolistview.setOnItemClickListener(ecolvlistener);
		
	} 
}

