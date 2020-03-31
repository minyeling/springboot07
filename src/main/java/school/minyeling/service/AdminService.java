package school.minyeling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.minyeling.dao.AdminMapper;
import school.minyeling.domain.Admin;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public List<Admin> allAdmin(){

        return adminMapper.allAdmin();
    }

}
