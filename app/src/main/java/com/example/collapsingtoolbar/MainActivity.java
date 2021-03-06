package com.example.collapsingtoolbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(MainActivity.this, "Item-1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(MainActivity.this, "Item-2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(MainActivity.this, "Item-3", Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Yoda");
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleTextColor(ColorStateList.valueOf(Color.WHITE));

        setCustomView(toolbar);
    }

    private void setCustomView(Toolbar toolbar) {
        View customView = getLayoutInflater().inflate(R.layout.custom_view, null);
        toolbar.addView(customView);

        customView.findViewById(R.id.custom_view_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.collapsing_image);
                imageView.setImageResource(R.drawable.vader);
                TextView textView = (TextView) findViewById(R.id.main_text);
                textView.setText(R.string.vader_quote);
            }
        });
    }
}
