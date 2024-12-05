package br.com.xuitter.xuitter_api.repositories;

import br.com.xuitter.xuitter_api.entities.Xuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XuitRepository extends JpaRepository<Xuit, Long> {
}