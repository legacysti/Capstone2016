package teamabraham.cerebral_palsy_communicator;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mp = new MediaPlayer();
    Button yesButton;
    Button noButton;
    int timesPressed;
    public ArrayList<Button> buttons = new ArrayList<Button>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            timesPressed = extras.getInt("timesPressed");
        }


        Button leftTop = (Button)findViewById(R.id.topLeftButton);
        buttons.add(leftTop);
        Button rightTop = (Button)findViewById(R.id.topRightButton);
        buttons.add(rightTop);
        Button leftMid = (Button)findViewById(R.id.midLeftButton);
        buttons.add(leftMid);
        Button rightMid = (Button)findViewById(R.id.midRightButton);
        buttons.add(rightMid);
        Button leftBot = (Button)findViewById(R.id.botLeftButton);
        buttons.add(leftBot);
        Button rightBot = (Button)findViewById(R.id.botRightButton);
        buttons.add(rightBot);
        yesButton = (Button)findViewById(R.id.yesButton);
        buttons.add(yesButton);
        noButton = (Button)findViewById(R.id.noButton);
        buttons.add(noButton);

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
        final Button pressed = (Button)view;
//        for (int i = 0; i < buttons.size(); i++) {
//           if(buttons.get(i) != pressed){
//               buttons.get(i).setEnabled(false);
//           }
//        }

        switch (view.getId()) {
            case R.id.topLeftButton:
                newActivity = new Intent(this, foodcategory.class);

                break;
            case R.id.topRightButton:
                newActivity = new Intent(this, activitiescategory.class);
                break;
            case R.id.midLeftButton:
                newActivity = new Intent(this, personalcategory.class);
                break;
            case R.id.midRightButton:
                newActivity = new Intent(this, funcategory.class);
                break;
            case R.id.botLeftButton:
                newActivity = new Intent(this, emotioncategory.class);
                break;
            case R.id.botRightButton:
                newActivity = new Intent(this, favoritescategory.class);
                newActivity.putExtra("timesPressed", timesPressed);
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
//        }
//
//        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                mediaPlayer.reset();
//                for (int i = 0; i < buttons.size(); i++) {
//                    if(buttons.get(i) != pressed){
//                        buttons.get(i).setEnabled(true);
//                    }
//                }
//                if(pressed != yesButton && pressed != noButton) {
//                    pressed.setBackgroundColor(Color.GREEN);
//                }
//            }
//        });
//
//
    }

}
