package udb.edu.sv.appsalaryfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class DetailsFragment extends Fragment {

    TextView Tv_Salary,TextWelcome,Tv_ISSS,Tv_AFP,Tv_Rent,Tv_NetSalary;
    Button BtnClear;
    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        getParentFragmentManager().setFragmentResultListener("data", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String Salary = result.getString("Salary");
                String Name = result.getString("Name");
                String ISSS = result.getString("ISSS");
                String AFP = result.getString("AFP");
                String Rent = result.getString("Rent");
                String Net_Salary = result.getString("NetSalary");
                TextWelcome.setText("Hello to "+ Name + " here is your salary summary:");
                Tv_Salary.setText("Salary: $"+Salary);
                Tv_ISSS.setText("ISSS: $"+ ISSS);
                Tv_AFP.setText("AFP $"+AFP);
                Tv_Rent.setText("RENT $"+Rent);
                Tv_NetSalary.setText("Net Salary $"+Net_Salary);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Tv_Salary=view.findViewById(R.id.Tv_Salary);
        TextWelcome= view.findViewById(R.id.TextWelcome);
        Tv_ISSS = view.findViewById(R.id.Tv_ISSS);
        Tv_AFP = view.findViewById(R.id.Tv_AFP);
        Tv_Rent = view.findViewById(R.id.Tv_Rent);
        Tv_NetSalary = view.findViewById(R.id.Tv_Net_Salary);
        BtnClear = view.findViewById(R.id.Btn_Clear);
        BtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tv_Salary.setText("");
                TextWelcome.setText("");
                Tv_ISSS.setText("");
                Tv_AFP.setText("");
                Tv_Rent.setText("");
                Tv_NetSalary.setText("");
            }
        });
    }
}