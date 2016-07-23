package com.wtianyi.rangebar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.edmodo.rangebar.RangeBar;

public class MainActivity extends Activity {

    private RangeBar rangeBar;
    private TextView tv_start_time;
    private TextView tv_end_time;

    private int startTime = 0;
    private int endTime = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rangeBar = (RangeBar) findViewById(R.id.rangebar);
        tv_start_time = (TextView) findViewById(R.id.tv_start_time);
        tv_end_time = (TextView) findViewById(R.id.tv_end_time);

        //设置RangeBar的监听事件
        rangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onIndexChangeListener(RangeBar rangeBar, int leftThumbIndex, int rightThumbIndex) {

                startTime = leftThumbIndex * 4;
                if (startTime < 10) {
                    tv_start_time.setText("0" + startTime + ":00");
                } else {
                    tv_start_time.setText(startTime + ":00");
                }

                endTime = rightThumbIndex * 4;
                if (endTime < 10) {
                    tv_end_time.setText("0" + endTime + ":00");
                } else {
                    tv_end_time.setText(endTime + ":00");
                }
            }
        });
    }
}
