package com.mtd.detector.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mtd.common.annotation.Log;
import com.mtd.common.core.controller.BaseController;
import com.mtd.common.core.domain.AjaxResult;
import com.mtd.common.enums.BusinessType;
import com.mtd.detector.domain.traffic;
import com.mtd.detector.service.ItrafficService;
import com.mtd.common.utils.poi.ExcelUtil;
import com.mtd.common.core.page.TableDataInfo;

/**
 * 恶意流量信息Controller
 * 
 * @author lixu
 * @date 2025-05-19
 */
@RestController
@RequestMapping("/detector/traffic")
public class trafficController extends BaseController
{
    @Autowired
    private ItrafficService trafficService;

    /**
     * 查询恶意流量信息列表
     */
    @PreAuthorize("@ss.hasPermi('detector:traffic:list')")
    @GetMapping("/list")
    public TableDataInfo list(traffic traffic)
    {
        startPage();
        List<traffic> list = trafficService.selecttrafficList(traffic);
        return getDataTable(list);
    }

    /**
     * 导出恶意流量信息列表
     */
    @PreAuthorize("@ss.hasPermi('detector:traffic:export')")
    @Log(title = "恶意流量信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, traffic traffic)
    {
        List<traffic> list = trafficService.selecttrafficList(traffic);
        ExcelUtil<traffic> util = new ExcelUtil<traffic>(traffic.class);
        util.exportExcel(response, list, "恶意流量信息数据");
    }

    /**
     * 获取恶意流量信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('detector:traffic:query')")
    @GetMapping(value = "/{trafficId}")
    public AjaxResult getInfo(@PathVariable("trafficId") Long trafficId)
    {
        return success(trafficService.selecttrafficByTrafficId(trafficId));
    }

    /**
     * 新增恶意流量信息
     */
    @PreAuthorize("@ss.hasPermi('detector:traffic:add')")
    @Log(title = "恶意流量信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody traffic traffic)
    {
        return toAjax(trafficService.inserttraffic(traffic));
    }

    /**
     * 修改恶意流量信息
     */
    @PreAuthorize("@ss.hasPermi('detector:traffic:edit')")
    @Log(title = "恶意流量信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody traffic traffic)
    {
        return toAjax(trafficService.updatetraffic(traffic));
    }

    /**
     * 删除恶意流量信息
     */
    @PreAuthorize("@ss.hasPermi('detector:traffic:remove')")
    @Log(title = "恶意流量信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{trafficIds}")
    public AjaxResult remove(@PathVariable Long[] trafficIds)
    {
        return toAjax(trafficService.deletetrafficByTrafficIds(trafficIds));
    }
}
