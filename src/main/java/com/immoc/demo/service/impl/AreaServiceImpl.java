package com.immoc.demo.service.impl;

import com.immoc.demo.dao.AreaDao;
import com.immoc.demo.entity.Area;
import com.immoc.demo.entity.Result;
import com.immoc.demo.handler.DemoException;
import com.immoc.demo.service.AreaService;
import com.immoc.demo.utils.ResultUtil;
import com.mysql.jdbc.StringUtils;
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

    public Area querAreaid(int areaId) {
        return areaDao.querAreaById(areaId);
    }

    //默认值处理Exception级别的
    @Transactional
    @Override
    public Result insertArea(Area area) {

        if (area == null || StringUtils.isNullOrEmpty(area.getAreaName())) {
            /*****返回格式统一化***/
            return ResultUtil.error(2, "名称不能为空");
        }

        if (area == null || area.getAreaName() == null) {
            throw new DemoException("区域信息名称不能为空");
        }
        int i = areaDao.insertArea(area);
        return ResultUtil.success();


    }

    @Override
    public int updateArea(Area area) {
        if (area == null || area.getAreaId() <= 0) {
            throw new DemoException("区域信息id,不能为空");
        }

        int i = areaDao.updateArea(area);
        return i;


    }

    @Override
    public int deleteArea(Area area) {
        if (area == null || area.getAreaId() <= 0) {
            throw new DemoException("删除信息id不能为空");
        }

        int i = areaDao.deleteArea(area);
        return i;

    }
}
