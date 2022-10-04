package com.example.aps.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.aps.R;

public class SetupActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        setToolbar();

    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_setup);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("設定");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(getDrawable(R.drawable.u154));
        toolbar.setContentInsetStartWithNavigation(0);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}
