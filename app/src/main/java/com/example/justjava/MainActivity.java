package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
int quantity = 0;
EditText namaEditText;
String nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment (View view) {
        quantity = quantity + 1;
        display(quantity);

    }

    public void decrement (View view) {
        if (quantity > 0){
            quantity = quantity - 1;
            display(quantity);
        }
    }

    public void submitOrder (View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        namaEditText = (EditText) findViewById(R.id.name_field);
        boolean hashWhippedCream = whippedCreamCheckbox.isChecked();
        boolean hashChocolate = chocolateCheckbox.isChecked();
        nama = namaEditText.getText().toString();
        int price = calculatePrice(hashWhippedCream, hashChocolate);
        String priceMessage = "Jumlah pembelian " + quantity + " cangkir" +
                "\nWhipped Cream : " + hashWhippedCream +
                "\nChocolate : " + hashChocolate +
                "\nTotal pembelian Rp " + price +
                "\nMatursalangkung, " + nama;
        displayMessage (priceMessage);
    }

    private int calculatePrice(boolean addhashWhippedCream, boolean addhashChocolate) {
        int basePrice = 5000;
        int price = 0;
        if (addhashWhippedCream) {
            basePrice = basePrice + 1000;
        }
        if(addhashChocolate){
            basePrice = basePrice + 2000;
        }
        return price = quantity * basePrice;
    }

    public void submitReset (View view) {
        if (quantity == quantity){                                                                                                                                        
            quantity = 0;
        };
        display(quantity);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void display (int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText ("" + number);
    }
    private void displayPrice (int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format (number));
    }
}