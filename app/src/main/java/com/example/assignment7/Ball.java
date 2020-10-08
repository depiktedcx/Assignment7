package com.example.assignment7;

public class Ball extends ScreenObject {



    public  Ball(int x_, int y_){

        x =x_;
        y=y_;

        sizeX=45;
        sizeY=45;

        Name= "Ball";


    }
    @Override
    public void Move(){


          x+=speedx[nextx];
          y+=speedy[nexty];


            if(speedy.length-1 >nexty&&speedy[nexty]!=0){
                nexty++;

            }
        if(speedx.length-1 >nextx&&speedx[nextx]!=0){
            nextx++;

        }

    }

    @Override
    public boolean CaculateSpeed(){
        if (x>-100 &&y>-100){
            return true;
        }
        else{return  false;}

    }

    @Override
    public  void  hit(){

    }

    public  void pass_Speed( int []speedx_1,int []speedy_1)
    {

        this.speedx =speedx_1;
        this.speedy =speedy_1;
    }


}
