package teamabraham.cerebral_palsy_communicator;

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
    public ArrayList<Button> buttons = new ArrayList<Button>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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

        leftTop.setBackgroundColor(Color.GREEN);
        rightTop.setBackgroundColor(Color.GREEN);
        leftMid.setBackgroundColor(Color.GREEN);
        rightMid.setBackgroundColor(Color.GREEN);
        leftBot.setBackgroundColor(Color.GREEN);
        rightBot.setBackgroundColor(Color.GREEN);
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

        final Button pressed = (Button)view;
        for (int i = 0; i < buttons.size(); i++) {
           if(buttons.get(i) != pressed){
               buttons.get(i).setEnabled(false);
           }
        }

        if(!mp.isPlaying()) {
            if(pressed != yesButton && pressed != noButton) {
                pressed.setBackgroundColor(Color.RED);
            }
            switch (view.getId()) {
                case R.id.topLeftButton:
                    try {
                        mp.reset();
                        Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.clap);
                        mp.setDataSource(getApplicationContext(), clapString);
                        mp.prepare();
                        mp.start();
                    } catch (IOException e) {

                    }
                    break;
                case R.id.topRightButton:
                    try {
                        mp.reset();
                        Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tada);
                        mp.setDataSource(getApplicationContext(), clapString);
                        mp.prepare();
                        mp.start();
                    } catch (IOException e) {

                    }
                    break;
                case R.id.midLeftButton:
                    try {
                        mp.reset();
                        Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.car);
                        mp.setDataSource(getApplicationContext(), clapString);
                        mp.prepare();
                        mp.start();
                    } catch (IOException e) {

                    }
                    break;
                case R.id.midRightButton:
                    try {
                        mp.reset();
                        Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.meeseeks);
                        mp.setDataSource(getApplicationContext(), clapString);
                        mp.prepare();
                        mp.start();
                    } catch (IOException e) {

                    }
                    break;
                case R.id.botLeftButton:
                    try {
                        mp.reset();
                        Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pizza);
                        mp.setDataSource(getApplicationContext(), clapString);
                        mp.prepare();
                        mp.start();
                    } catch (IOException e) {

                    }
                    break;
                case R.id.botRightButton:
                    try {
                        mp.reset();
                        Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.caught);
                        mp.setDataSource(getApplicationContext(), clapString);
                        mp.prepare();
                        mp.start();
                    } catch (IOException e) {

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
        }

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
                for (int i = 0; i < buttons.size(); i++) {
                    if(buttons.get(i) != pressed){
                        buttons.get(i).setEnabled(true);
                    }
                }
                if(pressed != yesButton && pressed != noButton) {
                    pressed.setBackgroundColor(Color.GREEN);
                }
            }
        });


    }

}
