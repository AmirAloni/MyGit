package mygit.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mygit.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImp implements UserDao{
    public UserDaoImp(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;
    @Override
    public List<User> findAll() {
        return template.query("select * from users", new UserRowMapper());
    }
    @Override
    public void insertUser(User user) {
        final String sql = "insert into users(userId, userName , userPassword,userEmail) values(:userId,:userName,:userEmail,:userPassword)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userId", user.getUserId())
                .addValue("userName", user.getUserName())
                .addValue("userEmail", user.getUserEmail())
                .addValue("userPassword", user.getUserPassword());
        template.update(sql,param, holder);
    }
    @Override
    public void updateUser(User user) {
        final String sql = "update users set userName=:userName, userPassword=:userPassword, userEmail=:userEmail where userId=:userId";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userId", user.getUserId())
                .addValue("userName", user.getUserName())
                .addValue("userEmail", user.getUserEmail())
                .addValue("userPassword", user.getUserPassword());
        template.update(sql,param, holder);
    }
    @Override
    public void deleteUser(User user) {
        final String sql = "delete from users where userId=:userId";
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("userId", user.getUserId());
        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }
}
