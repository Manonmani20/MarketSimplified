package com.example.marketsimplifiedapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.marketsimplifiedapp.databinding.DetailedFragmentBindingImpl;
import com.example.marketsimplifiedapp.databinding.FragmentEmptyBindingImpl;
import com.example.marketsimplifiedapp.databinding.FragmentHomeBindingImpl;
import com.example.marketsimplifiedapp.databinding.InnerlayRepolistBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_DETAILEDFRAGMENT = 1;

  private static final int LAYOUT_FRAGMENTEMPTY = 2;

  private static final int LAYOUT_FRAGMENTHOME = 3;

  private static final int LAYOUT_INNERLAYREPOLIST = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.marketsimplifiedapp.R.layout.detailed_fragment, LAYOUT_DETAILEDFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.marketsimplifiedapp.R.layout.fragment_empty, LAYOUT_FRAGMENTEMPTY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.marketsimplifiedapp.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.marketsimplifiedapp.R.layout.innerlay_repolist, LAYOUT_INNERLAYREPOLIST);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_DETAILEDFRAGMENT: {
          if ("layout/detailed_fragment_0".equals(tag)) {
            return new DetailedFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for detailed_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEMPTY: {
          if ("layout/fragment_empty_0".equals(tag)) {
            return new FragmentEmptyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_empty is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_INNERLAYREPOLIST: {
          if ("layout/innerlay_repolist_0".equals(tag)) {
            return new InnerlayRepolistBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for innerlay_repolist is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/detailed_fragment_0", com.example.marketsimplifiedapp.R.layout.detailed_fragment);
      sKeys.put("layout/fragment_empty_0", com.example.marketsimplifiedapp.R.layout.fragment_empty);
      sKeys.put("layout/fragment_home_0", com.example.marketsimplifiedapp.R.layout.fragment_home);
      sKeys.put("layout/innerlay_repolist_0", com.example.marketsimplifiedapp.R.layout.innerlay_repolist);
    }
  }
}
