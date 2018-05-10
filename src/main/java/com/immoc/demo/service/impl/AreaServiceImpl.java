package com.immoc.demo.service.impl;

import com.immoc.demo.dao.AreaDao;
import com.immoc.demo.entity.Area;
import com.immoc.demo.handler.AreaException;
import com.immoc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area querAreaById(int areaId) {
        return areaDao.querAreaById(areaId);
    }

    //默认值处理Exception级别的
    @Transactional
    @Override
    public int insertArea(Area area) {
        if (area == null || area.getAreaName() == null) {
            throw new AreaException("区域信息名称不能为空");
        }
        try {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            int i = areaDao.insertArea(area);
            return i;
        } catch (Exception e) {
            throw new AreaException("插入区域信息失败");
        }

    }

    @Override
    public int updateArea(Area area) {
        if (area == null || area.getAreaId() <= 0 ) {
            throw new AreaException("区域信息id,不能为空");
        }
        try {
            int i = areaDao.updateArea(area);
            return i;
        } catch (Exception e) {
            throw new AreaException("修改区域信息失败");
        }

    }

    @Override
    public int deleteArea(Area area) {
        if (area == null || area.getAreaId() <= 0) {
            throw new AreaException("删除信息id不能为空");
        }
        try {
            int i = areaDao.deleteArea(area);
            return i;
        } catch (Exception e) {
            throw new AreaException("删除区域信息失败");
        }
    }
}
