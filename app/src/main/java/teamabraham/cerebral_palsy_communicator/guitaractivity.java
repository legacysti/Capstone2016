package teamabraham.cerebral_palsy_communicator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.IOException;

/**
 * Created by rysonasuncion on 2/29/16.
 */
public class guitaractivity extends Activity{

    MediaPlayer mp1 = new MediaPlayer();
    MediaPlayer mp2 = new MediaPlayer();
    MediaPlayer mp3 = new MediaPlayer();
    MediaPlayer mp4 = new MediaPlayer();
    MediaPlayer mp5 = new MediaPlayer();
    MediaPlayer mp6 = new MediaPlayer();
    MediaPlayer mp = new MediaPlayer();
    LinearLayout layout;
    View lowEString;
    View AString;
    View DString;
    View GString;
    View BString;
    View highEString;
    View lastTouchedString;
    long previousClickTime;
    long currClickTime;
    String catID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar);
        layout = (LinearLayout)findViewById(R.id.stringsLinLayout);

        lowEString = findViewById(R.id.lowEString);
        AString = findViewById(R.id.AString);
        DString = findViewById(R.id.DString);
        GString = findViewById(R.id.GString);
        BString = findViewById(R.id.BString);
        highEString = findViewById(R.id.highEString);
        lastTouchedString = null;
        previousClickTime = 0;
        currClickTime = 0;

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            catID = extras.getString("catID");
        }

        layout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent e) {
                float xTouch = e.getX();
                float yTouch = e.getY();

                if (xTouch >= 470.0 && xTouch <= 500.0 && yTouch <= 550.0 && e.getAction() != MotionEvent.ACTION_UP){
                    currClickTime = System.currentTimeMillis();
                    if (lastTouchedString == lowEString && currClickTime - previousClickTime >= 300) {
                        lastTouchedString = lowEString;
                        lowEString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp1.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.low_e_string);
                            mp1.setDataSource(getApplicationContext(), clapString);
                            mp1.prepare();
                            mp1.start();
                        } catch (IOException exc) {

                        }
                        // We touched lowE string
                        Log.d("touched string", "lowE");
                        previousClickTime = currClickTime;
                    }
                    else if (lastTouchedString != lowEString){
                        lastTouchedString = lowEString;
                        lowEString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp1.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.low_e_string);
                            mp1.setDataSource(getApplicationContext(), clapString);
                            mp1.prepare();
                            mp1.start();
                        } catch (IOException exc) {

                        }
                        // We touched lowE string
                        Log.d("touched string", "lowE");
                        previousClickTime = currClickTime;
                    }
                }
                else if (!(xTouch >= 470.0 && xTouch <= 500.0 && yTouch <= 550.0) || (xTouch >= 470.0 && xTouch <= 500.0 && yTouch <= 550.0 && e.getAction() == MotionEvent.ACTION_UP)){
                    lowEString.setBackgroundResource(R.drawable.guitar_string_unpressed);
                }


                if (xTouch >= 530.0 && xTouch <= 560.0 && yTouch <= 550.0 && e.getAction() != MotionEvent.ACTION_UP){
                    currClickTime = System.currentTimeMillis();
                    if (lastTouchedString == AString && currClickTime - previousClickTime >= 300) {
                        lastTouchedString = AString;
                        AString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp2.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_string);
                            mp2.setDataSource(getApplicationContext(), clapString);
                            mp2.prepare();
                            mp2.start();
                        } catch (IOException exc) {

                        }
                        // We touched A string
                        Log.d("touched string", "A");
                        previousClickTime = currClickTime;
                    }
                    else if (lastTouchedString != AString){
                        lastTouchedString = AString;
                        AString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp2.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_string);
                            mp2.setDataSource(getApplicationContext(), clapString);
                            mp2.prepare();
                            mp2.start();
                        } catch (IOException exc) {

                        }
                        // We touched A string
                        Log.d("touched string", "A");
                        previousClickTime = currClickTime;
                    }
                }
                else if (!(xTouch >= 530.0 && xTouch <= 560.0 && yTouch <= 550.0) || (xTouch >= 530.0 && xTouch <= 560.0 && yTouch <= 550.0 && e.getAction() == MotionEvent.ACTION_UP)){
                    AString.setBackgroundResource(R.drawable.guitar_string_unpressed);
                }


                if (xTouch >= 590.0 && xTouch <= 620.0 && yTouch <= 550.0 && e.getAction() != MotionEvent.ACTION_UP){
                    currClickTime = System.currentTimeMillis();
                    if (lastTouchedString == DString && currClickTime - previousClickTime >= 300) {
                        lastTouchedString = DString;
                        DString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp3.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.d_string);
                            mp3.setDataSource(getApplicationContext(), clapString);
                            mp3.prepare();
                            mp3.start();
                        } catch (IOException exc) {

                        }
                        // We touched A string
                        Log.d("touched string", "D");
                        previousClickTime = currClickTime;
                    }
                    else if (lastTouchedString != DString){
                        lastTouchedString = DString;
                        DString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp3.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.d_string);
                            mp3.setDataSource(getApplicationContext(), clapString);
                            mp3.prepare();
                            mp3.start();
                        } catch (IOException exc) {

                        }
                        // We touched A string
                        Log.d("touched string", "D");
                        previousClickTime = currClickTime;
                    }
                }
                else if (!(xTouch >= 590.0 && xTouch <= 620.0 && yTouch <= 550.0) || (xTouch >= 590.0 && xTouch <= 620.0 && yTouch <= 550.0 && e.getAction() == MotionEvent.ACTION_UP)){
                    DString.setBackgroundResource(R.drawable.guitar_string_unpressed);
                }


                if (xTouch >= 650.0 && xTouch <= 680.0 && yTouch <= 550.0 && e.getAction() != MotionEvent.ACTION_UP){
                    currClickTime = System.currentTimeMillis();
                    if (lastTouchedString == GString && currClickTime - previousClickTime >= 300){
                        lastTouchedString = GString;
                        GString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp4.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.g_string);
                            mp4.setDataSource(getApplicationContext(), clapString);
                            mp4.prepare();
                            mp4.start();
                        } catch (IOException exc) {

                        }
                        // We touched G string
                        Log.d("touched string","G");
                        previousClickTime = currClickTime;
                    }
                    else if (lastTouchedString != GString){
                        lastTouchedString = GString;
                        GString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp4.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.g_string);
                            mp4.setDataSource(getApplicationContext(), clapString);
                            mp4.prepare();
                            mp4.start();
                        } catch (IOException exc) {

                        }
                        // We touched G string
                        Log.d("touched string","G");
                        previousClickTime = currClickTime;
                    }

                }
                else if(!(xTouch >= 650.0 && xTouch <= 680.0 && yTouch <= 550.0) || (xTouch >= 650.0 && xTouch <= 680.0 && yTouch <= 550.0 && e.getAction() == MotionEvent.ACTION_UP)){
                    GString.setBackgroundResource(R.drawable.guitar_string_unpressed);
                }


                if (xTouch >= 710.0 && xTouch <= 740.0 && yTouch <= 550.0 && e.getAction() != MotionEvent.ACTION_UP){
                    currClickTime = System.currentTimeMillis();
                    if (lastTouchedString == BString && currClickTime - previousClickTime >= 300){
                        lastTouchedString = BString;
                        BString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp5.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_string);
                            mp5.setDataSource(getApplicationContext(), clapString);
                            mp5.prepare();
                            mp5.start();
                        } catch (IOException exc) {

                        }
                        // We touched A string
                        Log.d("touched string","B");
                        previousClickTime = currClickTime;
                    }
                    else if (lastTouchedString != BString){
                        lastTouchedString = BString;
                        BString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp5.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_string);
                            mp5.setDataSource(getApplicationContext(), clapString);
                            mp5.prepare();
                            mp5.start();
                        } catch (IOException exc) {

                        }
                        // We touched A string
                        Log.d("touched string","B");
                        previousClickTime = currClickTime;
                    }

                }
                else if (!(xTouch >= 710.0 && xTouch <= 740.0 && yTouch <= 550.0) || xTouch >= 710.0 && xTouch <= 740.0 && yTouch <= 550.0 && e.getAction() == MotionEvent.ACTION_UP){
                    BString.setBackgroundResource(R.drawable.guitar_string_unpressed);
                }


                if (xTouch >= 770.0 && xTouch <= 800.0 && yTouch <= 550.0 && e.getAction() != MotionEvent.ACTION_UP){
                    currClickTime = System.currentTimeMillis();
                    if (lastTouchedString == highEString && currClickTime - previousClickTime >= 300){
                        lastTouchedString = highEString;
                        highEString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp6.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.high_e_string);
                            mp6.setDataSource(getApplicationContext(), clapString);
                            mp6.prepare();
                            mp6.start();
                        } catch (IOException exc) {

                        }
                        // We touched highE string
                        Log.d("touched string","highE");
                        previousClickTime = currClickTime;
                    }
                    else if (lastTouchedString != highEString){
                        lastTouchedString = highEString;
                        highEString.setBackgroundResource(R.drawable.guitar_string_pressed);
                        try {
                            mp6.reset();
                            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.high_e_string);
                            mp6.setDataSource(getApplicationContext(), clapString);
                            mp6.prepare();
                            mp6.start();
                        } catch (IOException exc) {

                        }
                        // We touched highE string
                        Log.d("touched string","highE");
                        previousClickTime = currClickTime;
                    }
                }
                else if (!(xTouch >= 770.0 && xTouch <= 800.0 && yTouch <= 550.0) || (xTouch >= 770.0 && xTouch <= 800.0 && yTouch <= 550.0 && e.getAction() == MotionEvent.ACTION_UP)){
                    highEString.setBackgroundResource(R.drawable.guitar_string_unpressed);
                }
                return true;
            }
        });
    }



    public void onHomeClick(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);
        startActivity(newActivity);
    }

    public void attentionClick(View v){
        try {
            mp.reset();
            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.attention);
            mp.setDataSource(getApplicationContext(), clapString);
            mp.prepare();
            mp.start();
        } catch (IOException e) {

        }
    }

    public void simpleClick(View v){
        switch (v.getId()) {
            case R.id.yesButton:
                try {
                    mp.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.yes);
                    mp.setDataSource(getApplicationContext(), clapString);
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {

                }
                break;
            case R.id.noButton:
                try {
                    mp.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no);
                    mp.setDataSource(getApplicationContext(), clapString);
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {

                }
                break;
            default:
                break;
        }
    }


    public void stringClick(View v){
        switch(v.getId()){
            case R.id.lowEString:
                Log.d("lowE X coord", ""+lowEString.getX());
                Log.d("lowE Y coord", ""+lowEString.getY());
                try {
                    mp1.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.low_e_string);
                    mp1.setDataSource(getApplicationContext(), clapString);
                    mp1.prepare();
                    mp1.start();
                } catch (IOException exc) {

                }
                break;
            case R.id.AString:
                Log.d("A X coord", ""+AString.getX());
                Log.d("A Y coord", ""+AString.getY());
                try {
                    mp2.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a_string);
                    mp2.setDataSource(getApplicationContext(), clapString);
                    mp2.prepare();
                    mp2.start();
                } catch (IOException exc) {

                }
                break;
            case R.id.DString:
                try {
                    mp3.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.d_string);
                    mp3.setDataSource(getApplicationContext(), clapString);
                    mp3.prepare();
                    mp3.start();
                } catch (IOException exc) {

                }
                break;
            case R.id.GString:
                try {
                    mp4.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.g_string);
                    mp4.setDataSource(getApplicationContext(), clapString);
                    mp4.prepare();
                    mp4.start();
                } catch (IOException exc) {

                }
                break;
            case R.id.BString:
                try {
                    mp5.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.b_string);
                    mp5.setDataSource(getApplicationContext(), clapString);
                    mp5.prepare();
                    mp5.start();
                } catch (IOException exc) {

                }
                break;
            case R.id.highEString:
                try {
                    mp6.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.high_e_string);
                    mp6.setDataSource(getApplicationContext(), clapString);
                    mp6.prepare();
                    mp6.start();
                } catch (IOException exc) {

                }
                break;
            default:
                break;
        }
    }




}
