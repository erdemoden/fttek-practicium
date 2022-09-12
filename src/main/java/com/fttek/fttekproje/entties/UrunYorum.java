package com.fttek.fttekproje.entties;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "urunyorum")
@Data
public class UrunYorum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "urun_yorum",length = 500)
	private String urunYorum;
	
	
	@Column(name = "yorum_tarihi")
	//@Temporal(TemporalType.DATE)
	private Date yorumTarihi;
	
	
	@ManyToOne
	@JoinColumn(name="urun_id")
	private Urun urunId;
	
	@ManyToOne
	@JoinColumn(name="kullanici_id")
	private Kullanici kullaniciId;
	
	
}
