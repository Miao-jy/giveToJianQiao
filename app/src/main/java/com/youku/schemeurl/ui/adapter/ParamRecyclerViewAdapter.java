package com.youku.schemeurl.ui.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
                return new EditTextViewHolder(view);
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
                editTextViewHolder.getParamEditText().addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        present.updateData(type, charSequence.toString());
                        present.updateUrl();
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                break;
            case FourChoicesViewHolder.FOUR_CHOICES_VIEW_HOLDER_VIEW_TYPE:
                FourChoicesViewHolder fourChoicesViewHolder = (FourChoicesViewHolder)holder;
                fourChoicesViewHolder.getParamName().setText(description);
                List<String> fixedValues = dataList.get(position).getFixedValues();
                if (fixedValues != null) {
                    fourChoicesViewHolder.getRadioOne().setText(fixedValues.get(0));
                    fourChoicesViewHolder.getRadioTwo().setText(fixedValues.get(1));
                    fourChoicesViewHolder.getRadioThree().setText(fixedValues.get(2));
                    fourChoicesViewHolder.getRadioFour().setText(fixedValues.get(3));
                }
                fourChoicesViewHolder.getRadioGroup().setOnCheckedChangeListener((group, checkedId) -> {
                    // Check which radio button was clicked
                    switch(checkedId) {
                        case R.id.radio_one:
                            present.updateData(ActionBeanConstant.DETAILACTION_TYPE, ActionBeanConstant.DETAILACTION_VALUE_ONE);
                            break;
                        case R.id.radio_two:
                            present.updateData(ActionBeanConstant.DETAILACTION_TYPE, ActionBeanConstant.DETAILACTION_VALUE_TWO);
                            break;
                        case R.id.radio_three:
                            present.updateData(ActionBeanConstant.DETAILACTION_TYPE, ActionBeanConstant.DETAILACTION_VALUE_THREE);
                            break;
                        case R.id.radio_four:
                            present.updateData(ActionBeanConstant.DETAILACTION_TYPE, ActionBeanConstant.DETAILACTION_VALUE_FOUR);
                            break;
                    }
                    present.updateUrl();
                });
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
        ActionBean actionBean = dataList.get(position);
        if (actionBean.getHasFixedValues()) {
            return FourChoicesViewHolder.FOUR_CHOICES_VIEW_HOLDER_VIEW_TYPE;
        };
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
