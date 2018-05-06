package com.eways.etutor.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * ScrollView which adds a simple parallax effect to its first grandchild.
 * The following views are required to:
 * - Have an opaque background to properly cover the "parallaxed" view
 * - Be clickable to prevent the touch events to go through and be intercepted
 *   by a clickable "parallaxed" view.
 *
 * @author Christophe Beyls
 */
public class ParallaxScrollView extends ScrollView {

	private static final float PARALLAX_FACTOR = 0.6f;

	private View animatedView;
	private int currentOffset;

	public ParallaxScrollView(Context context) {
		this(context, null, 0);
	}

	public ParallaxScrollView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ParallaxScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void addView(View child, int index, ViewGroup.LayoutParams params) {
		super.addView(child, index, params);
		if (child instanceof ViewGroup) {
			ViewGroup groupChild = (ViewGroup) child;
			if (groupChild.getChildCount() > 0) {
				animatedView = groupChild.getChildAt(0);
				currentOffset = 0;
			}
		}
	}

	@SuppressLint("NewApi")
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (animatedView != null) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
				animatedView.setTranslationY(t * PARALLAX_FACTOR);
			} else {
				int offset = (int) (t * PARALLAX_FACTOR);
				animatedView.offsetTopAndBottom(offset - currentOffset);
				currentOffset = offset;
			}
		}
	}
}
