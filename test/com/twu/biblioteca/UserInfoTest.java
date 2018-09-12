package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserInfoTest {
    @Test
    public void should_be_return_UserInfo() {
        UserInfo userInfo = new UserInfo(1, "xiaoming", "xiaoming@thoughtworks.com", "138919191911");
        assertThat(userInfo.getId(), is(1));
    }

}