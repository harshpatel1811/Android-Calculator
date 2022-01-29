package com.harsh.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Display
        TextView display = findViewById(R.id.display);

        //Buttons:- number initialization
        Button b_0 = findViewById(R.id.zero);
        Button b_1 = findViewById(R.id.one);
        Button b_2 = findViewById(R.id.two);
        Button b_3 = findViewById(R.id.three);
        Button b_4 = findViewById(R.id.four);
        Button b_5 = findViewById(R.id.five);
        Button b_6 = findViewById(R.id.six);
        Button b_7 = findViewById(R.id.seven);
        Button b_8 = findViewById(R.id.eight);
        Button b_9 = findViewById(R.id.nine);
        Button b_cautious = findViewById(R.id.cautious);


        //Buttons:- operators and clear buttons
        Button b_c = findViewById(R.id.c);
        Button b_clr = findViewById(R.id.clear);
        Button b_percent = findViewById(R.id.percentage);
        Button b_plus = findViewById(R.id.plus);
        Button b_subtract = findViewById(R.id.substract);
        Button b_multiplication = findViewById(R.id.multiplication);
        Button b_divide = findViewById(R.id.divide);
        Button b_equal = findViewById(R.id.equal);
        Button b_dot = findViewById(R.id.dot);

        //onClickListeners
        b_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_0.getText().toString());
                }
                else
                    buttonPressed(b_0, display);
            }
        });

        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_1.getText().toString());
                }
                else
                    buttonPressed(b_1, display);
            }
        });

        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_2.getText().toString());
                }
                else
                    buttonPressed(b_2, display);
            }
        });

        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_3.getText().toString());
                }
                else
                    buttonPressed(b_3, display);
            }
        });

        b_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_4.getText().toString());
                }
                else
                    buttonPressed(b_4, display);
            }
        });

        b_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_5.getText().toString());
                }
                else
                    buttonPressed(b_5, display);
            }
        });

        b_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_6.getText().toString());
                }
                else
                    buttonPressed(b_6, display);
            }
        });

        b_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_7.getText().toString());
                }
                else
                    buttonPressed(b_7, display);
            }
        });

        b_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_8.getText().toString());
                }
                else
                    buttonPressed(b_8, display);
            }
        });

        b_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                {
                    display.setText(b_9.getText().toString());
                }
                else
                    buttonPressed(b_9, display);
            }
        });

        b_cautious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Still left to work on it☺️", Toast.LENGTH_SHORT).show();
            }
        });


        //onClickListeners on operators

        //Percentage
        b_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Percentage operator is different
                //Just have to divide by 100

                String temp = funPercentage(display);
                display.setText(temp);
            }
        });


        //Multiplication
        b_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                    display.setText(b_multiplication.getText().toString());

                if(display.getText().toString().equals("0"))
                    display.setText(display.getText().toString()+ "*");

                if(display.getText().toString().charAt(display.getText().toString().length()-1) == '.')
                    display.setText(display.getText().toString() + "0");

                if (isOperatorExist(display))
                    setOperatorAtEnd(b_multiplication, display);
                else
                    buttonPressed(b_multiplication, display);
            }
        });


        //Plus or sum
        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                    display.setText(b_plus.getText().toString());

                if(display.getText().toString().equals("0"))
                    display.setText(display.getText().toString()+ "+");

                if(display.getText().toString().charAt(display.getText().toString().length()-1) == '.')
                    display.setText(display.getText().toString() + "0");

                if (isOperatorExist(display))
                    setOperatorAtEnd(b_plus, display);
                else
                    buttonPressed(b_plus, display);
            }
        });

        //Subtract
        b_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                    display.setText(b_subtract.getText().toString());
                if(display.getText().toString().equals("0"))
                    display.setText(display.getText().toString()+ "-");

                if(display.getText().toString().charAt(display.getText().toString().length()-1) == '.')
                    display.setText(display.getText().toString() + "0");


                if (isOperatorExist(display))
                    setOperatorAtEnd(b_subtract, display);
                else
                    buttonPressed(b_subtract, display);
            }
        });

        //Divide
        b_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().startsWith("="))
                    display.setText(b_subtract.getText().toString());

                if(display.getText().toString().equals("0"))
                    display.setText(display.getText().toString()+ "/");

                if(display.getText().toString().charAt(display.getText().toString().length()-1) == '.')
                    display.setText(display.getText().toString() + "0");


                if (isOperatorExist(display))
                    setOperatorAtEnd(b_divide, display);
                else
                    buttonPressed(b_divide, display);
            }
        });


        //Special Case onClickListeners

        // C:- clear all
        b_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("0");
            }
        });

        //Clear right most character
        b_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = display.getText().toString();
                if (temp.length() == 1)
                    display.setText("0");

                else
                    display.setText(temp.substring(0, temp.length() - 1));
            }
        });

        //Dot operator
        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //starting condition
                if(display.getText().toString() == "0")
                    display.setText(display.getText().toString() + ".");

                //if Operator is exists at the end of the string
                if(isOperatorExist(display))
                    display.setText(display.getText().toString() + "0.");

                if(!isDotExist(display))
                {
                    String temp = display.getText().toString() + ".";
                    display.setText(temp);
                }
            }
        });

        //Equals
        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate calculate = new Calculate();
                String s = display.getText().toString();
                if(s.startsWith("="))
                {
                    display.setText(display.getText().toString());
                }
                else
                {
                    if(calculate.isEndsWithOperator(s))
                    {
                        StringBuilder sb = new StringBuilder(s);
                        sb.deleteCharAt(sb.length()-1);
                        s = String.valueOf(sb);
                    }

                    try {
                        double result = calculate.calculate(s);
                        if(isInteger(result))
                        {
                            int num = (int) result;
                            display.setText("= "+ String.valueOf(num));
                        }
                        else
                        {
                            display.setText("= " + String.format("%.7f", result));
                        }
                    }
                    catch (Exception e)
                    {
                        display.setText("= Error");
                    }

                }


            }
        });

    }

    public static int parseStringFromEnd(String temp)
    {
        for(int i=temp.length()-1; i >= 0; i--)
        {
            if (temp.charAt(i) == '/' || temp.charAt(i) == '%' || temp.charAt(i) == '+' || temp.charAt(i) == '-' || temp.charAt(i) == '*')
                return i+1;
        }
        return 0;
    }

    public String funPercentage(TextView display)
    {

        if(display.getText().toString().startsWith("=")) {
            String temp = display.getText().toString();
            temp = temp.substring(2, temp.length() - 1);
            int startPos = parseStringFromEnd(temp);
            String newstr = temp.substring(startPos);
            Double number = Double.parseDouble(newstr);
            number = number / 100;
            if (number < 1E-3)
                return (temp + "-NaN");
            else {
                String value = String.valueOf(number);
                StringBuilder stringBuilder = new StringBuilder(temp);
                stringBuilder.delete(startPos, stringBuilder.length());
                stringBuilder.append(value);
                temp = String.valueOf(stringBuilder);
                return temp;
            }
        }
            if(display.getText().toString().equals("0"))
            {
                return "0";
            }
            else
            {
                String temp = display.getText().toString();
                int startPos = parseStringFromEnd(temp);
                String newstr = temp.substring(startPos);
                Double number = Double.parseDouble(newstr);
                number = number / 100;
                if(number < 1E-3)
                    return (display.getText().toString() + "-NaN");
                else {
                    String value = String.valueOf(number);
                    StringBuilder stringBuilder = new StringBuilder(temp);
                    stringBuilder.delete(startPos, stringBuilder.length());
                    stringBuilder.append(value);
                    temp = String.valueOf(stringBuilder);
                    return  temp;
                }

            }

    }

    public boolean isDotExist(TextView textView) {

        //check whether any operator is there in string?
        String temp = textView.getText().toString();
        for (int i = temp.length() - 1; i >= 0; i--) {
            if (temp.charAt(i) == '/' || temp.charAt(i) == '%' || temp.charAt(i) == '+' || temp.charAt(i) == '-' || temp.charAt(i) == '*') {
                for(int j = i; j < temp.length(); j++)
                {
                    if(temp.charAt(j) == '.')
                        return true;
                }
                return false;
            }
        }

        //Here string supposed to be non-operator so just have to check on whole string
        for(int i=0; i < temp.length(); i++)
        {
            if(temp.charAt(i) == '.')
                return true;
        }
        return false;

    }

    public void setOperatorAtEnd(Button button, TextView textView)
    {
        StringBuilder stringBuilder = new StringBuilder(textView.getText().toString());
        stringBuilder.setCharAt(stringBuilder.length()-1, button.getText().toString().charAt(0));
        textView.setText(stringBuilder);
    }
    public boolean isOperatorExist(TextView textView)
    {
        String temp = textView.getText().toString();
        char operator = temp.charAt(temp.length()-1);

        if(operator == '/' || operator == '%' || operator == '+' || operator == '-' || operator == '*')
        {
            return  true;
        }
        else
            return false;

    }

    public void buttonPressed(Button button, TextView textView)
    {
        String txt = textView.getText().toString();
        if(txt.equals("0"))
            textView.setText(button.getText().toString());
        else
            textView.setText(textView.getText().toString() + button.getText().toString());

    }

    public static boolean isInteger(double number){
        return Math.ceil(number) == Math.floor(number);
    }
}

