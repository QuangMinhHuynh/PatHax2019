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


        Button dayViewBtn = findViewById(R.id.dayViewBtn);
        Button weekViewBtn = findViewById(R.id.weekViewBtn);
        Button monthViewBtn = findViewById(R.id.monthViewBtn);
        Button scheduleViewBtn = findViewById(R.id.scheduleViewBtn);
        Button tasksViewBtn = findViewById(R.id.tasksViewBtn);

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
