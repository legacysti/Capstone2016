package teamabraham.cerebral_palsy_communicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class favoritescategory extends AppCompatActivity {

    String faveFood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritescategory);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            faveFood = extras.getString("topCats");
        }
        System.out.print(faveFood);
        //TextView test = (TextView)findViewById(R.id.testText);
        //test.setText(String.valueOf(timesPressed));
    }

}
