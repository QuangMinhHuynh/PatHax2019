package pat.hacks.lifemanager;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class AddEventActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button datePickerBtn;
    private Button saveBtn;
    private EditText eventTitle;
    private EditText eventNote;
    private DatePickerDialog.OnDateSetListener dateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        datePickerBtn = (Button) findViewById(R.id.datePicker);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        eventTitle = (EditText)findViewById(R.id.titleEdit);
        eventNote = (EditText)findViewById(R.id.noteEdit);

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddEventActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                datePickerBtn.setText(date);
            }
        };

        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                writeToSDFile();
                Toast.makeText(getApplicationContext(), "Saved event.", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void writeToSDFile(){
        File dir = new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/lifemanager");
        dir.mkdirs();
        File file = new File(dir, eventTitle.getText().toString());

        String text = eventNote.getText().toString();

        try {
            FileOutputStream f = new FileOutputStream(file);
            f.write(text.getBytes());
            f.flush();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("FNF", "******* File not found. Did you add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
