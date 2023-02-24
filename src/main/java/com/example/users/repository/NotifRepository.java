package com.example.users.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.users.entities.Notif;

public interface NotifRepository extends JpaRepository<Notif, Long>{

	List<Notif> findByNameuser(String username);

}
