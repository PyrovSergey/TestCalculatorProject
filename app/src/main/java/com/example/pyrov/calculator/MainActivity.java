package com.example.pyrov.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pyrov.calculator.data.DataStorage;
import com.example.pyrov.calculator.model.Expression;
import com.example.pyrov.calculator.model.ExtendedDoubleEvaluator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String DATE_PATTERN = "dd MMMM yyyy HH:mm";

    @BindView(R.id.computation_line)
    TextView computationLine;
    @BindView(R.id.result_output)
    TextView resultOutput;
    @BindView(R.id.button_seven)
    Button buttonSeven;
    @BindView(R.id.button_four)
    Button buttonFour;
    @BindView(R.id.button_one)
    Button buttonOne;
    @BindView(R.id.button_point)
    Button buttonPoint;
    @BindView(R.id.button_eight)
    Button buttonEight;
    @BindView(R.id.button_five)
    Button buttonFive;
    @BindView(R.id.button_two)
    Button buttonTwo;
    @BindView(R.id.button_zero)
    Button buttonZero;
    @BindView(R.id.button_nine)
    Button buttonNine;
    @BindView(R.id.button_six)
    Button buttonSix;
    @BindView(R.id.button_three)
    Button buttonThree;
    @BindView(R.id.button_delete)
    Button buttonDelete;
    @BindView(R.id.button_division)
    Button buttonDivision;
    @BindView(R.id.button_multiplication)
    Button buttonMultiplication;
    @BindView(R.id.button_minus)
    Button buttonMinus;
    @BindView(R.id.button_plus)
    Button buttonPlus;
    @BindView(R.id.button_equals)
    Button buttonEquals;

    private String expression;
    private DataStorage dataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dataStorage = App.getComponent().getDataStorage();

        buttonDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                expression = "";
                resultOutput.setText(expression);
                computationLine.setText("0");
                return false;
            }
        });
    }

    @OnClick({R.id.button_seven, R.id.button_four, R.id.button_one, R.id.button_point, R.id.button_eight, R.id.button_five, R.id.button_two, R.id.button_zero, R.id.button_nine, R.id.button_six, R.id.button_three, R.id.button_delete, R.id.button_division, R.id.button_multiplication, R.id.button_minus, R.id.button_plus, R.id.button_equals})
    public void onViewClicked(View view) {
        expression = computationLine.getText().toString();
        if (expression.equals("0") & (view.getId() != R.id.button_point) & (view.getId() != R.id.button_plus) & (view.getId() != R.id.button_minus) & (view.getId() != R.id.button_multiplication) & (view.getId() != R.id.button_division)) {
            expression = "";
            computationLine.setText(expression);
        }
        switch (view.getId()) {
            case R.id.button_seven:
                computationLine.setText(expression + "7");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_four:
                computationLine.setText(expression + "4");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_one:
                computationLine.setText(expression + "1");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_point:
                if (expression.endsWith(".")) {
                    break;
                } else {
                    computationLine.setText(expression + ".");
                }
                break;
            case R.id.button_eight:
                computationLine.setText(expression + "8");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_five:
                computationLine.setText(expression + "5");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_two:
                computationLine.setText(expression + "2");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_zero:
                computationLine.setText(expression + "0");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_nine:
                computationLine.setText(expression + "9");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_six:
                computationLine.setText(expression + "6");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_three:
                computationLine.setText(expression + "3");
                resultOutput.setText(getResult(computationLine.getText().toString()));
                break;
            case R.id.button_delete:
                if (expression.equals("Invalid Expression")) {
                    expression = "";
                    resultOutput.setText(expression);
                    computationLine.setText("0");
                }
                if (expression.length() > 1) {
                    computationLine.setText(expression.substring(0, expression.length() - 1));
                } else {
                    computationLine.setText("0");
                    resultOutput.setText("");
                }
                break;
            case R.id.button_division:
                if (expression.endsWith("/") | expression.endsWith("-")) {
                    break;
                } else if (expression.endsWith("*")) {
                    expression = expression.substring(0, expression.length() - 1);
                    computationLine.setText(expression + "/");
                } else {
                    computationLine.setText(expression + "/");
                }
                break;
            case R.id.button_multiplication:
                if (expression.endsWith("*") | expression.endsWith("-")) {
                    break;
                } else if (expression.endsWith("/") | expression.endsWith("+") | expression.endsWith("-")) {
                    expression = expression.substring(0, expression.length() - 1);
                    computationLine.setText(expression + "*");
                } else {
                    computationLine.setText(expression + "*");
                }
                break;
            case R.id.button_minus:
                if (expression.endsWith("-")) {
                    break;
                } else if (expression.endsWith("+")) {
                    expression = expression.substring(0, expression.length() - 1);
                    computationLine.setText(expression + "-");
                } else {
                    computationLine.setText(expression + "-");
                }
                break;
            case R.id.button_plus:
                if (expression.endsWith("+")) {
                    break;
                } else if (expression.endsWith("-") | expression.endsWith("/") | expression.endsWith("*")) {
                    expression = expression.substring(0, expression.length() - 1);
                    computationLine.setText(expression + "+");
                } else {
                    computationLine.setText(expression + "+");
                }
                break;
            case R.id.button_equals:
                String tmpResult = getResult(expression);
                dataStorage.insertExpression(new Expression(getStringDate(new Date()), computationLine.getText().toString() + " = " + tmpResult));
                computationLine.setText(tmpResult);
                expression = "";
                resultOutput.setText(expression);
                break;
        }
    }

    private String getResult(String expression) {
        Double result;
        try {
            result = new ExtendedDoubleEvaluator().evaluate(expression);
            if ((result % 1) == 0) {
                return String.valueOf(Math.round(result));
            } else {
                return String.valueOf(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid Expression";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.open_history) {
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

    private String getStringDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN, Locale.getDefault());
        return dateFormat.format(date);
    }
}
