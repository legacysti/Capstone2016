package teamabraham.cerebral_palsy_communicator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ImagePopUp extends Activity {

    private ImageView mDialog;
    TextView tView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_popup_layout);
        Bundle extras = getIntent().getExtras();
        String str = extras.getString("str");


        mDialog = (ImageView)findViewById(R.id.your_image);
        mDialog.setClickable(true);
        tView = (TextView)findViewById(R.id.your_image_text);

        tView.setText(str);

        //finish the activity (dismiss the image dialog) if the user clicks
        //anywhere on the image
        mDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}