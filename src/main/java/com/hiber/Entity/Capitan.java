package com.hiber.Entity;

import javax.persistence.*;

@Entity
@Table
public class Capitan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String capitanName;
	private Integer age;
	private Long runs;
	private Double wPercentage   ;
	@OneToOne(mappedBy="capitan"/* cascade=CascadeType.ALL,fetch=FetchType.EAGER */)
//	@JoinColumn(name="team_id",referencedColumnName="id")
	private IplTeam iplTeam;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCapitanName() {
		return capitanName;
	}

	public void setCapitanName(String capitanName) {
		this.capitanName = capitanName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getRuns() {
		return runs;
	}

	public void setRuns(Long runs) {
		this.runs = runs;
	}

	public Double getwPercentage() {
		return wPercentage;
	}

	public void setwPercentage(Double wPercentage) {
		this.wPercentage = wPercentage;
	}

	public IplTeam getIplTeam() {
		return iplTeam;
	}

	public void setIplTeam(IplTeam iplTeam) {
		this.iplTeam = iplTeam;
	}

	@Override
	public String toString() {
		return "Capitan [id=" + id + ", capitanName=" + capitanName + ", age=" + age + ", runs=" + runs
				+ ", wPercentage=" + wPercentage + "]";
	}
	
	
	
	
	
}
