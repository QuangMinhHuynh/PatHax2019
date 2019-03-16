package pat.hacks.lifemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.HashMap;


public class DayViewActivity extends AppCompatActivity {
    //TextView dateDisp = findViewById(R.id.dateTop);

    /*
        int height  = Resources.getSystem().getDisplayMetrics().heightPixels;

                long unixTimeSec= System.currentTimeMillis() / 1000L;

                long unixTimeHour = (((unixTimeSec-(3600*4)) /3600)%24);

                long unixTimeMinute = (((unixTimeSec-(3600*4))/60)%1440)%60;


                Log.d("tag",Long.toString(unixTimeMinute));

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);
        TextView text = (TextView) findViewById(R.id.dateTop);


        long unixTimeSec= System.currentTimeMillis() / 1000L;

        long unixTimeDay = (((unixTimeSec-(3600*4)/86400)+5)%8);

        HashMap<Integer, String> daysOfWeek = new HashMap<Integer, String>();

        daysOfWeek.put(1,"Sunday");
        daysOfWeek.put(2,"Monday");
        daysOfWeek.put(3,"Tuesday");
        daysOfWeek.put(4,"Wednesday");
        daysOfWeek.put(5,"Thursday");
        daysOfWeek.put(6,"Friday");
        daysOfWeek.put(7,"Saturday");


        text.setText(Long.toString(unixTimeDay));
        text.setText(daysOfWeek.get(unixTimeDay));

    }
}
