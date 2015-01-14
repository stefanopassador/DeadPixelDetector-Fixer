package it.smpm.testlcd.app;


        import java.util.TimerTask;
        import java.util.Timer;

        import android.content.Context;
        import android.graphics.Point;
        import android.os.Bundle;
        import android.view.Display;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.*;
        import android.app.Activity;
        import android.graphics.Color;


    public class FixerTimer extends Activity {

        public FixerTimer() {

            // creating timer task, timer
            Timer timer = new Timer();
            MyTimerTask tasknew = new MyTimerTask(0);


            // scheduling the task at fixed rate
            timer.scheduleAtFixedRate(tasknew, 10,100);

        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            setContentView(R.layout.activity_fixer_timer);
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.screenBrightness = 1.0f;
            getWindow().setAttributes(params);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
                getWindow().getDecorView()
                        .setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                        | View.INVISIBLE
                        );
            }


        }
        // this method performs the task
        class MyTimerTask extends TimerTask {
            int i;
            public MyTimerTask(int i){
                this.i = i;
            }
            public void run() {
                FixerTimer.this.runOnUiThread(new Runnable() {
                    public void run() {
                        View v = (View) findViewById(R.id.view1);

                        if (i == 0) {
                            v.setBackgroundColor(Color.parseColor("#0000FF"));
                        } else if (i == 1) {
                            v.setBackgroundColor(Color.parseColor("#FF0000"));
                        } else if (i == 2) {
                            v.setBackgroundColor(Color.parseColor("#00FF00"));
                        }
                        i = i + 1;
                        if (i == 3) {
                            i = 0;
                        }
                        v.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                finish();
                            }
                        });
                    }
                });
            }
        }
    }