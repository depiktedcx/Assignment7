package com.example.assignment7;

public class Ball extends ScreenObject {

    int next;

    public  Ball( int []speedx_1,int []speedy_1){

        this.speedx =speedx_1;
        this.speedy =speedy_1;


    }
    @Override
    public void Move(){

        if (speedx[next]!= 0) {

            sizeX += speedx[next];
            sizeY += speedy[next];
            next++;

        }





    }

    @Override
    public boolean CaculateSpeed(){
        if (speedx[next]!= 0){
            return true;
        }
        else{return  false;}

    }


    public  void  hit(){

    }


}
