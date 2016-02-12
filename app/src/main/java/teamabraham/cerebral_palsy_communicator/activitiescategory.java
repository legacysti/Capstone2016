package teamabraham.cerebral_palsy_communicator;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;


public class activitiescategory extends AppCompatActivity {

    String faveButton = "Listen to Music";

    ArrayList<Integer> valList = new ArrayList<Integer>(6);

    int max = -9999;

    public MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitiescategory);
        valList.add(0);
        valList.add(0);
        valList.add(0);
        valList.add(0);
        valList.add(0);
        valList.add(0);
    }

    @Override
    public void onBackPressed() {

        //TODO make sure that we efficiently clean up activities
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("actCat", faveButton);
        startActivity(i);
    }
    public void simpleClick(View view){
        Intent newActivity = null;
        final Button pressed = (Button)view;
//        for (int i = 0; i < buttons.size(); i++) {
//           if(buttons.get(i) != pressed){
//               buttons.get(i).setEnabled(false);
//           }
//        }

        switch (view.getId()) {
            case R.id.topLeftButton:
                int topLeftVal = valList.get(0);
                topLeftVal += 1;
                valList.set(0, topLeftVal);
                System.out.println("this is the top button:" + faveButton);
                if(topLeftVal > max){
                    max = topLeftVal;
                    faveButton = pressed.getText().toString();
                    break;
                }
                else{
                    break;
                }
            case R.id.topRightButton:
                int topRightVal = valList.get(1);
                topRightVal += 1;
                valList.set(1, topRightVal);
                System.out.println("this is the top button:" + faveButton);
                if(topRightVal > max){
                    max = topRightVal;
                    faveButton = pressed.getText().toString();
                    break;
                }
                else{
                    break;
                }

            case R.id.midLeftButton:
                int midLeftVal = valList.get(2);
                midLeftVal += 1;
                valList.set(2, midLeftVal);
                System.out.println("this is the top button:" + faveButton);
                if(midLeftVal > max){
                    max = midLeftVal;
                    faveButton = pressed.getText().toString();
                    break;
                }
                else{
                    break;
                }
            case R.id.midRightButton:
                int midRightVal = valList.get(3);
                midRightVal += 1;
                valList.set(3, midRightVal);
                System.out.println("this is the top button:" + faveButton);
                if(midRightVal > max){
                    max = midRightVal;
                    faveButton = pressed.getText().toString();
                    break;
                }
                else{
                    break;
                }
            case R.id.botLeftButton:
                int botLeftVal = valList.get(4);
                botLeftVal += 1;
                valList.set(4, botLeftVal);
                System.out.println("this is the top button:" + faveButton);
                if(botLeftVal > max){
                    max = botLeftVal;
                    faveButton = pressed.getText().toString();
                    break;
                }
                else{
                    break;
                }
            case R.id.botRightButton:
                int botRightVal = valList.get(5);
                botRightVal += 1;
                valList.set(5, botRightVal);
                System.out.println("this is the top button:" + faveButton);
                if(botRightVal > max){
                    max = botRightVal;
                    faveButton = pressed.getText().toString();
                    break;
                }
                else{
                    break;
                }
            case R.id.yesButton:
                try {
                    mp.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.yes);
                    mp.setDataSource(getApplicationContext(), clapString);
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {

                }
                break;
            case R.id.noButton:
                try {
                    mp.reset();
                    Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.no);
                    mp.setDataSource(getApplicationContext(), clapString);
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {

                }
                break;
            default:

        }
    }

}
