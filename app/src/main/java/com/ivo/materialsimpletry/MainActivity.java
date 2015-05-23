package com.ivo.materialsimpletry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import com.ivo.materialsimpletry.greenmatter.ColorOverrider;
import com.ivo.materialsimpletry.greenmatter.SelectColorActivity;
import com.negusoft.greenmatter.MatPalette;
import com.negusoft.greenmatter.activity.MatActivity;


public class MainActivity extends MatActivity {


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

//                palette.setColorAccent(Color.YELLOW);
//        palette.setColorPrimary(0xff880000);
//        palette.setColorPrimaryDark(0xff440000);
//        palette.setColorControlHighlight(Color.GREEN);
//        palette.setColorControlNormal(Color.MAGENTA);
//        palette.setColorControlActivated(Color.CYAN);
//        palette.setColorButtonNormal(0xff888800);
//        palette.setColorSwitchThumbNormal(Color.WHITE);

    }


}
