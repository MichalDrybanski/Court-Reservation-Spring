package pl.drybanski.court.group;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    public Group createGroup(GroupDTO groupDTO){
       // Group group = new Group(groupDTO.getName(), groupDTO.getPlayer());
       // groupRepository.save(group);
       return null;
    }

    public List<GroupDTO> getGroups(){
        List<Group> groupDB = groupRepository.findAll();

        return groupDB.stream()
                .map(group -> new GroupDTO(group.getName(), group.getPlayer().getId()))
                .toList();
    }

}
