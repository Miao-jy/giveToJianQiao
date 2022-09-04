package com.youku.schemeurl.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.youku.schemeurl.R;
import com.youku.schemeurl.model.ActionBean;
import com.youku.schemeurl.model.constant.ActionBeanConstant;
import com.youku.schemeurl.present.Present;
import com.youku.schemeurl.present.PresentImpl;
import com.youku.schemeurl.ui.adapter.ParamRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyView, View.OnClickListener{

    private Present present;
    private RecyclerView recyclerView;
    private TextView urlText;
    private ImageView imageView;
    private ParamRecyclerViewAdapter paramRecyclerViewAdapter;

    /** popup窗口 */
    private PopupWindow typeSelectPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        present = new PresentImpl(this);
        recyclerView = findViewById(R.id.paramRecyclerView);
        urlText = findViewById(R.id.urlText);
        imageView = findViewById(R.id.addButton);
        imageView.setOnClickListener(this);

        paramRecyclerViewAdapter = new ParamRecyclerViewAdapter(present);
        paramRecyclerViewAdapter.setOnRemoveListener(type -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("确定删除?");
            builder.setTitle("提示");
            builder.setPositiveButton("确定", (dialog, which) -> {
                present.deleteData(type);
                paramRecyclerViewAdapter.updateDataList();
                present.insertDescription(ActionBeanConstant.typeToDescription(type));
            });
            builder.setNegativeButton("取消", ((dialog, which) -> {}));
            builder.create().show();
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(paramRecyclerViewAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        urlText.setText(present.getUrl());
    }

    @Override
    public void setUrlText(String url) {
        urlText.setText(url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addButton:
                // 点击控件后显示popup窗口
                initSelectPopup();
                // 使用isShowing()检查popup窗口是否在显示状态
                if (typeSelectPopup != null && !typeSelectPopup.isShowing()) {
                    typeSelectPopup.showAsDropDown(imageView, 0, 10);
                }
                break;
        }
    }

    /**
     * 初始化popup窗口
     */
    private void initSelectPopup() {
        ListView listView = new ListView(this);
        ArrayAdapter<String> testDataAdapter = new ArrayAdapter<>(this, R.layout.popup_text_item, present.getDescription());
        listView.setAdapter(testDataAdapter);

        // 设置ListView点击事件监听
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // 在这里获取item数据
            String description = ActionBeanConstant.getAllDescriptionList().get(position);
            int type = ActionBeanConstant.descriptionToType(description);
            present.insertData(type);
            paramRecyclerViewAdapter.updateDataList();
            present.deleteDescription(description);
//            testDataAdapter.notifyDataSetChanged();
            // 选择完后关闭popup窗口
            typeSelectPopup.dismiss();
        });
        typeSelectPopup = new PopupWindow(listView, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        // 取得popup窗口的背景图片
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.bg_corner);
        typeSelectPopup.setBackgroundDrawable(drawable);
        typeSelectPopup.setFocusable(true);
        typeSelectPopup.setOutsideTouchable(true);
        typeSelectPopup.setOnDismissListener(() -> {
            // 关闭popup窗口
            typeSelectPopup.dismiss();
        });
    }
}