package com.youku.schemeurl.ui.viewHoler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public int viewType;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
