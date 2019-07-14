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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.antonioleiva.mvpexample.app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView, ItemClickListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MainPresenter presenter;

    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
        presenter = new MainPresenter(this, new FindItemsInteractor());
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(ArrayList<String> items) {
        Log.e("MainActivity", "setItems: ");

        ArrayList<String> arrayList = (ArrayList<String>) items;

        mainAdapter = new MainAdapter(arrayList, this);
        recyclerView.setAdapter(mainAdapter);

//        recyclerView.setAdapter(new MainAdapter(items, presenter::onItemClickedd));
    }

    @Override
    public void onClick(int position, boolean isLongClick, String btnType) {

        presenter.onItemClickedd(position, isLongClick, btnType);
    }

    @Override
    public void recyclerDeleteItemFinished(int position) {
//        mainAdapter.removeAt(position);
        Toast.makeText(this, position+" was deleted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Log.e("MainActivity", "showMessage: ");

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void likeBtn(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void shareBtn(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void favBtn(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void catBtn(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
}
