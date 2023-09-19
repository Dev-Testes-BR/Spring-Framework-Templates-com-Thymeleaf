package br.com.vinicius.crud.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name="nome")
	private String name;
	
	@Column(nullable = false, name = "data_nascimento")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birthDate;
	
	@Column(nullable = false, name = "profissão")
	private String profession;

	public Client() {
	}

	public Client(Long id, String name, LocalDate birthDate, String profession) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.profession = profession;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", profession=" + profession + "]";
	}
	
	
}
