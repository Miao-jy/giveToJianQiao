package com.youku.schemeurl.present;

import com.youku.schemeurl.model.ActionBean;

import java.util.List;

public interface Present {

    List<ActionBean<?>> getDataList();

    void updateData(int type, String value);

    void insertData(int type);

    void deleteData(int type);

    List<String> getDescription();

    void insertDescription(String description);

    void deleteDescription(String description);

    String getUrl();

    void updateUrl();
}
