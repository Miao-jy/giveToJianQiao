package com.youku.schemeurl.ui.viewHoler;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.youku.schemeurl.R;

public class EditTextViewHolder extends BaseViewHolder {
    private final TextView paramName;
    private final EditText paramEditText;

    public static final int EDIT_TEXT_VIEW_HOLDER_VIEW_TYPE = 0;

    public EditTextViewHolder(@NonNull View itemView) {
        super(itemView);
        viewType = EDIT_TEXT_VIEW_HOLDER_VIEW_TYPE;
        paramName = itemView.findViewById(R.id.paramName);
        paramEditText = itemView.findViewById(R.id.paramEditText);
    }


    public TextView getParamName() {
        return paramName;
    }

    public EditText getParamEditText() {
        return paramEditText;
    }
}
