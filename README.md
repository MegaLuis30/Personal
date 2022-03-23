# r1-Hibarguen

DESARROLLO DE LA API

La clase DemoWeb1.java
Es la clase que arranca cuando iniciamos la aplicación:

```Java
package com.mitocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoWeb1 {

	public static void main(String[] args) {
		SpringApplication.run(DemoWeb1.class, args);
		
	}
	
} 

```


La clase Person.java

La entidad de nuestro objeto Person, esta clase va a mapear los atributos como campos en la base de datos:

```
package com.mitocode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)

public class person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@Column(name = "numero_cuenta")
	private String numero_cuenta;
	
	@Column(name = "saldo")
	@CreatedDate
	private String saldo;
	
	@Column(name = "estado")
	private String estado;
	
	public person() {

	}

	public person(Long id, String nombre, String numero_cuenta, String saldo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.numero_cuenta = numero_cuenta;
		this.saldo=saldo;
		this.estado = estado;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nombre=" + nombre + ", numero_cuenta=" + numero_cuenta + ", saldo=" + saldo + ", estado="+ estado +"]";
	}

	
} 

```

La clase PersonRepository.java

Esta clase nos ayuda a realizar operaciones en nuestra base de datos sin escribir tantas líneas de código, Spring Data realiza esto por nosotros, operaciones como delete, save, findAll, son algunos de los métodos que realiza automáticamente:


```
package com.mitocode;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mitocode.person;


@Repository
public interface PersonRepository {

	List<person> findByName(@Param("nombre") String nombre);

	List<person> findAll();

	person save(person person);

	void deleteById(Long id);
	
} 

```










