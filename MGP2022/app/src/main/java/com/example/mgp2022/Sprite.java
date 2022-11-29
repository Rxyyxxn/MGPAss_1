package com.example.mgp2022;

import android.graphics.Bitmap;

// For spriteAnimation
public class Sprite {
    private int row =0;
    private int col=0;
    private int width=0;
    private int height=0;

    private Bitmap bmp=null;

    private int currentFrame = 0;
    private int startFrame=0;
    private int endFrame=0;

    private float timePerFrame = 0.0f;
    private float timeAcc=0.0f;

    public Sprite(Bitmap _bmp,int _row,int _col,int _fps)
    {
        //fps= speed if animation
        bmp=_bmp;
        row=_row;
        col=_col;

        width=bmp.getWidth()/_col;
        height=bmp.getHeight()/_row; //Find equal width and height for every frame for sprite image

        timePerFrame=1.0f/(float) _fps;

        endFrame= _col * _row;
    }
}
