package com.coursera.jortegac.modernartui;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View view_one=findViewById(R.id.view1);
        final View view_two=findViewById(R.id.view2);
        final View view_three=findViewById(R.id.view3);
        final View view_four=findViewById(R.id.view4);
        final View view_five=findViewById(R.id.view5);

        final int colorView1 = ((ColorDrawable) view_one.getBackground()).getColor();
        final int colorView2 = ((ColorDrawable) view_two.getBackground()).getColor();
        final int colorView3 = ((ColorDrawable) view_three.getBackground()).getColor();
        final int colorView4 = ((ColorDrawable) view_four.getBackground()).getColor();
        final int colorView5 = ((ColorDrawable) view_five.getBackground()).getColor();

        seekBar=(SeekBar)findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int increment, boolean fromUser) {

                progressChanged = increment;

                //change background color in each view
                setProgressBasedBackgroundColor(view_one, colorView1);
                setProgressBasedBackgroundColor(view_two, colorView2);
                setProgressBasedBackgroundColor(view_three, colorView3);
                setProgressBasedBackgroundColor(view_four, colorView4);
                setProgressBasedBackgroundColor(view_five, colorView5);
            }

            private void setProgressBasedBackgroundColor(View view, int viewColor) {
                float[] hsvColor = new float[3];
                Color.colorToHSV(viewColor, hsvColor);
                hsvColor[0] = hsvColor[0] + progressChanged;
                hsvColor[0] = hsvColor[0] % 255;
                view.setBackgroundColor(Color.HSVToColor(Color.alpha(viewColor), hsvColor));
            }
            /**
             *
             * @param seekBar The SeekBar in which the touch gesture began
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            /**
             *
             * @param seekBar The SeekBar in which the touch gesture began
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            DialogFragment moreInfoFragment = new MoreInfoDialogFragment();
            moreInfoFragment.show(getFragmentManager(), "moreInfo");
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
