package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

public class ShowidActionBean extends ActionBean<String> implements IAction<String> {

    public ShowidActionBean() {
        this.type = ActionBeanConstant.SHOWID_TYPE;
        this.key = ActionBeanConstant.SHOWID_KEY;
        this.description = ActionBeanConstant.SHOWID_DESCRIPTION;
        this.version = ActionBeanConstant.SHOWID_VERSION;
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
