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


    int startx= 400;
    int starty = 500 ;


    int flingx= 0;
    int flingY = 0;

    int ballSize = 40;


    Target Target1;
    Obstacles Obstacles1;
    Obstacles Obstacles2;
    Ball Ball1;

    private void pass_location_to_ScreenObject(int screenX, int screenY){
        Target1= new Target(screenX/2, 35);

        Ball1 =new Ball(screenX/2,screenY/80);
    }

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
        double frictionX = 0;
        double frictionY= 0;

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

                if(Ball1.isTouching((int)e1.getX(), (int)e1.getY())){
                    flingx = (int) velocityX/300;
                    flingY = (int) velocityY/300;
                    frictionX = flingx/10;
                    frictionY = flingY/10;
                }

//                startx = startx+flingx/5;
//                starty = (int) (starty+(flingY/7.5));
                Log.i(TAG_1, "flling~~~~~~~~~~~~~~~~");
                Log.i(TAG_1,"onFling vwlocity x:  "+velocityX);
                Log.i(TAG_1,"onFling vwlocity y:  "+velocityY);

                return true;
            }
        }



        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            //check if ball is in width boundaries
            if(startx + ballSize + (int) flingx >= canvas.getWidth() || startx - ballSize + (int) flingx < 0){
                flingx = -flingx;
            }

            //check if ball is in height boundaries
            if(starty + ballSize + (int) flingY >= canvas.getHeight() || starty - ballSize + (int) flingY < 0){
                flingY = -flingY;
            }

            //move ball on x axis and slow down velocity
            startx = (startx + (int) flingx);
            if(flingx > 0){
                Log.i("XVELOCITY", "subbing friction");
                flingx -= frictionX;
                if(flingx < 0){
                    flingx = 0;
                }
            }else if(flingx < 0){
                Log.i("XVELOCITY", "adding friction");
                flingx += frictionX;
                if(flingx > 0){
                    flingx = 0;
                }
            }

            //move ball on y axis and slow down velocity
            starty = (starty + (int) flingY);
            if(flingY > 0){
                Log.i("YVELOCITY", "subbing friction");
                flingY -= frictionY;
                if(flingY < 0){
                    flingY = 0;
                }
            }else if(flingY < 0){
                Log.i("YVELOCITY", "adding friction");
                flingY += frictionY;
                if (flingY > 0) {
                    flingY = 0;
                }
            }

            //draw the ball
            piant2.setColor(getColor(R.color.colorPrimaryDark));
            canvas.drawCircle(startx, startx, ballSize, piant2);

//            canvas.drawCircle(startx ,starty, 40, piant2);
//            canvas.drawRect(0,500,startx/6,350,piant2);

            invalidate();

        }
    }
}