package com.ruoyi.place.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.detection.domain.Detectionresult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.place.domain.Place;
import com.ruoyi.place.service.IPlaceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 场所码信息Controller
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Controller
@RequestMapping("/place/placecode")
public class PlaceController extends BaseController
{
    private String prefix = "place/placecode";

    @Autowired
    private IPlaceService placeService;


    @GetMapping()
    public String placecode()
    {
        return prefix + "/placecode";
    }

    /**
     * 查询场所码信息列表
     */

    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(Place place)
    {
        startPage();
        List<Place> list = placeService.selectPlaceList(place);
        return getDataTable(list);
    }

    /**
     * 导出场所码信息列表
     */

    @Log(title = "场所码信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Place place)
    {
        List<Place> list = placeService.selectPlaceList(place);
        ExcelUtil<Place> util = new ExcelUtil<Place>(Place.class);
        return util.exportExcel(list, "场所码信息数据");
    }

    /**
     * 新增场所码信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存场所码信息
     */

    @Log(title = "场所码信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Place place)
    {
        return toAjax(placeService.insertPlace(place));
    }

    /**
     * 修改场所码信息
     */

    @GetMapping("/edit/{no}")
    public String edit(@PathVariable("no") Long no, ModelMap mmap)
    {
        Place place = placeService.selectPlaceByNo(no);
        mmap.put("place", place);
        return prefix + "/edit";
    }

    /**
     * 修改保存场所码信息
     */

    @Log(title = "场所码信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Place place)
    {
        return toAjax(placeService.updatePlace(place));
    }

    /**
     * 删除场所码信息
     */

    @Log(title = "场所码信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(placeService.deletePlaceByNos(ids));
    }

    /**
     * 统计场所风险等级
     */

    @GetMapping("/eCharts")
    public String statistics(ModelMap mmap)
    {
        return prefix + "/eCharts";
    }
    //

    @Log(title = "场所风险等级统计", businessType = BusinessType.INSERT)
    @PostMapping("/eCharts")
    @ResponseBody
    public ArrayList<Map<String, String>> statisticsData()
    {
        ArrayList<Map<String, String>> list = placeService.getPlaceRisk();
        return list;
    }


    /**
     * 生成场所码
     */
    @GetMapping("/qrCode")
    public String qrCode()
    {
        return prefix + "/qrCode";
    }

//
//    /**
//     * 生成二维码
//     * */
//    @ApiOperation(value = "生成二维码", notes = "")
//    @PostMapping(value = "/qrCode")
//    public AjaxResult qrCode(){
//        try {
//            //若依系统封装的Config  不是若依使用  getProfile() + "/upload"
//            String filePath = RuoYiConfig.getUploadPath();
//            //查询数据库获取最新的apk的信息     根据自己需要调用数据里的数据
//            SysAppVersions newVersion = iSysAppVersionsService.getNewVersionId();
//            if (newVersion.getId()==null)
//                throw new CustomException("没有apk！");
//            //设置二维码图片名称，如果没有DateTool工具类也可以直接使用时间戳 System.currentTimeMillis()
//            String imgName = String.valueOf(newVersion.getId() + DateTool.currentTimestamp());
//            //设置二维码存储路径
//            String path = filePath + "/QRCode/" + imgName + ".png";
//            //本地测试IP+APK存储路径
//            String filename = "http://192.168.10.11:8086"+newVersion.getVersionsSite();
//            //真实使用IP
////            String filename = "https://***"+newVersion.getVersionsSite();
//            //保存二维码地址   profile若依系统映射文件路径方式
//            newVersion.setVersionsQrcode("/profile/upload/QRCode/" + imgName + ".png");
//            //将生成的二维码地址存入数据库   根据自己需求判断是否需要存储地址
//            //iSysAppVersionsService.updateVersionsQRcodeById(newVersion.getId(),newVersion.getVersionsQrcode());
//            img(filename, path);
//            return AjaxResult.success("生成二维码成功！");
//        }catch (Exception e){
//            return AjaxResult.error(e.getMessage());
//        }
//    }
//
//    private void img(String filename, String path) {
//        try {
//            //创建文件夹   如果没有工具类，则使用
//            //File file = new File(path);
//            //if (!file.exists()) {
//            //    file.mkdirs();
//            //}
//            FileUploadUtils.addFolder(path);
//            //生成二维码
//            ImageBuilderUtils.generateQRCodeImage(filename, path);
//        } catch (WriterException e) {
//            throw new CustomException("WriterException 生成二维码失败，请稍后再试！");
//        } catch (IOException e) {
//            throw new CustomException("IOException 生成二维码失败，请稍后再试！");
//        }
//    }
}
