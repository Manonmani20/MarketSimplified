package com.example.marketsimplifiedapp

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    lateinit var fragment: FrameLayout
    private val mFragList: ArrayList<WeakReference<Fragment>> =
        ArrayList<WeakReference<Fragment>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        fragment = findViewById(R.id.nav_host_fragment)
        setFragments( HomeFragment(),"home");

        navView.setOnNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.navigation_hometab -> {
                    setFragments( HomeFragment(),"home");
                    true
                }
                R.id.navigation_tab2 -> {
                    returnEmptyFragment("Tab2")
                    true
                }
                else -> {
                    returnEmptyFragment("Tab3")
                    true
                }
            }
        }
    }

    fun returnEmptyFragment(title:String){
        var emptyFragment : Fragment = EmptyFragment.newInstance(title);
        Log.e("REturn epty","title"+title)
        setFragments(emptyFragment,title)
    }
    override fun onBackPressed() {
        val fragmentManager = getSupportFragmentManager()
        fragmentManager.executePendingTransactions()
        val counts = fragmentManager.getBackStackEntryCount()
        Log.e("fragmnet","manger called size:"+counts)
        if(counts<=1){
            super.onBackPressed()
        }else {
            super.onBackPressed()
            val fragments = fragmentManager.getFragments()
            val lastFragment = fragments[fragments.size - 1]

//            Log.e("lastFragment","lastFragment tag:"+lastFragment.tag)


        }
    }

    fun setFragments(fragments: Fragment, backStateName: String) {
        val manager = getSupportFragmentManager()
        var fragmentPopped: Boolean = true
        val ft = getSupportFragmentManager()
        val fts = ft.beginTransaction()
        Log.e("fragmentPopped", "backStateName:" + backStateName)

        if (backStateName.equals("home")) {
            fragmentPopped = manager.popBackStackImmediate("detail", 0)
            if (!fragmentPopped) {
                fts.replace(fragment.id, fragments, backStateName)
                if (!backStateName.equals("detail")) {
                    fts.commit()
                } else {
                    val fragments = findFragement("DetailedFragment")

                    if (fragments != null && fragments is DetailedFragment) {
                        fts.add(fragment.id, fragments, backStateName)
                        fts.commit()
                    }
                }
            } else {
                val fragments = findFragement("DetailedFragment")

                if (fragments != null && fragments is DetailedFragment) {
                    fts.replace(fragment.id, fragments, backStateName)
                    fts.addToBackStack(null)
                    fts.commit()
                }
            }
            Log.e("fragmentPopped", "fragmentPopped:" + fragmentPopped)
        } else if (backStateName.equals("detail")) {
            fts.replace(fragment.id, fragments, backStateName)
            fts.addToBackStack(backStateName)
            fts.commit()
        } else {
            fts.replace(fragment.id, fragments, backStateName)
            fts.addToBackStack(backStateName)
            fts.commit()
        }
    }
        override fun onAttachFragment(fragment: Fragment) {
            super.onAttachFragment(fragment)
            mFragList.add( WeakReference(fragment));
        }
    fun findFragement(tClass: String): Fragment? {
        val fragments: ArrayList<Fragment> =
            getActiveFragments()
        for (fragment in fragments) {
            if (tClass.equals("detail", ignoreCase = true)) {
                if (fragment is DetailedFragment) {
                    return fragment
                }
            }
        }
        return null
    }
    fun getActiveFragments(): ArrayList<Fragment> {
        val ret =
            ArrayList<Fragment>()
        for (ref in mFragList) {
            val f = ref.get()
            if (f != null) {
                if (f.isVisible) {
                    ret.add(f)
                }
            }
        }
        return ret
    }
}