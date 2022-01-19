package com.swu.zzm.java81;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 自定义控件:封装
 * 方式：
 *      1.组合方式 ViewPager(用系统控件拼接)
 *      2.继承方式 (在已有控件的基础上添加新的功能)
 *      3.自绘方式 (自己画内容)
 * @author Administrator
 */

public class MainActivity extends AppCompatActivity {

    private int numberOfPages = 5;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取布局容器
        container = findViewById(R.id.ll_container);

        // 在容器中添加内容 View
        for (int i = 0; i < 5; i++) {
            // 创建视图控件
            ImageView dotView = new ImageView(this);
            // 配置显示样子
            dotView.setBackgroundResource(R.drawable.dot_gray_shape);
            // 给控件添加左间距
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                 ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = pixelToDp(10);
            // 添加到容器中
            container.addView(dotView);
        }
    }

    private int pixelToDp(int pixel){
        // 获取屏幕密度
        float density = getResources().getDisplayMetrics().density;
        return (int) (density * pixel);
    }

}