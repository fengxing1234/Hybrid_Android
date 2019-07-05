package com.zhyen.hybrid_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;
import io.flutter.view.FlutterView;

public class FlutterMainActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, FlutterMainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flutter_main);
        final FlutterView flutterView = Flutter.createView(
                this,
                getLifecycle(),
                "route1"
        );

        final FrameLayout layout = findViewById(R.id.flutter_container);
        layout.addView(flutterView);
        final FlutterView.FirstFrameListener[] listeners = new FlutterView.FirstFrameListener[1];
        listeners[0] = new FlutterView.FirstFrameListener() {
            @Override
            public void onFirstFrame() {
                layout.setVisibility(View.VISIBLE);
            }
        };
        flutterView.addFirstFrameListener(listeners[0]);

    }
}
