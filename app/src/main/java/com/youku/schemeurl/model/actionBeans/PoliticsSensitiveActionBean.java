package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

import java.util.ArrayList;


public class PoliticsSensitiveActionBean extends ActionBean<Boolean> implements IAction<Boolean> {

    public PoliticsSensitiveActionBean() {
        this.type = ActionBeanConstant.POLITICS_SENSITIVE_TYPE;
        this.key = ActionBeanConstant.POLITICS_SENSITIVE_KEY;
        this.description = ActionBeanConstant.POLITICS_SENSITIVE_DESCRIPTION;
        this.version = ActionBeanConstant.POLITICS_SENSITIVE_VERSION;
        this.hasFixedValues = true;
        ArrayList<String> options = new ArrayList<>();
        options.add(ActionBeanConstant.POLITICS_SENSITIVE_VALUE_ONE);
        options.add(ActionBeanConstant.POLITICS_SENSITIVE_VALUE_TWO);
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