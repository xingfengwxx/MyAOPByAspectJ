package com.wangxingxing.myaopbyaspectj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.wangxingxing.myaopbyaspectj.annotation.BehaviorTrace;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @BehaviorTrace("摇一摇")
    public void onShake(View view) {
        SystemClock.sleep(500);
    }

    @BehaviorTrace("音频通话")
    public void onAudioMsg(View view) {
        SystemClock.sleep(200);
    }

    @BehaviorTrace("视频通话")
    public void onVideoChat(View view) {
        SystemClock.sleep(300);
    }

    public void onJump(View view) {
        SystemClock.sleep(600);
    }
}