package com.presercomp.boleteador.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.presercomp.boleteador.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private TextView txt_pantalla;
    private TextView txt_cantidad;
    private TextView txt_valor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        txt_cantidad = root.findViewById(R.id.txt_cantidad);
        txt_pantalla = root.findViewById(R.id.txt_pantalla);
        txt_valor    = root.findViewById(R.id.txt_valor);
        Button btn_zero_double = root.findViewById(R.id.btn_zero_double);
        Button btn_zero_single = root.findViewById(R.id.btn_zero_single);
        Button btn_one = root.findViewById(R.id.btn_one);
        Button btn_two = root.findViewById(R.id.btn_two);
        Button btn_three = root.findViewById(R.id.btn_three);
        Button btn_four = root.findViewById(R.id.btn_four);
        Button btn_five = root.findViewById(R.id.btn_five);
        Button btn_six = root.findViewById(R.id.btn_six);
        Button btn_seven = root.findViewById(R.id.btn_seven);
        Button btn_eight = root.findViewById(R.id.btn_eight);
        Button btn_nine = root.findViewById(R.id.btn_nine);
        Button btn_add  = root.findViewById(R.id.btn_add);
        Button btn_multiply  = root.findViewById(R.id.btn_multiply);
        Button btn_clear  = root.findViewById(R.id.btn_clear);
        btn_zero_double.setOnClickListener(this);
        btn_zero_single.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        String valor = txt_valor.getText().toString();
        switch(v.getId()){
            case R.id.btn_zero_single:
                if(!valor.equals("$ 0")){
                    valor += "0";
                }
                break;
            case R.id.btn_zero_double:
                if(!valor.equals("$ 0")){
                    valor += "00";
                }
                break;
            case R.id.btn_one:
                if(valor.equals("$ 0")){
                    valor = "1";
                } else {
                    valor += "1";
                }
                break;
            case R.id.btn_two:
                if(valor.equals("$ 0")){
                    valor = "2";
                } else {
                    valor += "2";
                }
                break;
            case R.id.btn_three:
                if(valor.equals("$ 0")){
                    valor = "3";
                } else {
                    valor += "3";
                }
                break;
            case R.id.btn_four:
                if(valor.equals("$ 0")){
                    valor = "4";
                } else {
                    valor += "4";
                }
                break;
            case R.id.btn_five:
                if(valor.equals("$ 0")){
                    valor = "5";
                } else {
                    valor += "5";
                }
                break;
            case R.id.btn_six:
                if(valor.equals("$ 0")){
                    valor = "6";
                } else {
                    valor += "6";
                }
                break;
            case R.id.btn_seven:
                if(valor.equals("$ 0")){
                    valor = "7";
                } else {
                    valor += "7";
                }
                break;
            case R.id.btn_eight:
                if(valor.equals("$ 0")){
                    valor = "8";
                } else {
                    valor += "8";
                }
                break;
            case R.id.btn_nine:
                if(valor.equals("$ 0")){
                    valor = "9";
                } else {
                    valor += "9";
                }
                break;
            case R.id.btn_clear:
                valor = "$ 0";
                txt_pantalla.setText("$ 0");
                txt_cantidad.setText("1");
            break;
            case R.id.btn_multiply:
                txt_cantidad.setText(valor);
                valor = "$ 0";
                break;
            case R.id.btn_add:
                int unidades = Integer.parseInt(txt_cantidad.getText().toString());
                int monto    = Integer.parseInt(valor);
                int carga    = unidades * monto;
                int acomulado = Integer.parseInt(txt_pantalla.getText().toString().replace("$ ", ""));
                int pantalla  = acomulado + carga;
                txt_pantalla.setText("$ "+pantalla);
                valor = "$ 0";
                txt_cantidad.setText("1");

        }
        txt_valor.setText(valor);

    }
}