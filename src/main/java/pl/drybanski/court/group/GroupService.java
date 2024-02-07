package pl.drybanski.court.group;

import org.springframework.stereotype.Service;
@Service
public class GroupService {
    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    public Group createGroup(GroupDTO groupDTO){
        Group group = new Group(groupDTO.getGroupName(), groupDTO.getPlayer());
        groupRepository.save(group);
        return group;
    }
}
