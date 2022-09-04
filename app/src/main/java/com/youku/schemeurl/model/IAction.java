package com.youku.schemeurl.model;

public interface IAction<T> {

    void input (T value);

    T getParam();
}
