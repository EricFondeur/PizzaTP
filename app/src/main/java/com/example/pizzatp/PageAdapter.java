package com.example.pizzatp;

import android.icu.text.CaseMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    String Title[]={"pate", "ingredients", "boisson", "menu"};
    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Pate();
            case 1: return new Ingredients();
            case 2: return new Boisson();
            case 3: return new Menu();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return Title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Title[position];
    }
}
