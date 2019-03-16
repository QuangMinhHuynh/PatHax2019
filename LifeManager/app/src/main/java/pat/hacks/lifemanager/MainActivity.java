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

        editText = (EditText) findViewById(R.id.editText);
        writeToSDFile();

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
                //startActivity(new Intent(MainActivity.this, TasksActivity.class));

                writeToSDFile();
            }
        });


    }

    private void writeToSDFile(){
        File dir = new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/lifemanager");
        dir.mkdirs();
        File file = new File(dir, "hello.txt");

        String text = editText.getText().toString();

        try {
            FileOutputStream f = new FileOutputStream(file);
            f.write(text.getBytes());
            f.flush();
            f.close();
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("FNF", "******* File not found. Did you add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}