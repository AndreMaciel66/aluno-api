package br.com.everis.alunos.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.alunos.api.domain.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Long>
{
   
}