package com.example.baloon_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView,imageView2,imageView3,imageView4;
    private TextView toastView;
     boolean aBoolean;
    private Handler handler;
    private Random random;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        toastView = findViewById(R.id.toastView);
        handler = new Handler();
        random = new Random();
        vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);





        // Start with a random balloon color
        aBoolean = random.nextBoolean();






        imageView.setOnClickListener(view -> {
            if (aBoolean) {

                burstBalloon(imageView);
            } else {

                showToast("Wrong color! Try again.");
                burstBalloon(imageView);


            }

        });
        updateBalloon(imageView);

        imageView2.setOnClickListener(view -> {
            if (aBoolean) {

                burstBalloon(imageView2);
            } else {

                showToast("Wrong color! Try again.");
                burstBalloon(imageView2);

            }
        });
        updateBalloon(imageView2);

        imageView3.setOnClickListener(view -> {
            if (aBoolean) {

                burstBalloon(imageView3);
            } else {

                showToast("Wrong color! Try again.");
                burstBalloon(imageView3);
            }
        });
        updateBalloon(imageView3);


        imageView4.setOnClickListener(view -> {
            if (aBoolean) {

                burstBalloon(imageView4);
            } else {

                showToast("Wrong color! Try again.");
                burstBalloon(imageView4);

            }
        });
        updateBalloon(imageView4);
    }


    private void burstBalloon(ImageView img) {
        vibrator.vibrate(200);


        showToast("Balloon Burst!");
        img.setVisibility(View.INVISIBLE);

        Animation move= AnimationUtils.loadAnimation(this,R.anim.translate_anim);

        img.startAnimation(move);



        // Delay to allow burst sound to finish
        handler.postDelayed(() -> {
            img.setVisibility(View.VISIBLE);

            aBoolean = random.nextBoolean();
            updateBalloon(img);
        },1000);
    }

    @SuppressLint("SetTextI18n")
    private void updateBalloon(ImageView img1) {
        if (aBoolean) {
            img1.setImageResource(R.drawable.blue_balloon);
            toastView.setText("Pop the Blue Balloon!");

        } else {
            img1.setImageResource(R.drawable.red_balloon);
            toastView.setText("Pop the Red Balloon!");

        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();}
}






