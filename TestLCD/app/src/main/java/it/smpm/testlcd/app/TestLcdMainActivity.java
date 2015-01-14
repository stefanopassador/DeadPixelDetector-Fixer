package it.smpm.testlcd.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.graphics.Color;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.widget.ArrayAdapter;

public class TestLcdMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_test_lcd_main);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = 1.0f;
        getWindow().setAttributes(params);

        final GridView gv = (GridView) findViewById(R.id.gridViewMain);
        gv.setNumColumns(2);
        String[] colors = { this.getString(R.string.color_blue),
                this.getString(R.string.color_yellow), this.getString(R.string.color_red),this.getString(R.string.color_green),
                this.getString(R.string.color_black),
                this.getString(R.string.color_white)
                };

        gv.setAdapter(new GridViewCustomAdapter(this, colors));

        gv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Bundle b = new Bundle();
                if (position <= 5){
                    if (position == 0) {
                        b.putInt("value", Color.BLUE);
                    } else if (position == 1) {
                        b.putInt("value", Color.YELLOW);
                    } else if (position == 2) {
                        b.putInt("value", Color.RED);
                    } else if (position == 3) {
                        b.putInt("value", Color.GREEN);
                    } else if (position == 4) {
                        b.putInt("value", Color.BLACK);
                    } else if (position == 5) {
                        b.putInt("value", Color.WHITE);
                    }
                Intent launchColor = new Intent(getApplicationContext(), ColorActivity.class);
                launchColor.putExtras(b);
                startActivity(launchColor);
                }
            }
        });
    }

    public void onClickOtherColors(View v) {
        Intent launchChooseColor = new Intent(getApplicationContext(), ChooseColorActivity.class);
        startActivity(launchChooseColor);
    }

    public void onClickFixIt(View v) {
        Intent fixIt = new Intent(getApplicationContext(), FixerSetUp.class);
        startActivity(fixIt);
    }

    public void onClickInfo(View v) {
        // Intent info = new Intent(getApplicationContenxt(), Info.class);
        // startActivity(info);

        Intent licence = new Intent(getApplicationContext(), LicenseActivity.class);
        startActivity(licence);
    }
}
