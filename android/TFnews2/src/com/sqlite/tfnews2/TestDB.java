package com.sqlite.tfnews2;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestDB extends Activity {
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.testdb);
	        
	        Copydbtools.begincopydb(this, "news.db",
	        		this.getApplication().getFilesDir().getParentFile().getPath()+"/", true);
	        
	        /*Bundle bundle=this.getIntent().getExtras();
	        String type=bundle.getString("type");
	        Long id=bundle.getLong("id");*/
	        String type="coun";
	        //int id=1;
	        final DBAdapter dbadapter=new DBAdapter(TestDB.this);
			dbadapter.open();
			final News[] news=dbadapter.queryAllData(type);
	        
	        final TextView textview=(TextView)findViewById(R.id.textview001);
	       
	        
	        Button button=(Button)findViewById(R.id.button001);
	        button.setText("œ‘ æ");
	        button.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dbadapter.close();
					 textview.setText(news[1].part);
					/*Intent intent=new Intent();
					intent.setClass(TestDB.this,MainActivity.class);
					startActivity(intent);*/
					
				}
			});
	 }
}

