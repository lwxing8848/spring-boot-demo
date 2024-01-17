import com.xx.demo.service.DemoService;
import org.junit.Test;

import javax.annotation.Resource;

public class DemoTest {

    @Resource
    private DemoService demoService;

    @Test
    public void test_castDto() {
        String sql = "INSERT INTO `speech_quality`.`speech_instance_hit_log`(`company_id`, `label_name`, `hit_type`, `instance_id`, `hit_id`, `gmt_create`, `gmt_modified`, `anchor_id`, `hit_role_type`, `ext_data`) VALUES (2, '前端', 1, 74635, 7, NOW(), NOW(), NULL, NULL, NULL);";
        demoService.execDDL(sql);
    }
}
