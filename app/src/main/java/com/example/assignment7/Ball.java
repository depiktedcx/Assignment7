package com.example.assignment7;

public class Ball extends ScreenObject {

    int nextx;
    int nexty;

    public  Ball( int []speedx_1,int []speedy_1){

        this.speedx =speedx_1;
        this.speedy =speedy_1;

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


    public  void  hit(){

    }


}
