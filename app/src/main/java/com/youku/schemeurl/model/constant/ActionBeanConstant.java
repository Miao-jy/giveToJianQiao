package com.youku.schemeurl.model.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionBeanConstant {
    public static final int SOURCE_TYPE = 101;
    public static final String SOURCE_KEY = "source";
    public static final String SOURCE_DESCRIPTION = "页面来源";
    public static final String SOURCE_VERSION = "1.0";

    public static final int VID_TYPE = 102;
    public static final String VID_KEY = "vid";
    public static final String VID_DESCRIPTION = "播放指定视频必备参数";
    public static final String VID_VERSION = "1.0";

    public static final int SHOWID_TYPE = 103;
    public static final String SHOWID_KEY = "showid";
    public static final String SHOWID_DESCRIPTION = "播放指定节目必备参数";
    public static final String SHOWID_VERSION = "1.0";

    public static final int DETAILACTION_TYPE = 104;
    public static final String DETAILACTION_KEY = "detail_action";
    public static final String DETAILACTION_DESCRIPTION = "详情页动作";
    public static final String DETAILACTION_VERSION = "1.0";
    public static final String DETAILACTION_VALUE_ONE = "startComment";
    public static final String DETAILACTION_VALUE_TWO = "startStarCard";
    public static final String DETAILACTION_VALUE_THREE = "startCache";
    public static final String DETAILACTION_VALUE_FOUR = "startH5";

    public static Map<Integer, List<String>> map = new HashMap<>();

    static {
        map.put(SOURCE_TYPE, Arrays.asList(SOURCE_KEY, SOURCE_DESCRIPTION, SOURCE_VERSION));
        map.put(VID_TYPE, Arrays.asList(VID_KEY, VID_DESCRIPTION, VID_VERSION));
        map.put(SHOWID_TYPE, Arrays.asList(SHOWID_KEY, SHOWID_DESCRIPTION, SHOWID_VERSION));
        map.put(DETAILACTION_TYPE, Arrays.asList(DETAILACTION_KEY, DETAILACTION_DESCRIPTION, DETAILACTION_VERSION));
    }

    public static List<Integer> getAllTypeList() {
        ArrayList<Integer> typeList = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry: map.entrySet()) {
            typeList.add(entry.getKey());
        }
        return typeList;
    }

    public static List<String> getAllDescriptionList() {
        ArrayList<String> descriptionList = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry: map.entrySet()) {
            descriptionList.add(entry.getValue().get(1));
        }
        return descriptionList;
    }

}
