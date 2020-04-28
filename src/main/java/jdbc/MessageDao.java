package jdbc;


import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Slf4j
public class MessageDao {
    @Resource(lookup = "jdbc/MyDs")
    private DataSource ds;

//    private Logger log; // Чуть ниже есть log.error

    public Boolean insertMessages(long requestId, ArrayList<Message> messages) {
        // Если нечего добавлять - значит, всё хорошо
        if(messages == null || messages.size() == 0) {
            return true;
        }
        //Надеюсь, DataSource выставил con.setAutoCommit(false);? Если нет, надо выставить
        try (Connection con = ds.getConnection()) {
            try {
                con.setAutoCommit(false);
                lock(con, requestId);
                changeRequestStatus(con, requestId);
                insertMessages(con, requestId, messages);
                unlock(requestId);
                con.commit();
                return true;
            } catch (LockException | SQLException e) {
                con.rollback();
                log.error("Error. {}, {}", e.getMessage(), requestId);
                throw e;
            }
        } catch (Exception e) {
            String messagesText = messages.stream().map(Message::getMessage).collect(Collectors.joining(", "));
            log.error("Error. {}. {}, {}", e.getMessage(), requestId, messagesText);
            return false;
        }
    }

            private void lock(Connection con, long requestId) throws LockException {
        try (CallableStatement cs = con.prepareCall("{call LOCKS.lock_request(?)}")) {
            cs.setLong(1, requestId);
            cs.execute();
            int result = cs.getInt(0);
            if (result != 0) {
                throw new LockException(String.format("Can't lock registry with id=%s", requestId));
            }
        } catch (SQLException e) { //Иначе мы поймаем предыдущее jdbc.LockException, а оно нам ни к чему
            log.error("Error in lock(). {}. {}", e.getMessage(), requestId);
            throw new LockException(String.format("Can't lock registry with id=%s", requestId));
        }
    }

    private void insertMessages(Connection con, long requestId, ArrayList<Message> messages) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(
                "INSERT INTO MESSAGES(PK,RQ_PK,MSG) VALUES(MAX(PK)+1, ?,?)")) {
            for (Message msg : messages) {
                ps.setLong(1, requestId);
                ps.setString(2, msg.getMessage());
                ps.executeUpdate();
            }
        }
    }

    private void unlock(long registryId) throws SQLException {
        //....
    }

    private void changeRequestStatus(Connection con, long registryId) throws SQLException {
        //...
    }


}
