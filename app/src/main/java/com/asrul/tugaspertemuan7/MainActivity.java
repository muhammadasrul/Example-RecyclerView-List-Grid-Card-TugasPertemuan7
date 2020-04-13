package com.asrul.tugaspertemuan7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.asrul.tugaspertemuan7.Adapters.CardViewAdapter;
import com.asrul.tugaspertemuan7.Adapters.GridDataAdapter;
import com.asrul.tugaspertemuan7.Adapters.ListDataAdapter;
import com.asrul.tugaspertemuan7.Data.Camera;
import com.asrul.tugaspertemuan7.Data.DataCamera;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView btnList, btnGrid, btnCard;
    RecyclerView rvMain;
    ArrayList<Camera> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rv_main);
        btnList = findViewById(R.id.btn_list);
        btnGrid = findViewById(R.id.btn_grid);
        btnGrid.setVisibility(View.VISIBLE);
        btnCard = findViewById(R.id.btn_card);

        btnList.setOnClickListener(this);
        btnGrid.setOnClickListener(this);
        btnCard.setOnClickListener(this);

        rvMain.setHasFixedSize(true);
        list.addAll(DataCamera.getListData());
        showListData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_list:
                showListData();
                btnList.setVisibility(View.INVISIBLE);
                btnGrid.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_grid:
                showGridData();
                btnGrid.setVisibility(View.INVISIBLE);
                btnCard.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_card:
                showCardData();
                btnCard.setVisibility(View.INVISIBLE);
                btnList.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void showListData() {
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        ListDataAdapter listDataAdapter = new ListDataAdapter(list);
        rvMain.setAdapter(listDataAdapter);

        listDataAdapter.setOnItemClickCallback(new ListDataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Camera data) {
                showSelectedData(data);
            }
        });
    }
    private void showGridData() {
        rvMain.setLayoutManager(new GridLayoutManager(this, 2));
        GridDataAdapter gridDataAdapter = new GridDataAdapter(list);
        rvMain.setAdapter(gridDataAdapter);

        gridDataAdapter.setOnItemClickCallback(new GridDataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Camera data) {
                showSelectedData(data);
            }
        });
    }
    private void showCardData() {
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewAdapter = new CardViewAdapter(list);
        rvMain.setAdapter(cardViewAdapter);
    }
    private void showSelectedData(Camera data) {
        Toast.makeText(this, "Kamu memilih " + data.getName(), Toast.LENGTH_SHORT).show();
    }
}
