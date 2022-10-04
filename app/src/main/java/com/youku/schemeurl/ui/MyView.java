package com.youku.schemeurl.ui;

import androidx.recyclerview.widget.RecyclerView;

public interface MyView {
    void setUrlText(String url);

    void removeActionBean(int type);

    RecyclerView getRecyclerView();

    void initSelectPopup();
}
