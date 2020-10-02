package com.example.assignment7;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;

public class GameScreanMain extends AppCompatActivity {


    Paint piant2 = new Paint();

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

       // private GestureDetector gestureDetector_1;



        public GraphicsViewGame(Context context) {
            super(context);
            piant2.setColor(getColor(R.color.black_overlay));
           // gestureDetector_1 = new

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(100, 100, 76, piant2);

        }
    }
}