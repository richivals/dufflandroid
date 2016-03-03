package com.tetearent2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.tetearent.fragment.BagFragment;
import com.tetearent.fragment.ExploreFragment;
import com.tetearent.fragment.MyProfileFragment;
import com.tetearent.fragment.ReferNEarnFragment;
import com.tetearent.fragment.SellFragment;
import com.tetearent.fragment.WishListFragment;

public class HomeFragmentActivity extends AppCompatActivity {
	
	FragmentManager fragmentManager;
	
	private DrawerLayout mDrawerLayout;
	
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
		
		fragmentManager = getSupportFragmentManager();
		
		final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fragment, new SellFragment(), "Sell");
		fragmentTransaction.commit();
		setSelected(3);
		
		setListener();
	}
	
	private void setListener() {
		
		((LinearLayout)findViewById(R.id.profile)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				switchFragment(new MyProfileFragment(), "Profile", 1);
			}
		});
		
		((LinearLayout)findViewById(R.id.explore)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				switchFragment(new ExploreFragment(), "Explore", 2);
			}
		});
		
		((LinearLayout)findViewById(R.id.sell)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				switchFragment(new SellFragment(), "Sell", 3);
			}
		});
		
		((LinearLayout)findViewById(R.id.refernearn)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				switchFragment(new ReferNEarnFragment(), "ReferNEarn", 4);
			}
		});
		
		((LinearLayout)findViewById(R.id.bag)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				switchFragment(new BagFragment(), "Closet", 5);
			}
		});
	}
	
	private void switchFragment(Fragment obj, String value, int seelection) {
		
		final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fragment, obj, value);
		fragmentTransaction.commit();
		setSelected(seelection);
	}
	
	private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                
                switch (menuItem.getItemId()) {

                case R.id.nav_wishlist:
                	switchFragment(new WishListFragment(), "Wishlist", -1);
        			break;
					
				default:
					break;
				}
                
                return true;
            }
        });
    }
	
	private void setSelected(int pos) {
		
		((LinearLayout)findViewById(R.id.profile_clone)).setBackgroundResource(android.R.color.transparent);
		((LinearLayout)findViewById(R.id.explore_clone)).setBackgroundResource(android.R.color.transparent);
		((LinearLayout)findViewById(R.id.sell_clone)).setBackgroundResource(android.R.color.transparent);
		((LinearLayout)findViewById(R.id.refernearn_clone)).setBackgroundResource(android.R.color.transparent);
		((LinearLayout)findViewById(R.id.bag_clone)).setBackgroundResource(android.R.color.transparent);
		
		switch (pos) {
		case 1:
			((LinearLayout)findViewById(R.id.profile_clone)).setBackgroundResource(R.drawable.pink_button);
			break;
			
		case 2:
			((LinearLayout)findViewById(R.id.explore_clone)).setBackgroundResource(R.drawable.pink_button);
			break;
			
		case 3:
			((LinearLayout)findViewById(R.id.sell_clone)).setBackgroundResource(R.drawable.pink_button);
			break;
			
		case 4:
			((LinearLayout)findViewById(R.id.refernearn_clone)).setBackgroundResource(R.drawable.pink_button);
			break;
			
		case 5:
			((LinearLayout)findViewById(R.id.bag_clone)).setBackgroundResource(R.drawable.pink_button);
			break;

		default:
			break;
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
				mDrawerLayout.closeDrawer(Gravity.START);
			} else {
				mDrawerLayout.openDrawer(Gravity.START);
			}
			break;
			
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
