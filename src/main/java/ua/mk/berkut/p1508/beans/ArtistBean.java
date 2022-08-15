package ua.mk.berkut.p1508.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.mk.berkut.p1508.tables.Artist;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistBean {
    private List<Artist> artists;

}
