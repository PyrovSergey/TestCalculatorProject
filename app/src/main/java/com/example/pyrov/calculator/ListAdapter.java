package com.example.pyrov.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pyrov.calculator.model.Expression;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<Expression> expressions;

    public ListAdapter(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public int getCount() {
        return expressions.size();
    }

    @Override
    public Object getItem(int position) {
        return expressions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) App.getAppContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, parent, false);
        TextView tvDate = view.findViewById(R.id.tv_date);
        TextView tvExpression = view.findViewById(R.id.tv_expression);

        tvDate.setText(expressions.get(position).getDate());
        tvExpression.setText(expressions.get(position).getExpression());

        return view;
    }
}
