package com.youku.schemeurl.present;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.ActionBeanHolder;
import com.youku.schemeurl.model.Model;
import com.youku.schemeurl.ui.MyView;

import java.util.List;

public class PresentImpl implements Present {

    private final Model model = new ActionBeanHolder();

    private final MyView myView;

    public PresentImpl(MyView myView) {
        this.myView = myView;
    }

    @Override
    public List<ActionBean<?>> getDataList() {
        return this.model.getActionBeanList();
    }

    @Override
    public void updateData(int type, String value) {
        this.model.updateActionBean(type, value);
    }

    @Override
    public void insertData(int type) {
        this.model.insertActionBean(type);
    }

    @Override
    public void deleteData(int type) {
        this.model.deleteActionBean(type);
    }

    public String getUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append("youku://play?");
        List<ActionBean<?>> actionBeanList = this.model.getActionBeanList();
        for (int i = 0; i < actionBeanList.size(); i++) {
            ActionBean<?> actionBean = actionBeanList.get(i);
            sb.append(actionBean.getKey()).append("=").append(actionBean.getValue());
            if(i != actionBeanList.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    @Override
    public void updateUrl() {
        String url = getUrl();
        this.myView.setUrlText(url);
    }
}
