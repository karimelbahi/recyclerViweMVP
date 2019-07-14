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

import java.util.ArrayList;

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(ArrayList<String> items);

    void showMessage(String message);

    void likeBtn(String message);

    void shareBtn(String message);

    void favBtn(String message);

    void catBtn(String message);

    void recyclerDeleteItemFinished(int position);


}