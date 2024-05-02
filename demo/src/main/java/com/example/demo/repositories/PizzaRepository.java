package com.example.demo.repositories;

import com.example.demo.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository  extends JpaRepository<Pizza, Long> {

}
