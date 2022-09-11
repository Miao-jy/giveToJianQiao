package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

public class OpenHalfEncodeUrl extends ActionBean<String> implements IAction<String> {

    public OpenHalfEncodeUrl() {
        this.type = ActionBeanConstant.OPEN_HALF_ENCODE_URL_TYPE;
        this.key = ActionBeanConstant.OPEN_HALF_ENCODE_URL_KEY;
        this.description = ActionBeanConstant.OPEN_HALF_ENCODE_URL_DESCRIPTION;
        this.version = ActionBeanConstant.OPEN_HALF_ENCODE_URL_VERSION;
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
