package br.com.xuitter.xuitter_api.service;

import br.com.xuitter.xuitter_api.model.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

    private final RestTemplate restTemplate;

    public AddressService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Address fetchAddress(String zipCode) {
        String url = "https://viacep.com.br/ws/" + zipCode + "/json/";
        Address address = restTemplate.getForObject(url, Address.class);
        return address;
    }
}
