package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

public class SourceActionBean extends ActionBean<String> implements IAction<String> {

    public SourceActionBean() {
        this.type = ActionBeanConstant.SOURCE_TYPE;
        this.key = ActionBeanConstant.SOURCE_KEY;
        this.description = ActionBeanConstant.SOURCE_DESCRIPTION;
        this.version = ActionBeanConstant.SOURCE_VERSION;
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
