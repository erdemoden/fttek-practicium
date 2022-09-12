package com.fttek.fttekproje.requests;

import java.util.Date;

import com.fttek.fttekproje.entties.Kullanici;
import com.fttek.fttekproje.entties.Urun;

import lombok.Data;

@Data
public class UrunYorumRequest {

	private String urunYorum;
	
	private long urunId;
	
	private long kullaniciId;
	
}
