package alpha.profile.services;

import alpha.profile.exceptions.AddressNotFoundException;
import alpha.profile.model.Address;
import alpha.profile.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;


    public Address createAddress(Address address) {
        return addressRepo.save(address);
    }


    public List<Address> getAllAddress(){
        return addressRepo.findAll();
    }

    public Optional<Address> getAddressById(String addressId) throws AddressNotFoundException {
        Optional<Address> address=addressRepo.findById(addressId);

        if(!address.isPresent())
            throw new AddressNotFoundException("address not found");
        return address;
    }

    public void deleteAddressById(String addressId) {
        Optional<Address> address=addressRepo.findById(addressId);
        if(!address.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Address not found in repo,enter correct details");
        }
        addressRepo.deleteById(addressId);
    }

    public Address updateAddressById(String addressId,String addressline1) throws AddressNotFoundException {
        Optional<Address> addressData = addressRepo.findById(addressId);

        if(addressRepo.findById(addressId).isPresent()) {
            Address address=addressData.get();
            address.setAddressLine1(addressline1);
            return addressRepo.save(address);
        }
      throw new AddressNotFoundException("Address not found");
    }
}