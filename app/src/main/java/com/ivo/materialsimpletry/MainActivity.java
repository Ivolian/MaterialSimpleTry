package com.ivo.materialsimpletry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.ivo.materialsimpletry.activity.ToolbarActivity;
import com.ivo.materialsimpletry.greenmatter.ColorOverrider;
import com.ivo.materialsimpletry.greenmatter.SelectColorActivity;
import com.ivo.materialsimpletry.volley.MyVolley;
import com.negusoft.greenmatter.MatPalette;

import butterknife.OnClick;


public class MainActivity extends ToolbarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {

        Intent intent = new Intent(this, SelectColorActivity.class);
        startActivityForResult(intent, 1);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    recreate();
                }
            });
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public MatPalette overridePalette(MatPalette palette) {


        return ColorOverrider.getInstance(palette).applyOverride(palette);
    }

    @OnClick(R.id.button)
    public void onClick() {

        Toast.makeText(this,"sdf",Toast.LENGTH_LONG).show();
        MyVolley.getRequestQueue().add(new StringRequest("https://github.com/facebook/stetho", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        },
                MyVolley.getDefaultErrorListener()));
    }

}
