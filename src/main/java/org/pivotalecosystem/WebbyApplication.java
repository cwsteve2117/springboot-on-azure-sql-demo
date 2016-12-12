package org.pivotalecosystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication
public class WebbyApplication implements CommandLineRunner {

    private final FooRepository fooRepository;

    public WebbyApplication(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        fooRepository.save(new Foo("This should work."));
    }


    public static void main(String[] args) {
		SpringApplication.run(WebbyApplication.class, args);
	}
}

@RepositoryRestResource
interface FooRepository extends JpaRepository<Foo,Long> {}

@Entity
class Foo {

	@Id
	@GeneratedValue
	private Long id;

    private String foo;

	public Foo(String foo) {
		this.foo = foo;
	}

    public Long getId() {
        return id;
    }

    public String getFoo() {
        return foo;
    }

    public Foo() {}

}