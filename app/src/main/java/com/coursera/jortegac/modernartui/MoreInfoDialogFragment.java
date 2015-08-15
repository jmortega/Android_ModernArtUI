package com.coursera.jortegac.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;


public class MoreInfoDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.show_dialog, null));

        builder.setPositiveButton(R.string.visit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.moma.org"));
                startActivity(intent);
            }
        });

        builder.setNegativeButton(R.string.not_now, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        Button positiveButton =  ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);
        Button negativeButton =  ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_NEGATIVE);

        positiveButton.setBackgroundColor(getResources().getColor(R.color.abc_primary_text_disable_only_material_dark));
        positiveButton.setTextColor(Color.BLACK);
        negativeButton.setBackgroundColor(getResources().getColor(R.color.abc_primary_text_disable_only_material_dark));
        negativeButton.setTextColor(Color.BLACK);
    }
}
