package com.project_sajal.bojmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.project_sajal.bojmobile.Adapter.ImpHintsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView ImpHintsRecyclerview;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();  //logout
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
                return true;
            default:
                return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.bojmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ImpHints RecyclerView
        ImpHintsRecyclerview = findViewById(R.id.ImpHintsRecyclerview);
        ImpHintsRecyclerview.setHasFixedSize(true);
        ImpHintsRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.image1);
        imageList.add(R.drawable.image2);
        imageList.add(R.drawable.image3);
        imageList.add(R.drawable.image4);
        imageList.add(R.drawable.image1);
        imageList.add(R.drawable.image2);
        imageList.add(R.drawable.image3);
        imageList.add(R.drawable.image4);

        ImpHintsAdapter ImpHintsAdapter = new ImpHintsAdapter(imageList);
        ImpHintsRecyclerview.setAdapter(ImpHintsAdapter);

        Button profileBtn = findViewById(R.id.myprofile);
        Button passbookBtn = findViewById(R.id.mypassbook);
        Button fundtransferBtn = findViewById(R.id.fundtransfer);
        Button depositBtn = findViewById(R.id.deposit);
        Button cardserviceBtn = findViewById(R.id.card_service);
        Button service_requestBtn = findViewById(R.id.Service_request);
        Button GovtBtn = findViewById(R.id.govt);
        Button offersBtn = findViewById(R.id.offers);
        Button feedbackBtn = findViewById(R.id.feedback);

        profileBtn.setOnClickListener(this);
        passbookBtn.setOnClickListener(this);
        fundtransferBtn.setOnClickListener(this);
        depositBtn.setOnClickListener(this);
        cardserviceBtn.setOnClickListener(this);
        service_requestBtn .setOnClickListener(this);
        GovtBtn.setOnClickListener(this);
        offersBtn.setOnClickListener(this);
        feedbackBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.myprofile:
                Intent MaintoMyprofile=(new Intent(MainActivity.this,MyProfile.class));
                Toast.makeText(getApplicationContext(),"My Profile",Toast.LENGTH_SHORT).show();
                startActivity(MaintoMyprofile);
                break;
            case R.id.mypassbook:
                Intent MaintoMypassbook=(new Intent(MainActivity.this,MyPassbook.class));
                Toast.makeText(getApplicationContext(),"My Passbook",Toast.LENGTH_SHORT).show();
                startActivity(MaintoMypassbook);
                break;
            case R.id.fundtransfer:
                Intent MaintoFundTransfer=(new Intent(MainActivity.this,FundTransfer.class));
                Toast.makeText(getApplicationContext(),"Fund Transfer",Toast.LENGTH_SHORT).show();
                startActivity(MaintoFundTransfer);
                break;
            case R.id.deposit:
                Intent MaintoDeposit=(new Intent(MainActivity.this,Deposit.class));
                Toast.makeText(getApplicationContext(),"Deposit",Toast.LENGTH_SHORT).show();
                startActivity(MaintoDeposit);
                break;
            case R.id.card_service:
                Intent Maintocard_service=(new Intent(MainActivity.this,Card_Service.class));
                Toast.makeText(getApplicationContext(),"Card Services",Toast.LENGTH_SHORT).show();
                startActivity(Maintocard_service);
                break;
            case R.id.Service_request:
                Intent MaintoService_request=(new Intent(MainActivity.this,Service_Request.class));
                Toast.makeText(getApplicationContext(),"Service Request",Toast.LENGTH_SHORT).show();
                startActivity(MaintoService_request);
                break;
            case R.id.govt:
                Intent Maintogovt=(new Intent(MainActivity.this,Govt.class));
                Toast.makeText(getApplicationContext(),"Govt MIS",Toast.LENGTH_SHORT).show();
                startActivity(Maintogovt);
                break;
            case R.id.offers:
                Intent Maintooffers=(new Intent(MainActivity.this,Offers.class));
                Toast.makeText(getApplicationContext(),"Offers",Toast.LENGTH_SHORT).show();
                startActivity(Maintooffers);
                break;
            case R.id.feedback:
                Intent Maintofeedback=(new Intent(MainActivity.this,Feedback.class));
                Toast.makeText(getApplicationContext(),"Feedback",Toast.LENGTH_SHORT).show();
                startActivity(Maintofeedback);
                break;
        }
    }
}
