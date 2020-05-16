package com.example.orderapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import android.os.Bundle;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // helper function for display().
    // Calls async function display().
    public void submitOrder(View view) {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);

        // Gets the current quantity.
        int count = Integer.parseInt(quantityTextView.getText().toString()) + 1;
        display(count);

        // Display Coffee Price
        displayPrice(count * 5);
    }

    // Displays quantity after clicking button
    private void display(int number) {

        // Looks for the view we want to alter; our button view.
        TextView quantityTextView = (TextView)findViewById(
                R.id.quantity_text_view);

        // Alters the text attribute of our button view
        quantityTextView.setText("" + number);
    }

    // Calculate Coffee Price
    private void displayPrice(int number) {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}

// Logcat is used to debug logic errors that happen on the phone/emulator.