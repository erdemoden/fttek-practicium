package com.fttek.fttekproje.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fttek.fttekproje.entties.Urun;

public interface UrunRepository extends JpaRepository<Urun,Long> {

	@Query(value = "select * from urun where son_kullanma_tarihi < cast(now() as date)",nativeQuery = true)
	List<Urun>findAllOutOfDates();
	
	@Query(value = "select * from urun where son_kullanma_tarihi >= cast(now() as date) OR son_kullanma_tarihi IS NULL",nativeQuery = true)
	List<Urun>findAllNotOutOfDates();
}
