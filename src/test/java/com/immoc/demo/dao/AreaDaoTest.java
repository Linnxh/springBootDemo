package com.immoc.demo.dao;

import com.immoc.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {

        List<Area> areas = areaDao.queryArea();
        System.out.println(areas.toString());
    }

    @Test
    public void querAreaById() {
        Area area = areaDao.querAreaById(2);
        System.out.println(area.toString());
    }

    @Test
    public void insertArea() {
        Area area=new Area();
        area.setAreaName("南苑1");
        area.setPriority(3);
        area.setCreateTime("2019-01-01");
        area.setLastEditTime("2019-01-01");
        int i = areaDao.insertArea(area);
        assertEquals(1,i);
    }

    @Test
    public void updateArea() {
        Area area=new Area();
        area.setAreaName("南苑啦啦");
        area.setAreaId(2);
//        area.setLastEditTime(new Date());
        int i = areaDao.updateArea(area);
        assertEquals(1,i);
    }

    @Test
    public void deleteArea() {
        Area area=new Area();
        area.setAreaId(3);
        int i = areaDao.deleteArea(area);
        assertEquals(1,i);
    }
}