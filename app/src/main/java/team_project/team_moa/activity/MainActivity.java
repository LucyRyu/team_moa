package team_project.team_moa.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import team_project.team_moa.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    ActionBar actionBar;
    DrawerLayout drawer;
    int aIdx = LoginActivity.account_Idx;
    public static double lat, lon;
    public static int[] regular = new int[50];


    private MenuItem searchItem;
    private SearchRecentSuggestions suggestions;
    private SearchView searchView;


    String account_Name;
    String account_Phone;
    String account_Email;

    public static int[][] idx = new int[4][];
    public static int[][] flag = new int[4][];
    public static String[][] name = new String[4][];
    public static String[][] addr = new String[4][];
    public static String[][] phone = new String[4][];
    public static String[][] time = new String[4][];
    public static String[][] distance = new String[4][];
    String getJson;

    boolean sw = false;

    private long backKeyPressedTime = 0;
    private Toast toast;

    public static Activity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new MemberListFragment();
                title = getString(R.string.title_memberlist);
                break;
            case 1:
                Intent intent = new Intent(MainActivity.this, FavoriteMemberFragment.class);
                startActivity(intent);
                title = getString(R.string.title_favoritemember);
                break;
            case 2:
                Intent intent2 = new Intent(MainActivity.this, MypageMenu.class);
                startActivity(intent2);
                title = getString(R.string.title_mypage);
                break;
            case 3:
                Intent intent1 = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent1);
                title = getString(R.string.title_setting);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }




}