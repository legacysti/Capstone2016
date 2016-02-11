package teamabraham.cerebral_palsy_communicator;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mp = new MediaPlayer();
    Button yesButton;
    Button noButton;
    int timesPressed;
    public ArrayList<Button> buttons = new ArrayList<Button>();
    boolean parentalModeEnabled;
    Context thisActivity;
    Button leftTop;
    Button rightTop;
    Button leftMid;
    Button rightMid;
    Button leftBot;
    Button rightBot;
    String pressedText;
    Bundle passerBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            passerBundle = extras;
        }


        leftTop = (Button)findViewById(R.id.topLeftButton);
        buttons.add(leftTop);
        rightTop = (Button)findViewById(R.id.topRightButton);
        buttons.add(rightTop);
        leftMid = (Button)findViewById(R.id.midLeftButton);
        buttons.add(leftMid);
        rightMid = (Button)findViewById(R.id.midRightButton);
        buttons.add(rightMid);
        leftBot = (Button)findViewById(R.id.botLeftButton);
        buttons.add(leftBot);
        rightBot = (Button)findViewById(R.id.botRightButton);
        buttons.add(rightBot);
        yesButton = (Button)findViewById(R.id.yesButton);
        buttons.add(yesButton);
        noButton = (Button)findViewById(R.id.noButton);
        buttons.add(noButton);

        final ImageButton parentalMode = (ImageButton) findViewById(R.id.parentalModeButton);
        Intent newActivity = new Intent(this, youtubeactivity.class);
        parentalModeEnabled = false;

        thisActivity= this;
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
                //final EditText input = new EditText(thisActivity);

                //builder.setView(input);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        parentalModeEnabled = !parentalModeEnabled;
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

    public void simpleClick(View view){
        Intent newActivity = null;
        final Button pressed = (Button) view;
        pressedText = pressed.getText().toString();
        if(parentalModeEnabled == false) {
            switch (view.getId()) {
                case R.id.topLeftButton:
                    newActivity = new Intent(this, foodcategory.class);
                    if(passerBundle != null) {
                        newActivity.putExtra("topLeftText", passerBundle.getString("topLeftText"));
                        newActivity.putExtra("topRightText", passerBundle.getString("topRightText"));
                        newActivity.putExtra("midRightText", passerBundle.getString("midRightText"));
                        newActivity.putExtra("midLeftText", passerBundle.getString("midLeftText"));
                        newActivity.putExtra("botRightText", passerBundle.getString("botRightText"));
                        newActivity.putExtra("botLeftText", passerBundle.getString("botLeftText"));
                    }
                    break;
                case R.id.topRightButton:
                    newActivity = new Intent(this, activitiescategory.class);
                    if(passerBundle != null) {
                        newActivity.putExtra("topLeftText", passerBundle.getString("topLeftText"));
                        newActivity.putExtra("topRightText", passerBundle.getString("topRightText"));
                        newActivity.putExtra("midRightText", passerBundle.getString("midRightText"));
                        newActivity.putExtra("midLeftText", passerBundle.getString("midLeftText"));
                        newActivity.putExtra("botRightText", passerBundle.getString("botRightText"));
                        newActivity.putExtra("botLeftText", passerBundle.getString("botLeftText"));
                    }
                    break;
                case R.id.midLeftButton:
                    newActivity = new Intent(this, personalcategory.class);
                    if(passerBundle != null) {
                        newActivity.putExtra("topLeftText", passerBundle.getString("topLeftText"));
                        newActivity.putExtra("topRightText", passerBundle.getString("topRightText"));
                        newActivity.putExtra("midRightText", passerBundle.getString("midRightText"));
                        newActivity.putExtra("midLeftText", passerBundle.getString("midLeftText"));
                        newActivity.putExtra("botRightText", passerBundle.getString("botRightText"));
                        newActivity.putExtra("botLeftText", passerBundle.getString("botLeftText"));
                    }
                    break;
                case R.id.midRightButton:
                    newActivity = new Intent(this, funcategory.class);
                    if(passerBundle != null) {
                        newActivity.putExtra("topLeftText", passerBundle.getString("topLeftText"));
                        newActivity.putExtra("topRightText", passerBundle.getString("topRightText"));
                        newActivity.putExtra("midRightText", passerBundle.getString("midRightText"));
                        newActivity.putExtra("midLeftText", passerBundle.getString("midLeftText"));
                        newActivity.putExtra("botRightText", passerBundle.getString("botRightText"));
                        newActivity.putExtra("botLeftText", passerBundle.getString("botLeftText"));
                    }
                    break;
                case R.id.botLeftButton:
                    newActivity = new Intent(this, emotioncategory.class);
                    if(passerBundle != null) {
                        newActivity.putExtra("topLeftText", passerBundle.getString("topLeftText"));
                        newActivity.putExtra("topRightText", passerBundle.getString("topRightText"));
                        newActivity.putExtra("midRightText", passerBundle.getString("midRightText"));
                        newActivity.putExtra("midLeftText", passerBundle.getString("midLeftText"));
                        newActivity.putExtra("botRightText", passerBundle.getString("botRightText"));
                        newActivity.putExtra("botLeftText", passerBundle.getString("botLeftText"));
                    }
                    break;
                case R.id.botRightButton:
                    newActivity = new Intent(this, favoritescategory.class);
                    if(passerBundle != null) {
                        newActivity.putExtra("topLeftText", passerBundle.getString("topLeftText"));
                        newActivity.putExtra("topRightText", passerBundle.getString("topRightText"));
                        newActivity.putExtra("midRightText", passerBundle.getString("midRightText"));
                        newActivity.putExtra("midLeftText", passerBundle.getString("midLeftText"));
                        newActivity.putExtra("botRightText", passerBundle.getString("botRightText"));
                        newActivity.putExtra("botLeftText", passerBundle.getString("botLeftText"));
                    }
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
            if(newActivity != null){
                startActivity(newActivity);
            }
        }
        else if(parentalModeEnabled == true){

            final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
            builder.setTitle("Enter new button text:");
            final EditText input = new EditText(thisActivity);
            builder.setView(input);

            builder.setPositiveButton("Change", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    pressed.setText(input.getText().toString());

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }

    }

}
