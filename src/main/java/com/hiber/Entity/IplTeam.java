package com.hiber.Entity;


import javax.persistence.*;

@Entity
@Table(name="Ipl_Teams")
public class IplTeam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Team_Name",unique=true,nullable=false)
	private String teamName;
	
	@Column(name="Trophies",unique=false,nullable=true)
	private Integer trophies;
	
	@Column(name="Jersy_Colour")
	private String jersyColour;
	
	@Column(name="Logo")
	private String logo;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="cap_id",referencedColumnName="id")
	private Capitan capitan;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getTrophies() {
		return trophies;
	}

	public void setTrophies(Integer trophies) {
		this.trophies = trophies;
	}

	public String getJersyColour() {
		return jersyColour;
	}

	public void setJersyColour(String jersyColour) {
		this.jersyColour = jersyColour;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Capitan getCapitan() {
		return capitan;
	}

	public void setCapitan(Capitan capitan) {
		this.capitan = capitan;
	}

	@Override
	public String toString() {
		return "IplTeam [id=" + id + ", teamName=" + teamName + ", trophies=" + trophies + ", jersyColour="
				+ jersyColour + ", logo=" + logo +  "]";
	}
	
	
	
	
}
