package com.tetearent.fragment;

import java.util.ArrayList;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tetearent2.R;

public class ReferNEarnFragment extends Fragment {

	private java.util.List<ResolveInfo> listApp;
	
	View view;
	FragmentActivity activity;
	
	GridView gridView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_refernearn, container, false);

		activity = getActivity();
		
		gridView = (GridView) view.findViewById(R.id.gridview);
		
		listApp = showAllShareApp();
        if (listApp != null) {
        	gridView.setAdapter(new MyAdapter());
        	gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    share(listApp.get(position));
                }
            });
        }

		return view;
	}

	private void share(ResolveInfo appInfo) {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
		if (appInfo != null) {
			sendIntent
					.setComponent(new ComponentName(
							appInfo.activityInfo.packageName,
							appInfo.activityInfo.name));
		}
		sendIntent.setType("text/plain");
		// startActivity(Intent.createChooser(sendIntent, "Share"));
		startActivity(sendIntent);
	}

	private java.util.List<ResolveInfo> showAllShareApp() {
		java.util.List<ResolveInfo> mApps = new ArrayList<ResolveInfo>();
		Intent intent = new Intent(Intent.ACTION_SEND, null);
		intent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
		intent.setType("text/plain");
		PackageManager pManager = activity.getPackageManager();
		mApps = pManager.queryIntentActivities(intent,
				PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
		return mApps;
	}

	class MyAdapter extends BaseAdapter {

		PackageManager pm;

		public MyAdapter() {
			pm = activity.getPackageManager();
		}

		@Override
		public int getCount() {
			return listApp.size();
		}

		@Override
		public Object getItem(int position) {
			return listApp.get(position);
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = LayoutInflater.from(activity).inflate(
						R.layout.layout_share_app, parent, false);
				holder.ivLogo = (ImageView) convertView
						.findViewById(R.id.iv_logo);
				holder.tvAppName = (TextView) convertView
						.findViewById(R.id.tv_app_name);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			ResolveInfo appInfo = listApp.get(position);
			holder.ivLogo.setImageDrawable(appInfo.loadIcon(pm));
			holder.tvAppName.setText(appInfo.loadLabel(pm));

			return convertView;
		}
	}

	static class ViewHolder {
		ImageView ivLogo;
		TextView tvAppName;
	}
}
