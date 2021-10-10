package com.leuenroo.persistentdata;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    @BindView(R.id.sharedPrefClick )TextView mTv1;
    @BindView(R.id.filesClick )TextView mTv2;
    @BindView(R.id.sqlLiteClick )TextView mTv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        //Anonymous class creation to call onClick -- which is the only abstract class
        mTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,FilesActivity.class));
            }
        });
                // ^can be converted into lambda expression (shown below)
        /*
        mTv2.setOnClickListener (v ->
            startActivity(new Intent(MainActivity2.this,FilesActivity.class))
        );
         */

        mTv3.setOnClickListener(this::goToSQL);
    }

    private void goToSQL(View view) {
        startActivity(new Intent(this,SQLActivity.class));

    }

    public void goToSharedPref(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

}
