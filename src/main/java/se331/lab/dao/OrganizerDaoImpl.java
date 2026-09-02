package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;
    @PostConstruct
    public void init(){
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                        .id(1L)
                        .organizationName("Kat Laydee")
                        .address("Somewhere Building 1, Somewhere Rd, Somewhere state")
                        .build()
        );
        organizerList.add(Organizer.builder()
                .id(2L)
                .organizationName("Fern Pollin")
                .address("Somewhere Building 2, Somewhere Rd, Somewhere state")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(3L)
                .organizationName("Carey Wales")
                .address("Somewhere Building 3, Somewhere Rd, Somewhere state")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(4L)
                .organizationName("Dawg Dahd")
                .address("Somewhere Building 4, Somewhere Rd, Somewhere state")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(5L)
                .organizationName("Kahn Opiner")
                .address("Somewhere Building 5, Somewhere Rd, Somewhere state")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(6L)
                .organizationName("Brody Kill")
                .address("Somewhere Building 6, Somewhere Rd, Somewhere state")
                .build()
        );
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex =  (page - 1) * pageSize;
        return organizerList.subList(firstIndex, Math.min(firstIndex + pageSize, organizerList.size()));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
