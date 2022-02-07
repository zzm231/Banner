package com.swu.zzm.customattr;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author Administrator
 */
public class PageController extends LinearLayout {
    private int numberOfPages;
    /**
     * 不同状态下显示的形式和颜色
     */
    public int resourceID;
    /**
     *间距
     */
    public int padding;

    /**
     * 记录当前指示的是第几个
     * @param context
     */
    private int currentPage;
    private PageChangeListener mPageChangeListener;

    public PageController(Context context) {
        this(context,null);
    }

    public PageController(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PageController(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(LinearLayout.HORIZONTAL);

        /**
         * 将xml里面自定义属性的值去出来
         */
        if (attrs != null) {
            // 从一个资源里面将自定义的所有属性取出来
            TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.PageController);
            /**
             * 1.属性名
             * 2.默认值
             */
            padding = typedArray.getInteger(R.styleable.PageController_mPadding,0);
            resourceID = typedArray.getResourceId(R.styleable.PageController_resourceID,0);
            int page = typedArray.getInteger(R.styleable.PageController_numberOfPages,0);
            // 显示
            setNumberOfPages(page);
        }
    }

    /**
     *numberOfPages setter/getter方法
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;

        // 创建点
        for (int i = 0; i < numberOfPages; i++) {
            // 创建控件ImageView
            ImageView dotView = new ImageView(getContext());
            // 设置显示的内容
            dotView.setBackgroundResource(resourceID);
            // 设置约束
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER_VERTICAL;
            if (i > 0) {
                params.leftMargin = padding;
            }else {
                // 默认选择第一个点
                dotView.setEnabled(false);
            }

            // 添加到容器中
            
            addView(dotView,params);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // 取出当前页数
            int current = currentPage;
            if (event.getX() > getWidth() * 0.5) {
                // 右边
                if (current == numberOfPages - 1) {
                    current = 0;
                }else {
                    current ++;
                }
            }else {
                // 左边
                if (current == 0) {

                    current = numberOfPages - 1;
                }else {
                    current --;
                }
            }
            setCurrentPage(current);
        }
        return true;
    }

    /**
     * currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        // 将上一次的还原为默认状态
        ImageView old = (ImageView) getChildAt(this.currentPage);
        old.setEnabled(true);

        // 将当前选中的设置为选中状态
        ImageView current = (ImageView) getChildAt(this.currentPage);
        current.setEnabled(false);
        this.currentPage = currentPage;

        // 将页数改变的事件回调给监听者
        if (mPageChangeListener != null) {
            mPageChangeListener.pageDidChanged(currentPage);
        }

        // 开启动画
        showAnimation(current);
    }

    /**
     * 定义接口监听指示器改变的事件
     */
    public interface PageChangeListener{
        void pageDidChanged(int currentPage);
    }

    /**
     * 设置监听对象
     * mPageChangeListener
     */
    public void addPageChangeListener(PageChangeListener listener){
        this.mPageChangeListener = listener;
    }

    /**
     * 宽度拉伸动画
     */
    public void showAnimation(ImageView item){
        ObjectAnimator scale = ObjectAnimator.ofFloat(item,"scaleX",1,1.5f,1);
        scale.setDuration(400);
        scale.start();
    }
}
