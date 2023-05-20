package so.fine.codingchallenge.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ZipcodesTest {

    private final Zipcodes zipcodes;

    @Autowired
    public ZipcodesTest(Zipcodes zipcodes) {
        this.zipcodes = zipcodes;
    }

    @Test
    public void basicTest() {
        Assertions.assertThat(zipcodes.get(1234)).isEqualTo("Berlin");
        Assertions.assertThat(zipcodes.get(4321)).isEqualTo("Brandenburg");
    }
}
