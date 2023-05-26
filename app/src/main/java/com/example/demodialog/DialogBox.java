package com.example.demodialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogBox extends DialogFragment {

    private DialogListner listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener=(DialogListner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+" Must implemente dialog listner");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view =layoutInflater.inflate(R.layout.layout_dialog,null);
        alertBuilder.setView(view);
        EditText edit_username,edit_password;
        edit_username=view.findViewById(R.id.et_username);
        edit_password=view.findViewById(R.id.et_password);
        alertBuilder.setTitle("Login")
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = edit_username.getText().toString();
                        String password = edit_password.getText().toString();

                        listener.applyText(username,password);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });



        return alertBuilder.create();
    }
    public interface DialogListner{
        void applyText(String username,String password);
    }


}
                                                                                                                                                                                                                                                                                                    ;