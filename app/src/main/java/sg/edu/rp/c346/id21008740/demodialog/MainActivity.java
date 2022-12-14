package sg.edu.rp.c346.id21008740.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, Ex3, Demo4, Demo5;
    TextView TVDemo2, TVDemo3, TVEx3, TvDemo4, TvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TVDemo2= findViewById(R.id.textViewDemo2);
        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.btnDemio2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        TVDemo3 = findViewById(R.id.tvDemo3);
        Ex3 = findViewById(R.id.Exercise3);
        TVEx3 = findViewById(R.id.tvEx3);
        Demo4 = findViewById(R.id.Demo4);
        TvDemo4 = findViewById(R.id.DEMO4);
        Demo5 = findViewById(R.id.Demo5);
        TvDemo5 = findViewById(R.id.TvDemo5);
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Congraduation");
                myBuilder.setMessage("you have completed a simple dialog Box.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog ");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TVDemo2.setText("You have selected Positive.");

                    }
                });
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TVDemo2.setText("You have selected Negative ");
                    }
                });myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                final EditText etInput = viewDialog.findViewById(R.id.editTextinput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = etInput.getText().toString();
                        TVDemo3.setText(message);
                    }
                });myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

                Ex3.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        LayoutInflater inflater =
                                (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View viewDialog = inflater.inflate(R.layout.ex3, null);
                        final EditText etInput = viewDialog.findViewById(R.id.etInputNum);
                        final EditText etInput2 = viewDialog.findViewById(R.id.etInputNum2);

                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                        myBuilder.setView(viewDialog);
                        myBuilder.setTitle("Exercise3");
                        myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int message = Integer.valueOf(etInput.getText().toString());
                                int message2 = Integer.valueOf(etInput2.getText().toString());
                                int sum = message + message2;

                                TVEx3.setText("The sum is " + String.valueOf(sum));

            }
                });
                        myBuilder.setNeutralButton("Cancel", null);
                        AlertDialog myDialog = myBuilder.create();
                        myDialog.show();

            }
        });
                Demo4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create the Listener to set the date
                        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                TvDemo4.setText("Date: " + dayOfMonth + "/" +year);
                            }
                        };
                        Calendar now = Calendar.getInstance();
                        int year = now.get(Calendar.YEAR);
                        int month = now.get(Calendar.MONTH);
                        int day = now.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                                myDateListener, 2014, 11, 31);
                        myDateDialog.show();
                    }
                });
                Demo5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                TvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                            }
                        };
                        TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                                myTimeListener, 20, 00, true);
                        myTimeDialog.show();
                    }
                });
    }
}