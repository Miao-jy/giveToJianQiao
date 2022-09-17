package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;


public class AkActionBean extends ActionBean<String> implements IAction<String> {

    public AkActionBean() {
        this.type = ActionBeanConstant.AK_TYPE;
        this.key = ActionBeanConstant.AK_KEY;
        this.description = ActionBeanConstant.AK_DESCRIPTION;
        this.version = ActionBeanConstant.AK_VERSION;
        this.hasFixedValues = false;
    }

    @Override
    public void input(String value) {
        setValue(value);
    }

    @Override
    public String getParam() {
        return getValue();
    }
}