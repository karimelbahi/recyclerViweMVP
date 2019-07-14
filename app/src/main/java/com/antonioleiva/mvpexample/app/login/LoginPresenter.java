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

package com.antonioleiva.mvpexample.app.login;

import android.util.Log;

public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        Log.e("LoginPresenter", "onConstructor: "+loginView +"   "+loginInteractor);
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void validateCredentials(String username, String password) {
        Log.e("LoginPresenter", "validateCredentials: "+loginView );
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    public void onDestroy() {
        Log.e("LoginPresenter", "onDestroy: "+loginView );
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        Log.e("LoginPresenter", "onUsernameError: "+loginView );

        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        Log.e("LoginPresenter", "onPasswordError: "+loginView );
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        Log.e("LoginPresenter", "onSuccess: "+loginView );
        if (loginView != null) {
            loginView.navigateToHome();
            loginView.hideProgress();

        }
    }
}
