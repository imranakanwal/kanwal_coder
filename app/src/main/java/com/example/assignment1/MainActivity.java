package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public String op;
    public float calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText id1 = findViewById(R.id.id1);
        EditText id2 = findViewById(R.id.id2);
        TextView t1=(TextView)findViewById(R.id.t1) ;

        Spinner spin1 = (Spinner) findViewById(R.id.spin1);

        ArrayList<String> operations = new ArrayList<>();
        operations.add("Choose operand");
        operations.add("addition");
        operations.add("subtraction");
        operations.add("multiplication");
        operations.add("division");


        ArrayAdapter<String> myadp = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, operations);
        myadp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(myadp);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String imrana = parent.getItemAtPosition(position).toString();
                int val=0,val2=0;
                try {
                     val = Integer.parseInt(id1.getText().toString());

                     val2 = Integer.parseInt(id2.getText().toString());
                }
                catch(NumberFormatException e){
                    System.out.println("not a number");
                }
                if (imrana == "addition") {
                 int ad=val+val2;
                 t1.setText(String.valueOf(ad));
                }
                if (imrana == "subtraction") {
                    int sub=val-val2;
                    t1.setText(String.valueOf(sub));
                }
                if (imrana == "multiplication") {
                    float ad=val*val2;
                    t1.setText(String.valueOf(ad));
                }
                if (imrana == "division") {
                    int quotient=val/val2;
                    int remainder=val%val2;
                    t1.setText("quotient is"+quotient+"remainder is"+remainder);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    }
