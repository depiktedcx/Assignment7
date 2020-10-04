package com.example.assignment7;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class GameScreanMain extends AppCompatActivity {


    Paint piant2 = new Paint();

    String TAG_1="TAG_Flling" ;


    int startx=0;
    int starty =0 ;


    int flingx= 0;
    int flingY = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screan);



        ActionBar actionbar1 = getSupportActionBar();
        actionbar1.hide();


        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);






        GraphicsViewGame graphicsView_1 = new GraphicsViewGame(this);
        ConstraintLayout constraintLayout = findViewById(R.id.gamepage);
        constraintLayout.addView(graphicsView_1);

    }


    public class GraphicsViewGame extends View{

       private GestureDetector gestureDetector_1;



        public GraphicsViewGame(Context context) {
            super(context);
            piant2.setColor(getColor(R.color.black_overlay));
            gestureDetector_1 = new GestureDetector(context,new MyGestureListener());

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            if(gestureDetector_1.onTouchEvent(event)){
                return true;

            }
            return super.onTouchEvent(event);
        }


        class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
            @Override
            public boolean onDown(MotionEvent e) {
                Log.i(TAG_1, "onDOWN");
                return true;
            }
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2,
                                   float velocityX, float velocityY) {

                flingx = (int) velocityX;
                flingY = (int) velocityY;


                startx = startx+flingx/5;

                starty = (int) (starty+(flingY/7.5));


                Log.i(TAG_1, "flling~~~~~~~~~~~~~~~~");
                Log.i(TAG_1,"onFling vwlocity x:  "+velocityX);
                Log.i(TAG_1,"onFling vwlocity y:  "+velocityY);

                return true;
            }
        }



        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            if (startx == 0){
                startx =canvas.getWidth()/2;
                starty= canvas.getHeight()-100;

                Log.i(TAG_1,"screensize x:  "+startx);
                Log.i(TAG_1,"screensize y:  "+starty);

            }




            canvas.drawCircle(startx ,starty, 40, piant2);

            invalidate();

        }
    }
}