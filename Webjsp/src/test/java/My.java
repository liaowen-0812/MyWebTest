import com.lovo.bean.SysKaoqing;
import com.lovo.bean.SysStudent;
import com.lovo.dao.IKaoqingDao;
import com.lovo.mybatisdb.GetSession;
import com.lovo.service.IKaoqingService;
import com.lovo.service.impl.KaoqingServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class My {
    @Test
    public void my(){
        IKaoqingDao dao = GetSession.creatSession().getMapper(IKaoqingDao.class);
        Map map = new HashMap();
        map.put("name","8");
        System.out.println(dao.findAllKaoqingNum(map));
    }
}
