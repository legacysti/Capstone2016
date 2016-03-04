package teamabraham.cerebral_palsy_communicator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.util.Random;

/**
 * Created by rysonasuncion on 2/25/16.
 */
public class stamperactivity extends Activity{

    RelativeLayout layout;
    int drawingMode = MotionEvent.ACTION_DOWN;
    int drawCount = 0;
    final int MAX_STAMP_SIZE = 200;
    View [] viewArr = new View[MAX_STAMP_SIZE];
    MediaPlayer mp = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stamper_activity);
        layout=(RelativeLayout)findViewById(R.id.stampingLayout);
        final Random randy = new Random();
        layout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent e) {
                if (v == layout){
                    float x = e.getX();
                    float y = e.getY();
                    if (e.getAction() == drawingMode && y < 650){
                        int randInt = randy.nextInt(4);
                        layout = (RelativeLayout) v;
                        if (drawCount == MAX_STAMP_SIZE){
                            drawCount = 0;
                        }
                        switch (randInt){
                            case 0:
                                viewArr[drawCount] = new CircleView(stamperactivity.this, x, y, 25);
                                Log.d("viewArr", "added circle at index " + drawCount);
                                break;
                            case 1:
                                viewArr[drawCount] = new SquareView(stamperactivity.this, x, y);
                                Log.d("viewArr", "added square at index " + drawCount);
                                break;
                            case 2:
                                viewArr[drawCount] = new TriangleView(stamperactivity.this, x, y);
                                Log.d("viewArr", "added triangle at index " + drawCount);
                                break;
                            case 3:
                                viewArr[drawCount] = new StarView(stamperactivity.this, x, y);
                                Log.d("viewArr", "added star at index " + drawCount);
                                break;
                            default:
                                break;
                        }
                        layout.removeAllViews();
                        for (int i=0; i<MAX_STAMP_SIZE; i++){
                            if (viewArr[i] != null) {
                                layout.addView(viewArr[i]);
                            }
                        }
                        drawCount++;
                    }
                }
                return true;
            }
        });
    }


    public class CircleView extends View {
        private final float x;
        private final float y;
        private final int r;
        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


        public CircleView(Context context, float x, float y, int r) {
            super(context);
            mPaint.setColor(genRandHexColor());
            this.x = x;
            this.y = y;
            this.r = r;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(x, y, r, mPaint);
        }
    }



    public class SquareView extends View {
        private final float x;
        private final float y;
        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


        public SquareView(Context context, float x, float y) {
            super(context);
            mPaint.setColor(genRandHexColor());
            this.x = x;
            this.y = y;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(x - 25, y - 25, x + 25, y + 25, mPaint);
        }
    }



    public class TriangleView extends View {
        private final float x;
        private final float y;
        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Path path;


        public TriangleView(Context context, float x, float y) {
            super(context);
            mPaint.setColor(genRandHexColor());
            mPaint.setStrokeWidth(4);
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.x = x;
            this.y = y;

            Point a = new Point((int)this.x-25, (int)this.y+22);
            Point b = new Point((int)this.x+25, (int)this.y+22);
            Point c = new Point((int)this.x, (int)this.y-22);


            path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.moveTo(b.x, b.y);
            path.lineTo(c.x, c.y);
            path.lineTo(a.x, a.y);
            path.close();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawPath(path, mPaint);
        }
    }



    public class StarView extends View {
        private final float x;
        private final float y;
        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Path path;


        public StarView(Context context, float x, float y) {
            super(context);
            mPaint.setColor(genRandHexColor());
            mPaint.setStrokeWidth(4);
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.x = x;
            this.y = y;

            Point a = new Point((int)this.x, (int)this.y-22);
            Point b = new Point((int)this.x+10, (int)this.y-5);
            Point c = new Point((int)this.x+25, (int)this.y-5);
            Point d = new Point((int)this.x+10, (int)this.y+5);
            Point e = new Point((int)this.x+15, (int)this.y+22);
            Point f = new Point((int)this.x, (int)this.y+15);
            Point g = new Point((int)this.x-15, (int)this.y+22);
            Point h = new Point((int)this.x-10, (int)this.y+5);
            Point i = new Point((int)this.x-25, (int)this.y-5);
            Point j = new Point((int)this.x-10, (int)this.y-5);

            path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.moveTo(a.x, a.y);
            path.lineTo(b.x, b.y);
            path.lineTo(c.x, c.y);
            path.lineTo(d.x, d.y);
            path.lineTo(e.x, e.y);
            path.lineTo(f.x, f.y);
            path.lineTo(g.x, g.y);
            path.lineTo(h.x, h.y);
            path.lineTo(i.x, i.y);
            path.lineTo(j.x, j.y);
            path.close();
        }



        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawPath(path, mPaint);
        }
    }



    protected int genRandHexColor(){
        Random random = new Random();
        return random.nextInt(0x01000000) + 0xFF000000;
    }



    public void onHomeClick(View v) {
        Intent newActivity = new Intent(this, MainActivity.class);
        startActivity(newActivity);
    }

    public void attentionClick(View v){
        try {
            mp.reset();
            Uri clapString = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.attention);
            mp.setDataSource(getApplicationContext(), clapString);
            mp.prepare();
            mp.start();
        } catch (IOException e) {

        }
    }

    public void simpleClick(View v){
        switch (v.getId()) {
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
                break;
        }
    }

}
