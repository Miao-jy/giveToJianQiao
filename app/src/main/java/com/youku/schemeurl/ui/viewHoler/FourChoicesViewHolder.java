package com.youku.schemeurl.ui.viewHoler;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.youku.schemeurl.R;

public class FourChoicesViewHolder extends BaseViewHolder {
    private final TextView paramNameSelect;
    private final RadioGroup radioGroup;
    public static final int FOUR_CHOICES_VIEW_HOLDER_VIEW_TYPE = 1;

    public FourChoicesViewHolder(@NonNull View itemView) {
        super(itemView);
        viewType = FOUR_CHOICES_VIEW_HOLDER_VIEW_TYPE;
        paramNameSelect = itemView.findViewById(R.id.paramNameSelect);
        radioGroup = itemView.findViewById(R.id.paramSelect);
    }

    public TextView getParamName() {
        return paramNameSelect;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }
}
