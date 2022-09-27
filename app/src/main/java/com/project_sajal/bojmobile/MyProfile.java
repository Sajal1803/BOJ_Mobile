package com.project_sajal.bojmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class MyProfile extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    ImageView profileImage;
    String userID;
    TextView name;
    TextView Email;
    TextView Phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_my_profile);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        FirebaseUser user= mAuth.getCurrentUser();
        profileImage = findViewById(R.id.profileImageId);
        name = findViewById(R.id.profileNameTextView);
        Email=findViewById(R.id.profileEmail);
        Phone=findViewById(R.id.userphone_no);
        userID= Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
        DocumentReference documentReference= fstore.collection("users").document(userID);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists())
                {
                    name.setText(documentSnapshot.getString("fName"));
                    Email.setText(documentSnapshot.getString("email"));
                    Phone.setText(documentSnapshot.getString("phone"));
                }
            }
        });

    }
}