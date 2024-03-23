package com.ltz.my_empl;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ltz.my_empl.adapter.MyPagerAdapter;
import com.ltz.my_empl.fragment.HomeFragment;
import com.ltz.my_empl.fragment.MineFragment;
import com.ltz.my_empl.fragment.SubmitFragment;
import com.ltz.my_empl.util.StatusBar;

public class HomeActivity extends AppCompatActivity {

    private boolean isLightMode = true;
    private ViewPager viewPager;
    private BottomNavigationView navView;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        StatusBar.setStatusBarTransparent(this);
        StatusBar.setStatusBarLightMode(this, isLightMode);

        viewPager = findViewById(R.id.viewPager);
        navView = findViewById(R.id.nav_view);
        // 创建并设置适配器
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), getString(R.string.home));
        adapter.addFragment(new SubmitFragment(), getString(R.string.submit));
        adapter.addFragment(new MineFragment(), getString(R.string.mine));
        viewPager.setAdapter(adapter);
        // 设置 BottomNavigationView 的点击事件监听器
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.homeFragment) {
                    viewPager.setCurrentItem(0);
                    return true;
                } else if (item.getItemId() == R.id.submitFragment) {
                    viewPager.setCurrentItem(1);
                    return true;
                } else if (item.getItemId() == R.id.mineFragment) {
                    viewPager.setCurrentItem(2);
                    return true;
                } else {
                    return false;
                }
            }
        });

        // 设置 ViewPager 的页面改变监听器，以便更新 BottomNavigationView 的选中项
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 不需要实现
            }

            @Override
            public void onPageSelected(int position) {
                navView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // 不需要实现
            }
        });

        // 初始设置 BottomNavigationView 的选中项
        // 添加页面改变监听器之后进行，以避免冲突
        navView.getMenu().getItem(0).setChecked(true);
    }
}