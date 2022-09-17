package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

import java.util.ArrayList;

public class BackFinishActionBean extends ActionBean<Boolean> implements IAction<Boolean> {

    public BackFinishActionBean() {
        this.type = ActionBeanConstant.BACK_FINISH_TYPE;
        this.key = ActionBeanConstant.BACK_FINISH_KEY;
        this.description = ActionBeanConstant.BACK_FINISH_DESCRIPTION;
        this.version = ActionBeanConstant.BACK_FINISH_VERSION;
        this.hasFixedValues = true;
        ArrayList<String> options = new ArrayList<>();
        options.add(ActionBeanConstant.BACK_FINISH_VALUE_ONE);
        options.add(ActionBeanConstant.BACK_FINISH_VALUE_TWO);
        this.fixedValues = options;
    }

    @Override
    public void input(Boolean value) {
        setValue(value);
    }

    @Override
    public Boolean getParam() {
        return getValue();
    }
}