package com.youku.schemeurl.model.actionBeans;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.IAction;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

public class ContentSurveyId extends ActionBean<String> implements IAction<String> {

    public ContentSurveyId() {
        this.type = ActionBeanConstant.CONTENT_SURVEY_ID_TYPE;
        this.key = ActionBeanConstant.CONTENT_SURVEY_ID_KEY;
        this.description = ActionBeanConstant.CONTENT_SURVEY_ID_DESCRIPTION;
        this.version = ActionBeanConstant.CONTENT_SURVEY_ID_VERSION;
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
