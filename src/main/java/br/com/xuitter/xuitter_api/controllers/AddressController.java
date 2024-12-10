package br.com.xuitter.xuitter_api.controllers;

import br.com.xuitter.xuitter_api.dtos.AddressResponse;
import br.com.xuitter.xuitter_api.model.Address;
import br.com.xuitter.xuitter_api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Contract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/fetch-address", produces = "application/json")
    public AddressResponse fetchedAddress(@RequestParam String zipCode) {
        Address address = addressService.fetchAddress(zipCode);

        return new AddressResponse(
                address.getZipCode(),
                address.getStreet(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState()
        );
    }
}