package udb.edu.sv.appsalaryfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class InputFragment extends Fragment {


  EditText Name,Hours;
  Button BtnCalculate;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Name = view.findViewById(R.id.Et_Name);
        Hours = view.findViewById(R.id.Et_Hours);
        BtnCalculate = view.findViewById(R.id.Btn_Salary);

        BtnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Double Salary,ISSS,AFP,Rent,NetSalary;
            String Tv_Name;
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
            Salary = Double.parseDouble(Hours.getText().toString())*8.5;
            ISSS = Double.parseDouble(String.valueOf(Salary*0.02));
            AFP = Double.parseDouble(String.valueOf(Salary*0.03));
            Rent = Double.parseDouble(String.valueOf(Salary*0.04));
            NetSalary = (Salary) - (Salary*0.02) - (Salary*0.03) - (Salary*0.04);
            Tv_Name = Name.getText().toString();


            Bundle bundle = new Bundle();
            bundle.putString("Name",Tv_Name);
            bundle.putString("Salary",String.valueOf(Salary));
            bundle.putString("ISSS",String.valueOf(ISSS));
            bundle.putString("AFP",String.valueOf(AFP));
            bundle.putString("Rent",String.valueOf(Rent));
            bundle.putString("NetSalary",String.valueOf(NetSalary));

            getParentFragmentManager().setFragmentResult("data",bundle);
            }

        });


    }
}