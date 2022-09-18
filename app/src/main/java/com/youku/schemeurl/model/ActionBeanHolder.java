package com.youku.schemeurl.model;

import com.youku.schemeurl.model.actionBeans.AkActionBean;
import com.youku.schemeurl.model.actionBeans.BackFinishActionBean;
import com.youku.schemeurl.model.actionBeans.ContentSurveyId;
import com.youku.schemeurl.model.actionBeans.DetailActionActionBean;
import com.youku.schemeurl.model.actionBeans.ForceOpenDanmuActionBean;
import com.youku.schemeurl.model.actionBeans.OpenHalfEncodeUrl;
import com.youku.schemeurl.model.actionBeans.OpenHalfUrl;
import com.youku.schemeurl.model.actionBeans.PlayModeActionBean;
import com.youku.schemeurl.model.actionBeans.PointActionBean;
import com.youku.schemeurl.model.actionBeans.PoliticsSensitiveActionBean;
import com.youku.schemeurl.model.actionBeans.ShowidActionBean;
import com.youku.schemeurl.model.actionBeans.SourceActionBean;
import com.youku.schemeurl.model.actionBeans.VidActionBean;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ActionBeanHolder implements Model{

    // 存放要用于生成url的actionBean实例对象
    private final List<ActionBean<?>> actionBeanList;
    // 存放加号对应的list
    private final List<String> descriptionList;
    // 不能长按删除，和不能点击新增的list
    private final List<Integer> disLongRemoveOrClickAddList;

    public ActionBeanHolder() {
        // 默认两个必选参数
        actionBeanList = ActionBeanConstant.getAllActionBeanList();
        descriptionList = ActionBeanConstant.getAllDescriptionList();
        disLongRemoveOrClickAddList = ActionBeanConstant.getAllDisLongRemoveOrClickAddList();
    }

    @Override
    public List<ActionBean<?>> getActionBeanList() {
        return this.actionBeanList;
    }

    /**
     * 更新bean里面数据，使用反射获取泛型进行判断。
     */
    @Override
    public void updateActionBean(int type, String value) {
        Type actualTypeArgument = getActionBeanType(type);
        actionBeanList.forEach(actionBean -> {
            if (actionBean.getType() == type) {
                if (String.class.equals(actualTypeArgument)) {
                    ActionBean<String> stringBean = (ActionBean<String>) actionBean;
                    stringBean.setValue(value);
                } else if (Boolean.class.equals(actualTypeArgument)) {
                    ActionBean<Boolean> booleanBean = (ActionBean<Boolean>) actionBean;
                    booleanBean.setValue(Boolean.valueOf(value));
                } else if (Integer.class.equals(actualTypeArgument)) {
                    ActionBean<Integer> integerBean = (ActionBean<Integer>) actionBean;
                    integerBean.setValue(Integer.valueOf(value));
                }
            }
        });
    }

    @Override
    public void insertActionBean(int type) {
        if (hasActionBean(type)) {
            return;
        }
        switch (type) {
            case ActionBeanConstant.SHOWID_TYPE:
                actionBeanList.add(new ShowidActionBean());
                break;
            case ActionBeanConstant.DETAILACTION_TYPE:
                actionBeanList.add(new DetailActionActionBean());
                break;
            case ActionBeanConstant.FORCE_OPEN_DANMU_TYPE:
                actionBeanList.add(new ForceOpenDanmuActionBean());
                break;
            case ActionBeanConstant.OPEN_HALF_URL_TYPE:
                actionBeanList.add(new OpenHalfUrl());
                break;
            case ActionBeanConstant.OPEN_HALF_ENCODE_URL_TYPE:
                actionBeanList.add(new OpenHalfEncodeUrl());
                break;
            case ActionBeanConstant.AK_TYPE:
                actionBeanList.add(new AkActionBean());
                break;
            case ActionBeanConstant.POINT_TYPE:
                actionBeanList.add(new PointActionBean());
                break;
            case ActionBeanConstant.BACK_FINISH_TYPE:
                actionBeanList.add(new BackFinishActionBean());
                break;
            case ActionBeanConstant.POLITICS_SENSITIVE_TYPE:
                actionBeanList.add(new PoliticsSensitiveActionBean());
                break;
            case ActionBeanConstant.PLAY_MODE_TYPE:
                actionBeanList.add(new PlayModeActionBean());
                break;
            case ActionBeanConstant.CONTENT_SURVEY_ID_TYPE:
                actionBeanList.add(new ContentSurveyId());
                break;
        }
    }

    @Override
    public void deleteActionBean(int type) {
        for (int i = 0; i < actionBeanList.size(); i++) {
            if (actionBeanList.get(i).getType() == type) {
                actionBeanList.remove(i);
                break;
            }
        }
    }

    @Override
    public List<String> getDescriptionList() {
        return this.descriptionList;
    }

    @Override
    public void insertDescription(String description) {
        for (String d : descriptionList) {
            if (d.equals(description)) return;
        }
        this.descriptionList.add(description);
    }

    @Override
    public void deleteDescription(String description) {
        this.descriptionList.remove(description);
    }

    @Override
    public List<Integer> getDisLongRemoveOrClickAddList() {
        return this.disLongRemoveOrClickAddList;
    }

    /**
     * actionBeanList如果已经存在actionBean，不重复添加
     * true 存在
     * false 不存在
     */
    private Boolean hasActionBean(int type) {
        for (ActionBean<?> actionBean : actionBeanList) {
            if (actionBean.getType() == type) {
                return true;
            }
        }
        return false;
    }

    /**
     *  根据type获取actionBean的类型
     */
    @Override
    public Type getActionBeanType(int type) {
        for (ActionBean<?> actionBean : actionBeanList) {
            if (actionBean.getType() == type) {
                ParameterizedType type1 = (ParameterizedType) actionBean.getClass().getGenericSuperclass();
                if (type1 != null) {
                    return type1.getActualTypeArguments()[0];
                }
            }
        }
        return null;
    }
}

