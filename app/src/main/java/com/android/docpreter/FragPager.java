package com.android.docpreter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragPager extends FragmentStateAdapter {
    public FragPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new InEffect();
            case 1:
                return new ToAdd();
            case 2:
                return new MyReceipts();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
