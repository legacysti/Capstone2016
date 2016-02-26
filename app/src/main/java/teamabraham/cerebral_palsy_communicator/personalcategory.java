package teamabraham.cerebral_palsy_communicator;

import android.app.Activity;
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

public class personalcategory extends AppCompatActivity {

    Context thisActivity;
    public MediaPlayer mp = new MediaPlayer();
    boolean parentalModeEnabled;
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
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    int max = -9999;
    int leftTopVal;
    int rightTopVal;
    int leftMidVal;
    int rightMidVal;
    int leftBotVal;
    int rightBotVal;
    String faveButton = "IM OKAY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcategory);

        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = pref.edit();

        parentalMode = (ImageButton) findViewById(R.id.parentalModeButton);
        thisActivity= this;
        parentalModeEnabled = false;
        assignButtons();
        setText();

        parentalMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return presentToggle();
            }
        });

    }

    public void onHomeClick(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);
        updateText();
        updateFaveCount();
        newActivity.putExtra("perCat", faveButton);
        startActivity(newActivity);
    }

    public void simpleClick(View view){

        final Button pressed = (Button) view;

        if(parentalModeEnabled == false) {
            Intent imagePopUpIntent = new Intent(this, ImagePopUp.class);
            switch (view.getId()) {
                case R.id.topLeftButton:
                    //set fave
                    leftTopVal += 1;
                    System.out.println("this is the top button:" + faveButton);
                    if(leftTopVal > max){
                        max = leftTopVal;
                        faveButton = pressed.getText().toString();
                    }
                    imagePopUpIntent.putExtra("str", pressed.getText().toString());
                    startActivity(imagePopUpIntent);
                    break;

                case R.id.topRightButton:
                    //set fave
                    rightTopVal += 1;
                    System.out.println("this is the top button:" + faveButton);
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
                    System.out.println("this is the top button:" + faveButton);
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
                    System.out.println("this is the top button:" + faveButton);
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
                    System.out.println("this is the top button:" + faveButton);
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
                    System.out.println("this is the top button:" + faveButton);
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

    private void setText(){
        leftTop.setText(pref.getString("topLeftTextPer", leftTop.getText().toString()));
        rightTop.setText(pref.getString("topRightTextPer", rightTop.getText().toString()));
        leftMid.setText(pref.getString("midLeftTextPer", leftMid.getText().toString()));
        rightMid.setText(pref.getString("midRightTextPer", rightMid.getText().toString()));
        leftBot.setText(pref.getString("botLeftTextPer", leftBot.getText().toString()));
        rightBot.setText(pref.getString("botRightTextPer", rightBot.getText().toString()));
    }
    private void updateText(){
        editor.putString("topLeftTextPer", leftTop.getText().toString());
        editor.putString("topRightTextPer", rightTop.getText().toString());
        editor.putString("midLeftTextPer", leftMid.getText().toString());
        editor.putString("midRightTextPer", rightMid.getText().toString());
        editor.putString("botLeftTextPer", leftBot.getText().toString());
        editor.putString("botRightTextPer", rightBot.getText().toString());
        editor.commit();
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
    private void updateFaveCount(){
        editor.putInt("topLeftValFood", leftTopVal);
        editor.putInt("topRightValFood", rightTopVal);
        editor.putInt("midLeftValFood", leftMidVal);
        editor.putInt("midRightValFood", rightMidVal);
        editor.putInt("botLeftValFood", leftBotVal);
        editor.putInt("botRightValFood", rightBotVal);
        editor.commit();
    }
    private boolean presentToggle(){
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
}
