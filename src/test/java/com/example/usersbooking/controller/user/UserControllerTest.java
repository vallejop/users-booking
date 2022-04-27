package com.example.usersbooking.controller.user;

import com.example.usersbooking.model.User;
import com.example.usersbooking.service.users.UserService;
import com.example.usersbooking.utils.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    UserService userService;

    protected MockMvc mockMvc;

    private User user;

    private UserDto userDto;

    private String id;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();

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

    /*
    @Test
    void testGetAll_notNull() throws Exception {
        when(userService.getAll()).thenReturn(Arrays.asList(userDto));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/all"))
                .andExpect(status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value(user.getEmail()));
    }

    @Test
    void getUserById_notNull() {
    }

    @Test
    void updateUser_notNull() {
    }

    @Test
    void testCreateUser_notNull() {
    }

    @Test
    void testDeleteUser_notNull() {
    }
 */
}