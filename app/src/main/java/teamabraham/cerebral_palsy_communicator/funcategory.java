package teamabraham.cerebral_palsy_communicator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class funcategory extends AppCompatActivity {

    String video;
    Intent newActivity;
    ImageButton parentalMode;
    boolean parentalModeEnabled;
    Button leftTop;
    Button rightTop;
    Button leftMid;
    Button rightMid;
    Button leftBot;
    Button rightBot;
    Button yesButton;
    Button noButton;
    String MY_PREFS_NAME = "storage";
    SharedPreferences.Editor editor;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcategory);
        video = "";
        newActivity = null;
        final Context thisActivity = this;
        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = pref.edit();
        leftTop = (Button)findViewById(R.id.topLeftButton);
        rightTop = (Button) findViewById(R.id.topRightButton);
        leftMid = (Button) findViewById(R.id.midLeftButton);
        rightMid = (Button) findViewById(R.id.midRightButton);
        leftBot = (Button) findViewById(R.id.botLeftButton);
        rightBot = (Button) findViewById(R.id.botRightButton);
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);
        parentalMode = (ImageButton) findViewById(R.id.parentalModeButton);
        newActivity = new Intent(this, youtubeactivity.class);
        parentalModeEnabled = false;
        Bundle extras = getIntent().getExtras();

        leftTop.setText(pref.getString("topLeftTextFun", leftTop.getText().toString()));
        rightTop.setText(pref.getString("topRightTextFun", rightTop.getText().toString()));
        leftMid.setText(pref.getString("midLeftTextFun", leftMid.getText().toString()));
        rightMid.setText(pref.getString("midRightTextFun", rightMid.getText().toString()));
        leftBot.setText(pref.getString("botLeftTextFun", leftBot.getText().toString()));
        rightBot.setText(pref.getString("botRightTextFun", rightBot.getText().toString()));

        parentalMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
                builder.setTitle("Enter URL Key:");

                final EditText input = new EditText(thisActivity);

                builder.setView(input);

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        video = input.getText().toString();

                        if(newActivity != null) {
                            newActivity.putExtra("url", video);
                            startActivity(newActivity);
                        }
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

    public void onHomeClickFun(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);
        editor.putString("topLeftTextFun", leftTop.getText().toString());
        editor.putString("topRightTextFun", rightTop.getText().toString());
        editor.putString("midLeftTextFun", leftMid.getText().toString());
        editor.putString("midRightTextFun", rightMid.getText().toString());
        editor.putString("botLeftTextFun", leftBot.getText().toString());
        editor.putString("botRightTextFun", rightBot.getText().toString());
        editor.commit();
        newActivity.putExtra("id", "funCat");
        startActivity(newActivity);
    }

    public void simpleClick(View v){

        switch(v.getId()){
            case R.id.topLeftButton:
                newActivity = new Intent(this, youtubeactivity.class);
                startActivity(newActivity);


            break;
        }

    }

}
