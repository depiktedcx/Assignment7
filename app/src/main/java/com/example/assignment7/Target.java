package com.example.assignment7;

public class Target extends ScreenObject {

    int constantSpeedX=10;

    public  Target(int x_, int y_){
        super();
        x =x_;
        y=y_;
        sizeX=45;
        sizeY = 45;
        Name= "Target";


    }
    @Override
    public void Move(){

        if(constantSpeedX!=0){
            x+=constantSpeedX;

        }
        else {

            x+=speedx[nextx];
            y+=speedy[nexty];


            if(speedy.length-1 >nexty&&speedy[nexty]!=0){
                nexty++;

            }
            if(speedx.length-1 >nextx&&speedx[nextx]!=0){
                nextx++;

            }
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
        constantSpeedX=constantSpeedX*-1;

    }

}
