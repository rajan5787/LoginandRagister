package com.example.rajanpipaliya.loginandragister;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import java.io.FileNotFoundException;



public class Profile extends AppCompatActivity {

    Toolbar toolbar;

    Button _save ;
    FloatingActionButton edit;

    EditText _name;
    EditText _email;
    EditText _password;
    EditText _subject;
    EditText _mobileno;
    EditText _schoolname;
    EditText _standard;

    ImageView profilepic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        _save = (Button)findViewById(R.id.save);
        edit = (FloatingActionButton)findViewById(R.id.edit);
        _name = (EditText)findViewById(R.id.name);
        _email = (EditText)findViewById(R.id.email);
        _password = (EditText)findViewById(R.id.password);
        _mobileno = (EditText)findViewById(R.id.mobileno);
        _schoolname = (EditText)findViewById(R.id.schoolname);
        _standard=(EditText)findViewById(R.id.standard);
        _subject=(EditText)findViewById(R.id.subject);
        profilepic=(ImageView)findViewById(R.id.cat_avatar);

        methoddiseble();
        toolbar.inflateMenu(R.menu.menu_profile);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_mtrl_am_alpha);
       // Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.cutecat);
       // profilepic.setImageBitmap(icon);
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choosePictureIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(choosePictureIntent, 0);
            }
        });
        _name.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        _schoolname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        _subject.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        _standard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        _mobileno.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        _email.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        _password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
    _save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //  _nameText.setEnabled(false);
            _name.setEnabled(false);
            _name.setFocusable(false);
            _schoolname.setEnabled(false);
            _schoolname.setFocusable(false);
            _email.setEnabled(false);
            _email.setFocusable(false);
            _password.setEnabled(false);
            _password.setFocusable(false);
            _mobileno.setEnabled(false);
            _mobileno.setFocusable(false);
            _subject.setEnabled(false);
            _subject.setFocusable(false);
            _standard.setEnabled(false);
            _standard.setFocusable(false);
            profilepic.setEnabled(false);


        }
    });
    edit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            _name.setEnabled(true);
            _schoolname.setEnabled(true);
            _mobileno.setEnabled(true);
            _standard.setEnabled(true);
            _subject.setEnabled(true);
            _email.setEnabled(true);
            _password.setEnabled(true);
            profilepic.setEnabled(true);



        }
    });

    }


    ///for import picture//////


    //Read more: http://www.androidhub4you.com/2014/10/android-custom-shape-imageview-rounded.html#ixzz3mHPeLeos

    protected void onActivityResult(int requestCode, int resultCode,Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            Uri imageFileUri = intent.getData();
            Display currentDisplay = getWindowManager().getDefaultDisplay();
            int dw = currentDisplay.getWidth();
            int dh = currentDisplay.getHeight() / 2 - 100;
            try {
                BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
                bmpFactoryOptions.inJustDecodeBounds = true;
                Bitmap bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageFileUri), null, bmpFactoryOptions);
                bmpFactoryOptions.inSampleSize = 2;
                bmpFactoryOptions.inJustDecodeBounds = false;
                bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(
                        imageFileUri), null, bmpFactoryOptions);
                profilepic.setImageBitmap(bmp);
            } catch (FileNotFoundException e) {
                Log.v("ERROR", e.toString());
            }
        }
    }

 void methoddiseble(){
     _name.setEnabled(false);
     _schoolname.setEnabled(false);
     _email.setEnabled(false);
     _password.setEnabled(false);
     _mobileno.setEnabled(false);
     _subject.setEnabled(false);
     _standard.setEnabled(false);
     profilepic.setEnabled(false);
 }
}
