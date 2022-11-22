package com.example.mgp2022;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;

// Created by TanSiewLan2021

public class Settings extends Activity implements OnClickListener, StateBase {  //Using StateBase class

    //Define buttons
    private Button btn_start;
    private Button btn_back;
    SeekBar seekbar_vol;
    AudioManager audiomanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide Title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide Top Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.settings);

        btn_start = (Button)findViewById(R.id.btn_retry);
        btn_start.setOnClickListener(this); //Set Listener to this button --> Start Button

        btn_back = (Button)findViewById(R.id.btn_quit);
        btn_back.setOnClickListener(this); //Set Listener to this button --> Back Button

        seekbar_vol=findViewById(R.id.seekbar_vol);
        audiomanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        //get max volume
        int maxvolume = audiomanager.getStreamMaxVolume(audiomanager.STREAM_MUSIC);

        //get current volume
        int curvolume = audiomanager.getStreamVolume(audiomanager.STREAM_MUSIC);

        seekbar_vol.setMax(maxvolume);
        seekbar_vol.setProgress(curvolume);
        seekbar_vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromuser) {
                audiomanager.setStreamVolume(audiomanager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        StateManager.Instance.AddState(new Settings());
    }

    @Override
    //Invoke a callback event in the view
    public void onClick(View v)
    {
        // Intent = action to be performed.
        // Intent is an object provides runtime binding.
        // new instance of this object intent

        Intent intent = new Intent();

        if (v == btn_start)
        {
            // intent --> to set to another class which another page or screen that we are launching.
            intent.setClass(this, GamePage.class);
            StateManager.Instance.ChangeState("MainGame"); // Default is like a loading page

        }

        else if (v == btn_back)
        {
            intent.setClass(this, Mainmenu.class);
        }
        startActivity(intent);

    }

    @Override
    public void Render(Canvas _canvas) {
    }

    @Override
    public void OnEnter(SurfaceView _view) {
    }

    @Override
    public void OnExit() {
    }

    @Override
    public void Update(float _dt) {
    }

    @Override
    public String GetName() {
        return "Mainmenu";
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}