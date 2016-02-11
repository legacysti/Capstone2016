package teamabraham.cerebral_palsy_communicator;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;

public class emotioncategory extends AppCompatActivity {

    public MediaPlayer mp = new MediaPlayer();
    int timesPressed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotioncategory);
    }

    @Override
    public void onBackPressed() {
        //TODO make sure that we efficiently clean up activities
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("timesPressed", timesPressed);
        startActivity(i);
    }
    public void simpleClick(View view){

        timesPressed += 1;

        if(view.getId() == R.id.attentionButton) {
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
