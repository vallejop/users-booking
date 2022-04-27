package com.example.usersbooking.service.users;

import com.example.usersbooking.model.User;
import com.example.usersbooking.repository.IUserRepository;
import com.example.usersbooking.utils.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    private IUserRepository userRepository;

    private User user;

    private UserDto userDto;

    private String id;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        id = "625f3af6511ce93efa05e32d";

        user = new User();
        user.setName("Nelson Vallejo");
        user.setActive(true);
        user.setUntil(null);
        user.setAge(50);
        user.setEmail("nelson.vallejo@vasslatam.com");
        user.setPhone(Long.valueOf("3000000000"));
        user.setProfession("Developer");

        userDto = new UserDto(user.getName(),
                user.getActive(),
                user.getUntil(),
                user.getAge(),
                user.getEmail(),
                user.getPhone(),
                user.getProfession());
    }

    @Test
    void getAll_isNotNull() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        assertNotNull(userService.getAll());
    }

    @Test
    void getAll_isEmpty() {
        when(userRepository.findAll()).thenReturn(Arrays.asList());
        assertEquals(Arrays.asList(), userService.getAll());
    }

    @Test
    void getById_isNotNull() {
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        assertNotNull(userService.getById(id));
    }

    @Test
    void getById_isNull() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        assertNull(userService.getById(id+"xyz"));
    }

    @Test
    void updateSuscription_isNotNull() {
        when(userRepository.save(user)).thenReturn(user);
        assertNotNull(userService.updateSuscription(userDto, id));
    }

    @Test
    void updateSuscription_isUserDto() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        assertEquals(userDto, userService.updateSuscription(userDto, id));
    }

    @Test
    void create_isNotNull() {
        when(userRepository.save(user)).thenReturn(user);
        assertNotNull(userService.create(userDto));
    }

    @Test
    void create_userIsEqualUserDto() {
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(userDto, userService.create(userDto));
    }

    @Test
    void delete_isNotNull() {
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        assertNotNull(userService.delete(id));
    }

    @Test
    void delete_isNull() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        assertNull(userService.delete(id));
    }
}