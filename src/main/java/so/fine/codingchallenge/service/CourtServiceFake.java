package so.fine.codingchallenge.service;

import org.springframework.stereotype.Component;

@Component
public class CourtServiceFake implements CourtService {

    @Override
    public String get(int zipcode) {
        return "Fake_Court";
    }
}
