package com.heyang.hrm;

import com.heyang.hrm.domain.Systemdictionary;
import com.heyang.hrm.service.ISystemdictionaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysManage9001Application.class)
public class ISystemdictionarytemServiceTest {
    @Autowired
    private ISystemdictionaryService systemdictionaryService;
    @Test
    public void testFindAll() throws Exception{
        List<Systemdictionary> systemdictionaries = systemdictionaryService.selectList(null);
        for (Systemdictionary systemdictionary : systemdictionaries) {
            System.out.println(systemdictionary);
        }
    }
}
