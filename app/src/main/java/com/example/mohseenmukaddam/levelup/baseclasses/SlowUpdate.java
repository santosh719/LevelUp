package com.example.mohseenmukaddam.levelup.baseclasses;

import java.util.List;

/**
 * Created by mohseenmukaddam on 10/27/16.
 */

public class SlowUpdate extends Update {
//    UpdateArgs args;
    public SlowUpdate( UpdateArgs args ){
        super( args );
    }
    public UpdateArgs levelUp(){
        //TODO: needs to be implemented (SLOW)
        //process data
        return args;
    }
    public Skillset skillsetUpgrade( Skillset skillset, List<String> args ){
        //TODO: needs to be implemented (SLOW)
        //process data
        return null;
    }
}
