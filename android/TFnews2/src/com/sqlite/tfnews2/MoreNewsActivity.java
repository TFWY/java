package com.sqlite.tfnews2;


import java.util.ArrayList;
import java.util.List;




import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MoreNewsActivity extends ActionBarActivity{

	//private static final int mor_num = 15;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_news);

        Bundle bundle=this.getIntent().getExtras();
        final String type=bundle.getString("type");
        
        ListView listview=(ListView)findViewById(R.id.listview_more);
        Button button=(Button)findViewById(R.id.button_more);
        button.setText("·µ»Ø");
        
        final DBAdapter dbadapter=new DBAdapter(MoreNewsActivity.this);
		dbadapter.open();
		News[] news=dbadapter.queryAllData(type);
        
        button.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dbadapter.close();
				Intent intent=new Intent();
				intent.setClass(MoreNewsActivity.this,MainActivity.class);
				startActivity(intent);
				
			}
		});
        
        List<String>list=new ArrayList<String>();
		for(int i=10;i<news.length;i++){
			list.add(news[i].name);
		}
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,list);
		listview.setAdapter(adapter);
	
			 OnItemClickListener lvlistener=
				new OnItemClickListener(){
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							long arg3) {
						// TODO Auto-generated method stub
						dbadapter.close();
						Intent intent=
								new Intent(MoreNewsActivity.this,NewsActivity.class);
						Bundle bundle=new Bundle();
						bundle.putString("type", type);
						bundle.putLong("id",(arg3+11));
						intent.putExtras(bundle);
						startActivity(intent);
					}
		};
		listview.setOnItemClickListener(lvlistener);
	}
}

