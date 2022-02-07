package com.swu.zzm.customattr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.WrapperListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
        // 代码创建自定义控件
        PageController pc = new PageController(this);
        // 设置每个点显示的样式
        pc.resourceID = R.drawable.dot_shape;
        // 设置间距
        pc.padding = (int) (10 * getResources().getDisplayMetrics().density);

        // 设置显示的页数
        pc.setNumberOfPages(5);

        // 监听事件
        pc.addPageChangeListener(currentPage ->{
                    System.out.println("选中"+currentPage+"页");
        });

        // 将控件添加到界面上 找到当前界面的容器
        RelativeLayout rl = findViewById(R.id.root);
        // 创建在父容器上的具体布局参数
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置约束
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        // 添加子控件
        rl.addView(pc,params);
         */

    }
}