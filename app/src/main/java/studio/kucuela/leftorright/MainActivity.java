package studio.kucuela.leftorright;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import com.jrummyapps.android.animations.Technique;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#1bbaee"));
        setSupportActionBar(toolbar);








        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.pljava));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_donate) {
            String url = "https://paypal.me/svetaz";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }  else if (id == R.id.nav_feedback) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("mailto:" + "rollbarbullbar@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            startActivity(Intent.createChooser(intent, "Send email"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void left(View view) {

        TextView textl = (TextView)findViewById(R.id.textl);
        TextView textr = (TextView)findViewById(R.id.textr);
        Technique.ROTATE.getComposer().duration(650).delay(0).playOn(textl);



        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.isWiredHeadsetOn();


        if (audioManager.isWiredHeadsetOn()==true) {

            MediaPlayer mp;
            mp = MediaPlayer.create(MainActivity.this, R.raw.moon1);
            mp.setVolume(0.75f, 0f);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    mp.reset();
                    mp.release();
                    mp = null;
                }

            });
            mp.start();

        } else {

            ConstraintLayout cl = (ConstraintLayout)findViewById(R.id.layout);
            final Snackbar snackbar = Snackbar.make(cl,"Please connect your headphones and try again", Snackbar.LENGTH_SHORT);

            // Set an action on it, and a handler
            snackbar.setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });



            snackbar.show();
        }





    }

    public void right(View view) {

        TextView textl = (TextView)findViewById(R.id.textl);
        TextView textr = (TextView)findViewById(R.id.textr);
        Technique.ROTATE.getComposer().duration(650).delay(0).playOn(textr);

        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.isWiredHeadsetOn();


        if (audioManager.isWiredHeadsetOn()==true) {

            MediaPlayer mp;
            mp = MediaPlayer.create(MainActivity.this, R.raw.moon1);
            mp.setVolume(0f, 0.75f);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    mp.reset();
                    mp.release();
                    mp = null;
                }

            });
            mp.start();

        } else {

            ConstraintLayout cl = (ConstraintLayout)findViewById(R.id.layout);
            final Snackbar snackbar = Snackbar.make(cl,"Please connect your headphones and try again", Snackbar.LENGTH_SHORT);

            // Set an action on it, and a handler
            snackbar.setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });



            snackbar.show();
        }

    }

    public void onResume() {

        TextView textl = (TextView)findViewById(R.id.textl);
        TextView textr = (TextView)findViewById(R.id.textr);
        Technique.SLIDE_IN_RIGHT.getComposer().duration(650).delay(0).playOn(textr);
        Technique.SLIDE_IN_LEFT.getComposer().duration(650).delay(0).playOn(textl);
        super.onResume();
    }
}
