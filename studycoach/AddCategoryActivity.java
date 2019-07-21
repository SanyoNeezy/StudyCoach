package com.example.studycoach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class AddCategoryActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.simpleItemListSQL.REPLY";

    private  EditText editTextCategory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        editTextCategory = findViewById(R.id.editTextCategory);
        //the following 2 lines open the keyboard right from the start
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        final Button buttonAdd = findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editTextCategory.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String categoryName = editTextCategory.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, categoryName);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }
}

