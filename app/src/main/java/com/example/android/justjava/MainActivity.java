package com.example.android.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    int quantity = 2;
    int price = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox WhippedCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.Chocolate_checkbox);
        boolean hasChocolate = ChocolateCheckBox.isChecked();
        boolean hasWhippedCream = WhippedCheckbox.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(5, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
//        EditText cliente = (EditText) findViewById(R.id.nome);
//        String nomecliente = cliente.getText().toString();
 //       Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:"));
//        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + nomecliente);
 //       intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
 //       if (intent.resolveActivity(getPackageManager()) != null) {
 //           startActivity(intent);
 //       }
    }

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int price = quantity * 5;

        return price;
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.price_text_view);
        orderSummaryTextView.setText(message);
    }
    private String createOrderSummary(int priceForCup, boolean hasWhippedCream, boolean hasChocolate) {
        EditText cliente = (EditText) findViewById(R.id.nome);
        String nomecliente = cliente.getText().toString();
        int totalPrice = priceForCup * quantity;
        if (hasWhippedCream == true)  {
            totalPrice +=  quantity;
        }
        if (hasChocolate == true) {
            totalPrice += (quantity * 2);
        }

        String message1 = "Name: "+ nomecliente + "\nAdd whipped cream: " + hasWhippedCream + "\nAdd chocolate: " + hasChocolate + "\nQuantity: "+ quantity + "\nTotal: $" + totalPrice + "\nThank you!";
        return message1;
    }
    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
        }
        else {

            quantity =100;
            Context context = getApplicationContext();
            CharSequence text = "You cannot have more than 100 coffees";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        display(quantity);

    }
    public void decrement(View view) {

        if (quantity >1) {
            quantity = quantity - 1;
        }
        else {
            quantity =1;
            Context context = getApplicationContext();
            CharSequence text = "You cannot have less than 1 coffee";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        display(quantity);}
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}