package com.example.mohseenmukaddam.levelup.baseclasses;

/**
 * Created by mohseenmukaddam on 10/27/16.
 */

import java.util.List;

/**
 * Update objects are generic and can hold different implementations of LevelUp() and SkillsetUpgrade().
 * Use Update factory to generate those objects.
 * NOTE: Default values og UpdateArgs are -1 for max, level, currentExp and addExp
 * and rate is NORMAL
 */
public class Update implements UpdateModules{
    private UpdateArgs args;

    public Update( UpdateArgs args ){
        this.args = args;
    }
    public Update(){
        this.args = new UpdateArgs();
    }
    public void setArgs( UpdateArgs args ){
        this.args = args;
    }
    public UpdateArgs getArgs(){
        return this.args;
    }
    //TODO: check Level up condition method
    public UpdateArgs levelUp(){
        UpdateArgs returnObj;
        returnObj = this.getArgs();
        returnObj.setMax(this.getMaxPoints());

        //check whether to level up or not
        if( ( returnObj.getCurrentExp() + returnObj.getAddExp() ) < returnObj.getMax() )
            return null;

        returnObj.setLevel(returnObj.getLevel() + 1);
        returnObj.setCurrentExp((returnObj.getCurrentExp() + returnObj.getAddExp() ) - returnObj.getMax());
        returnObj.setAddExp(0);

        return returnObj;
    }

    /**
     * updateSkill function will take a skill level and update the value
     * assuming levelup has occured
     * @param skill [ double ] : skill that you want to update
     * @return [ double ] : updated value of skill
     */
    private double updateSkill( double skill ){
        skill = ( ( ( 100 - ( 2 * skill ) ) / 100 ) + skill );
        return skill;
    }

    /**
     * skillsetUpgrade takes current state (Assuming level up) and updates each skillset
     * specified in the List Parameter
     * @param skillset [ Skillset ] : Current state of skillset of player
     * @param args [ List<Skillset> ] : List of skills to update (Associated with each task)
     * @return [ Skillset ] : upgraded skillset object
     */
    public Skillset skillsetUpgrade( Skillset skillset , List<String> args ){
        double temp;
        for( String  skill : args ){
            temp = -1;
            switch ( skill ){
                case "IQ": temp = skillset.getIq();
                    skillset.setIq( this.updateSkill( temp ) );
                    break;
                case "CHARISMA": temp = skillset.getCharisma();
                    skillset.setCharisma( this.updateSkill( temp ) );
                    break;
                case "STRENGTH": temp = skillset.getStrength();
                    skillset.setEndurance( this.updateSkill( temp ) );
                    break;
                case "ENDURANCE": temp = skillset.getEndurance();
                    skillset.setEndurance( this.updateSkill( temp ) );
                    break;
                case "LEADERSHIP": temp = skillset.getLeadership();
                    skillset.setLeadership( this.updateSkill( temp ) );
                    break;
                case "CREATIVITY": temp = skillset.getCreativity();
                    skillset.setCreativity( this.updateSkill( temp ) );
                    break;
            }
        }
        return skillset;
    }

    /**
     * getBasePoints will get the base points for each level
     * Note: this is not the same as total points in a given level
     * Use this value to calculate maxPoints per level
     * @Required: UpdateArg object with current state info
     * @return [ double ] : base points for given level
     */
    private double getBasePoints(){
        int level = this.args.getLevel();
        if( level > 1 && level < 16 )
            return( 2700 + ( 10 * level ) );
            //16-45
        else if( level > 15 && level < 46 )
            return( 100000 + ( 25 * level ) );
            //46-85
        else if( level > 45 && level < 86 )
            return( 300000 + ( 55 * level ) );
            //85-100
        else if( level > 85 && level < 101 )
            return( 800000 + ( 75 * level ) );
        //should not get inside else
        else
            return( -1 );
    }

    /**
     * getMaxPoints uses the base points for each level and calculates the maxpoints for
     * each level. Making it more difficult as one levels up. Also, based on learning rate
     * @Requires: UpdateArgs Object
     * @return [ double ] : max points for given level
     */
    private double getMaxPoints(){
        double basePoints = this.getBasePoints();
        String rate = this.args.getRate();
        double factor = 1;
        if( basePoints == -1 ) {
            //TODO: log error
        }
        switch ( rate ){
            case "FAST":
                factor = 0.8;
                break;
            case "SLOW":
                factor = 1.2;
                break;
            default:
                factor = 1;
        }
        return ( factor * Math.pow( basePoints, 3 ) );
    }
}