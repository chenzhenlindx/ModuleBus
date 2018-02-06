package com.cangwang.anchor;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cangwang.anchor.dialog.AnchorDialog;
import com.cangwang.annotation.ModuleGroup;
import com.cangwang.annotation.ModuleUnit;
import com.cangwang.core.cwmodule.CWModuleContext;
import com.cangwang.core.cwmodule.ex.CWBasicExModule;
import com.cangwang.enums.LayoutLevel;

/**
 * 信息页
 * Created by cangwang on 2018/2/6.
 */
@ModuleGroup({
        @ModuleUnit(templet = "top",layoutlevel = LayoutLevel.HIGHT),
})
public class AnchorModule extends CWBasicExModule{
    private View anchorLayout;
    private ImageView anchorImg;
    private TextView anchorName;
    private ImageView anchorCareBtn;

    @Override
    public boolean init(CWModuleContext moduleContext, Bundle extend) {
        super.init(moduleContext, extend);
        initView();
        return true;
    }

    private void initView(){
        anchorLayout = LayoutInflater.from(context).inflate(R.layout.anchor_title_layout,parentTop,true);
        anchorImg = (ImageView) anchorLayout.findViewById(R.id.anchor_img);
        anchorName = (TextView) anchorLayout.findViewById(R.id.anchor_name);
        anchorCareBtn = (ImageView) anchorLayout.findViewById(R.id.anchor_care_btn);

        anchorCareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(context.getSupportFragmentManager());
            }
        });
    }

    private void showDialog(FragmentManager manager) {
        if (!AnchorDialog.isAnchorDialogShow) {
            AnchorDialog.isAnchorDialogShow = true;
            AnchorDialog anchorDialog = AnchorDialog.newInstance();
            anchorDialog.show(manager, AnchorDialog.TAG);
        }
    }
}
