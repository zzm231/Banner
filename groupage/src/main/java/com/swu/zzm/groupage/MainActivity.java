package com.swu.zzm.groupage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 使用自定义控件
        PageController pageController = new PageController(this);
        pageController.setPadding(10);
        pageController.normalResource = R.drawable.dot_gray_shape;
        pageController.selectedResource = R.drawable.dot_red_shape;

        pageController.setNumberOfPagers(5);

        relativeLayout = findViewById(R.id.root);
        relativeLayout.addView(pageController);
    }
}