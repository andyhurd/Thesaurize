package edu.uwec.cs.hurdad.thesaurize;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayList<String> pages = new ArrayList<String>();
		pages.add(getString(R.string.app_name));
		pages.add(getString(R.string.twodee));
		
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pages);
		setListAdapter(adapter);
        
        final OnItemClickListener onItemClickListener = new OnItemClickListener() {

			public void onItemClick(AdapterView<?> adapterView,
									View itemView,
									int position,
									long id) {
				
				String link = adapter.getItem(position);
				if (link.equals(getString(R.string.app_name))) {
					Intent intent = new Intent(MainActivity.this, ThesaurizeActivity.class);
					startActivity(intent);
				} else if (link.equals(getString(R.string.twodee))) {
					Intent intent = new Intent(MainActivity.this, TwodeeActivity.class);
					startActivity(intent);
				}
			}
        	
        };
        
        getListView().setOnItemClickListener(onItemClickListener);
	}
	
}
