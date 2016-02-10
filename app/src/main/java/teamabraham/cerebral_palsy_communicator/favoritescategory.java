package teamabraham.cerebral_palsy_communicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class favoritescategory extends AppCompatActivity {

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
}
