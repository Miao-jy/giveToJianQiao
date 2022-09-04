package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

public class VidActionBean extends ActionBean<String> implements IAction<String> {

    public VidActionBean() {
        this.type = ActionBeanConstant.VID_TYPE;
        this.key = ActionBeanConstant.VID_KEY;
        this.description = ActionBeanConstant.VID_DESCRIPTION;
        this.version = ActionBeanConstant.VID_VERSION;
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
