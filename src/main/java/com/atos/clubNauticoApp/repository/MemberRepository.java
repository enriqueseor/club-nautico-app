package com.atos.clubNauticoApp.repository;

import java.util.Optional;

import com.atos.clubNauticoApp.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	public Optional<Member> findByDni(String dni);

}
