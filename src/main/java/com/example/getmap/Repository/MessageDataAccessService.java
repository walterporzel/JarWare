package com.example.getmap.Repository;

import com.example.getmap.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class MessageDataAccessService implements MessageDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertMessage(UUID id, Message message) {
        return 0;
    }

    @Override
    public List<Message> selectAllMessages() {
        final String sql = "SELECT id, message FROM message";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String message = resultSet.getString("message");
            return new Message(id, message);
        });
    }

    @Override
    public Optional<Message> selectMessageById(UUID id) {
        final String sql = "SELECT id, message FROM message WHERE id = ?";
        Message messages = jdbcTemplate.queryForObject(sql,  new Object[]{id}, (resultSet, i) -> {
            UUID messageId = UUID.fromString(resultSet.getString("id"));
            String message = resultSet.getString("message");
            return new Message(messageId, message);
        });
        return Optional.ofNullable(messages);
    }

    @Override
    public int deleteMessageByID(UUID id) {
        return 0;
    }

    @Override
    public int updateMessageById(UUID id, Message message) {
        return 0;
    }
}
