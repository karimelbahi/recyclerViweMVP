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

public class FindItemsInteractor {

    interface OnFinishedListener {
        void onFinished(ArrayList<String> items);

        void recycleDeleteItem(int position);

    }

    public void findItems(final OnFinishedListener listener) {
        Log.e("FindItemsInteractor", "findItems: ");

//        new Handler().postDelayed(() ->
        listener.onFinished(createArrayList());
//                        , 2000);
    }

    private ArrayList<String> createArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");
        list.add("Item 6");
        list.add("Item 7");
        list.add("Item 8");
        list.add("Item 9");
        list.add("Item 10");
        return list;

    }

    public void deleteItemArrayList(int position, final OnFinishedListener listener) {
        ArrayList<String> deleteFromList = createArrayList();
        Log.e("deleteItemArrayList: B", deleteFromList.size() + "  " + position + "");
//        deleteFromList.remove(position);
        Log.e("deleteItemArrayList: A", deleteFromList.size() + "  " + position + "");
        listener.recycleDeleteItem(position);

    }
}
