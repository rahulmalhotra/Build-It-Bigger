package com.example.showmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessage extends AppCompatActivity {

    private String message;
    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        message = getIntent().getStringExtra("joke");
        messageView = findViewById(R.id.messageView);
        messageView.setText(message);
    }
}
