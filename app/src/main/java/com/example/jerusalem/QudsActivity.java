package com.example.jerusalem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Iterator;

public class QudsActivity extends AppCompatActivity {
    FirebaseFirestore firebaseFirestore;
    ImageView qudsIm;
    TextView qudsTv;
    String[] fonts = {"arial", "arizonia_regular", "roboto_black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quds);

        qudsTv = findViewById(R.id.camDescTv2);
        qudsIm = findViewById(R.id.qudsIm);
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("About")
                .get()
                .addOnSuccessListener(command -> {
                  Iterator<QueryDocumentSnapshot> iterator = command.iterator();
                    if (iterator.hasNext()){
                       QueryDocumentSnapshot queryDocumentSnapshot = iterator.next();
                        Picasso.get().load(queryDocumentSnapshot.getString("qudsImUrl"))
                                .fit().centerCrop()
                                .placeholder(R.mipmap.ic_launcher).into(qudsIm);
                        qudsTv.setText(queryDocumentSnapshot.getString("quds"));
                    }
                })
                .addOnFailureListener(command -> {
                    Toast.makeText(this, command.getMessage(), Toast.LENGTH_SHORT).show();
                });


        qudsTv.setOnClickListener(v -> {
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this)
                    .setTitle("تغيير نوع الخط")
                    .setItems(fonts, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0){
                                qudsTv.setTypeface(ResourcesCompat.getFont(QudsActivity.this, R.font.arial));
                            }else  if (which == 1){
                                qudsTv.setTypeface(ResourcesCompat.getFont(QudsActivity.this, R.font.arizonia_regular));
                            }else if (which == 2){
                                qudsTv.setTypeface(ResourcesCompat.getFont(QudsActivity.this, R.font.roboto_black));
                            }
                        }
                    })
                    .setPositiveButton("إرجاع", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            qudsTv.setTypeface(ResourcesCompat.getFont(QudsActivity.this, R.font.jannat_bold));
                        }
                    });
            builder.create().show();
        });


    }
}