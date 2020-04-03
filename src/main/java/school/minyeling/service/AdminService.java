package school.minyeling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import school.minyeling.Utils.RedisUtils;
import school.minyeling.dao.AdminMapper;
import school.minyeling.domain.Admin;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public List<Admin> allAdmin(){
        Admin admin=new Admin();
        admin.setId(1);
        if (redisTemplate.opsForHash().hasKey(admin.getId().toString(),"id")){
            Object id = redisTemplate.opsForHash().get(admin.getId().toString(), "id");
            System.out.println("id = "+id);
            int ids=Integer.parseInt(id.toString());
            System.out.println(Integer.parseInt(id.toString()));
            admin.setId(ids);

            admin.setPassword((String)(redisTemplate.opsForHash().get(admin.getId().toString(),"password")));
            admin.setUsername((String)(redisTemplate.opsForHash().get(admin.getId().toString(),"username")));
            List<Admin> adminList=new ArrayList<>();
            adminList.add(admin);
            System.out.println("===========我是 redis ===========");
            return adminList;
        }

        List<Admin> adminList = adminMapper.allAdmin();

        admin =adminList.get(0);

        redisTemplate.opsForHash().put(admin.getId().toString(),"id",admin.getId().toString());
        redisTemplate.opsForHash().put(admin.getId().toString(),"password",admin.getPassword());
        redisTemplate.opsForHash().put(admin.getId().toString(),"username",admin.getUsername());


        return adminList;
    }

}
