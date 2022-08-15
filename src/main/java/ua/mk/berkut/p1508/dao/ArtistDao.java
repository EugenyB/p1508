package ua.mk.berkut.p1508.dao;

import ua.mk.berkut.p1508.db.DBManager;
import ua.mk.berkut.p1508.tables.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDao {
    public List<Artist> findAll() {
        List<Artist> artists = new ArrayList<>();
        Connection connection = DBManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from artist");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ArtistId");
                String name = rs.getString("Name");
                artists.add(new Artist(id, name));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return artists;
    }

    public void addArtist(String name) {
        Connection connection = DBManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("insert into artist (Name) values (?)");
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteArtist(int id) {
        Connection connection = DBManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("delete from artist where ArtistId = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
