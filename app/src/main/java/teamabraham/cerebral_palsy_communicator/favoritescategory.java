package teamabraham.cerebral_palsy_communicator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class favoritescategory extends AppCompatActivity {
    public MediaPlayer mp = new MediaPlayer();
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    String MY_PREFS_NAME = "storage";
    Button leftTop;
    Button rightTop;
    Button leftMid;
    Button rightMid;
    Button leftBot;
    Button rightBot;
    Button yesButton;
    Button noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritescategory);
        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = pref.edit();
        assignButtons();
        setText();


    }
    public void onHomeClick(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);
        updateText();
        startActivity(newActivity);
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
    private void setText(){
        leftTop.setText(pref.getString("topLeftTextFav", leftTop.getText().toString()));
        rightTop.setText(pref.getString("topRightTextFav", rightTop.getText().toString()));
        leftMid.setText(pref.getString("midLeftTextFav", leftMid.getText().toString()));
        rightMid.setText(pref.getString("midRightTextFav", rightMid.getText().toString()));
        leftBot.setText(pref.getString("botLeftTextFav", leftBot.getText().toString()));
    }
    private void updateText(){
        editor.putString("topLeftTextFav", leftTop.getText().toString());
        editor.putString("topRightTextFav", rightTop.getText().toString());
        editor.putString("midLeftTextFav", leftMid.getText().toString());
        editor.putString("midRightTextFav", rightMid.getText().toString());
        editor.putString("botLeftTextFav", leftBot.getText().toString());
        editor.commit();
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

    public void simpleClick(View view) {
        final Button pressed = (Button) view;
        Intent imagePopUpIntent = new Intent(this, ImagePopUp.class);
        switch (view.getId()) {
            case R.id.topLeftButton:
                imagePopUpIntent.putExtra("str", pressed.getText().toString());
                startActivity(imagePopUpIntent);
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
}

