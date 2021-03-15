package icu.bitchigo.blog.service;

import icu.bitchigo.blog.pojo.VO.HomePostsResponse;
import org.springframework.lang.NonNull;

public interface HomeService {
    HomePostsResponse getHomePosts(@NonNull Integer page);
}
