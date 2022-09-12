package com.fttek.fttekproje.entties;

import java.sql.Date;
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
@Table(name = "urun")
@Data
public class Urun {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "adi",nullable = false)
	private String adi;
	@Column(name = "fiyat",nullable = false)
	private int fiyat;
	@Column(name = "son_kullanma_tarihi",nullable = true)
	private Date sonKullanmaTarihi;
	
	@JsonIgnore
	@OneToMany(mappedBy = "urunId",cascade = {CascadeType.ALL})
	private List<UrunYorum> urunYorum;
}
