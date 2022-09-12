package com.fttek.fttekproje.repositories;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fttek.fttekproje.entties.Urun;
import com.fttek.fttekproje.entties.UrunYorum;

public interface UrunYorumRepository extends JpaRepository<UrunYorum, Long> {

	@Query(value = "select * from urunyorum inner join urun ON urun.id = urunyorum.urun_id where urun.id=:urunid",nativeQuery=true)
	List<UrunYorum> findByUrunId(@Param("urunid") long urunid);
	
	@Query(value = "select * from urunyorum where yorum_tarihi between :baslangic and :bitis",nativeQuery = true)
	List<UrunYorum> findAllByUrunYorumBetween(@Param("baslangic") String baslangic,@Param("bitis") String bitis);

	@Query(value = "select * from urunyorum inner join kullanici ON kullanici.id =urunyorum.kullanici_id where kullanici.id=:kullanici ",nativeQuery = true)
	List<UrunYorum> findByKullanici(@Param("kullanici") long kullanici);
	
	@Query(value = "select * from urunyorum inner join kullanici ON kullanici.id =urunyorum.kullanici_id where kullanici.id=:kullanici and yorum_tarihi between :baslangic and :bitis ",nativeQuery = true)
	List<UrunYorum> findByKullaniciBetweenYorumDates(@Param("kullanici") long kullanici,@Param("baslangic") String baslangic,@Param("bitis") String bitis);


}
