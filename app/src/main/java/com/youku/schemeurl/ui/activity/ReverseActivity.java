package com.youku.schemeurl.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youku.schemeurl.R;
import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.actionBeans.AkActionBean;
import com.youku.schemeurl.model.actionBeans.BackFinishActionBean;
import com.youku.schemeurl.model.actionBeans.ContentSurveyId;
import com.youku.schemeurl.model.actionBeans.DetailActionActionBean;
import com.youku.schemeurl.model.actionBeans.ForceOpenDanmuActionBean;
import com.youku.schemeurl.model.actionBeans.OpenHalfEncodeUrl;
import com.youku.schemeurl.model.actionBeans.OpenHalfUrl;
import com.youku.schemeurl.model.actionBeans.PlayModeActionBean;
import com.youku.schemeurl.model.actionBeans.PointActionBean;
import com.youku.schemeurl.model.actionBeans.PoliticsSensitiveActionBean;
import com.youku.schemeurl.model.actionBeans.ShowidActionBean;
import com.youku.schemeurl.model.actionBeans.SourceActionBean;
import com.youku.schemeurl.model.actionBeans.VidActionBean;
import com.youku.schemeurl.model.constant.ActionBeanConstant;
import com.youku.schemeurl.present.Present;
import com.youku.schemeurl.present.PresentImpl;
import com.youku.schemeurl.ui.adapter.ReverseParamRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ReverseActivity extends AppCompatActivity {

    private RecyclerView reverseRecyclerView;
    private EditText reverseUrlEditText;
    private ReverseParamRecyclerViewAdapter reverseParamRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse);
        initView();
    }

    private void initView() {
        reverseParamRecyclerViewAdapter = new ReverseParamRecyclerViewAdapter();
        reverseRecyclerView = findViewById(R.id.reverseRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reverseRecyclerView.setLayoutManager(linearLayoutManager);
        reverseRecyclerView.setAdapter(reverseParamRecyclerViewAdapter);

        reverseUrlEditText = findViewById(R.id.reverseUrlEditText);
        reverseUrlEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                reverseUrl(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void reverseUrl(String url) {
        if (url == null || url.isEmpty()) {
            return;
        }

        String[] splitByQuestion = url.split("\\?");
        if (splitByQuestion.length < 2) {
            return;
        }

        String[] params = splitByQuestion[1].split("&");
        if (params.length < 1) {
            return;
        }

        List<ActionBean<?>> actionBeanList = new ArrayList<>();
        for (String param : params) {
            String[] keyAndValue = param.split("=");
            if (keyAndValue.length < 2) {
                return;
            }
            String key = keyAndValue[0];
            String value = keyAndValue[1];

            switch (key) {
                case ActionBeanConstant.SOURCE_KEY:
                    SourceActionBean sourceActionBean = new SourceActionBean();
                    sourceActionBean.input(value);
                    actionBeanList.add(sourceActionBean);
                    break;
                case ActionBeanConstant.VID_KEY:
                    VidActionBean vidActionBean = new VidActionBean();
                    vidActionBean.input(value);
                    actionBeanList.add(vidActionBean);
                    break;
                case ActionBeanConstant.SHOWID_KEY:
                    ShowidActionBean showidActionBean = new ShowidActionBean();
                    showidActionBean.input(value);
                    actionBeanList.add(showidActionBean);
                    break;
                case ActionBeanConstant.DETAILACTION_KEY:
                    DetailActionActionBean detailActionActionBean = new DetailActionActionBean();
                    detailActionActionBean.input(value);
                    actionBeanList.add(detailActionActionBean);
                    break;
                case ActionBeanConstant.FOUCE_OPEN_DANMU_KEY:
                    ForceOpenDanmuActionBean forceOpenDanmuActionBean = new ForceOpenDanmuActionBean();
                    forceOpenDanmuActionBean.input(Boolean.valueOf(value));
                    actionBeanList.add(forceOpenDanmuActionBean);
                    break;
                case ActionBeanConstant.OPEN_HALF_URL_KEY:
                    OpenHalfUrl openHalfUrl = new OpenHalfUrl();
                    openHalfUrl.input(value);
                    actionBeanList.add(openHalfUrl);
                    break;
                case ActionBeanConstant.OPEN_HALF_ENCODE_URL_KEY:
                    OpenHalfEncodeUrl openHalfEncodeUrl = new OpenHalfEncodeUrl();
                    openHalfEncodeUrl.input(value);
                    actionBeanList.add(openHalfEncodeUrl);
                    break;
                case ActionBeanConstant.AK_KEY:
                    AkActionBean akActionBean = new AkActionBean();
                    akActionBean.input(value);
                    actionBeanList.add(akActionBean);
                    break;
                case ActionBeanConstant.POINT_KEY:
                    PointActionBean pointActionBean = new PointActionBean();
                    pointActionBean.input(Integer.valueOf(value));
                    actionBeanList.add(pointActionBean);
                    break;
                case ActionBeanConstant.BACK_FINISH_KEY:
                    BackFinishActionBean backFinishActionBean = new BackFinishActionBean();
                    backFinishActionBean.input(Boolean.valueOf(value));
                    actionBeanList.add(backFinishActionBean);
                    break;
                case ActionBeanConstant.POLITICS_SENSITIVE_KEY:
                    PoliticsSensitiveActionBean politicsSensitiveActionBean = new PoliticsSensitiveActionBean();
                    politicsSensitiveActionBean.input(Boolean.valueOf(value));
                    actionBeanList.add(politicsSensitiveActionBean);
                    break;
                case ActionBeanConstant.PLAY_MODE_KEY:
                    PlayModeActionBean playModeActionBean = new PlayModeActionBean();
                    playModeActionBean.input(value);
                    actionBeanList.add(playModeActionBean);
                    break;
                case ActionBeanConstant.CONTENT_SURVEY_ID_KEY:
                    ContentSurveyId contentSurveyId = new ContentSurveyId();
                    contentSurveyId.input(value);
                    actionBeanList.add(contentSurveyId);
                    break;
            }
        }

        reverseParamRecyclerViewAdapter.setDataList(actionBeanList);

    }
}