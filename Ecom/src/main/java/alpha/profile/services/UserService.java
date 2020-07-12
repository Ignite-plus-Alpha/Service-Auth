package alpha.profile.services;

import alpha.profile.exceptions.AddressNotFoundException;
import alpha.profile.model.Address;
import alpha.profile.repo.UserRepo;
import alpha.profile.exceptions.UserNotFoundException;
import alpha.profile.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    //Createuser
    public User createUser(User user) {
        return userRepo.save(user);
    }

    //getAllusers
    public List<User> getAllUser(){
        return userRepo.findAll();

    }

    public Optional<User> getUserById(String userId) throws UserNotFoundException {
        Optional<User> user=userRepo.findById(userId);

        if(!user.isPresent())
            throw new UserNotFoundException("user not found");
        return user;
    }


    public void deleteUserById(String userId) {

        Optional<User> user=userRepo.findById(userId);
        if(!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found in repo,enter correct details");
        }

        userRepo.deleteById(userId);

    }


    public User updateUserById(String userId,String newName) throws UserNotFoundException {

        Optional<User> userData = userRepo.findById(userId);

        if(userRepo.findById(userId).isPresent()) {
            User user=userData.get();
            user.setFirstName(newName);
            return userRepo.save(user);
        }
        throw new UserNotFoundException("User not found");
    }

}
