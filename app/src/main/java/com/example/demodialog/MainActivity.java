package com.example.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements DialogBox.DialogListner {

    private Button showDialogbtn;
    private TextView txt1,txt2;
    @Override
    public void applyText(String username, String password) {
        txt1.setText(username);
        txt2.setText(password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 =findViewById(R.id.tv_user);
        txt2 =findViewById(R.id.tv_pass);
        showDialogbtn =findViewById(R.id.showDialogBtn);
        showDialogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogBox();
            }
        });
    }
    private void showDialogBox(){
        DialogBox alertDialog = new DialogBox();
        alertDialog.show(getSupportFragmentManager(),"Dialog example");
    }
}