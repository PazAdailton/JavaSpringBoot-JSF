package br.com.pazimports.repository;

import org.springframework.test.context.junit4.SpringRunner;

public @interface Runwith {

	Class<SpringRunner> value();

}
