package com.waspar.gradientbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class GradientButton extends FrameLayout {

    private TextView textView;
    private View root;

    public static int RIGHT_LEFT = 1;
    public static int LEFT_RIGHT = 2;
    public static int BOTTOM_TOP = 3;
    public static int TOP_BOTTOM = 4;

    public GradientButton(@NonNull Context context) {
        super(context);
        initView();
    }

    public GradientButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public GradientButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.gradient_button, null);
        addView(view);
    }

    private void initView(Context context, AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.gradient_button, null);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GradientButton, 0, 0);
        try {
            textView = view.findViewById(R.id.gradient_button_txt);
            root = view.findViewById(R.id.gradient_button_root1);

            float Radius = ta.getDimension(R.styleable.GradientButton_Radius, 10);
            float textSize = ta.getDimension(R.styleable.GradientButton_textSize, 10);
            String Text = ta.getString(R.styleable.GradientButton_setText);

            int startColor = R.styleable.GradientButton_startColor;
            int mStartColor = context.getResources().getColor(R.color.colorBlue_A400);
            if (ta.hasValue(startColor)) {
                mStartColor = ta.getResourceId(startColor, 0);
                mStartColor = context.getResources().getColor(mStartColor);
            }

            int endColor = R.styleable.GradientButton_endColor;
            int mEndColor = context.getResources().getColor(R.color.colorBlue_900);
            if (ta.hasValue(endColor)) {
                mEndColor = ta.getResourceId(endColor, 0);
                mEndColor = context.getResources().getColor(mEndColor);
            }

            int orientation = ta.getInteger(R.styleable.GradientButton_orientation, 1);

            String Font = ta.getString(R.styleable.GradientButton_typeface);

            if (Font != null) {
                setFont(context, Font);
            }

            ColorStateList color = ta.getColorStateList(R.styleable.GradientButton_textColor);

            setRadius(Radius * 2, mStartColor, mEndColor, orientation);

            setText(Text);

            setTextSize((float) (textSize * 0.4));

            if (color != null) {
                setTextColor(color);
            }


        } finally {
            ta.recycle();
        }

        addView(view);
    }

    public void setFont(Context context, String font) {
        textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/" + font));
    }

    public void setTextColor(ColorStateList color) {
        if (color != null) {
            textView.setTextColor(color);
        }
    }

    public void setTextSize(float textSize) {
        textView.setTextSize(textSize);
    }

    public void setText(String Text) {
        textView.setText(Text);
    }

    public void setRadius(float Radius, int start, int end, int Orientation) {

        GradientDrawable.Orientation orientation = null;

        switch (Orientation) {
            case 1:
                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                break;
            case 2:
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                break;
            case 3:
                orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                break;
            case 4:
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                break;
            default:
                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
        }

        GradientDrawable drawable = new GradientDrawable(orientation, new int[]{start, end});
        drawable.setCornerRadii(new float[]{Radius, Radius, Radius, Radius, Radius, Radius, Radius, Radius});
        root.setBackground(drawable);
    }
}
