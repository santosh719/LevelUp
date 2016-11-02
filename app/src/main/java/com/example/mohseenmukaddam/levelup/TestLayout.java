package com.example.mohseenmukaddam.levelup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.honorato.multistatetogglebutton.MultiStateToggleButton;



/**
 * Created by mohseenmukaddam on 10/27/16.
 */
@EActivity( R.layout.task_builder )
public class TestLayout extends AppCompatActivity {
    @ViewById( R.id.mstb_multi_id_1 )
    MultiStateToggleButton skillButtons1;

    @ViewById( R.id.mstb_multi_id_2 )
    MultiStateToggleButton skillButtons2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.task_builder);


        //this.L = new CharacterAnimated( )
    }
    @AfterViews
    void setMultipleChoiceButtons(){
        //added android annotations
        skillButtons1.enableMultipleChoice( true );
        skillButtons2.enableMultipleChoice( true );
    }
}
