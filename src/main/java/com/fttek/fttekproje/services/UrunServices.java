package com.fttek.fttekproje.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fttek.fttekproje.entties.Urun;
import com.fttek.fttekproje.repositories.UrunRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrunServices {


	private final UrunRepository urunRepository;
	
	public void saveUrun(Urun urun) {
		urunRepository.save(urun);
	}
	
	public List<Urun> outOfDate(){
		return urunRepository.findAllOutOfDates();
	}
	
	public List<Urun> notOutOfDate(){
		return urunRepository.findAllNotOutOfDates();
	}
}
