package com.aksar.android_pip;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.PictureInPictureParams;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getActionBar();
        button = findViewById(R.id.enter_button);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Display display = getWindowManager().getDefaultDisplay();
                Point point = new Point();

                display.getSize(point);
                int width = point.x;
                int height = point.y;

                Rational rational = new Rational(width, height);
                PictureInPictureParams.Builder pip_Builder = new PictureInPictureParams.Builder();
                pip_Builder.setAspectRatio(rational).build();
                enterPictureInPictureMode(pip_Builder.build());
            }
        });

    }
}
