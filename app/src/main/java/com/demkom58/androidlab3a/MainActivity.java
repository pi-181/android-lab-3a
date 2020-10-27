package com.demkom58.androidlab3a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonSelectBackground);
        layout = findViewById(R.id.rootConstraintLayout);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final CharSequence[] items = {
                getText(R.string.red),
                getText(R.string.yellow),
                getText(R.string.green)
        };

        AlertDialog alertDialog = new Builder(this)
                .setTitle(R.string.message)
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        MainActivity context = MainActivity.this;
                        switch (item) {
                            case 0: {
                                layout.setBackgroundResource(R.color.redColor);
                                Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();
                                break;
                            }
                            case 1: {
                                layout.setBackgroundResource(R.color.yellowColor);
                                Toast.makeText(context, R.string.yellow, Toast.LENGTH_LONG).show();
                                break;
                            }
                            case 2: {
                                layout.setBackgroundResource(R.color.greenColor);
                                Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
                                break;
                            }
                        }
                    }
                }).create();
        alertDialog.show();
    }
}