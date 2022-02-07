package com.swu.zzm.groupage;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author PageController
 */
public class PageController extends LinearLayout {
    private int padding;
    private int numberOfPagers;
    public int normalResource;
    public int selectedResource;

    /**
     * 当使用java代码创建
     */
    public PageController(Context context) {
        this(context,null);

    }

    /**
     * xml里面配置
     */
    public PageController(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    /**
     * xml里面还配置了样式的
     */
    public PageController(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public void setNumberOfPagers(int numberOfPagers) {
        for (int i = 0; i < numberOfPagers; i++) {
            ImageView dotView = new ImageView(getContext());

            LayoutParams params = new LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i == 0) {
                dotView.setImageResource(selectedResource);
            }else {
                dotView.setImageResource(normalResource);
            }
            // 设置间距
            params.leftMargin = padding;
            params.gravity = Gravity.CENTER_VERTICAL;
            // 添加控件
            addView(dotView,params);
        }
        this.numberOfPagers = numberOfPagers;
    }

    public int getNumberOfPagers() {
        return numberOfPagers;
    }


    /**
     * 定义一个接口 在接口里面定义常量 表示状态
     */
    public interface DotState{
        int NORMAL = 0;
        int SELECTED = 0;
    }

    /**
     * padding set get方法
     */
    public void setPadding(int padding) {
        this.padding = padding;
    }

    public float getPadding() {
        return padding;
    }
}














