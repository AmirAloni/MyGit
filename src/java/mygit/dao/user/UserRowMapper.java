package mygit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import mygit.entity.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();
        user.setUserId(rs.getString("userId"));
        user.setUserPassword(rs.getString("userPassword"));
        user.setUserName(rs.getString("userName"));
        user.setUserEmail(rs.getString("userEmail"));
        return user;
    }
}