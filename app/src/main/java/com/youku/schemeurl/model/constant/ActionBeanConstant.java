package com.youku.schemeurl.model.constant;

import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.actionBeans.SourceActionBean;
import com.youku.schemeurl.model.actionBeans.VidActionBean;

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
    public static final String DETAILACTION_DESCRIPTION = "详情页动作\nstartComment:打开评论\n" +
            "startStarCard:打开某明星半屏卡片\nstartCache:打开缓存\nstartH5:打开半屏H5";
    public static final String DETAILACTION_VERSION = "1.0";
    public static final String DETAILACTION_VALUE_ONE = "startComment";
    public static final String DETAILACTION_VALUE_TWO = "startStarCard";
    public static final String DETAILACTION_VALUE_THREE = "startCache";
    public static final String DETAILACTION_VALUE_FOUR = "startH5";

    public static final int FORCE_OPEN_DANMU_TYPE = 105;
    public static final String FOUCE_OPEN_DANMU_KEY = "forceOpenDanmu";
    public static final String FOUCE_OPEN_DANMU_DESCRIPTION = "弹幕设置,true开启，false关闭";
    public static final String FOUCE_OPEN_DANMU_VERSION = "1.0";
    public static final String FOUCE_OPEN_DANMU_VALUE_ONE = "true";
    public static final String FOUCE_OPEN_DANMU_VALUE_TWO = "false";

    public static final int OPEN_HALF_URL_TYPE = 106;
    public static final String OPEN_HALF_URL_KEY = "openHalfUrl";
    public static final String OPEN_HALF_URL_DESCRIPTION = "打开半屏H5的url";
    public static final String OPEN_HALF_URL_VERSION = "1.0";

    public static final int OPEN_HALF_ENCODE_URL_TYPE = 107;
    public static final String OPEN_HALF_ENCODE_URL_KEY = "openHalfEncodeUrl";
    public static final String OPEN_HALF_ENCODE_URL_DESCRIPTION = "打开半屏H5且需要Encode的url";
    public static final String OPEN_HALF_ENCODE_URL_VERSION = "1.0";

    public static final int AK_TYPE = 108;
    public static final String AK_KEY = "ak";
    public static final String AK_DESCRIPTION = "免流参数";
    public static final String AK_VERSION = "1.0";

    public static final int POINT_TYPE = 109;
    public static final String POINT_KEY = "point";
    public static final String POINT_DESCRIPTION = "指定起播时间(秒)";
    public static final String POINT_VERSION = "1.0";

    public static final int BACK_FINISH_TYPE = 110;
    public static final String BACK_FINISH_KEY = "backFinish";
    public static final String BACK_FINISH_DESCRIPTION = "换端启动播放页\nfalse为引导到首页\nture表示不引导到首页";
    public static final String BACK_FINISH_VERSION = "1.0";
    public static final String BACK_FINISH_VALUE_ONE = "true";
    public static final String BACK_FINISH_VALUE_TWO = "false";

    public static final int POLITICS_SENSITIVE_TYPE = 111;
    public static final String POLITICS_SENSITIVE_KEY = "politicsSensitive";
    public static final String POLITICS_SENSITIVE_DESCRIPTION = "政治敏感\nfalse默认不传\nture表示判定为政治敏感";
    public static final String POLITICS_SENSITIVE_VERSION = "1.0";
    public static final String POLITICS_SENSITIVE_VALUE_ONE = "true";
    public static final String POLITICS_SENSITIVE_VALUE_TWO = "false";

    public static final int PLAY_MODE_TYPE = 112;
    public static final String PLAY_MODE_KEY = "playMode";
    public static final String PLAY_MODE_DESCRIPTION = "播放设定画面\ncontentSurvey:观影会\n" +
            "pugv:中视频播放页\ndsp:换端播放页";
    public static final String PLAY_MODE_VERSION = "1.0";
    public static final String PLAY_MODE_VALUE_ONE = "contentSurvey";
    public static final String PLAY_MODE_VALUE_TWO = "pugv";
    public static final String PLAY_MODE_VALUE_THREE = "dsp";

    public static final int CONTENT_SURVEY_ID_TYPE = 113;
    public static final String CONTENT_SURVEY_ID_KEY = "contentSurveyId";
    public static final String CONTENT_SURVEY_ID_DESCRIPTION = "观影会ID";
    public static final String CONTENT_SURVEY_ID_VERSION = "1.0";

    public static Map<Integer, List<String>> map = new HashMap<>();

    static {
        map.put(SOURCE_TYPE, Arrays.asList(SOURCE_KEY, SOURCE_DESCRIPTION, SOURCE_VERSION));
        map.put(VID_TYPE, Arrays.asList(VID_KEY, VID_DESCRIPTION, VID_VERSION));
        map.put(SHOWID_TYPE, Arrays.asList(SHOWID_KEY, SHOWID_DESCRIPTION, SHOWID_VERSION));
        map.put(DETAILACTION_TYPE, Arrays.asList(DETAILACTION_KEY, DETAILACTION_DESCRIPTION, DETAILACTION_VERSION));
        map.put(FORCE_OPEN_DANMU_TYPE, Arrays.asList(FOUCE_OPEN_DANMU_KEY, FOUCE_OPEN_DANMU_DESCRIPTION, FOUCE_OPEN_DANMU_VERSION));
        map.put(OPEN_HALF_URL_TYPE, Arrays.asList(OPEN_HALF_URL_KEY, OPEN_HALF_URL_DESCRIPTION, OPEN_HALF_URL_VERSION));
        map.put(OPEN_HALF_ENCODE_URL_TYPE, Arrays.asList(OPEN_HALF_ENCODE_URL_KEY, OPEN_HALF_ENCODE_URL_DESCRIPTION, OPEN_HALF_ENCODE_URL_VERSION));
        map.put(AK_TYPE, Arrays.asList(AK_KEY, AK_DESCRIPTION, AK_VERSION));
//        map.put(POINT_TYPE, Arrays.asList(POINT_KEY, POINT_DESCRIPTION, POINT_VERSION));
        map.put(BACK_FINISH_TYPE, Arrays.asList(BACK_FINISH_KEY, BACK_FINISH_DESCRIPTION, BACK_FINISH_VERSION));
        map.put(POLITICS_SENSITIVE_TYPE, Arrays.asList(POLITICS_SENSITIVE_KEY, POLITICS_SENSITIVE_DESCRIPTION, POLITICS_SENSITIVE_VERSION));
        map.put(PLAY_MODE_TYPE, Arrays.asList(PLAY_MODE_KEY, PLAY_MODE_DESCRIPTION, PLAY_MODE_VERSION));
        map.put(CONTENT_SURVEY_ID_TYPE, Arrays.asList(CONTENT_SURVEY_ID_KEY, CONTENT_SURVEY_ID_DESCRIPTION, CONTENT_SURVEY_ID_VERSION));

    }

    public static List<Integer> getAllTypeList() {
        ArrayList<Integer> typeList = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry: map.entrySet()) {
            typeList.add(entry.getKey());
        }
        return typeList;
    }

    public static List<ActionBean<?>> getAllActionBeanList() {
        List<ActionBean<?>> actionBeanList = new ArrayList<>();
        actionBeanList.add(new SourceActionBean());
        actionBeanList.add(new VidActionBean());
        return actionBeanList;
    }


    public static List<String> getAllDescriptionList() {
        ArrayList<String> descriptionList = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            if (entry.getKey() == SOURCE_TYPE
                    || entry.getKey() == VID_TYPE
                    || entry.getKey() == OPEN_HALF_URL_TYPE
                    || entry.getKey() == OPEN_HALF_ENCODE_URL_TYPE
                    || entry.getKey() == CONTENT_SURVEY_ID_TYPE) continue;
            descriptionList.add(entry.getValue().get(1));
        }
        return descriptionList;
    }

    public static List<Integer> getAllDisLongRemoveOrClickAddList() {
        ArrayList<Integer> disLongRemoveOrClickAddList = new ArrayList<>();
        disLongRemoveOrClickAddList.add(SOURCE_TYPE);
        disLongRemoveOrClickAddList.add(VID_TYPE);
        disLongRemoveOrClickAddList.add(OPEN_HALF_URL_TYPE);
        disLongRemoveOrClickAddList.add(OPEN_HALF_ENCODE_URL_TYPE);
        disLongRemoveOrClickAddList.add(CONTENT_SURVEY_ID_TYPE);
        return disLongRemoveOrClickAddList;
    }


    //Model层不应直接和MainActivity交互，这两个方法不应让ui拿到，移植到presentLmpl中
    public static int descriptionToType(String description) {
        for (Map.Entry<Integer, List<String>> entry: map.entrySet()) {
            if (entry.getValue().get(1).equals(description)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static String typeToDescription(int type) {
        for (Map.Entry<Integer, List<String>> entry: map.entrySet()) {
            if (entry.getKey() == type) {
                return entry.getValue().get(1);
            }
        }
        return "";
    }

}
