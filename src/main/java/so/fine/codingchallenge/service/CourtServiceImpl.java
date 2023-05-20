package so.fine.codingchallenge.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CourtServiceImpl implements CourtService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String get(int zipcode) {
        ResponseEntity<ZipcodeDto> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(String.format("https://api.courtdata.io/court/zip-code/%d", zipcode), ZipcodeDto.class);
        } catch (RestClientException e ) {
            throw new ZipcodeServiceException();
        }
        if (responseEntity.getBody() == null) {
            throw new ZipcodeServiceException();
        }
        return responseEntity.getBody().getCourt();
    }
}
