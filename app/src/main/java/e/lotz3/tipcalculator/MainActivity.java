package e.lotz3.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private EditText box_total;
    private TextView totalBillAmount10;
    private TextView totalBillAmount15;
    private TextView totalBillAmount20;

    private TextView custip;
    private TextView custotal;
    private SeekBar tipPercent;
    private Button enter;
    private String total;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        box_total = (EditText) findViewById(R.id.bill);
        enter = (Button) findViewById(R.id.btn_enter);
         final TextView box1 = (TextView)findViewById(R.id.tip1);
         final TextView box2 = (TextView)findViewById(R.id.tip2);
         final TextView box3 = (TextView)findViewById(R.id.tip3);
        final TextView box4 = (TextView)findViewById(R.id.total1);
        final TextView box5 = (TextView)findViewById(R.id.total2);
        final TextView box6 = (TextView)findViewById(R.id.total3);
        final TextView box7 = (TextView)findViewById(R.id.finaltip);
        final TextView box8 = (TextView)findViewById(R.id.finaltotal);
        final TextView seekBarValue = (TextView)findViewById(R.id.seekbarvalue);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar2);
        final EditText myTextBox = (EditText) findViewById(R.id.bill);


        myTextBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                total= box_total.getText().toString();
                double tip1 = Double.parseDouble(total);
                double tip2 = Double.parseDouble(total);
                double tip3 = Double.parseDouble(total);
                tip1 = tip1*.1;
                tip2 = tip2*.15;
                tip3 = tip3*.2;


                box1.setText("$"+String.format("%.2f", tip1));
                box2.setText("$"+String.format("%.2f", tip2));
                box3.setText("$"+String.format("%.2f", tip3));
                box4.setText("$"+String.format("%.2f", tip1+Double.parseDouble(total)));
                box5.setText("$"+String.format("%.2f", tip2+Double.parseDouble(total)));
                box6.setText("$"+String.format("%.2f", tip3+Double.parseDouble(total)));



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });








        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBarValue.setText(String.valueOf(progress+"%"));
                double tipval = (double) progress;
                tipval = tipval*.01;
                double total2 = Double.parseDouble(total);
                double finaltip = tipval*total2;
                double finaltotal = finaltip+total2;
                box7.setText("$"+String.format("%.2f", finaltip));
                box8.setText("$"+String.format("%.2f", finaltotal));



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
        ;





    }

}
