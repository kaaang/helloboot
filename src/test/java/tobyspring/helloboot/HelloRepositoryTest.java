package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
public class HelloRepositoryTest {
    @Autowired JdbcTemplate jdbcTemplate;
    @Autowired HelloRepository helloRepository;

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("Toby")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("kang")).isEqualTo(0);

        helloRepository.increaseCount("kang");
        assertThat(helloRepository.countOf("kang")).isEqualTo(1);

        helloRepository.increaseCount("kang");
        assertThat(helloRepository.countOf("kang")).isEqualTo(2);
    }
}
