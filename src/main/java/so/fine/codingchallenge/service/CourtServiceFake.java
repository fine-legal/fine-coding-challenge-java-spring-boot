package so.fine.codingchallenge.service;

import org.springframework.stereotype.Service;

@Service("fakeCourtService")
public class CourtServiceFake implements CourtService {

    @Override
    public String get(int zipcode) {
        return "Fake_Court";
    }
}
