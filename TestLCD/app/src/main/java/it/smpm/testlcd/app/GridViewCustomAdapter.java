package it.smpm.testlcd.app;

/**
 * Created by stefanopassador on 06/06/14.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Display;
import android.graphics.Point;
import android.view.WindowManager;

public class GridViewCustomAdapter extends BaseAdapter {
    private Context context;
    private final String[] colors;

    public GridViewCustomAdapter(Context context, String[] colors) {
        this.context = context;
        this.colors = colors;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.grid_view_item, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(colors[position]);
            textView.setTextColor(Color.TRANSPARENT);

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

            textView.setHeight((height/5));
            textView.setTextSize((float) 16.5);
            String color = colors[position];

            if (color.equals(context.getString(R.string.color_yellow))) {
                textView.setBackgroundColor(Color.YELLOW);
            } else if (color.equals(context.getString(R.string.color_blue))) {
                textView.setBackgroundColor(Color.BLUE);
            } else if (color.equals(context.getString(R.string.color_red))) {
                textView.setBackgroundColor(Color.RED);
            } else if (color.equals(context.getString(R.string.color_green))) {
                textView.setBackgroundColor(Color.GREEN);
            } else if (color.equals(context.getString(R.string.color_black))) {
                textView.setBackgroundColor(Color.BLACK);
            } else if (color.equals(context.getString(R.string.color_white))) {
               textView.setBackgroundColor(Color.WHITE);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
