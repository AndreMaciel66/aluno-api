package br.com.everis.alunos.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true, of = { "id", "name" })
@Data
public class Student {

	@Id
	@SequenceGenerator(name = "student_generator", sequenceName = "student_sequence", allocationSize = 1)
	@GeneratedValue(generator = "student_generator")
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String name;
}
