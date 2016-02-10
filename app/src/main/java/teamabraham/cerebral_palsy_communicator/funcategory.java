package teamabraham.cerebral_palsy_communicator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class funcategory extends AppCompatActivity {

    String videoList;
    Intent newActivity;
    ImageButton parentalMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcategory);
        videoList = "";
        newActivity = null;
        final Context thisActivity = this;

        parentalMode = (ImageButton) findViewById(R.id.parentalModeButton);
        parentalMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
                builder.setTitle("Enter Keyword to search for");

                final EditText input = new EditText(thisActivity);
                final TextView list = new TextView(thisActivity);

                builder.setView(input);

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*
                        videoList = input.getText().toString();
                        list.setText(videoList);
                        builder.setView(list);

                        if(newActivity != null) {
                            startActivity(newActivity);
                        }
                        */

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
                return true;
            }
        });
    }

    public void simpleClick(View v){

        switch(v.getId()){
            case R.id.topLeftButton:
                newActivity = new Intent(this, youtubeactivity.class);



            break;
        }

    }

}
