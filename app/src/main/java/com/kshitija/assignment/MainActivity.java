package com.kshitija.assignment;


import androidx.appcompat.app.AppCompatActivity;

import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private TextView txtResult;
    private Button btnAdd , btnSub , btnMult , btnDiv ,btnClear ,btnInput;
    int sum, res;

    ArrayList<EditText> editTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearlayout);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        btnInput = findViewById(R.id.btnInput);
        txtResult= findViewById(R.id.txtResult);
        btnClear = findViewById(R.id.btnClear);

        btnInput.setOnClickListener(new BtnAddTextClickListener());
        btnAdd.setOnClickListener(new BtnAddListener());
        btnSub.setOnClickListener(new BtnSubListener());
        btnMult.setOnClickListener(new BtnMultListener());
        btnDiv.setOnClickListener(new BtnDivListener());
        btnClear.setOnClickListener(new BtnClearListener());

    }
    private class BtnAddTextClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText edtText = new EditText(MainActivity.this);
            edtText.setLayoutParams(
                    new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    )
            );
            edtText.setText("");
            linearLayout.addView(edtText);
            editTexts.add(edtText);

        }
    }
    private class BtnAddListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Log.d("TAG11", "onClick: 11 add");
            for (int i = 0 ;i<editTexts.size(); i++ ){
                try {
                   res =  Integer.parseInt(editTexts.get(i).getText().toString()) + res;
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Addition", Toast.LENGTH_LONG).show();
                }

          txtResult.setText(res + "");
            }
        }
    }
    private class BtnSubListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            int sum;
            sum = Integer.parseInt(editTexts.get(0).getText().toString());
            for (int i = 0 ;i<editTexts.size();i++){
                try {
                res = Integer.parseInt(editTexts.get(i).getText().toString()) - res;
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Subtraction", Toast.LENGTH_SHORT).show();
                }
                txtResult.setText(res +"");
            }
        }
    }
    private class BtnMultListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            sum = Integer.parseInt(editTexts.get(0).getText().toString());
            for (int i = 1 ;i<editTexts.size(); i++ ){
                try {
                  res = Integer.parseInt(editTexts.get(i).getText().toString()) * res ;
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Multiplication", Toast.LENGTH_LONG).show();
                }

                txtResult.setText(res + "");
            }
        }
    }

    private class BtnDivListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            sum = Integer.parseInt(editTexts.get(1).getText().toString());
            for (int i = 1 ;i<editTexts.size(); i++ ){
                try {
                    res = Integer.parseInt(editTexts.get(i).getText().toString()) / res;
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Division", Toast.LENGTH_LONG).show();
                }

                txtResult.setText(res + "");
            }
        }
    }

    private class BtnClearListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            EditText edttxtremove = new EditText(MainActivity.this);
            for(int i=0; i<editTexts.size(); i++){
                linearLayout.removeView(editTexts.get(i));
            }
            editTexts.clear();
            txtResult.setText("");
        }
    }
}