package com.shakilkhan.userinterfafcebasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox checkBoxHarry, checkBoxJocker, checkBoxTheMatrix;
    private RadioGroup radioGroupMaritalStatus;
    private ProgressBar prgeressBar;
    private ListView citiesList;
    private Spinner studentSpinner;


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_first:
                Toast.makeText(this, "Button First clicked!", Toast.LENGTH_SHORT).show();
                TextView helloText = findViewById(R.id.helloText);
                helloText.setText("Hello Wolrld\nChanged to:\nI am new Text!");
                break;
            case R.id.button_second:
                EditText editTextName = findViewById(R.id.editTextName);
                TextView helloTexts = findViewById(R.id.helloText);
                helloTexts.setText(editTextName.getText().toString());
                editTextName.setText("");
                Toast.makeText(this, "Button Second Clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        start code here.........

        studentSpinner = findViewById(R.id.studentSpinner);
        ArrayList<String> student = new ArrayList<>();
        student.add("shakil khan");
        student.add("Khalid Hossain");
        student.add("Tanvir Hossain");
        student.add("Siam Khan");

        ArrayAdapter<String> studentAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                student
        );
        studentSpinner.setAdapter(studentAdapter);

        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, student.get(i) + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        citiesList = findViewById(R.id.listView);

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Faridpur");
        cities.add("Moskow");
        cities.add("Shanhai");
        cities.add("Dhaka");
        cities.add("Beijing");
        cities.add("New York");


        ArrayAdapter<String> citiesAdapter =new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                cities
        );

        citiesList.setAdapter(citiesAdapter);

        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,cities.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        checkBoxHarry = findViewById(R.id.checkboxHarryPoter);
        checkBoxJocker = findViewById(R.id.checkboxJocker);
        checkBoxTheMatrix = findViewById(R.id.checkboxTheMatrix);

        prgeressBar = findViewById(R.id.progress_horizontal);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    prgeressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();


        radioGroupMaritalStatus = findViewById(R.id.radioGroupMaritalStatus);
        radioGroupMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioBtnMarrid:
                        Toast.makeText(MainActivity.this, "Marrid", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBtnSingle:
                        Toast.makeText(MainActivity.this, "single", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBtnRelationship:
                        Toast.makeText(MainActivity.this, "In a relationship", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });


        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(MainActivity.this, checkBoxHarry.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "U have to watched harry poter", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnnHello = findViewById(R.id.button_first);
        btnnHello.setOnClickListener(this);

        Button btnSecond = findViewById(R.id.button_second);
        btnSecond.setOnClickListener(this);

        Button btnSeconds = findViewById(R.id.button_second);
        btnSeconds.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Long Press Detected on button second!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }


}