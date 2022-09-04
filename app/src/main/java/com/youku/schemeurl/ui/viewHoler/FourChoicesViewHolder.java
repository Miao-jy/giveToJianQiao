package com.youku.schemeurl.ui.viewHoler;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youku.schemeurl.R;

public class FourChoicesViewHolder extends BaseViewHolder {
    private final TextView paramNameSelect;
    private final RadioGroup radioGroup;
    private final RadioButton radioOne;
    private final RadioButton radioTwo;
    private final RadioButton radioThree;
    private final RadioButton radioFour;

    public static final int FOUR_CHOICES_VIEW_HOLDER_VIEW_TYPE = 1;

    public FourChoicesViewHolder(@NonNull View itemView) {
        super(itemView);
        viewType = FOUR_CHOICES_VIEW_HOLDER_VIEW_TYPE;
        paramNameSelect = itemView.findViewById(R.id.paramNameSelect);
        radioGroup = itemView.findViewById(R.id.paramSelect);
        radioOne = itemView.findViewById(R.id.radio_one);
        radioTwo = itemView.findViewById(R.id.radio_two);
        radioThree = itemView.findViewById(R.id.radio_three);
        radioFour = itemView.findViewById(R.id.radio_four);
    }

    public TextView getParamName() {
        return paramNameSelect;
    }

    public RadioButton getRadioOne() {
        return radioOne;
    }

    public RadioButton getRadioTwo() {
        return radioTwo;
    }

    public RadioButton getRadioThree() {
        return radioThree;
    }

    public RadioButton getRadioFour() {
        return radioFour;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }
}
