package com.nineSoftech.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nineSoftech.Entity.Payments;


@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {

	List<Payments> findAllByEventId(Long eventId);

	

}
