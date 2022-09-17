package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;


public class PointActionBean extends ActionBean<Integer> implements IAction<Integer> {

    public PointActionBean() {
        this.type = ActionBeanConstant.POINT_TYPE;
        this.key = ActionBeanConstant.POINT_KEY;
        this.description = ActionBeanConstant.POINT_DESCRIPTION;
        this.version = ActionBeanConstant.POINT_VERSION;
        this.hasFixedValues = false;
    }

    @Override
    public void input(Integer value) {
        setValue(value);
    }

    @Override
    public Integer getParam() {
        return getValue();
    }
}
