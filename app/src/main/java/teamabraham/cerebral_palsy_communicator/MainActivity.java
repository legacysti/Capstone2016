package teamabraham.cerebral_palsy_communicator;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    public MediaPlayer mp = new MediaPlayer();
    Button yesButton;
    Button noButton;
    boolean parentalModeEnabled;
    Context thisActivity;
    Button leftTop;
    Button rightTop;
    Button leftMid;
    Button rightMid;
    Button leftBot;
    Button rightBot;
    String MY_PREFS_NAME = "storage";
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    boolean hasStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = pref.edit();
        hasStarted = pref.getBoolean("hasStarted", false);
        if(!hasStarted){
            editor.putString("topLeftTextFood", "FuFu");
            editor.putString("topRightTextFood", "Banana");
            editor.putString("midLeftTextFood", "Pizza");
            editor.putString("midRightTextFood", "Drink");
            editor.putString("botLeftTextFood", "Pineapple");
            editor.putString("botRightTextFood", "Casava");
            editor.putString("topLeftTextAct", "Go Outside");
            editor.putString("topRightTextAct", "Listen to Music");
            editor.putString("midLeftTextAct", "Watch TV");
            editor.putString("midRightTextAct", "Watch Netflix");
            editor.putString("botLeftTextAct", "Go Somewhere");
            editor.putString("botRightTextAct", "Go Inside");
            editor.putString("topLeftTextEmo", "I don't Care");
            editor.putString("topRightTextEmo", "Sad");
            editor.putString("midLeftTextEmo", "Aggravated");
            editor.putString("midRightTextEmo", "Angry");
            editor.putString("botLeftTextEmo", "Bored");
            editor.putString("botRightTextEmo", "Happy");
            editor.putString("topLeftTextPer", "I Feel Sick");
            editor.putString("topRightTextPer", "I'm Tired");
            editor.putString("midLeftTextPer", "I'm Uncomfortable");
            editor.putString("midRightTextPer", "Need to go to the Bathroom");
            editor.putString("botLeftTextPer", "I'm OK");
            editor.putString("botRightTextPer", "Need to be changed");
            editor.putString("topLeftTextFun", "YouTube");
            editor.putString("topRightTextFun", "Stamper");
            editor.putString("midLeftTextFun", "");
            editor.putString("midRightTextFun", "");
            editor.putString("botLeftTextFun", "");
            editor.putString("botRightTextFun", "");
            editor.putString("topLeftTextFav", "");
            editor.putString("topRightTextFav", "");
            editor.putString("midLeftTextFav", "");
            editor.putString("midRightTextFav", "");
            editor.putString("botLeftTextFav", "");
            editor.putString("botRightTextFav", "");
            hasStarted = true;
            editor.putBoolean("hasStarted", hasStarted);
            editor.commit();
        }
        leftTop = (Button)findViewById(R.id.topLeftButton);
        rightTop = (Button)findViewById(R.id.topRightButton);
        leftMid = (Button)findViewById(R.id.midLeftButton);
        rightMid = (Button)findViewById(R.id.midRightButton);
        leftBot = (Button)findViewById(R.id.botLeftButton);
        rightBot = (Button)findViewById(R.id.botRightButton);
        yesButton = (Button)findViewById(R.id.yesButton);
        noButton = (Button)findViewById(R.id.noButton);

        final ImageButton parentalMode = (ImageButton) findViewById(R.id.parentalModeButton);
        parentalModeEnabled = false;
        thisActivity = this;
        
        parentalMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
                if(!parentalModeEnabled) {
                    builder.setTitle("Enter Parental Mode?");
                }
                else if(parentalModeEnabled){
                    builder.setTitle("Exit Parental Mode?");
                }


                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        parentalModeEnabled = !parentalModeEnabled;
                        if(parentalModeEnabled) {
                            parentalMode.setImageResource(R.drawable.button_parental_mode_pressed);
                        }
                        else{
                            parentalMode.setImageResource(R.drawable.button_parental_mode_unpressed);
                        }
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
                return true;
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    public void simpleClick(View view){
        Intent newActivity = null;
        final Button pressed = (Button) view;
        if(parentalModeEnabled == false) {
            switch (view.getId()) {
                case R.id.topLeftButton:
                    newActivity = new Intent(this, categoryActivity.class);
                    newActivity.putExtra("catID", "Food");
                    break;
                case R.id.topRightButton:

                    newActivity = new Intent(this, categoryActivity.class);
                    newActivity.putExtra("catID", "Act");
                    break;
                case R.id.midLeftButton:

                    newActivity = new Intent(this, categoryActivity.class);
                    newActivity.putExtra("catID", "Per");
                    break;
                case R.id.midRightButton:

                    newActivity = new Intent(this, categoryActivity.class);
                    newActivity.putExtra("catID", "Fun");
                    break;
                case R.id.botLeftButton:

                    newActivity = new Intent(this, categoryActivity.class);
                    newActivity.putExtra("catID", "Emo");
                    break;
                case R.id.botRightButton:
                    newActivity = new Intent(this, categoryActivity.class);
                    newActivity.putExtra("catID", "Fav");
                    break;
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

            }
            if(newActivity != null) {
                startActivity(newActivity);
            }
        }
        else if(parentalModeEnabled == true){

            final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
            builder.setTitle("Cannot change category text");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            builder.show();
        }

    }

}
