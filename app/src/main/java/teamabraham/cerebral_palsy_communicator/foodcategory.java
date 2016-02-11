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

public class foodcategory extends AppCompatActivity {

    Context thisActivity;
    boolean parentalModeEnabled;
    Button leftTop;
    Button rightTop;
    Button leftMid;
    Button rightMid;
    Button leftBot;
    Button rightBot;
    Button yesButton;
    Button noButton;
    Bundle saver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodcategory);
        final ImageButton parentalMode = (ImageButton) findViewById(R.id.parentalModeButton);
        thisActivity = this;
        parentalModeEnabled = false;
        leftTop = (Button)findViewById(R.id.topLeftButton);
        rightTop = (Button) findViewById(R.id.topRightButton);
        leftMid = (Button) findViewById(R.id.midLeftButton);
        rightMid = (Button) findViewById(R.id.midRightButton);
        leftBot = (Button) findViewById(R.id.botLeftButton);
        rightBot = (Button) findViewById(R.id.botRightButton);
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            leftTop.setText(extras.getString("topLeftText"));
            rightTop.setText(extras.getString("topRightText"));
            leftMid.setText(extras.getString("midLeftText"));
            rightMid.setText(extras.getString("midRightText"));
            leftBot.setText(extras.getString("botLeftText"));
            rightBot.setText(extras.getString("botRightText"));
        }

        parentalMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
                if (!parentalModeEnabled) {
                    builder.setTitle("Enter Parental Mode?");
                } else if (parentalModeEnabled) {
                    builder.setTitle("Exit Parental Mode?");
                }

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        parentalModeEnabled = !parentalModeEnabled;
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
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

    public void onHomeClick(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);

        newActivity.putExtra("topLeftText", leftTop.getText().toString());
        newActivity.putExtra("topRightText", rightTop.getText().toString());
        newActivity.putExtra("midLeftText", leftMid.getText().toString());
        newActivity.putExtra("midRightText", rightMid.getText().toString());
        newActivity.putExtra("botLeftText", leftBot.getText().toString());
        newActivity.putExtra("botRightText", rightBot.getText().toString());
        startActivity(newActivity);
    }

    public void simpleClick(View v){
        final Button pressed = (Button) v;

        if(parentalModeEnabled == false) {


        }
        else if(parentalModeEnabled == true){

            final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
            builder.setTitle("Enter new button text:");
            final EditText input = new EditText(thisActivity);
            builder.setView(input);

            builder.setPositiveButton("Change", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    pressed.setText(input.getText().toString());

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
    }
}
