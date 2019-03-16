package pat.hacks.lifemanager;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ScheduleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_view);

        Map<Integer,String[]> task = new HashMap<Integer,String[]>();

        ScheduleData scheduleData = new ScheduleData;

        ListView schedule = (ListView) findViewById(R.id.listView);
        schedule.setAdapter(new CustomAdapter(this));

        TextView yearView = (TextView)findViewById(R.id.yearView);



        Button button1 = (Button) findViewById(R.id.backYearButton);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //yearView.setText(.getYear());
            }
        });

        Button button2 = (Button) findViewById(R.id.forwardYearButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
            }
        });
    }

    class CustomAdapter extends BaseAdapter
    {
        private Context context; //context
        private ArrayList<ClipData.Item> items; //data source of the list adapter

        @Override
        public int getCount()
        {
            return 0;
        }

        @Override
        public Object getItem(int i)
        {
            return null;
        }

        @Override
        public long getItemId(int i)
        {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            // inflate the layout for each list row
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.layout_list_view_row_items, parent, false);
            }

            // get current item to be displayed
            Item currentItem = (Item) getItem(position);

            // get the TextView for item name and item description
            TextView textViewItemName = (TextView) view.findViewById(R.id.text_view_item_name);
            TextView textViewItemDescription = (TextView) view.findViewById(R.id.text_view_item_description);

            //sets the text for item name and item description from the current item object
            textViewItemName.setText(currentItem.getItemName());
            textViewItemDescription.setText(currentItem.getItemDescription());

            // returns the view for the current row
            return convertView;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
