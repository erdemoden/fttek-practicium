package com.fttek.fttekproje.entties;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "kullanici")
@Data
public class Kullanici {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "adi",length = 50)
	private String adi;
	@Column(name = "soyadi",length = 50)
	private String soyadi;
	@Column(name = "email",length = 50)
	private String email;
	@Column(name = "telefon",length = 15)
	private String telefon;
	
	@OneToMany(mappedBy = "kullaniciId",cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<UrunYorum>urunYorum;
	


}
