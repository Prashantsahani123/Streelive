package com.kaizen.stree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Viewprofile extends AppCompatActivity {

    ImageView back,ivNewCallButton,ivNewMessage,ivWhatsApp,ivNewMail;
    TextView memn , memclu, clas , emaill , mobil,comp_N, webs, facebkpage,Youtub,BusinessB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);
        back = findViewById(R.id.prof);
        getSupportActionBar().hide();


        ivNewCallButton = findViewById(R.id.ivNewCallButton);
        ivNewMessage = findViewById(R.id.ivNewMessage);
        ivWhatsApp = findViewById(R.id.ivWhatsApp);
        ivNewMail = findViewById(R.id.ivNewMail);



        memn = findViewById(R.id.tv_member_name);
        memclu = findViewById(R.id.tvClubName);
        mobil = findViewById(R.id.mobil);
        emaill = findViewById(R.id.emal);
        clas  = findViewById(R.id.clas);
        comp_N = findViewById(R.id.comp_N);
        webs = findViewById(R.id.webs);
        facebkpage = findViewById(R.id.faceblpage);
        Youtub= findViewById(R.id.Youtub);
        BusinessB = findViewById(R.id.BusinessB);


try {
    String nam = getIntent().getExtras().getString("name");
    String clbn = getIntent().getExtras().getString("clubn");
    String mob = getIntent().getExtras().getString("mobile");
    String eml = getIntent().getExtras().getString("email");
    String cls = getIntent().getExtras().getString("classi");
    String cmp_n = getIntent().getExtras().getString("companyN");
    String websitee = getIntent().getExtras().getString("website");

    String faceb = getIntent().getExtras().getString("facebook");

    String youtube = getIntent().getExtras().getString("youtube");
//BusinessB

    String Business_Brief = getIntent().getExtras().getString("BusinessB");

    memn.setText(nam);
    memclu.setText(clbn);
    mobil.setText(mob);
    emaill.setText(eml);
    clas.setText(cls);
    comp_N.setText(cmp_n);
    webs.setText(websitee);
    facebkpage.setText(faceb);
    Youtub.setText(youtube);
    BusinessB.setText(Business_Brief);

}
catch (Exception e)
{
    e.printStackTrace();
}

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

ivNewCallButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent callIntent = new Intent( Intent.ACTION_DIAL, Uri.parse( "tel: " + mobil.getText().toString().trim()) );
        startActivity( callIntent );

    }
});

ivNewMessage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //https://api.whatsapp.com/send?phone=


//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="
//
        String url = "https://api.whatsapp.com/send?phone=91"+mobil.getText().toString().trim();;//"https://wa.me/"+profileData.getMobile()+"/?text=hii";

        Intent i = new Intent( Intent.ACTION_VIEW );
        i.setData( Uri.parse( url ) );
        startActivity( i );

    }
});

ivWhatsApp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        try {

            Intent msgIntent = new Intent(Intent.ACTION_VIEW);
//                        msgIntent.setType("vnd.android-dir/mms-sms");
//                        msgIntent.putExtra("address", myMsgList.get(0).getNumber());
            msgIntent.setData(Uri.parse("smsto: " + mobil.getText().toString().trim()));
            startActivity(msgIntent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
});
ivNewMail.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final Intent emailIntent = new Intent( Intent.ACTION_SENDTO );
        emailIntent.setType( "plain/text" );
        emailIntent.setData( Uri.parse( "mailto:" ) );

        emailIntent.putExtra( Intent.EXTRA_EMAIL, new String[]{emaill.getText().toString().trim()} );
       // emailIntent.putExtra( Intent.EXTRA_EMAIL, emaill.getText().toString().trim() );
        emailIntent.putExtra( Intent.EXTRA_SUBJECT, "" );
        emailIntent.putExtra( Intent.EXTRA_TEXT, "" );
        startActivity( emailIntent );


//        final Intent emailIntent = new Intent( Intent.ACTION_SENDTO );
//        emailIntent.setType( "plain/text" );
//        emailIntent.setData( Uri.parse( "mailto:" ) );
//        emailIntent.putExtra( Intent.EXTRA_EMAIL, new String[]{myMailList.get( 0 ).getEmailId().toString()} );
//        emailIntent.putExtra( Intent.EXTRA_SUBJECT, "" );
//        emailIntent.putExtra( Intent.EXTRA_TEXT, "" );
//        startActivity( emailIntent );

    }
});

        facebkpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (facebkpage.getText().toString().trim().contains("http")) {
                        Uri uri = Uri.parse(facebkpage.getText().toString().trim()); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else if(facebkpage.getText().toString().trim().contains("www")) {
                        Uri uri = Uri.parse("https://" + facebkpage.getText().toString().trim()); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);


                    }else {
                        Toast.makeText(getApplicationContext(), "URL is not Exist", Toast.LENGTH_SHORT).show();

                    }
                }
                catch(Exception e)
                {

                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }


            }
        });

        Youtub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (Youtub.getText().toString().trim().contains("http")) {
                        Uri uri = Uri.parse(Youtub.getText().toString().trim()); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                 else if(Youtub.getText().toString().trim().contains("www")){
                    Uri uri = Uri.parse("https://"+Youtub.getText().toString().trim()); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                    else {
                        Toast.makeText(getApplicationContext(), "URL is not Exist", Toast.LENGTH_SHORT).show();

                    }
                }
                catch(Exception e)
                {

                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }


            }
        });
        webs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (webs.getText().toString().trim().contains("http")) {
                        Uri uri = Uri.parse(webs.getText().toString().trim()); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    } else if(webs.getText().toString().trim().contains("www")){
                        Uri uri = Uri.parse("https://"+webs.getText().toString().trim()); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "URL is not Exist", Toast.LENGTH_SHORT).show();

                    }
                }
                catch(Exception e)
                {

                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }





}

//    Uri uri = Uri.parse("https://projectshare.rotaryindia.org/CovidExcelData/My_Stories_session.jpeg"); // missing 'http://' will cause crashed
//    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//    startActivity(intent);
