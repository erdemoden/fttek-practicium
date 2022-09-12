package com.fttek.fttekproje.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fttek.fttekproje.entties.Urun;
import com.fttek.fttekproje.services.UrunServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/urun")
@RequiredArgsConstructor
public class UrunController {

	private final UrunServices urunServices;
	@PostMapping("/saveurun")
	public void saveUrun(Urun urun) {
		urunServices.saveUrun(urun);
	}
	@GetMapping("outofdate")
	public List<Urun> tarihiGecmis(){
		return urunServices.outOfDate();
		
	}
	@GetMapping("notoutofdate")
	public List<Urun> tarihGecmemis(){
		return urunServices.notOutOfDate();
	}
}
