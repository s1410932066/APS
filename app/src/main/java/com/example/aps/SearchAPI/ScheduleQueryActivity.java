package com.example.aps.SearchAPI;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.aps.Activity.MenuActivity;
import com.example.aps.DataResponse.SearchCustomer;
import com.example.aps.DataResponse.SearchSoId;
import com.example.aps.R;
import com.example.aps.SearchDataAPI.ScheduleQueryDataActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ScheduleQueryActivity extends AppCompatActivity implements SearchContract.IView{

    Spinner spinner;
    Button button_date, button_send, button_so_id, button_customer;
    EditText edit_date, edit_so_id, edit_customer;
    DatePickerDialog.OnDateSetListener datePicker;
    Calendar calendar;
    SearchPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_query);



        presenter = new SearchPresenter(this);

        spinner = findViewById(R.id.spinner);
        button_date = findViewById(R.id.button_date);
        edit_date = findViewById(R.id.edit_date);
        edit_so_id = findViewById(R.id.edit_so_id);
        edit_customer = findViewById(R.id.edit_customer);

        setToolbar();
//下拉選單
        final String[] sp = {"點焊"};
        ArrayAdapter<String> spList = new ArrayAdapter<>(ScheduleQueryActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                sp);
        spinner.setAdapter(spList);

//日期選擇
        calendar = Calendar.getInstance();
        datePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH , month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.TAIWAN);
                edit_date.setText(sdf.format(calendar.getTime()));
            }
        };
        button_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(ScheduleQueryActivity.this,
                        datePicker,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
//Token
        String token = getSharedPreferences("getParams", MODE_PRIVATE).getString("token", "");
        //Log.e("token", token);
//訂單單號按鈕
        button_so_id = findViewById(R.id.button_so_id);
        button_so_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String so_id = edit_so_id.getText().toString();
                presenter.getSo_Id(token, so_id);
            }
        });
//客戶名稱按鈕
        button_customer = findViewById(R.id.button_customer);
        button_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customer = edit_customer.getText().toString();
                presenter.getCustomer(token, customer);
            }
        });

//確定按鈕
        button_send = findViewById(R.id.button_send);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sale_order = edit_so_id.getText().toString();
//                SharedPreferences getParams = getSharedPreferences("getParams", MODE_PRIVATE);
//                getParams.edit().putString("sale_order", sale_order).commit();
                if (sale_order.isEmpty()){
                    return;
                }
                else {
                    Intent intent_send = new Intent(ScheduleQueryActivity.this, ScheduleQueryDataActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("so_id",sale_order);
                    intent_send.putExtras(bundle);
                    startActivity(intent_send);
                }
                //presenter.getSaleOrder(token, sale_order, "","");
            }
        });
    }

//Toolbar
    private void setToolbar() {
        Toolbar toolbar_Schedule = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar_Schedule);
        getSupportActionBar().setTitle("進度表查詢");
        toolbar_Schedule.setTitleTextColor(Color.WHITE);
        toolbar_Schedule.setNavigationIcon(getDrawable(R.drawable.u154));
        toolbar_Schedule.setContentInsetStartWithNavigation(0);
        toolbar_Schedule.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScheduleQueryActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
//訂單單號回傳
    @Override
    public void callback_V_so_id(List<SearchSoId> searchSoIdData) {
        String[] allSo_Id = new String[searchSoIdData.size()];
        //Log.e("fuck", searchSoIdData.get(0).getSo_id());
        for (int i=0;i<searchSoIdData.size();i++){
            allSo_Id[i]=searchSoIdData.get(i).getSo_id();
        }
        //Log.e("fuck1", allSo_Id[1].toString());
        AlertDialog.Builder dialog_list_so_id = new AlertDialog.Builder(ScheduleQueryActivity.this);
        dialog_list_so_id.setTitle("選擇訂單單號");
        dialog_list_so_id.setItems(allSo_Id, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                edit_so_id.setText(allSo_Id[i]);
            }
        });
        dialog_list_so_id.show();
    }
//客戶名稱回傳
    @Override
    public void callback_V_customer(List<SearchCustomer> searchCustomerData) {
        String[] allCustomer = new String[searchCustomerData.size()];
        for (int i=0;i<searchCustomerData.size();i++){
            allCustomer[i] = searchCustomerData.get(i).getCustomer();
        }
        AlertDialog.Builder dialog_list_customer = new AlertDialog.Builder(ScheduleQueryActivity.this);
        dialog_list_customer.setTitle("選擇客戶名稱");
        dialog_list_customer.setItems(allCustomer, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                edit_customer.setText(allCustomer[i]);
            }
        });
        dialog_list_customer.show();
    }
}
