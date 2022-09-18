package com.youku.schemeurl.present;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.ActionBeanHolder;
import com.youku.schemeurl.model.Model;
import com.youku.schemeurl.model.constant.ActionBeanConstant;
import com.youku.schemeurl.ui.MyView;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<String> getDescription() {
        return this.model.getDescriptionList();
    }

    @Override
    public void insertDescription(String description) {
        this.model.insertDescription(description);
    }

    @Override
    public void deleteDescription(String description) {
        this.model.deleteDescription(description);
    }

    @Override
    public List<Integer> getDisLongRemoveOrClickAdd() {
        return this.model.getDisLongRemoveOrClickAddList();
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
    public int descriptionToType(String description) {
        for (Map.Entry<Integer, List<String>> entry : ActionBeanConstant.map.entrySet()) {
            if (entry.getValue().get(1).equals(description)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    @Override
    public String typeToDescription(int type) {
        for (Map.Entry<Integer, List<String>> entry : ActionBeanConstant.map.entrySet()) {
            if (entry.getKey() == type) {
                return entry.getValue().get(1);
            }
        }
        return "";
    }

    @Override
    public void updateUrl() {
        String url = getUrl();
        this.myView.setUrlText(url);
    }
}
