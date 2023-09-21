package ru.job4j.tracker;

import com.sun.net.httpserver.Authenticator;
import ru.job4j.tracker.Item;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private Item packResultItem(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        LocalDateTime created = resultSet.getTimestamp("created").toLocalDateTime();
        return new Item(id, name, created);
    }

    private void packResultList(List<Item> list, ResultSet resultSet) throws SQLException {
        list.add(packResultItem(resultSet));
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        String query = "insert into items(name, created) values(?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                item.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        String query = "update items set name = ?, created = ? where id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void delete(int id) {
        String query = "delete from items where id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        String query = "select * from items;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                packResultList(result, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        String query = "select id, name, created from items where name = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, key);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                packResultList(result, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        String query = "select id, name, created from items where id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = packResultItem(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}