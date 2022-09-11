package com.youku.schemeurl.ui;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youku.schemeurl.R;
import com.youku.schemeurl.model.constant.ActionBeanConstant;
import com.youku.schemeurl.present.Present;
import com.youku.schemeurl.present.PresentImpl;
import com.youku.schemeurl.ui.adapter.ParamRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements MyView, View.OnClickListener{

    private Present present;
    private RecyclerView recyclerView;
    private TextView urlText;
    private ImageView imageView;
    private Button jumpToUrlButton;
    private Button shareUrlButton;
    private Button copyButton;
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
        jumpToUrlButton = findViewById(R.id.jumpToUrl);
        shareUrlButton = findViewById(R.id.share);
        copyButton = findViewById(R.id.copy);
        jumpToUrlButton.setOnClickListener(this);
        shareUrlButton.setOnClickListener(this);
        copyButton.setOnClickListener(this);

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
            case R.id.jumpToUrl:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlText.getText().toString()));
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(this, "跳转失败", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.share:
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.setType("text/plain");//设置分享内容的类型
                share.putExtra(Intent.EXTRA_TEXT, urlText.getText().toString());//添加分享内容
                //创建分享的Dialog
                startActivity(Intent.createChooser(share, ""));
                break;
            case R.id.copy:
                ClipboardManager clipManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);//获取剪切板管理对象
                ClipData clipData = ClipData.newPlainText("copy text", urlText.getText().toString());//将数据放到clip对象
                clipManager.setPrimaryClip(clipData);//将clip对象放到剪切板
                Toast.makeText(this, "已复制", Toast.LENGTH_LONG).show();
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
            String description = present.getDescription().get(position);
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