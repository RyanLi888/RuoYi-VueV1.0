package com.mtd.detector.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtd.detector.mapper.trafficMapper;
import com.mtd.detector.domain.traffic;
import com.mtd.detector.service.ItrafficService;

/**
 * 恶意流量信息Service业务层处理
 * 
 * @author lixu
 * @date 2025-05-19
 */
@Service
public class trafficServiceImpl implements ItrafficService 
{
    @Autowired
    private trafficMapper trafficMapper;

    /**
     * 查询恶意流量信息
     * 
     * @param trafficId 恶意流量信息主键
     * @return 恶意流量信息
     */
    @Override
    public traffic selecttrafficByTrafficId(Long trafficId)
    {
        return trafficMapper.selecttrafficByTrafficId(trafficId);
    }

    /**
     * 查询恶意流量信息列表
     * 
     * @param traffic 恶意流量信息
     * @return 恶意流量信息
     */
    @Override
    public List<traffic> selecttrafficList(traffic traffic)
    {
        return trafficMapper.selecttrafficList(traffic);
    }

    /**
     * 新增恶意流量信息
     * 
     * @param traffic 恶意流量信息
     * @return 结果
     */
    @Override
    public int inserttraffic(traffic traffic)
    {
        return trafficMapper.inserttraffic(traffic);
    }

    /**
     * 修改恶意流量信息
     * 
     * @param traffic 恶意流量信息
     * @return 结果
     */
    @Override
    public int updatetraffic(traffic traffic)
    {
        return trafficMapper.updatetraffic(traffic);
    }

    /**
     * 批量删除恶意流量信息
     * 
     * @param trafficIds 需要删除的恶意流量信息主键
     * @return 结果
     */
    @Override
    public int deletetrafficByTrafficIds(Long[] trafficIds)
    {
        return trafficMapper.deletetrafficByTrafficIds(trafficIds);
    }

    /**
     * 删除恶意流量信息信息
     * 
     * @param trafficId 恶意流量信息主键
     * @return 结果
     */
    @Override
    public int deletetrafficByTrafficId(Long trafficId)
    {
        return trafficMapper.deletetrafficByTrafficId(trafficId);
    }
}
