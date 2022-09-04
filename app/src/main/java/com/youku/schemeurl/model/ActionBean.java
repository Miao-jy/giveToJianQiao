package com.youku.schemeurl.model;

import java.util.List;

public abstract class ActionBean<T> {
    protected int type;
    protected String key;
    protected T value;
    protected String description;
    protected String version;
    protected Boolean hasFixedValues;
    protected List<String> fixedValues;

    public int getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public Boolean getHasFixedValues() {
        return hasFixedValues;
    }

    public List<String> getFixedValues() {
        return fixedValues;
    }

}
