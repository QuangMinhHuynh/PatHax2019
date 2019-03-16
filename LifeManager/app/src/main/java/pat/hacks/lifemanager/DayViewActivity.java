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

        TimeFormated count = new TimeFormated();

        text.setText(count.getMonth()+" "+count.getDate()+" "+count.getYear()+" "+count.getTimeHour());


    }
}
