package com.mtd.detector.mapper;

import java.util.List;
import com.mtd.detector.domain.DetectionRule;

/**
 * 检测规则Mapper接口
 * 
 * @author lixu
 * @date 2025-05-19
 */
public interface DetectionRuleMapper 
{
    /**
     * 查询检测规则
     * 
     * @param ruleId 检测规则主键
     * @return 检测规则
     */
    public DetectionRule selectDetectionRuleByRuleId(Long ruleId);

    /**
     * 查询检测规则列表
     * 
     * @param detectionRule 检测规则
     * @return 检测规则集合
     */
    public List<DetectionRule> selectDetectionRuleList(DetectionRule detectionRule);

    /**
     * 新增检测规则
     * 
     * @param detectionRule 检测规则
     * @return 结果
     */
    public int insertDetectionRule(DetectionRule detectionRule);

    /**
     * 修改检测规则
     * 
     * @param detectionRule 检测规则
     * @return 结果
     */
    public int updateDetectionRule(DetectionRule detectionRule);

    /**
     * 删除检测规则
     * 
     * @param ruleId 检测规则主键
     * @return 结果
     */
    public int deleteDetectionRuleByRuleId(Long ruleId);

    /**
     * 批量删除检测规则
     * 
     * @param ruleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDetectionRuleByRuleIds(Long[] ruleIds);
}
