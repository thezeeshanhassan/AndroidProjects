package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // All Buttons
    Button one, two, three, four, five, six, seven, eight, nine, zero,
            add, minus, clear, divide, multiply, equal, square, cube, underroot, fact,
            sin, cos, tan, power, log, point, eularConstat, pi;

    // Accessing EditText Area
    EditText editText;
    String operation = "";
    double firstVal, secondVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        add = findViewById(R.id.add);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        minus = findViewById(R.id.minus);
        clear = findViewById(R.id.clear);
        equal = findViewById(R.id.equal);
        editText = findViewById(R.id.editText);
        fact = findViewById(R.id.fact);
        square = findViewById(R.id.square);
        cube = findViewById(R.id.cube);
        underroot =findViewById(R.id.underroot);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);
        power = findViewById(R.id.power);
        log = findViewById(R.id.log);
        point = findViewById(R.id.point);
        eularConstat = findViewById(R.id.eularConstant);
        pi = findViewById(R.id.pi);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "1");

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText(str + "0");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "sum";
                if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText("");
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "sub";
                if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText("");
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "multi";
                if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText("");
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "div";
                if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText("");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                firstVal = 0;
                secondVal = 0;
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText(firstVal * firstVal +"");
                }

            }
        });
        cube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText(firstVal * firstVal * firstVal +"");
                }
            }
        });
        underroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText(Math.sqrt(firstVal)+"");
                }
            }
        });
        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    double factorial = 1;
                    while(firstVal > 0)
                    {
                        factorial *= firstVal;
                        firstVal -= 1;
                    }
                    editText.setText(factorial+"");
                }
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "sin";
                editText.setText("sin(");
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "tan";
                editText.setText("tan(");
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "cos";
                editText.setText("cos(");
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "pow";
                if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText("");
                }
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "log";
                editText.setText("ln(");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().equals("")) {
                    editText.setText("0.");
                }
                else if(!editText.getText().toString().contains("."))
                {
                    editText.setText(editText.getText().toString() + ".");

                }
                else {
                    editText.setText(editText.getText().toString());
                }
            }
        });
        eularConstat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals("")) {
                    editText.setText(2.718282 + "");
                }
                else if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText(2.718282 * firstVal + "");
                }
            }
        });
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals("")) {
                    firstVal = 3.14159265;
                    editText.setText(firstVal +"");
                }
                else if(!editText.getText().toString().equals("")) {
                    firstVal = Double.parseDouble(editText.getText().toString());
                    editText.setText(3.14159265 * firstVal + "");
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (operation) {
                    case "sum":
                        if(!editText.getText().toString().equals("")) {
                            secondVal = Double.parseDouble(editText.getText().toString());
                            editText.setText(firstVal + secondVal + "");
                        }
                        break;
                    case "sub":
                        if(!editText.getText().toString().equals("")) {
                            secondVal = Double.parseDouble(editText.getText().toString());
                            editText.setText(firstVal - secondVal + "");
                        }
                        break;
                    case "div":
                        if(!editText.getText().toString().equals("")) {
                            secondVal = Double.parseDouble(editText.getText().toString());
                            editText.setText(firstVal / secondVal + "");
                        }
                        break;
                    case "multi":
                        if(!editText.getText().toString().equals("")) {
                            secondVal = Double.parseDouble(editText.getText().toString());
                            editText.setText(firstVal * secondVal + "");
                        }
                        break;
                    case "sin":
                        if(!editText.getText().
                                toString().substring(4).equals("")) {
                            firstVal = Double.parseDouble(editText.getText().
                                    toString().substring(4));
                            editText.setText(Math.sin(firstVal) + "");
                        }
                        break;
                    case "cos":
                        if(!editText.getText().
                                toString().substring(4).equals("")) {
                            firstVal = Double.parseDouble(editText.getText().
                                    toString().substring(4));
                            editText.setText(Math.cos(firstVal) + "");
                        }
                        break;
                    case "tan":
                        if(!editText.getText().
                                toString().substring(4).equals("")) {
                            firstVal = Double.parseDouble(editText.getText().
                                    toString().substring(4));
                            editText.setText(Math.tan(firstVal) + "");
                        }
                        break;
                    case "pow":
                        if(!editText.getText().
                                toString().equals("")) {
                            secondVal = Double.parseDouble(editText.getText().toString());
                            editText.setText(Math.pow(firstVal,secondVal) + "");
                        }
                        break;
                    case "log":
                        if(!editText.getText().
                                toString().substring(3).equals("")) {
                            firstVal = Double.parseDouble(editText.getText().
                                    toString().substring(3));
                            editText.setText(Math.sin(firstVal) + "");
                        }
                    default:
                        // Handle unexpected operation
                        break;
                }
            }
        });

    }
}