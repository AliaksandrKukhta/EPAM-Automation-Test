package com.epam.automation.data;

import com.epam.automation.browser.configuration.Configuration;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    public String selectUsersMail() {
        return String.format("SELECT e_mail FROM user.test_users ");
    }

    public void fillingInUser(ArrayList<String> users) {
        String url = Configuration.getDataUrl();
        String user = Configuration.getDataUser();
        String password = Configuration.getDataPassword();

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectUsersMail());
            while (rs.next()) {
                users.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
