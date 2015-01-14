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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Gravity;

public class ChooseColorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose_color);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = 1.0f;
        getWindow().setAttributes(params);


        Button b = (Button) findViewById(R.id.buttonChooseColor);
        ColorPicker picker = (ColorPicker) findViewById(R.id.picker);

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


        RelativeLayout r = (RelativeLayout) findViewById(R.id.layoutColorPicker);
        r.setPadding(0,(height/6)-25,0,0);



        picker.setShowOldCenterColor(false);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPicker picker = (ColorPicker) findViewById(R.id.picker);
                picker.setShowOldCenterColor(false);
//To get the color
                int color = picker.getColor();

//To set the old selected color u can do it like this
//                picker.setOldCenterColor(picker.getColor());
// adds listener to the colorpicker which is implemented
//in the activity
//                picker.setOnColorChangedListener(this);

//to turn of showing the old color
//                picker.setShowOldCenterColor(false);

//adding onChangeListeners to bars
                Bundle bundle = new Bundle();
                bundle.putInt("value", color);
                Intent launchColor = new Intent(getApplicationContext(), ColorActivity.class);
                launchColor.putExtras(bundle);
                startActivity(launchColor);
            }

    });
    }
}
