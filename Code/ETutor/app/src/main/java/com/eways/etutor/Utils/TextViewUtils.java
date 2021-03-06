package com.eways.etutor.Utils;

/**
 * Created by ADMIN on 5/17/2018.
 */

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.TextView;

/**

 * TextViewUtils.
 */

public class TextViewUtils {

    public static void addTextViewLeftIcon(
            EditText editText
            , Drawable drawable
            , int imgSize) {

        if (editText == null || drawable == null || imgSize <= 0) {
            return;
        }

        drawable.setBounds(0, 0
                , imgSize
                , imgSize);

        editText.setCompoundDrawables(
                drawable
                , null
                , null
                , null);
    }

    public static void addTextViewBottomIcon(
            TextView textView
            , Drawable drawable
            , int imgWidth
            , int imgHeight) {

        if (textView == null || drawable == null || imgWidth <= 0) {
            return;
        }

        drawable.setBounds(0, 0
                , imgWidth
                , imgHeight);

        textView.setCompoundDrawables(
                null
                , null
                , null
                , drawable);
    }
}
