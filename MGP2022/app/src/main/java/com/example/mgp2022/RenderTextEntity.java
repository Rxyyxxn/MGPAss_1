package com.example.mgp2022;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.SurfaceView;

// https://developer.android.com/reference/android/graphics/Paint

//C:\Rayyaan_NYP\Year2Sem2\Mobile phone programming\MGPAss_1\MGP2022\app\src\main\assets
// Above is my drive for my project
// Under main, create a folder assets then inside there create another folder fonts. Place the font type inside there.

public class RenderTextEntity implements EntityBase{

    private Bitmap bmp = null;
    private boolean isDone=false;
    private boolean inInit=false;

    int framecount;
    long lastTime = 0;
    long lastFPSTime = 0;
    float fps = 0;

    //Paint object
    Paint paint = new Paint();
    private int red=0, green=0, blue=0;

    //Define how to use my own font type
    Typeface myfont;

    public boolean IsDone(){
        return isDone;
    }

    public void SetIsDone(boolean _isDone){
        isDone = _isDone;
    }

    public void Init(SurfaceView _view){
        // Use my own fonts
        // myfont=Typeface.createFromAsset(_view.getContext().getAssets(), "assets/font.ttf");

        //Defult font
        myfont=Typeface.create(Typeface.SERIF,Typeface.BOLD);
        inInit=true;
    };
    public void Update(float _dt){
        //get fps
        long currenttime = System.currentTimeMillis();
        long lastTime = currenttime;
        if (currenttime - lastFPSTime > 1000) {
            fps = (framecount * 1000) / (currenttime - lastFPSTime);
            lastFPSTime = currenttime;
            framecount = 0;
        }
        framecount++;

    };
    public void Render(Canvas _canvas)
    {
        Paint paint=new Paint();
        //text color alpha,red,green,blue
        paint.setARGB(255,red,green,blue);
        paint.setStrokeWidth(200);
        //use your own font
        paint.setTypeface(myfont);
        paint.setTextSize(70);
        _canvas.drawText("FPS: "+fps,30,80,paint);
    };


    public boolean IsInit()
    {

        return bmp != null;
    }

    public int GetRenderLayer()
    {
        return LayerConstants.BACKGROUND_LAYER;
    }

    public void SetRenderLayer(int _newLayer)
    {
        return;
    }

    public ENTITY_TYPE GetEntityType(){
        return ENTITY_TYPE.ENT_DEFAULT;
    }

    public static RenderTextEntity Create(){
        RenderTextEntity result = new RenderTextEntity();
        EntityManager.Instance.AddEntity(result, ENTITY_TYPE.ENT_TEXT);
        return result;
    }


}
