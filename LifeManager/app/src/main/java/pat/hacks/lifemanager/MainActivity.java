package pat.hacks.lifemanager;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button dayViewBtn = (Button) findViewById(R.id.dayViewBtn);
        Button weekViewBtn = (Button) findViewById(R.id.weekViewBtn);
        Button monthViewBtn = (Button) findViewById(R.id.monthViewBtn);
        Button scheduleViewBtn = (Button) findViewById(R.id.scheduleViewBtn);
        Button tasksViewBtn = (Button) findViewById(R.id.tasksViewBtn);
        Button addEventBtn = (Button) findViewById(R.id.addEventBtn);

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

        addEventBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddEventActivity.class));

            }
        });


    }
}