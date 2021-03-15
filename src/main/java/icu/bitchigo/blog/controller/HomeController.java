package icu.bitchigo.blog.controller;

import icu.bitchigo.blog.pojo.VO.HomePostsResponse;
import icu.bitchigo.blog.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/posts/{page}")
    public HomePostsResponse getHomePosts(@PathVariable Integer page){
        return homeService.getHomePosts(page);
    }

}
