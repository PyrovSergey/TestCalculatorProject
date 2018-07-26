package com.example.pyrov.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pyrov.calculator.data.DataStorage;
import com.example.pyrov.calculator.model.Expression;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity {

    @BindView(R.id.tv_list_view)
    ListView tvListView;
    private ArrayAdapter<String> emptyAdapter;
    private ListAdapter listAdapter;
    private DataStorage dataStorage;
    private List<Expression> expressions;
    private String[] emptyList = {"There is no history yet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        dataStorage = App.getComponent().getDataStorage();
        expressions = dataStorage.getExpressionsList();
        if (expressions.isEmpty()) {
            emptyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emptyList);
            tvListView.setAdapter(emptyAdapter);
        } else {
            listAdapter = new ListAdapter(expressions);
            tvListView.setAdapter(listAdapter);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.history, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.clear_history) {
            dataStorage.clearTable();
            emptyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emptyList);
            tvListView.setAdapter(emptyAdapter);
            return true;
        }
        return true;
    }
}
