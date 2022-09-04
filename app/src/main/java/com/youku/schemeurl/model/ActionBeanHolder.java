package com.youku.schemeurl.model;

import com.youku.schemeurl.model.actionBeans.DetailActionActionBean;
import com.youku.schemeurl.model.actionBeans.ShowidActionBean;
import com.youku.schemeurl.model.actionBeans.SourceActionBean;
import com.youku.schemeurl.model.actionBeans.VidActionBean;
import com.youku.schemeurl.model.constant.ActionBeanConstant;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ActionBeanHolder implements Model{

    // 存放要用于生成url的actionBean实例对象
    private final List<ActionBean<?>> actionBeanList = new ArrayList<>();

    public ActionBeanHolder() {
        // 默认两个必选参数
        actionBeanList.add(new SourceActionBean());
        actionBeanList.add(new VidActionBean());
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
        actionBeanList.forEach( actionBean -> {
            if (actionBean.getType() == type) {
                ParameterizedType type1 = (ParameterizedType) actionBean.getClass().getGenericSuperclass();
                Type actualTypeArgument = type1.getActualTypeArguments()[0];
                if (String.class.equals(actualTypeArgument)) {
                    ActionBean<String> stringBean = (ActionBean<String>) actionBean;
                    stringBean.setValue(value);
                } else if (Boolean.class.equals(actualTypeArgument)) {
                    ActionBean<Boolean> booleanBean = (ActionBean<Boolean>) actionBean;
                    booleanBean.setValue(new Boolean(value));
                } else if (Integer.class.equals(actualTypeArgument)) {
                    ActionBean<Integer> integerBean = (ActionBean<Integer>) actionBean;
                    integerBean.setValue(new Integer(value));
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
}

