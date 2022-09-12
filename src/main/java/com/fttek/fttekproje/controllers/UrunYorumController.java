package com.fttek.fttekproje.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fttek.fttekproje.entties.UrunYorum;
import com.fttek.fttekproje.requests.UrunYorumRequest;
import com.fttek.fttekproje.services.UrunYorumServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("urunyorum")
@RequiredArgsConstructor
public class UrunYorumController {

	private final UrunYorumServices urunYorumServices;
	
	@PostMapping("/saveyorum")
	public void saveYorum(UrunYorumRequest urunYorum) {
		urunYorumServices.saveUrunYorum(urunYorum);
	}
	@GetMapping("/geturunyorums")
	public List<UrunYorum> yorumwithurun(@RequestParam long urunid){
		return urunYorumServices.listUrunYorumsByUrun(urunid);
	}
	@GetMapping("getbyyorumtarih")
	public List<UrunYorum>yorumTariheUrun(@RequestParam String baslangic, String bitis){
		System.out.println(baslangic);
		return urunYorumServices.yorumaGoreUrun(baslangic, bitis);
		
	}
	@GetMapping("/geturunyorumbykullanici")
	public List<UrunYorum> yorumWithKullanici(@RequestParam long kullanici){
		return urunYorumServices.listUrunYorumsByKullanici(kullanici);
	}
	@GetMapping("geturunyorumbydateandkullanici")
	public List<UrunYorum> yorumWithKullaniciAndDate(@RequestParam long kullanici,String baslangic,String bitis){
		return urunYorumServices.listUrunYorumsByKullaniciWithYorumdate(kullanici, baslangic, bitis);
	}
	
	
}
