package examples.boot.springboard.dao;

import examples.boot.springboard.dto.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class MemberDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;

    public MemberDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
        .withTableName("member").usingGeneratedKeyColumns("id");
    }

    public Member getMember(String email){
        String sql = "SELECT * FROM member where email=:email";
        RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
        Map<String, ?> params = Collections.singletonMap("email",email);

        return jdbc.queryForObject(sql, params, rowMapper);
    }

    public Long addMember(Member member){
        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        System.out.println(member.getRegdate());
        return insertAction.executeAndReturnKey(params).longValue();
    }
}
