package com.hiber;

import java.lang.reflect.Field;
import java.util.List;

import com.hiber.Entity.Capitan;
import com.hiber.Entity.IplTeam;
import com.hiber.Service.TeamDao;
import com.hiber.Service.TeamServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IllegalArgumentException, IllegalAccessException
    {	
        TeamDao team=new TeamServiceImpl();

       //get Team By Id	
       
       IplTeam singleTeam=team.getTeamById(1L);
       Field [] fields=singleTeam.getClass().getDeclaredFields();
       for(Field f:fields) {
    	   f.setAccessible(true);
    	   Object value=f.get(singleTeam);
    	  System.out.println(f.getName()+"  :"+value);
       }
       
       //get All Teams
       List<IplTeam> allTeams=team.getTeams();
       for(IplTeam i:allTeams) {
    	   System.out.println(i);
       }
       System.out.println();
       
       //saveTeam withCapitan
       
       Capitan cap=new Capitan();
       cap.setAge(35);
       cap.setCapitanName("Yuvaraj");
       cap.setRuns(3500L);
       cap.setwPercentage(35.90);
       IplTeam pwi=new IplTeam();
       pwi.setJersyColour("Navy Blue");
       pwi.setLogo("Indian flag with solider on Horse");
       pwi.setTeamName("PWI");
       pwi.setCapitan(cap);
       pwi.setTrophies(0);
       team.saveTeam(pwi);
       
       
       //saveTeam withoutCapitan
       IplTeam GL=new IplTeam();
       GL.setJersyColour("Safron");
       GL.setLogo("Loin");
       GL.setTeamName("GL");
       GL.setTrophies(0);
       team.saveTeam(GL);
       
       //save Capitan
       Capitan raina=new Capitan();
       raina.setAge(35);
       raina.setCapitanName("Raina");
       raina.setRuns(5600L);
       raina.setwPercentage(80.00);
       
       team.saveCapitan(raina);
       
      //update Team
       GL.setCapitan(raina);
       team.updateTeam(GL,13L);
       
       //delete Team and Capitan
       team.deleteById(12L);
       team.deleteCap(14L);
    }
}
