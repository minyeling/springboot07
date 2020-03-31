package school.minyeling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.minyeling.dao.SafeMapper;
import school.minyeling.domain.Safe;

@Service
public class SafeService {

    @Autowired
    SafeMapper safeMapper;

    public void insertOne(Safe safe){
        System.out.println("》》》 safe="+safe);
        safeMapper.insertOne(safe);
    }

}
