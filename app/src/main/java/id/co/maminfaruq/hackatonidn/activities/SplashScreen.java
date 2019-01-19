package id.co.maminfaruq.hackatonidn.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import id.co.maminfaruq.hackatonidn.R;

public class SplashScreen extends AppCompatActivity {

    long ms = 0;
    final long splashTime = 3000;
    private Boolean splashActive = true;
    private Boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ProgressBar progressBar = findViewById(R.id.progressBar);

        Thread myThread = new Thread(){
            public void run() {
                try {
                    while (splashActive && ms < splashTime){
                        if (!paused) {
                            ms = ms + 100;
                            sleep(100);
                            progressBar.setProgress((int) ms);
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreen.this,MainActivity.class));
                    finish();
                }
            }
        };
        myThread.start();


    }
}
