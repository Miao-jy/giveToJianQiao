package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

import java.util.ArrayList;

public class ForceOpenDanmuActionBean extends ActionBean<Boolean> implements IAction<Boolean> {

    public ForceOpenDanmuActionBean() {
        this.type = ActionBeanConstant.FORCE_OPEN_DANMU_TYPE;
        this.key = ActionBeanConstant.FOUCE_OPEN_DANMU_KEY;
        this.description = ActionBeanConstant.FOUCE_OPEN_DANMU_DESCRIPTION;
        this.version = ActionBeanConstant.FOUCE_OPEN_DANMU_VERSION;
        this.hasFixedValues = true;
        ArrayList<String> options = new ArrayList<>();
        options.add(ActionBeanConstant.FOUCE_OPEN_DANMU_VALUE_ONE);
        options.add(ActionBeanConstant.FOUCE_OPEN_DANMU_VALUE_TWO);
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
