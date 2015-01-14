package it.smpm.testlcd.app;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by stefanopassador on 24/06/14.
 */
public class GridViewBottomCustomAdapter extends BaseAdapter {
    private Context context;
    private String[] bottomButtons;

    public GridViewBottomCustomAdapter(Context context, String[] bottomButtons) {
        this.context = context;
        this.bottomButtons = bottomButtons;
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
            textView.setText(bottomButtons[position]);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(20);
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return bottomButtons.length;
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
