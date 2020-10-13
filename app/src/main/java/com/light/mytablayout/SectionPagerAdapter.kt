package com.light.mytablayout

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionPagerAdapter(private val mContext: Context,fm : FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES = intArrayOf(
        R.string.tab_text_1
        , R.string.tab_text_2
//        , R.string.tab_text_3
    )

    //      TODO Yang di comment dalam Home Fragment serta SectionPager Adapater adalah untuk menampilkan 3 Tab Layout tetapi isinya mirip
//    TODO Ubah getCount menjadi 3 untuk fitur 3 TabLayout 1 Activity
    override fun getCount(): Int = 2


    override fun getItem(position: Int): Fragment {
//        val fragment = HomeFragment.newInstance(position+1)
//        return fragment
//        TODO  Ini untuk 1 fragment didalam beberapa Tab Layout

        var fragment: Fragment? = null
        when(position){
            0 -> fragment = HomeFragment()
            1 -> fragment = ProfileFragment()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }
}