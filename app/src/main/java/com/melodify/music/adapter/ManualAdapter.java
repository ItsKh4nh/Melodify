package com.melodify.music.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.melodify.music.R;
import com.melodify.music.constant.GlobalFunction;
import com.melodify.music.databinding.ItemManualBinding;
import com.melodify.music.model.Manual;

import java.util.List;

public class ManualAdapter extends RecyclerView.Adapter<ManualAdapter.ManualViewHolder> {

    private Context context;
    private final List<Manual> listManual;
    private final ICallPhone iCallPhone;

    public interface ICallPhone {
        void onClickCallPhone();
    }

    public ManualAdapter(Context context, List<Manual> listManual, ICallPhone iCallPhone) {
        this.context = context;
        this.listManual = listManual;
        this.iCallPhone = iCallPhone;
    }

    @NonNull
    @Override
    public ManualViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemManualBinding itemManualBinding = ItemManualBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ManualViewHolder(itemManualBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ManualViewHolder holder, int position) {
        Manual manual = listManual.get(position);
        if (manual == null) {
            return;
        }
        holder.mItemManualBinding.imgManual.setImageResource(manual.getImage());
        switch (manual.getId()) {
            case Manual.FACEBOOK:
                holder.mItemManualBinding.tvManual.setText(context.getString(R.string.label_facebook));
                break;

            case Manual.HOTLINE:
                holder.mItemManualBinding.tvManual.setText(context.getString(R.string.label_call));
                break;

            case Manual.GMAIL:
                holder.mItemManualBinding.tvManual.setText(context.getString(R.string.label_gmail));
                break;

            case Manual.SKYPE:
                holder.mItemManualBinding.tvManual.setText(context.getString(R.string.label_skype));
                break;

            case Manual.YOUTUBE:
                holder.mItemManualBinding.tvManual.setText(context.getString(R.string.label_youtube));
                break;

            case Manual.ZALO:
                holder.mItemManualBinding.tvManual.setText(context.getString(R.string.label_zalo));
                break;
        }

        holder.mItemManualBinding.layoutItem.setOnClickListener(v -> {
            switch (manual.getId()) {
                case Manual.FACEBOOK:
                    GlobalFunction.onClickOpenFacebook(context);
                    break;

                case Manual.HOTLINE:
                    iCallPhone.onClickCallPhone();
                    break;

                case Manual.GMAIL:
                    GlobalFunction.onClickOpenGmail(context);
                    break;

                case Manual.SKYPE:
                    GlobalFunction.onClickOpenSkype(context);
                    break;

                case Manual.YOUTUBE:
                    GlobalFunction.onClickOpenYoutubeChannel(context);
                    break;

                case Manual.ZALO:
                    GlobalFunction.onClickOpenZalo(context);
                    break;
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == listManual ? 0 : listManual.size();
    }

    public void release() {
        context = null;
    }

    public static class ManualViewHolder extends RecyclerView.ViewHolder {

        private final ItemManualBinding mItemManualBinding;

        public ManualViewHolder(ItemManualBinding itemManualBinding) {
            super(itemManualBinding.getRoot());
            this.mItemManualBinding = itemManualBinding;
        }
    }
}