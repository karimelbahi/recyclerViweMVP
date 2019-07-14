/*
 *
 *  * Copyright (C) 2018 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.antonioleiva.mvpexample.app.main;

import android.util.Log;

import java.util.ArrayList;

class MainPresenter implements FindItemsInteractor.OnFinishedListener {

    private MainView mainView;
    private FindItemsInteractor findItemsInteractor;

    MainPresenter(MainView mainView, FindItemsInteractor findItemsInteractor) {
        Log.e("MainPresenter", "MainPresenter: ");
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }

    void onResume() {
        Log.e("MainPresenter", "onResume: ");
        if (mainView != null) {
//            mainView.showProgress();
        }
        findItemsInteractor.findItems(this);
    }

//    void onItemClickedd(String item) {
//        Log.e("MainPresenter", "onItemClickedd: ");
//        if (mainView != null) {
//            mainView.showMessage(String.format("%s clicked", item));
//        }
//    }

    public void onItemClickedd(int position, boolean b, String item) {

        Log.e("MainPresenter", "onItemClickedd: "+item);
        if (mainView != null) {
//            mainView.showMessage(String.format("%s clicked", item));
            if (item.equals("like")) {
                mainView.likeBtn(String.format("%s clicked", item + " " + position));
            } else if (item.equals("fav")) {
                mainView.favBtn(String.format("%s clicked", item + " " + position));
//                Log.e("onItemClickedd: fav", position + "");
            } else if (item.equals("share")) {
                mainView.shareBtn(String.format("%s clicked", item + " " + position));
            } else if (item.equals("delete")) {
                mainView.catBtn(String.format("%s clicked", item + " " + position));
                findItemsInteractor.deleteItemArrayList(position, this);
            }
        }
    }

    void onDestroy() {
        Log.e("MainPresenter", "onDestroy: ");
        mainView = null;
    }

    public void onFinished(ArrayList<String> items) {
        Log.e("MainPresenter", "onFinished: ");

        if (mainView != null) {
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }

    @Override
    public void recycleDeleteItem(int position) {
        mainView.recyclerDeleteItemFinished(position);

    }


    public MainView getMainView() {
        Log.e("MainPresenter", "getMainView: ");

        return mainView;
    }


//
//    public void onItemClickedd(View view, int i, boolean b) {
//    }
}