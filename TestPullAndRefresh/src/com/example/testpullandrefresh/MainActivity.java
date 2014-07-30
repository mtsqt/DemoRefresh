package com.example.testpullandrefresh;


import java.util.ArrayList;
import java.util.List;

import com.example.testpullandrefresh.MyListView.OnRefreshListener;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

public class MainActivity extends Activity {
	private List<String> list;
	private MyListView lv;
	private LvAdapter adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (MyListView) findViewById(R.id.lv);
		list = new ArrayList<String>();
		list.add("loonggg");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		list.add("我们都是开发者");
		adapter = new LvAdapter(list, this);
		lv.setAdapter(adapter);

		lv.setonRefreshListener(new OnRefreshListener() {

			public void onRefresh() {
				new AsyncTask<Void, Void, Void>() {
					protected Void doInBackground(Void... params) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
						list.add("刷新后添加的内容");
						return null;
					}

					protected void onPostExecute(Void result) {
						adapter.notifyDataSetChanged();
						lv.onRefreshComplete();
					}
				}.execute(null, null, null);
			}
		});
	}
}
