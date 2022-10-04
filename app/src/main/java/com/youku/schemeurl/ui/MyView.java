package com.youku.schemeurl.ui;

import android.text.SpannableStringBuilder;

import androidx.recyclerview.widget.RecyclerView;

public interface MyView {
    void setUrlText(SpannableStringBuilder url);

    void removeActionBean(int type);

    RecyclerView getRecyclerView();

    void initSelectPopup();
}
