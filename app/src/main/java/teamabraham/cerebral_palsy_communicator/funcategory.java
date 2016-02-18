package teamabraham.cerebral_palsy_communicator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;


public class funcategory extends AppCompatActivity {

    String video;
    public MediaPlayer mp = new MediaPlayer();
    Intent newActivity;
    Context thisActivity;
    ImageButton parentalMode;
    boolean parentalModeEnabled;
    Button leftTop;
    Button rightTop;
    Button leftMid;
    Button rightMid;
    Button leftBot;
    Button rightBot;
    Button yesButton;
    Button noButton;
    String MY_PREFS_NAME = "storage";
    SharedPreferences.Editor editor;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcategory);
        video = "";
        newActivity = null;
        thisActivity = this;
        final Context thisActivity = this;
        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = pref.edit();
        leftTop = (Button)findViewById(R.id.topLeftButton);
        rightTop = (Button) findViewById(R.id.topRightButton);
        leftMid = (Button) findViewById(R.id.midLeftButton);
        rightMid = (Button) findViewById(R.id.midRightButton);
        leftBot = (Button) findViewById(R.id.botLeftButton);
        rightBot = (Button) findViewById(R.id.botRightButton);
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);
        parentalMode = (ImageButton) findViewById(R.id.parentalModeButton);
        newActivity = new Intent(this, youtubeactivity.class);
        parentalModeEnabled = false;


        leftTop.setText(pref.getString("topLeftTextFun", leftTop.getText().toString()));
        rightTop.setText(pref.getString("topRightTextFun", rightTop.getText().toString()));
        leftMid.setText(pref.getString("midLeftTextFun", leftMid.getText().toString()));
        rightMid.setText(pref.getString("midRightTextFun", rightMid.getText().toString()));
        leftBot.setText(pref.getString("botLeftTextFun", leftBot.getText().toString()));
        rightBot.setText(pref.getString("botRightTextFun", rightBot.getText().toString()));

        leftTop.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
                builder.setTitle("Enter URL Key:");

                final EditText input = new EditText(thisActivity);

                builder.setView(input);

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        video = input.getText().toString();

                        if (newActivity != null) {
                            newActivity.putExtra("url", video);
                            startActivity(newActivity);
                        }
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
                return true;
            }
        });

        parentalMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
                if (!parentalModeEnabled) {
                    builder.setTitle("Enter Parental Mode?");
                } else if (parentalModeEnabled) {
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

    public void onHomeClickFun(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);
        editor.putString("topLeftTextFun", leftTop.getText().toString());
        editor.putString("topRightTextFun", rightTop.getText().toString());
        editor.putString("midLeftTextFun", leftMid.getText().toString());
        editor.putString("midRightTextFun", rightMid.getText().toString());
        editor.putString("botLeftTextFun", leftBot.getText().toString());
        editor.putString("botRightTextFun", rightBot.getText().toString());
        editor.commit();
        newActivity.putExtra("id", "funCat");
        startActivity(newActivity);
    }

    public void simpleClick(View view){

        final Button pressed = (Button) view;
        if(parentalModeEnabled == false) {
            Intent imagePopUpIntent = new Intent(this, ImagePopUp.class);
            switch (view.getId()) {
                case R.id.topLeftButton:
                    newActivity = new Intent(this, youtubeactivity.class);
                    startActivity(newActivity);
                    break;
                case R.id.topRightButton:
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
                    break;
                case R.id.midLeftButton:
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
                    break;
                case R.id.midRightButton:
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
                    break;
                case R.id.botLeftButton:
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
                    break;
                case R.id.botRightButton:
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
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

        }
        else if(parentalModeEnabled == true){

            if(pressed.getId() == R.id.yesButton || pressed.getId() == R.id.noButton){
                final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
                builder.setTitle("Can't change 'Yes' or 'No' button text.");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });

                builder.show();
            }
            else {
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

}
