package com.melodify.music.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.melodify.music.fragment.ListSongPlayingFragment;
import com.melodify.music.fragment.PlaySongFragment;

public class MusicViewPagerAdapter extends FragmentStateAdapter {

    public MusicViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ListSongPlayingFragment();
        }
        return new PlaySongFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
