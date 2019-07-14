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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.antonioleiva.mvpexample.app.R;
import com.antonioleiva.mvpexample.app.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progress);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(v -> validateCredentials());

        presenter = new LoginPresenter(this, new LoginInteractor());
    }

    @Override
    protected void onDestroy() {
        Log.e("LoginActivity", "onDestroy: "+presenter );
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        Log.e("LoginActivity", "showProgress: "+presenter );
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        Log.e("LoginActivity", "hideProgress: "+presenter );
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setUsernameError() {
        Log.e("LoginActivity", "setUsernameError: "+presenter );
        username.setError(getString(R.string.username_error));

    }

    @Override
    public void setPasswordError() {
        Log.e("LoginActivity", "setPasswordError: "+presenter );
        password.setError(getString(R.string.password_error));

    }

    @Override
    public void navigateToHome() {
        Log.e("LoginActivity", "navigateToHome: "+presenter );
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void validateCredentials() {
        Log.e("LoginActivity", "validateCredentials: "+presenter );
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());

    }
}
