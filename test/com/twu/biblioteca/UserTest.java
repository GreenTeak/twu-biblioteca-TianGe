package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void should_be_return_UserInfo() {
        User user = new User(1, "xiaoming", "xiaoming@thoughtworks.com", "138919191911");
        assertThat(user.getId(), is(1));
    }

}