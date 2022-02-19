package udb.edu.sv.appsalary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         EditText Name=(EditText) findViewById(R.id.Et_Name);
         EditText Hours=(EditText) findViewById(R.id.Et_Hours);
         Button BtnSalary=(Button) findViewById(R.id.Btn_Salary);

        BtnSalary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Name.setError(null);
                    Hours.setError(null);

                Intent intent= new Intent(MainActivity.this,FrmSalary.class);
                Bundle b = new Bundle();
                b.putString("Name",Name.getText().toString());
                b.putString("Hours",Hours.getText().toString());
                final String regex = "^[0-9]\\d*(.\\d+)?$";


                if ("".equals(Name.getText().toString())) {
                    Name.setError("error. enter your name");
                    Name.requestFocus();
                    return;
                }else if("".equals(Hours.getText().toString())){

                    Hours.setError("error enter the number of hours worked");
                    Hours.requestFocus();
                    return;
                }else if(Hours.getText().toString().matches(regex)==false){
                    Hours.setError("error only whole numbers and decimals are accepted");
                    Hours.requestFocus();
                    return;
                }
                intent.putExtras(b);
                startActivity(intent);

            }
        });

    }


}