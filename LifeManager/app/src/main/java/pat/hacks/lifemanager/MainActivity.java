package pat.hacks.lifemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button dayViewBtn = (Button) findViewById(R.id.dayViewBtn);
        Button weekViewBtn = (Button) findViewById(R.id.weekViewBtn);
        Button monthViewBtn = (Button) findViewById(R.id.monthViewBtn);
        Button scheduleViewBtn = (Button) findViewById(R.id.scheduleViewBtn);
        Button tasksViewBtn = (Button) findViewById(R.id.tasksViewBtn);

        dayViewBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DayViewActivity.class));
            }
        });

        weekViewBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WeekViewActivity.class));
            }
        });

        monthViewBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MonthViewActivity.class));
            }
        });

        scheduleViewBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScheduleViewActivity.class));
            }
        });

        tasksViewBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TasksActivity.class));
            }
        });
    }
}
