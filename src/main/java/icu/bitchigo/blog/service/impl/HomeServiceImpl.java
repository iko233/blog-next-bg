package icu.bitchigo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.bitchigo.blog.mapper.ClazzMapper;
import icu.bitchigo.blog.mapper.PostsMapper;
import icu.bitchigo.blog.mapper.TargetMapMapper;
import icu.bitchigo.blog.mapper.TargetMapper;
import icu.bitchigo.blog.pojo.DO.Clazz;
import icu.bitchigo.blog.pojo.DO.Posts;
import icu.bitchigo.blog.pojo.DO.Target;
import icu.bitchigo.blog.pojo.DO.TargetMap;
import icu.bitchigo.blog.pojo.VO.HomeCard;
import icu.bitchigo.blog.pojo.VO.HomeCardTarget;
import icu.bitchigo.blog.pojo.VO.HomePostsResponse;
import icu.bitchigo.blog.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private PostsMapper postsMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private TargetMapMapper targetMapMapper;
    @Autowired
    private TargetMapper targetMapper;

    @Override
    public HomePostsResponse getHomePosts(Integer page) {
        HomePostsResponse homePostsResponse = new HomePostsResponse();
        ArrayList<HomeCard> homeCards = new ArrayList<>();
        Page<Posts> postsPage = new Page<>(page, 10);
        postsMapper.selectPage(postsPage, null)
                .getRecords()
                .forEach(posts -> {
                    Integer classId = posts.getClassId();
                    Clazz clazz = clazzMapper.selectById(classId);
                    ArrayList<HomeCardTarget> targets = new ArrayList<>();
                    targetMapMapper.selectList(
                            new QueryWrapper<TargetMap>()
                                    .eq("post_id", posts.getId())
                    ).forEach(targetMap -> {
                        Target target = targetMapper.selectById(targetMap.getTargetId());
                        targets.add(
                                new HomeCardTarget()
                                    .setId(target.getId())
                                    .setName(target.getName())
                                    .setColor(target.getColor())
                        );
                    });
                    homeCards.add(
                            new HomeCard()
                                    .setTitle(posts.getTitle())
                                    .setContent(posts.getContent()
                                            .substring(0, Math.min(posts.getContent().length(), 50))
                                    )
                                    .setTarget(targets)
                                    .setClassName(clazz.getName())
                                    .setId(posts.getId())
                    );
                });
        homePostsResponse.setTotal(postsPage.getTotal());
        homePostsResponse.setHomeCards(homeCards);
        return homePostsResponse;
    }
}
