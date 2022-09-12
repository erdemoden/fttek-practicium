package com.fttek.fttekproje.services;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.fttek.fttekproje.entties.Kullanici;
import com.fttek.fttekproje.entties.Urun;
import com.fttek.fttekproje.entties.UrunYorum;
import com.fttek.fttekproje.repositories.KullaniciRepository;
import com.fttek.fttekproje.repositories.UrunRepository;
import com.fttek.fttekproje.repositories.UrunYorumRepository;
import com.fttek.fttekproje.requests.UrunYorumRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrunYorumServices {

	private final UrunYorumRepository urunYorumRepository;
	private final UrunRepository urunRepository;
	private final KullaniciRepository kullaniciRepository;
	public void saveUrunYorum(UrunYorumRequest urunYorumRequest) {
		Kullanici kullanici = kullaniciRepository.findById(urunYorumRequest.getKullaniciId()).orElse(null);
		Urun urun = urunRepository.findById(urunYorumRequest.getUrunId()).orElse(null);
		UrunYorum urunYorum = new UrunYorum();
		urunYorum.setUrunId(urun);
		urunYorum.setKullaniciId(kullanici);
		urunYorum.setUrunYorum(urunYorumRequest.getUrunYorum());
		urunYorum.setYorumTarihi(new Date(Calendar.getInstance().getTime().getTime()));
		urunYorumRepository.save(urunYorum);
	}
	
	public List<UrunYorum> listUrunYorumsByUrun(long urunId){
		 return urunYorumRepository.findByUrunId(urunId);
	}
	
	public List<UrunYorum> listUrunYorumsByKullanici(long kullaniciId){
		return urunYorumRepository.findByKullanici(kullaniciId);
	}
	
	public List<UrunYorum> listUrunYorumsByKullaniciWithYorumdate(long kullaniciId,String baslangic,String bitis){
		return urunYorumRepository.findByKullaniciBetweenYorumDates(kullaniciId, baslangic, bitis);
	}
	public List<UrunYorum> yorumaGoreUrun(String baslangic,String bitis){
		List <UrunYorum> urunYorums = urunYorumRepository.findAllByUrunYorumBetween(baslangic, bitis);
		return urunYorums;
	}
	
	
}
