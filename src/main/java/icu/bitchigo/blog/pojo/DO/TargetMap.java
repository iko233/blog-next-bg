package icu.bitchigo.blog.pojo.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("target_map")
public class TargetMap {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("post_id")
    private Integer postId;
    @TableField("target_id")
    private Integer targetId;
}
