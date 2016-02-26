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
    String funCategory = "fun";
    String activeCategory = "go outside";
    String emotionCategory = "Happy";
    String personalCategory = "I'm Okay";
    String foodCategory = "FUFU";
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
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            funCategory = extras.getString("favFun");
            activeCategory = extras.getString("favActivity");
            emotionCategory = extras.getString("favEmotion");
            personalCategory = extras.getString("favPersonal");
            foodCategory = extras.getString("favFood");
        }
        assignButtons();
        setText();


    }
    public void onHomeClick(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);
        updateText();
        newActivity.putExtra("id", "favCat");
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
        leftTop.setText(foodCategory);
        rightTop.setText(activeCategory);
        leftMid.setText(personalCategory);
        rightMid.setText(funCategory);
        leftBot.setText(emotionCategory);
    }
    private void updateText(){
        editor.putString("topLeftTextFav", foodCategory);
        editor.putString("topRightTextFav", activeCategory);
        editor.putString("midLeftTextFav", personalCategory);
        editor.putString("midRightTextFav", emotionCategory);
        editor.putString("botLeftTextFav", funCategory);
//        editor.putString("botRightTextFav", rightBot.getText().toString());
        editor.commit();
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

