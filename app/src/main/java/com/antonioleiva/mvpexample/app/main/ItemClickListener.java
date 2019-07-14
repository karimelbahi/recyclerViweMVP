package com.antonioleiva.mvpexample.app.main;

import android.view.View;

/**
 * Created by playmaker on 3/30/2018.
 */

public interface ItemClickListener {
    void onClick( int position, boolean isLongClick, String btnType);
}
