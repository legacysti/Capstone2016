package teamabraham.cerebral_palsy_communicator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class emotioncategory extends AppCompatActivity {

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
    public void simpleClick(View v){
        timesPressed += 1;
    }

}
