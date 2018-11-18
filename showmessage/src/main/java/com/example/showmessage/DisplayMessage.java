package com.example.showmessage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayMessage extends AppCompatActivity {

    private String message;
    private TextView messageView;
    private static String KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        if(getIntent().hasExtra(KEY)) {
            message = getIntent().getStringExtra(KEY);
        } else {
            message = "";
        }
        messageView = findViewById(R.id.messageView);
        messageView.setText(message);
    }
}
