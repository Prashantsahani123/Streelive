package com.kaizen.stree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Viewprofile extends AppCompatActivity {

    ImageView back,ivNewCallButton,ivNewMessage,ivWhatsApp,ivNewMail;
    TextView memn , memclu, clas , emaill , mobil,comp_N, webs, facebkpage,Youtub,BusinessB;


    LinearLayout Mb,Em,AofB,Comp_N,websit,facebook, Youtube, BussinessBrief;



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

// prashant sahani

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



        Mb = findViewById(R.id.Mb);
        Em = findViewById(R.id.Em);
        AofB = findViewById(R.id.AofB);
        websit = findViewById(R.id.websit);
        Comp_N = findViewById(R.id.Comp_N);
        facebook = findViewById(R.id.facebook);

        Youtube = findViewById(R.id.Youtube);
        BussinessBrief = findViewById(R.id.BussinessBrief);



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

    if(mob.length()>1)
    {
        mobil.setText(mob);
        Mb.setVisibility(View.VISIBLE);
    }else {
        Mb.setVisibility(View.GONE);
    }

    if(eml.length()>1)
    {
        emaill.setText(eml);
        Em.setVisibility(View.VISIBLE);
    }else {
        Em.setVisibility(View.GONE);
    }

    if(cls.length()>1)
    {
        clas.setText(cls);
        AofB.setVisibility(View.VISIBLE);
    }else {
        AofB.setVisibility(View.GONE);
    }



    if(cmp_n.length()>1)
    {
        comp_N.setText(cmp_n);

        Comp_N.setVisibility(View.VISIBLE);
    }
    else {
        Comp_N.setVisibility(View.GONE);
    }

    if(websitee.length()>1) {
        webs.setText(websitee);

        websit.setVisibility(View.VISIBLE);
    }
        else {
        websit.setVisibility(View.GONE);
    }


        if(faceb.length()>1) {
            facebkpage.setText(faceb);
            facebook.setVisibility(View.VISIBLE);
        }
        else {
            facebook.setVisibility(View.GONE);
            }


        if(youtube.length()>1) {
            Youtub.setText(youtube);
            Youtube.setVisibility(View.VISIBLE);
        }else {
            Youtube.setVisibility(View.GONE);
    }

    if(Business_Brief.length()>1)
    {
        BusinessB.setText(Business_Brief);
        BussinessBrief.setVisibility(View.VISIBLE);

    }else {
        BussinessBrief.setVisibility(View.GONE);
    }




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
