package com.youku.schemeurl.model;

import java.lang.reflect.Type;
import java.util.List;

public interface Model {

    //取到AcioonBeanList
    List<ActionBean<?>> getActionBeanList();

    //更新
    void updateActionBean(int type, String value);

    //增加
    void insertActionBean(int type);

    //删除
    void deleteActionBean(int type);

    //取到加号按钮List
    List<String> getDescriptionList();

    //新增
    void insertDescription(String description);

    //删除
    void deleteDescription(String description);

    //取到长按删除和不在新增按钮Iist中的LIst
    List<Integer> getDisLongRemoveOrClickAddList();

    Type getActionBeanType(int type);
}
