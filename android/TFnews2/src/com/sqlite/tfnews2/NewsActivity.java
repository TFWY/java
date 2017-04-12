package com.sqlite.tfnews2;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NewsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        
        Bundle bundle=this.getIntent().getExtras();
        String type=bundle.getString("type");
        Long id=bundle.getLong("id");
        
        final DBAdapter dbadapter=new DBAdapter(NewsActivity.this);
		dbadapter.open();
		News[] news=dbadapter.queryOneData(type, id);
        
        TextView textview=(TextView)findViewById(R.id.textview01);
        textview.setText(news[0].part);
        
        Button button=(Button)findViewById(R.id.button00);
        button.setText("·µ»Ø");
        button.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dbadapter.close();
				Intent intent=new Intent();
				intent.setClass(NewsActivity.this,MainActivity.class);
				startActivity(intent);
				
			}
		});
        
/*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
    
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.main, container, false);
            return rootView;
        } */
    }

}

