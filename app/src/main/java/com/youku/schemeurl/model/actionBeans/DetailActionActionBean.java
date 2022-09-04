package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

import java.util.ArrayList;


public class DetailActionActionBean extends ActionBean<String> implements IAction<String> {

    public DetailActionActionBean() {
        this.type = ActionBeanConstant.DETAILACTION_TYPE;
        this.key = ActionBeanConstant.DETAILACTION_KEY;
        this.description = ActionBeanConstant.DETAILACTION_DESCRIPTION;
        this.version = ActionBeanConstant.DETAILACTION_VERSION;
        this.hasFixedValues = true;
        ArrayList<String> options = new ArrayList<>();
        options.add(ActionBeanConstant.DETAILACTION_VALUE_ONE);
        options.add(ActionBeanConstant.DETAILACTION_VALUE_TWO);
        options.add(ActionBeanConstant.DETAILACTION_VALUE_THREE);
        options.add(ActionBeanConstant.DETAILACTION_VALUE_FOUR);
        this.fixedValues = options;
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

