package teamabraham.cerebral_palsy_communicator;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

public class favoritescategory extends AppCompatActivity {

    public MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritescategory);
        int timesPressed = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            timesPressed = extras.getInt("timesPressed");
        }
        //TextView test = (TextView)findViewById(R.id.testText);
        //test.setText(String.valueOf(timesPressed));
    }

    public void simpleClick(View view) {
        Intent newActivity = null;
        if (view.getId() == R.id.attentionButton) {
            final ImageButton pressed = (ImageButton) view;
        } else {
            final Button pressed = (Button) view;
        }

        switch (view.getId()) {
            case R.id.attentionButton:
                try {
                    mp.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.attention);
                    mp.setDataSource(getApplicationContext(), clapString);
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {

                }

            default:
        }
    }
}
