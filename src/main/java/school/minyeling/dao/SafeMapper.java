package school.minyeling.dao;

import org.springframework.stereotype.Component;
import school.minyeling.domain.Safe;

@Component
public interface SafeMapper {

    public void insertOne(Safe safe);

}
