package com.tp.admin.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tp.common.constant.OperateConstant;
import com.tp.admin.entity.User;
import com.tp.admin.service.IUserService;
import com.tp.common.controller.BaseController;
import org.springframework.web.bind.annotation.RestController;
import com.tp.common.exception.BizException;
import org.springframework.web.bind.annotation.PathVariable;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tp.common.page.Query;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author tp
 * @since 2018-04-28
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired private IUserService userService;

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return User
     */
    @GetMapping("/{id}")
    @ApiOperation(httpMethod = "GET", value = "通过ID查询系统用户")
    public Map<String, Object> get(@PathVariable String id) {
        try {
            return  successMap(userService.selectById(id));
        }catch (BizException e){
            return failMap(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return failMap(OperateConstant.OPERATION_FAIL);
        }
    }


    /**
     * 分页查询信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @RequestMapping("/page")
    @ApiOperation(httpMethod = "POST", value = "分页查询系统用户")
    public Map<String, Object> page(@RequestParam Map<String, Object> params) {
        try {
            Page<User> page = userService.selectPage(new Query<>(params), new EntityWrapper<>());
            return successMap(page);
        }catch (BizException e){
            return failMap(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return failMap(OperateConstant.QUERY_FAIL);
        }
    }

    /**
     * 添加
     * @param  user  实体
     * @return
     */
    @PostMapping
    @ApiOperation(httpMethod = "POST", value = "添加系统用户")
    public Map<String, Object> add(@RequestBody User user) {
        try {
            return  successMap(userService.insert(user));
        }catch (BizException e){
            return failMap(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return failMap(OperateConstant.OPERATION_FAIL);
        }
    }

    /**
     * 删除
     * @param id ID
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(httpMethod = "DELETE", value = "删除系统用户")
    public Map<String, Object> delete(@PathVariable String id) {
        try {
            return  successMap(userService.deleteById(id));
        }catch (BizException e){
            return failMap(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return failMap(OperateConstant.OPERATION_FAIL);
        }
    }

    /**
     * 编辑
     * @param  user  实体
     * @return
     */
    @PutMapping
    @ApiOperation(httpMethod = "PUT", value = "编辑系统用户")
    public  Map<String, Object> edit(@RequestBody User user) {
        try {
            return  successMap(userService.insertOrUpdate(user));
        }catch (BizException e){
            return failMap(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return failMap(OperateConstant.OPERATION_FAIL);
        }
    }
}
