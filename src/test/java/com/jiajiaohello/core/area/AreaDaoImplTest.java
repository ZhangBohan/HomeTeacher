package com.jiajiaohello.core.area;

import com.jiajiaohello.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AreaDaoImplTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testGet() throws Exception {
        Area area = areaDao.get(1);
        System.out.println(area);
        assertNotNull(area);
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        Area area = new Area();
        area.setName("鞍山");
        area.setDescription("鞍山站");
        area.setPhone("18511870281");
        area.init();
        areaDao.saveOrUpdate(area);
        assertNotNull(area.getId());
    }

    @Test
    public void testGetList() throws Exception {

    }

    @Test
    public void testGetList1() throws Exception {

    }
}