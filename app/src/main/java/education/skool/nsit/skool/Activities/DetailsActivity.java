package education.skool.nsit.skool.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import education.skool.nsit.skool.Fragments.LeaderBoardFrag;
import education.skool.nsit.skool.Fragments.UntrainedFrag;
import education.skool.nsit.skool.Fragments.ScholarFrag;
import education.skool.nsit.skool.R;

public class DetailsActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private FragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new FragAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }

    public class FragAdapter extends FragmentPagerAdapter {

        public FragAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0) {
                fragment = new UntrainedFrag();
            }
            if (position == 1) {
                fragment = new ScholarFrag();
            }
            if (position == 2) {
                fragment = new LeaderBoardFrag();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Untrained";
                case 1:
                    return "Scholar";
                case 3:
                    return "LeaderBoard";
            }
            return null;
        }
    }
}
