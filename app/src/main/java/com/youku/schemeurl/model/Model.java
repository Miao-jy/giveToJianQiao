package com.youku.schemeurl.model;

import java.util.List;

public interface Model {

    List<ActionBean<?>> getActionBeanList();

    void updateActionBean(int type, String value);

    void insertActionBean(int type);

    void deleteActionBean(int type);
}
