package org.example.lehmall.testsupport

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@DataJpaTest
@EnableJpaAuditing
abstract class DataJpaTestSupport
