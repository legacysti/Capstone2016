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
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;

public class categoryActivity extends AppCompatActivity {

    boolean parentalModeEnabled;
    public MediaPlayer mp = new MediaPlayer();
    Context thisActivity;
    Intent newActivity;
    Button leftTop;
    Button rightTop;
    Button leftMid;
    Button rightMid;
    Button leftBot;
    Button rightBot;
    Button yesButton;
    Button noButton;
    ImageButton parentalMode;
    String MY_PREFS_NAME = "storage";
    String video;
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    int max = -9999;
    int leftTopVal;
    int rightTopVal;
    int leftMidVal;
    int rightMidVal;
    int leftBotVal;
    int rightBotVal;
    String catID;
    String faveButton = "";
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            catID = extras.getString("catID");
        }
        setContentView(R.layout.activity_category);
        assignButtons();
        if(catID != null){
            rl = (RelativeLayout) findViewById(R.id.categoryact);
            if(catID.equals("Food")) {
                rl.setBackgroundResource(R.drawable.food_background);
            }
            if(catID.equals("Act")){
                rl.setBackgroundResource(R.drawable.activities_background);
            }
            if(catID.equals("Per")){
                rl.setBackgroundResource(R.drawable.personal_background);
            }
            if(catID.equals("Fav")){
                rl.setBackgroundResource(R.drawable.favorites_background);
            }
            if(catID.equals("Emo")){
                rl.setBackgroundResource(R.drawable.emotions_background);
            }
            if(catID.equals("Fun")){
                rl.setBackgroundResource(R.drawable.fun_background);
                leftTop.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        return newYouTubeKey();
                    }
                });
            }
        }
        parentalModeEnabled = false;
        parentalMode = (ImageButton) findViewById(R.id.parentalModeButton);
        parentalModeEnabled = false;

        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = pref.edit();
        setText(catID);
        thisActivity = this;
        parentalMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return presentToggle();
            }
        });
    }

    public void onHomeClick(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);
        updateText(catID);
        updateFaves(catID);
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


    public void simpleClick(View view){
        final Button pressed = (Button) view;

        if(parentalModeEnabled == false) {
            Intent imagePopUpIntent = new Intent(this, ImagePopUp.class);
            switch (view.getId()) {
                case R.id.topLeftButton:
                    //set fave
                    leftTopVal += 1;
                    if(leftTopVal > max){
                        max = leftTopVal;
                        faveButton = pressed.getText().toString();
                    }
                    if(catID.equals("Fun")){
                        newActivity = new Intent(this, youtubeactivity.class);
                        startActivity(newActivity);
                    }
                    else {
                        imagePopUpIntent.putExtra("str", pressed.getText().toString());
                        startActivity(imagePopUpIntent);
                    }
                    break;

                case R.id.topRightButton:
                    //set fave
                    rightTopVal += 1;
                    if(rightTopVal > max){
                        max = rightTopVal;
                        faveButton = pressed.getText().toString();
                    }
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
                    break;
                case R.id.midLeftButton:
                    //set fave
                    leftMidVal += 1;
                    if(leftMidVal > max){
                        max = leftMidVal;
                        faveButton = pressed.getText().toString();
                    }
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
                    break;
                case R.id.midRightButton:
                    //set fave
                    rightMidVal += 1;
                    if(rightMidVal > max){
                        max = rightMidVal;
                        faveButton = pressed.getText().toString();
                    }
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
                    break;
                case R.id.botLeftButton:
                    //set fave
                    leftBotVal += 1;
                    if(leftBotVal > max){
                        max = leftBotVal;
                        faveButton = pressed.getText().toString();

                    }
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
                    break;
                case R.id.botRightButton:
                    //set fave
                    rightBotVal += 1;
                    if(rightBotVal > max){
                        max = rightBotVal;
                        faveButton = pressed.getText().toString();

                    }
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
                changeText(pressed);
            }
        }
    }

    private void assignButtons(){
        leftTop = (Button)findViewById(R.id.topLeftButton);
        rightTop = (Button) findViewById(R.id.topRightButton);
        leftMid = (Button) findViewById(R.id.midLeftButton);
        rightMid = (Button) findViewById(R.id.midRightButton);
        leftBot = (Button) findViewById(R.id.botLeftButton);
        rightBot = (Button) findViewById(R.id.botRightButton);
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);
    }

    private void setText(String id){
        leftTop.setText(pref.getString("topLeftText" + id, leftTop.getText().toString()));
        rightTop.setText(pref.getString("topRightText" + id, rightTop.getText().toString()));
        leftMid.setText(pref.getString("midLeftText" + id, leftMid.getText().toString()));
        rightMid.setText(pref.getString("midRightText" + id, rightMid.getText().toString()));
        leftBot.setText(pref.getString("botLeftText" + id, leftBot.getText().toString()));
        rightBot.setText(pref.getString("botRightText" + id, rightBot.getText().toString()));
    }

    private boolean presentToggle(){
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
                if (parentalModeEnabled) {
                    parentalMode.setImageResource(R.drawable.button_parental_mode_pressed);
                } else {
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

    private void updateText(String id){
        editor.putString("topLeftText" + id, leftTop.getText().toString());
        editor.putString("topRightText" + id, rightTop.getText().toString());
        editor.putString("midLeftText" + id, leftMid.getText().toString());
        editor.putString("midRightText" + id, rightMid.getText().toString());
        editor.putString("botLeftText" + id, leftBot.getText().toString());
        editor.putString("botRightText" + id, rightBot.getText().toString());
        editor.commit();
    }
    private void updateFaves(String id){
        if(id.equals("Emo")) {
            editor.putString("botLeftTextFav", faveButton);
            editor.commit();
        }
        if(id.equals("Act")) {
            editor.putString("topRightTextFav", faveButton);
            editor.commit();
        }
        if(id.equals("Fun")) {
            editor.putString("midRightTextFav", faveButton);
            editor.commit();
        }
        if(id.equals("Per")) {
            editor.putString("midLeftTextFav", faveButton);
            editor.commit();
        }
        if(id.equals("Fun")) {
            editor.putString("midLeftTextFav", faveButton);
            editor.commit();
        }
    }

    private void changeText(Button b){
        final Button bb = b;
        final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
        builder.setTitle("Enter new button text:");
        final EditText input = new EditText(thisActivity);
        builder.setView(input);

        builder.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bb.setText(input.getText().toString());

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

    /*
    METHOD: newYouTubeKey
    RETURN: boolean
 */
    private boolean newYouTubeKey(){
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
}
