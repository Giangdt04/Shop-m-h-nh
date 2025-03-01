package com.example.shopmohinh.repository;

import com.example.shopmohinh.entity.BrandEntity;
import com.example.shopmohinh.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    @Transactional
    @Query(value = """
            select * from brand order by brand.id desc limit 1
            """,nativeQuery = true)
    SizeEntity getTop1();

    @Transactional
    Optional<BrandEntity> findByCode(String code);
}
