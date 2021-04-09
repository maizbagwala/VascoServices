package com.techspinsolutions.vascoservices;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.techspinsolutions.vascoservices.fragments.AboutUsFragment;
import com.techspinsolutions.vascoservices.fragments.CartFragment;
import com.techspinsolutions.vascoservices.fragments.ContactUsFragment;
import com.techspinsolutions.vascoservices.fragments.HelpCenterFragment;
import com.techspinsolutions.vascoservices.fragments.HomeFragment;
import com.techspinsolutions.vascoservices.fragments.PrivacyPolicyFragment;
import com.techspinsolutions.vascoservices.fragments.ProfileFragment;
import com.techspinsolutions.vascoservices.fragments.SettingFragment;
import com.techspinsolutions.vascoservices.fragments.TermConditionFragment;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    static DrawerLayout drawerLayout;
    static FragmentManager fragmentManager;
    static RelativeLayout rr_s, rr_b;
    static TextView tv_appbar;
    public static TextView HomeSearch;
    public static ImageView back_btn;
    static LinearLayout bottom;
    static TextView b_n_home, b_n_cart, b_n_profile, b_n_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        navigationView = findViewById(R.id.nav_view1);
        drawerLayout = findViewById(R.id.drawer_layout);
        rr_s = findViewById(R.id.rr_s);
        rr_b = findViewById(R.id.rr_b);
        HomeSearch = findViewById(R.id.home_search);
        tv_appbar = findViewById(R.id.tv_appbar);
        back_btn = findViewById(R.id.back_btn);
        b_n_home = findViewById(R.id.bottom_home_tv);
        b_n_cart = findViewById(R.id.bottom_cart_tv);
        b_n_profile = findViewById(R.id.bottom_profile_tv);
        b_n_setting = findViewById(R.id.bottom_setting_tv);
        bottom = findViewById(R.id.bottom_layout);

        setAppbarWithBack(false);

        loadFragment(new HomeFragment());
        findViewById(R.id.menu_btn).setOnClickListener(v -> {
            ((DrawerLayout) findViewById(R.id.drawer_layout)).openDrawer(Gravity.LEFT);

        });
        findViewById(R.id.menu_close_btn).setOnClickListener(v -> {
            ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer(Gravity.LEFT);

        });

    }

    public static void setAppbarText(String text) {
        tv_appbar.setText(text);
    }

    public static void setAppbarWithBack(boolean b) {

        if (b) {
            rr_s.setVisibility(View.GONE);
            rr_b.setVisibility(View.VISIBLE);
        } else {
            rr_s.setVisibility(View.VISIBLE);
            rr_b.setVisibility(View.GONE);
        }

    }

    public static void setAppbarWithBack(int b) {

        if (b == 0) {
            rr_s.setVisibility(View.GONE);
            rr_b.setVisibility(View.GONE);
        }

    }


    public void side_nav_item_click(View view) {


        switch (view.getId()) {
            case R.id.nav_home:
                loadFragment(new HomeFragment());
                break;
            case R.id.nav_help_center:
                loadFragment(new HelpCenterFragment());

                break;
            case R.id.nav_share_app:
                Toast.makeText(this, "share clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about_us:
                loadFragment(new AboutUsFragment());

                break;
            case R.id.nav_privacy_policy:
                loadFragment(new PrivacyPolicyFragment());
                break;
            case R.id.nav_term:
                loadFragment(new TermConditionFragment());
                break;
            case R.id.nav_contact_us:
                loadFragment(new ContactUsFragment());
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "logout clicked", Toast.LENGTH_SHORT).show();
                break;


        }
    }

    public static void loadFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.frag_container, fragment, null) // gets the second animations
                .addToBackStack(null)
                .commit();
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

    public void bottom_nav_item_click(View view) {
        switch (view.getId()) {
            case R.id.bottom_home:
                loadFragment(new HomeFragment());
                break;
            case R.id.bottom_cart:
                loadFragment(new CartFragment());
                break;
            case R.id.bottom_profile:
                loadFragment(new ProfileFragment());
                break;
            case R.id.bottom_setting:
                loadFragment(new SettingFragment());
                break;
        }
    }


    public static void setBottomSelected(String nav) {
        switch (nav) {
            case "home":
                bottom.setVisibility(View.VISIBLE);
                b_n_home.setVisibility(View.VISIBLE);
                b_n_cart.setVisibility(View.GONE);
                b_n_profile.setVisibility(View.GONE);
                b_n_setting.setVisibility(View.GONE);

                break;
            case "cart":
                bottom.setVisibility(View.VISIBLE);
                b_n_home.setVisibility(View.GONE);
                b_n_cart.setVisibility(View.VISIBLE);
                b_n_profile.setVisibility(View.GONE);
                b_n_setting.setVisibility(View.GONE);

                break;
            case "profile":
                bottom.setVisibility(View.VISIBLE);
                b_n_home.setVisibility(View.GONE);
                b_n_cart.setVisibility(View.GONE);
                b_n_profile.setVisibility(View.VISIBLE);
                b_n_setting.setVisibility(View.GONE);

                break;
            case "setting":
                bottom.setVisibility(View.VISIBLE);
                b_n_home.setVisibility(View.GONE);
                b_n_cart.setVisibility(View.GONE);
                b_n_profile.setVisibility(View.GONE);
                b_n_setting.setVisibility(View.VISIBLE);

                break;
            case "remove":
                bottom.setVisibility(View.GONE);
                break;
            default:
                bottom.setVisibility(View.VISIBLE);
                b_n_home.setVisibility(View.GONE);
                b_n_cart.setVisibility(View.GONE);
                b_n_profile.setVisibility(View.GONE);
                b_n_setting.setVisibility(View.GONE);
                break;
        }
    }
}


