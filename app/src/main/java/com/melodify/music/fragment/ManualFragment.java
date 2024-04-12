package com.melodify.music.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.melodify.music.R;
import com.melodify.music.adapter.ManualAdapter;
import com.melodify.music.constant.AboutUsConfig;
import com.melodify.music.constant.GlobalFunction;
import com.melodify.music.databinding.FragmentManualBinding;
import com.melodify.music.model.Manual;

import java.util.ArrayList;
import java.util.List;

public class ManualFragment extends Fragment {

    private FragmentManualBinding mFragmentManualBinding;
    private ManualAdapter mManualAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentManualBinding = FragmentManualBinding.inflate(inflater, container, false);

        initUi();
        initListener();

        return mFragmentManualBinding.getRoot();
    }

    private void initUi() {
        mFragmentManualBinding.tvAboutUsTitle.setText(AboutUsConfig.ABOUT_US_TITLE);
        mFragmentManualBinding.tvAboutUsContent.setText(AboutUsConfig.ABOUT_US_CONTENT);
        mFragmentManualBinding.tvAboutUsWebsite.setText(AboutUsConfig.ABOUT_US_WEBSITE_TITLE);

        mManualAdapter = new ManualAdapter(getActivity(), getListManual(),
                () -> GlobalFunction.callPhoneNumber(getActivity()));
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        mFragmentManualBinding.rcvData.setNestedScrollingEnabled(false);
        mFragmentManualBinding.rcvData.setFocusable(false);
        mFragmentManualBinding.rcvData.setLayoutManager(layoutManager);
        mFragmentManualBinding.rcvData.setAdapter(mManualAdapter);
    }

    private void initListener() {
        mFragmentManualBinding.layoutWebsite.setOnClickListener(view
                -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(AboutUsConfig.WEBSITE))));
    }

    public List<Manual> getListManual() {
        List<Manual> manualArrayList = new ArrayList<>();
        manualArrayList.add(new Manual(Manual.FACEBOOK, R.drawable.ic_facebook));
        manualArrayList.add(new Manual(Manual.HOTLINE, R.drawable.ic_hotline));
        manualArrayList.add(new Manual(Manual.GMAIL, R.drawable.ic_gmail));
        manualArrayList.add(new Manual(Manual.SKYPE, R.drawable.ic_skype));
        manualArrayList.add(new Manual(Manual.YOUTUBE, R.drawable.ic_youtube));
        manualArrayList.add(new Manual(Manual.ZALO, R.drawable.ic_zalo));

        return manualArrayList;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mManualAdapter.release();
    }
}
