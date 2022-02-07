package com.swu.zzm.java81;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
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
    private int currentPage = 0;
    private LinearLayout container;

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
            if (i == 0) {
                dotView.setBackgroundResource(R.drawable.dot_red_shape);
            }else {
                dotView.setBackgroundResource(R.drawable.dot_gray_shape);
            }
            // 给控件添加左间距
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                 ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            // 第二个开始需要间距
            if (i > 0) {
                layoutParams.leftMargin = dpToPixel(10);
            }
            // 设置垂直居中
            layoutParams.gravity = Gravity.CENTER_VERTICAL;
            // 添加到容器中
            container.addView(dotView,layoutParams);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // 还原原来的currentPage
            // 找到page对应控件
            ImageView dotView = (ImageView) container.getChildAt(currentPage);
            dotView.setBackgroundResource(R.drawable.dot_gray_shape);
            // 切换指示器
            if (currentPage < numberOfPages-1){
                currentPage ++;
            }else {
                currentPage = 0;
            }
            // 找到当前指示的控件
            ImageView current = (ImageView) container.getChildAt(currentPage);
            current.setBackgroundResource(R.drawable.dot_red_shape);
        }
        return true;
    }

    private int dpToPixel(int dp){
        // 获取屏幕密度
        float density = getResources().getDisplayMetrics().density;
        return (int) (density * dp);
    }

}