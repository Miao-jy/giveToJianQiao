package com.youku.schemeurl.ui.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youku.schemeurl.R;
import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.constant.ActionBeanConstant;
import com.youku.schemeurl.present.Present;
import com.youku.schemeurl.ui.viewHoler.BaseViewHolder;
import com.youku.schemeurl.ui.viewHoler.EditTextViewHolder;
import com.youku.schemeurl.ui.viewHoler.FourChoicesViewHolder;

import java.util.List;

public class ParamRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ActionBean<?>> dataList;
    private final Present present;
    private OnRemoveListener onRemoveListener;

    public void setOnRemoveListener(OnRemoveListener onRemoveListener) {
        this.onRemoveListener = onRemoveListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case EditTextViewHolder.EDIT_TEXT_VIEW_HOLDER_VIEW_TYPE:
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recyclerview_item_input, parent, false);
                EditTextViewHolder editTextViewHolder = new EditTextViewHolder(view);
                editTextViewHolder.setIsRecyclable(false);
                return editTextViewHolder;
            case FourChoicesViewHolder.FOUR_CHOICES_VIEW_HOLDER_VIEW_TYPE:
                View select = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recyclerview_item_select, parent, false);
                return new FourChoicesViewHolder(select);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        int type = dataList.get(position).getType();
        String description = dataList.get(position).getDescription();
        switch (holder.viewType) {
            case EditTextViewHolder.EDIT_TEXT_VIEW_HOLDER_VIEW_TYPE:
                EditTextViewHolder editTextViewHolder = (EditTextViewHolder)holder;
                editTextViewHolder.getParamName().setText(description);
                EditText editText = editTextViewHolder.getParamEditText();
                if (dataList.get(position).getValue() != null) {
                    editText.setText(dataList.get(position).getValue().toString());
                }
                editTextViewHolder.getParamEditText().addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        present.updateData(type, s.toString());
                        present.updateUrl();
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                break;
            case FourChoicesViewHolder.FOUR_CHOICES_VIEW_HOLDER_VIEW_TYPE:
                FourChoicesViewHolder fourChoicesViewHolder = (FourChoicesViewHolder)holder;
                fourChoicesViewHolder.getParamName().setText(description);
                List<String> fixedValues = dataList.get(position).getFixedValues();
                RadioGroup radioGroup = fourChoicesViewHolder.getRadioGroup();
                radioGroup.removeAllViews();
                RadioButton radioButton;
                RadioGroup.LayoutParams buttonLayoutParams = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                for (int i = 0; i < fixedValues.size(); i++) {
                    radioButton = new RadioButton(radioGroup.getContext());
                    radioButton.setId((type << 3) + i);
                    String value = fixedValues.get(i);
                    radioButton.setText(value);
                    if (dataList.get(position).getValue() != null && dataList.get(position).getValue().toString().equals(value)) {
                        radioButton.setChecked(true);
                    }
                    radioGroup.addView(radioButton, buttonLayoutParams);
                    radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
                        if (isChecked) {
                            present.updateData(dataList.get(position).getType(), value);
                            present.updateUrl();
                        }
                    });
                }
                break;
        }
        if(type != ActionBeanConstant.SOURCE_TYPE && type != ActionBeanConstant.VID_TYPE) {
            holder.itemView.setOnLongClickListener(view -> {
                if (onRemoveListener != null) {
                    onRemoveListener.ondelect(type);
                }
                return true;
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void updateDataList() {
        this.dataList = present.getDataList();
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        ActionBean<?> actionBean = dataList.get(position);
        if (actionBean.getHasFixedValues()) {
            return FourChoicesViewHolder.FOUR_CHOICES_VIEW_HOLDER_VIEW_TYPE;
        }
        return EditTextViewHolder.EDIT_TEXT_VIEW_HOLDER_VIEW_TYPE;
    }

    public interface OnRemoveListener {
        void ondelect(int type);
    }

    public ParamRecyclerViewAdapter(Present present) {
        this.dataList = present.getDataList();
        this.present = present;
    }
}
