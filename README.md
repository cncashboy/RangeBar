##自定义的RangeBar

RangeBar是一个可以有选择范围的Seekbar，其实很简单，就是一个自定义控件。
这里有很多属性可以定制，除了通过xml来定义也可以用java代码进行定义。

1.res-->values-->attrs.xml

	tickCount:有多少个分割线
	tickHeight：分割线的高度
	barWeight：分割线和滑动条的粗细
	barColor：分割线和滑动条的颜色
	connectingLineWeight：已经选中区域的滑动条宽度
	connectingLineColor：已经选中区域的滑动条颜色（不包括滑块）
	thumbRadius：滑块的半径，其实就是改变滑块的大小
	thumbImageNormal：滑块普通状态的图片
	thumbImagePressed：滑块按下时的图片
	thumbColorNormal：滑块普通状态的颜色
	thumbColorPressed：滑块按下时的颜色

或者
	
	rangeBar.setTickCount(7);//有多少分割线
    rangeBar.setTickHeight(10);//分割线的高度
	...

2.首先导入lib_RangeBar的库文件

3.activity_main.xml

	<?xml version="1.0" encoding="UTF-8"?>
	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="fill_parent"
	    android:layout_height="fill_parent"
	    android:background="#ffffff"
	    android:orientation="vertical" >
	
	    <ScrollView
	        android:layout_width="fill_parent"
	        android:layout_height="fill_parent"
	        android:scrollbars="none" >
	
	        <LinearLayout
	            android:layout_width="fill_parent"
	            android:layout_height="fill_parent"
	            android:gravity="center"
	            android:orientation="vertical" >
	
	            <RelativeLayout
	                android:id="@+id/ll_ticket_time1"
	                android:layout_width="fill_parent"
	                android:layout_height="wrap_content"
	                android:padding="20dp"
	                android:paddingLeft="5dp" >
	
	                <LinearLayout
	                    android:id="@+id/ll_1"
	                    android:layout_width="fill_parent"
	                    android:layout_height="wrap_content"
	                    android:gravity="center_vertical"
	                    android:orientation="horizontal" >
	
	                    <ImageView
	                        android:id="@+id/imageView5"
	                        android:layout_width="wrap_content"
	                        android:layout_height="40dip"
	                        />
	
	                    <TextView
	                        android:id="@+id/tv_start_time"
	                        android:layout_width="wrap_content"
	                        android:layout_height="wrap_content"
	                        android:layout_marginLeft="14dp"
	                        android:text="00:00"
	                        android:textColor="#000000"
	                        android:textSize="18sp" />
	
	                    <TextView
	                        android:layout_width="wrap_content"
	                        android:layout_height="wrap_content"
	                        android:layout_marginLeft="5dp"
	                        android:layout_marginRight="5dp"
	                        android:text="-"
	                        android:textColor="#000000"
	                        android:textSize="15sp"
	                        android:textStyle="bold" />
	
	                    <TextView
	                        android:id="@+id/tv_end_time"
	                        android:layout_width="wrap_content"
	                        android:layout_height="wrap_content"
	                        android:text="24:00"
	                        android:textColor="#000000"
	                        android:textSize="18sp" />
	                </LinearLayout>
	
	                <com.edmodo.rangebar.RangeBar
	                    xmlns:custom="http://schemas.android.com/apk/res-auto"
	                    android:id="@+id/rangebar"
	                    android:layout_width="match_parent"
	                    android:layout_height="70dip"
	                    android:layout_marginBottom="50dp"
	                    android:layout_marginTop="50dp"
	                    custom:tickCount="7"
	                    custom:thumbRadius="5dp"
	                    custom:connectingLineColor="@android:color/holo_green_dark"
	                    custom:thumbColorNormal="@android:color/holo_green_dark"
	                    custom:thumbColorPressed="@android:color/holo_green_dark"
	                    custom:tickHeight="10dp" />
	            </RelativeLayout>
	
	        </LinearLayout>
	    </ScrollView>
	
	</RelativeLayout>

4.MainActivity.java

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


		