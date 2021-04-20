package by.dach.app.service;

import by.dach.app.model.BodyType;
import by.dach.app.model.Transmission;
import by.dach.app.model.User;
import by.dach.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public User findUserById(int id) {
        return userRepository.getOne(id);
    }

    public List<User> findAllUserByCarTransmissionType(Transmission transmissionType) {
        return userRepository.findAllUserByCarTransmissionType(transmissionType);
    }

    public List<User> findAllUserByCarBodyType(BodyType bodyType) {
        return userRepository.findAllUserByCarBodyType(bodyType);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Page<User> findAllUserWhereCarVolumeBigger(Pageable pageable, int volume) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return userRepository.findAllUserWhereCarVolumeBigger(pageable, volume);
    }
}
