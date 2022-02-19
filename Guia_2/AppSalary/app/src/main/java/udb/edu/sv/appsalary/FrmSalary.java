package udb.edu.sv.appsalary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

public class FrmSalary extends AppCompatActivity {
    Double ISSS,AFP,RENT,Net_Salary,Hours,Salary;
    String TxtName;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_salary);

        TextView Welcome=(TextView) findViewById(R.id.TextWelcome);
        TextView TxtSalary=(TextView) findViewById(R.id.Tv_Salary);
        TextView TxtNetSalary=(TextView) findViewById(R.id.Tv_Net_Salary);
        TextView TxtAFP=(TextView) findViewById(R.id.Tv_AFP);
        TextView TxtISSS=(TextView) findViewById(R.id.Tv_ISSS);
        TextView TxtRent=(TextView) findViewById(R.id.Tv_Rent);
        Button BtnBack=(Button) findViewById(R.id.Btn_Back);


        Bundle bundle = this.getIntent().getExtras();

        TxtName = bundle.getString("Name");

        Hours= Double.parseDouble(bundle.getString("Hours"));
        Salary = Hours*8.5;
        ISSS = 0.02;
        AFP = 0.03;
        RENT = 0.04;

        Net_Salary = Salary - Salary*ISSS - Salary*AFP - Salary*RENT;


        Welcome.setText("Hello to "+TxtName + " here is your salary summary:");

        TxtSalary.setText("Salary: $"+Salary);

        TxtISSS.setText("ISSS: $"+ Salary*ISSS);

        TxtAFP.setText("AFP $"+Salary*AFP);

        TxtRent.setText("RENT $"+Salary*RENT);

        TxtNetSalary.setText("Net Salary $"+Net_Salary);

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FrmSalary.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}