package kobayashi.reiji.tabilog;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    private FragmentPagerAdapter adapter;

    private TabHost tabHost;

    private int currentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);

        adapter = new UserInfoViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        currentPage = 0;


        tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
        for(int i=0; i<adapter.getCount(); i++){
            tabHost.addTab(tabHost
                    .newTabSpec(String.valueOf(i))
                    .setIndicator(adapter.getPageTitle(i))
                    .setContent(android.R.id.tabcontent));
        }


        // タブとViewPagerのイベントを追加
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                pager.setCurrentItem(Integer.valueOf(tabId));
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}