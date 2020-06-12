package com.example.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Increment Helper function
    private int addCoffee() {
        return getCoffeeQuantity() + 1;
    }

    // Decrement Helper function
    private int removeCoffee() {
        int count = getCoffeeQuantity();
        return count > 0 ? count - 1 : 0;
    }

    // Gets the current quantity.
    private int getCoffeeQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int count = Integer.parseInt(quantityTextView.getText().toString());
        return count;
    }

    // Increments and sets quantity
    public void incrementCoffee(View view) {
        display(addCoffee());
    }

    // Decrements and sets quantity
    public void decrementCoffee(View view) {
        display(removeCoffee());
    }

    // Helper Function: Calculate Price
    public void calcPrice(View view) {
        int count = getCoffeeQuantity();
        // Display Coffee Price
        displayPrice(count * 5);
    }

    // Helper Function: Displays quantity after clicking button
    private void display(int number) {

        // Looks for the view we want to alter; our button view.
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);

        // Alters the text attribute of our button view
        quantityTextView.setText("" + number);
    }

    // Calculate Coffee Price
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        EditText name = (EditText)findViewById(R.id.inputName);
        String customerName = name.getText().toString();
        priceTextView.setText(customerName + ": " + NumberFormat.getCurrencyInstance().format(number));

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }
}

// Logcat is used to debug logic errors that happen on the phone/emulator.
// To learn more about debugging, google "debugging android studio" -> has more tips