package com.hiber.Service;

import java.util.List;

import com.hiber.Entity.Capitan;
import com.hiber.Entity.IplTeam;

public interface TeamDao {
	
	
	IplTeam getTeamById(Long Id) ;

	List<IplTeam> getTeams();
	
	void saveTeam(IplTeam team);
	
	void saveCapitan(Capitan cap);
	
	void updateTeam(IplTeam ipl,Long Id);

	void deleteById(long l);

	void deleteCap(long l);

	void deleteTeam(long l);
}
