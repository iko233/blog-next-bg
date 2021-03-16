package icu.bitchigo.blog.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class HomeCard {
    private Integer id;
    private String title;
    private String content;
    private ArrayList<HomeCardTarget> target;
    private String className;
}
