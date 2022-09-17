package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

import java.util.ArrayList;

public class PlayModeActionBean extends ActionBean<String> implements IAction<String> {

    public PlayModeActionBean() {
        this.type = ActionBeanConstant.PLAY_MODE_TYPE;
        this.key = ActionBeanConstant.PLAY_MODE_KEY;
        this.description = ActionBeanConstant.PLAY_MODE_DESCRIPTION;
        this.version = ActionBeanConstant.PLAY_MODE_VERSION;
        this.hasFixedValues = true;
        ArrayList<String> options = new ArrayList<>();
        options.add(ActionBeanConstant.PLAY_MODE_VALUE_ONE);
        options.add(ActionBeanConstant.PLAY_MODE_VALUE_TWO);
        options.add(ActionBeanConstant.PLAY_MODE_VALUE_THREE);
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

