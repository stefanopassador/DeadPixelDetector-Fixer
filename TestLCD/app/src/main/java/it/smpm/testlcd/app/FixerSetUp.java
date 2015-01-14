package it.smpm.testlcd.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.larswerkman.holocolorpicker.*;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.util.DisplayMetrics;

public class FixerSetUp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fixer_setup);
        Button b = (Button) findViewById(R.id.buttonStart);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = 1.0f;
        getWindow().setAttributes(params);

        /*
        Context context = this;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        Point size = new Point();
        int height;
        if (android.os.Build.VERSION.SDK_INT >= 13){
            display.getSize(size);
            height = size.y;}
        else{

            height = display.getHeight();
        }
        */

        TextView textView = (TextView) findViewById(R.id.textViewFixerSetup);

        DisplayMetrics dm = getResources().getDisplayMetrics();

        double density = dm.density * 160;
        double x = Math.pow(dm.widthPixels / density, 2);
        double y = Math.pow(dm.heightPixels / density, 2);
        int screenInches = (int )Math.sqrt(x + y);


        textView.setTextSize(screenInches*5);


        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent launchColor = new Intent(getApplicationContext(), FixerTimer.class);

                startActivity(launchColor);
            }

        });
}




}
