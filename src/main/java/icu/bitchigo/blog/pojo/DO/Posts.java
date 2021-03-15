package icu.bitchigo.blog.pojo.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("posts")
public class Posts {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    @TableField("update_time")
    private Date updateTime;
    @TableField("class_id")
    private Integer classId;
}
