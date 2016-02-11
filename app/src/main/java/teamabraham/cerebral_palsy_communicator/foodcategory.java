package teamabraham.cerebral_palsy_communicator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class foodcategory extends AppCompatActivity {

    boolean parentalModeActive = false;
    private Button button;
    private TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodcategory);
    }

    public void simpleClick(View view){
        if (parentalModeActive == true)
        {
            switch (view.getId())
            {
                case R.id.topLeftButton:
                    button = (Button) findViewById(R.id.topLeftButton);
                    resultText = (TextView) findViewById(R.id.text);
                    break;
                case R.id.topRightButton:
                    button = (Button) findViewById(R.id.topRightButton);
                    resultText = (TextView) findViewById(R.id.text);
                    break;
                case R.id.midLeftButton:
                    button = (Button) findViewById(R.id.midLeftButton);
                    resultText = (TextView) findViewById(R.id.text);
                    break;
                case R.id.midRightButton:
                    button = (Button) findViewById(R.id.midRightButton);
                    resultText = (TextView) findViewById(R.id.text);
                    break;
                case R.id.botLeftButton:
                    button = (Button) findViewById(R.id.botLeftButton);
                    resultText = (TextView) findViewById(R.id.text);
                    break;
                case R.id.botRightButton:
                    button = (Button) findViewById(R.id.botRightButton);
                    resultText = (TextView) findViewById(R.id.text);
                    break;
            }



//            LayoutInflater li = LayoutInflater.from(this);

//            View promptsView = li.inflate(R.layout.prompts, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            final EditText input = (EditText) this
                    .findViewById(R.id.editTextDialogUserInput);

            builder.setView(R.id.layout_root);

            // setup a dialog window
            builder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // get user input and set it to result
                                    // edit text
                                    resultText.setText(input.getText());
                                }
                            })

                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
             // create an alert dialog
            AlertDialog alert = builder.create();
            alert.show();
        }
    }


    public void parentalModeOnClick(View v) {
        if (parentalModeActive == false) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Would you like to activate parental mode?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            parentalModeActive = true;
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        } else {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setMessage("Would you like to deactivate parental mode?");
            builder2.setCancelable(true);

            builder2.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            parentalModeActive = false;
                            dialog.cancel();
                        }
                    });

            builder2.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder2.create();
            alert11.show();

        }

    }
}

