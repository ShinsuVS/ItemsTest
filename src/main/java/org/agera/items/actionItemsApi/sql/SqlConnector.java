package org.agera.items.actionItemsApi.sql;

import org.agera.items.utils.CodeUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlConnector {

    private final Statement statement;
    private final Connection connection;

    public SqlConnector() {
        {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/serverstats?characterEncoding=utf8", "User1", "1234");
                statement = connection.createStatement();
            } catch (SQLException e) {
                CodeUtils.logToConsole(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public List<StatsTableEntity> getDataFromTable() {
        String query = "SELECT * FROM serverstats.serverstatstable";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            List<StatsTableEntity> Data = new ArrayList<>();
            while (resultSet.next()) {
                StatsTableEntity statsTable = new StatsTableEntity(resultSet.getString("playerDisplayName"), resultSet.getString("playerUUID"), resultSet.getInt("droppedActionItem"), resultSet.getInt("craftedActionItem"), resultSet.getInt("collectedActionItem"), resultSet.getInt("burningActionItem"));
                Data.add(statsTable);
            }

            return Data;
        } catch (SQLException e) {
            CodeUtils.logToConsole(e.getMessage());
            return null;
        }


    }

    public void setDataToTable(StatsTableEntity statsTable) {
        String sql = "INSERT INTO serverstats.serverstatstable (playerDisplayName, playerUUID, droppedActionItem, craftedActionItem,collectedActionItem,burningActionItem) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, statsTable.getPlayerDisplayName());
            preparedStatement.setString(2, statsTable.getPlayerUUID());
            preparedStatement.setInt(3, statsTable.getDroppedActionItem());
            preparedStatement.setInt(4, statsTable.getCraftedActionItem());
            preparedStatement.setInt(5, statsTable.getCollectedActionItem());
            preparedStatement.setInt(6, statsTable.getBurningActionItem());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            CodeUtils.logToConsole(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void testConnection() {
        try {
            this.connection.isValid(10);
            CodeUtils.logToConsole("DATABASE CONNECT SUCCESSFULLY");
        } catch (SQLException e) {
            CodeUtils.logToConsole(e.getMessage());
        }

    }

    //"UPDATE serverstats.serverstatstable SET craftedActionItem = 1 WHERE playerDisplayName = TheShinsu"
    public void updateDataFromTable(String playerDisplayName, String collumName, int value) {
        String sql = "UPDATE serverstats.serverstatstable SET " + collumName + " = " + value + " WHERE playerDisplayName = '" + playerDisplayName + "'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public StatsTableEntity selectDataFromTable(String playerDisplayName) {
        String sqlQuery = "SELECT * FROM serverstats.serverstatstable WHERE playerDisplayName = '" + playerDisplayName + "'";
        try {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            StatsTableEntity statsTableEntity = null;
            while (resultSet.next()) {
                statsTableEntity = new StatsTableEntity(resultSet.getString("playerDisplayName"), resultSet.getString("playerUUID"), resultSet.getInt("droppedActionItem"), resultSet.getInt("craftedActionItem"), resultSet.getInt("collectedActionItem"), resultSet.getInt("burningActionItem"));

            }
            return statsTableEntity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
