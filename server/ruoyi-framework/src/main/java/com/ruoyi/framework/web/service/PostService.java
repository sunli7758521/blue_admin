package com.ruoyi.framework.web.service;

import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.service.ISysPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  sun li 首创 html调用 thymeleaf 实现字典读取
 * @author sun li
 * @Date 2018/10/27 10:05
 * @Description
 */
@Service("post")
public class PostService {

    @Autowired
    private ISysPostService postService;

    /**
     * 根据职位类型查询字典数据信息
     *
     * @return 参数键值
     */
    public List<SysPost> getPost()
    {
        return  postService.selectPost();
    }

}
