package teamabraham.cerebral_palsy_communicator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class favoritescategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritescategory);

    }

    public void onHomeClick(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);
        newActivity.putExtra("id", "favCat");
        startActivity(newActivity);
    }
}
