package com.example.baloon_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
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
        toastView = findViewById(R.id.toastView);
        handler = new Handler();
        random = new Random();
        vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);

        // Start with a random balloon color
       // isBlueBalloon = random.nextBoolean();



        // Start with a random balloon color
        aBoolean = random.nextBoolean();
        updateBalloon();

        imageView.setOnClickListener(view -> {
            if (aBoolean) {
                // Correct color balloon clicked
                burstBalloon();
            } else {
                // Wrong color balloon clicked
                showToast("Wrong color! Try again.");
            }
        });
    }

    private void burstBalloon() {
        vibrator.vibrate(200);
        // Play burst sound here
        // You can use MediaPlayer or SoundPool for sound effects

        showToast("Balloon Burst!");
        imageView.setVisibility(View.INVISIBLE);

        // Delay to allow burst sound to finish
        handler.postDelayed(() -> {
            imageView.setVisibility(View.VISIBLE);
            aBoolean = random.nextBoolean();
            updateBalloon();
        }, 1000); // Adjust the delay as needed
    }

    @SuppressLint("SetTextI18n")
    private void updateBalloon() {
        if (aBoolean) {
            imageView.setImageResource(R.drawable.blue_balloon);
            toastView.setText("Pop the Blue Balloon!");
        } else {
            imageView.setImageResource(R.drawable.red_balloon);
            toastView.setText("Pop the Red Balloon!");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();}
}






